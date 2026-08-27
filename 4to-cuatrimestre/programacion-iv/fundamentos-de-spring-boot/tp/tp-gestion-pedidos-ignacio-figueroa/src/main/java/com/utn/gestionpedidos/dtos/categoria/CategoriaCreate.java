package com.utn.gestionpedidos.dtos.categoria;

/**
 * DTO de ENTRADA para crear. No lleva id: lo genera la base.
 * Es un record: clase inmutable, con getters (nombre()), equals, hashCode y toString.
 */
public record CategoriaCreate(
        String nombre,
        String descripcion
) {}
