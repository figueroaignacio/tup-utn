package com.utn.gestionpedidos.dtos.categoria;

/** DTO de SALIDA: lo que la app le devuelve al cliente. */
public record CategoriaDto(
        Long id,
        String nombre,
        String descripcion,
        int cantidadProductos
) {}
