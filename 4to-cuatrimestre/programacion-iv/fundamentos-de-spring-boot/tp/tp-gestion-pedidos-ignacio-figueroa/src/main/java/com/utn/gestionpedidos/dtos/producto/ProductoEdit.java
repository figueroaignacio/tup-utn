package com.utn.gestionpedidos.dtos.producto;

public record ProductoEdit(
        Long id,
        String nombre,
        Double precio,
        String descripcion,
        int stock,
        String imagen,
        Boolean disponible,
        Long categoriaId
) {}
