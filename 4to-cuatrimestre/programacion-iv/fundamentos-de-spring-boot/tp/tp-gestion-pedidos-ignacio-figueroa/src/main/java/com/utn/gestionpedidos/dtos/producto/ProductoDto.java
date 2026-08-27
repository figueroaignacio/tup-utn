package com.utn.gestionpedidos.dtos.producto;

public record ProductoDto(
        Long id,
        String nombre,
        Double precio,
        String descripcion,
        int stock,
        String imagen,
        Boolean disponible,
        Long categoriaId,
        String categoriaNombre
) {}
