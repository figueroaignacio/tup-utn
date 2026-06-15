package org.utn.tp.entities;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    public Categoria(Long id, boolean eliminado, String nombre, String descripcion) {
        super(id, eliminado);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
}