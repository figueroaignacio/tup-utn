package com.utn.gestionpedidos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase padre del UML.
 *
 * @MappedSuperclass: NO es una tabla. Hibernate copia estos atributos
 * dentro de la tabla de cada hija (usuario, pedido, producto, ...).
 * Es lo que corresponde cuando la clase padre solo aporta atributos comunes.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "eliminado")
    protected boolean eliminado = false;

    @Column(name = "created_at", updatable = false)
    protected LocalDateTime createdAt;

    /** Callback de JPA: se ejecuta justo antes del INSERT. */
    @PrePersist
    protected void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
