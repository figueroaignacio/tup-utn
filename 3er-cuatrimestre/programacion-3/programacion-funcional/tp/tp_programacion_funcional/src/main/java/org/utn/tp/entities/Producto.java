package org.utn.tp.entities;

public class Producto extends Base {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;

    public Producto(Long id, boolean eliminado, String nombre, Double precio, int stock, Boolean disponible) {
        super(id, eliminado);
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public Boolean getDisponible() {
        return disponible;
    }
}