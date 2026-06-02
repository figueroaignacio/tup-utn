package com.tup.programacion3.entities;

import java.util.Objects;

public class DetallePedido {
    private final int cantidad;
    private Double subtotal;
    private final Producto producto;

    public DetallePedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        if (producto != null) {
            this.subtotal = this.cantidad * producto.getPrecio();
        } else {
            this.subtotal = 0.0;
        }
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePedido que = (DetallePedido) o;
        return Objects.equals(producto, que.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto);
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "producto=" + (producto != null ? producto.getNombre() : "Ninguno") +
                ", cantidad=" + cantidad +
                ", subtotal=$" + subtotal +
                '}';
    }
}