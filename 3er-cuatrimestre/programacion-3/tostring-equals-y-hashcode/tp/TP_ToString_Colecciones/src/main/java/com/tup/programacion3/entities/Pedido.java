package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

interface Calculable {
    void calcularTotal();
}

public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total = 0.0;
    private FormaPago formaPago;
    private Set<DetallePedido> detalles = new HashSet<>();

    public Pedido(Long id, boolean eliminado, LocalDateTime createdAt, LocalDate fecha, Estado estado, FormaPago formaPago) {
        super(id, eliminado, createdAt);
        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;
    }

    public Set<DetallePedido> getDetalles() {
        return detalles;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public void calcularTotal() {
        this.total = 0.0;
        for (DetallePedido detalle : detalles) {
            this.total += detalle.getSubtotal();
        }
    }

    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido nuevoDetalle = new DetallePedido(cantidad, producto);
        this.detalles.add(nuevoDetalle);
        calcularTotal();
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido aEliminar = findDetallePedidoByProducto(producto);
        if (aEliminar != null) {
            this.detalles.remove(aEliminar);
            calcularTotal();
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + getId() +
                ", fecha=" + fecha +
                ", estado=" + estado +
                ", total=$" + total +
                ", detalles=" + detalles +
                '}';
    }
}