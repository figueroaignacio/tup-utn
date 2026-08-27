package com.utn.gestionpedidos.entities;

import com.utn.gestionpedidos.enums.Estado;
import com.utn.gestionpedidos.enums.FormaPago;
import com.utn.gestionpedidos.interfaces.Calculable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
public class Pedido extends Base implements Calculable {

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private Double total = 0.0;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /**
     * Composicion del UML (rombo negro): los detalles no existen sin el pedido.
     * Por eso cascade = ALL y orphanRemoval = true: si borro el pedido o saco
     * un detalle de la lista, se borra tambien en la base.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detalles = new ArrayList<>();

    // ---------- Metodos del UML ----------

    /**
     * Si el producto ya estaba en el pedido suma la cantidad,
     * si no, crea un detalle nuevo. Siempre recalcula el total.
     */
    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido existente = findDetallePedidoByProducto(producto);
        if (existente != null) {
            existente.setCantidad(existente.getCantidad() + cantidad);
            existente.calcularSubtotal();
        } else {
            this.detalles.add(new DetallePedido(cantidad, producto));
        }
        calcularTotal();
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        if (producto == null) return null;
        return this.detalles.stream()
                .filter(d -> d.getProducto() != null
                        && d.getProducto().getId() != null
                        && d.getProducto().getId().equals(producto.getId()))
                .findFirst()
                .orElse(null);
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detalle = findDetallePedidoByProducto(producto);
        if (detalle != null) {
            this.detalles.remove(detalle);
            calcularTotal();
        }
    }

    /** Implementacion de la interface Calculable. */
    @Override
    public void calcularTotal() {
        this.total = this.detalles.stream()
                .mapToDouble(d -> d.getSubtotal() == null ? 0.0 : d.getSubtotal())
                .sum();
    }
}
