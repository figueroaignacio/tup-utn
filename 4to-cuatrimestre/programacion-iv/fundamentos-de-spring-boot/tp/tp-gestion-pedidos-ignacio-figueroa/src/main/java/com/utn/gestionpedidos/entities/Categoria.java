package com.utn.gestionpedidos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
public class Categoria extends Base {

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    /** Agregacion del UML: una categoria agrupa 1..m productos. */
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();
}
