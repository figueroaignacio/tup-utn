package com.utn.gestionpedidos.dtos.producto;

public record ProductoCreate(
        String nombre,
        Double precio,
        String descripcion,
        int stock,
        String imagen,
        Long categoriaId   // se manda el ID, NUNCA la entidad Categoria
) {}
