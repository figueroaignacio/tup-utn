package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Rol;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;
    private Set<Pedido> pedidos = new HashSet<>();

    public Usuario(Long id, boolean eliminado, LocalDateTime createdAt, String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) {
        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + getId() +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", totalPedidos=" + pedidos.size() +
                '}';
    }
}