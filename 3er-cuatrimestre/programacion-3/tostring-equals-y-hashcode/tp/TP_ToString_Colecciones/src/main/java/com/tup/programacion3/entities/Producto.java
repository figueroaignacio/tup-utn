package com.tup.programacion3.entities;

import java.time.LocalDateTime;

public class Producto extends Base {
    private final String nombre;
    private final Double precio;
    private final String descripcion;
    private final int stock;
    private final String imagen;
    private final Boolean disponible;

    public Producto(Long id, boolean eliminado, LocalDateTime createdAt, String nombre, Double precio, String descripcion, int stock, String imagen, Boolean disponible) {
        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + getId() +
                ", nombre='" + nombre + '\'' +
                ", precio=$" + precio +
                ", stock=" + stock +
                '}';
    }
}