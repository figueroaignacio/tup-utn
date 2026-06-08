package com.utn.entities;

import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Usuario usuario;

    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();

    @Override
    public void calcularTotal() {
        if (detalles != null) {
            this.total = detalles.stream()
                    .mapToDouble(DetallePedido::getSubtotal)
                    .sum();
        } else {
            this.total = 0.0;
        }
    }

    public void addDetallePedido(int cantidad, Producto producto) {
        if (this.detalles == null) {
            this.detalles = new ArrayList<>();
        }
        Double subtotal = cantidad * producto.getPrecio();
        DetallePedido detalle = DetallePedido.builder()
                .cantidad(cantidad)
                .subtotal(subtotal)
                .producto(producto)
                .build();
        this.detalles.add(detalle);
        calcularTotal();
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        return this.detalles.stream()
                .filter(d -> d.getProducto().equals(producto))
                .findFirst()
                .orElse(null);
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        this.detalles.removeIf(d -> d.getProducto().equals(producto));
        calcularTotal();
    }
}