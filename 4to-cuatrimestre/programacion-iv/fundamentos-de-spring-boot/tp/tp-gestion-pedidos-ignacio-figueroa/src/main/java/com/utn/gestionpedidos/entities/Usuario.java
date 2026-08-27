package com.utn.gestionpedidos.entities;

import com.utn.gestionpedidos.enums.Rol;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Base {

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String mail;

    private String celular;

    @Column(nullable = false)
    private String contrasenia; // sin enie para evitar problemas de encoding

    @Enumerated(EnumType.STRING) // guarda "ADMIN" y no 0
    @Column(nullable = false)
    private Rol rol;

    /**
     * Un usuario tiene 1..m pedidos (relacion del UML).
     * mappedBy = "usuario" -> el DUENIO de la relacion es Pedido,
     * o sea la FK usuario_id vive en la tabla pedido.
     */
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        pedido.setUsuario(this);
    }
}
