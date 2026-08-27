package com.utn.gestionpedidos.dtos.categoria;

/** DTO de ENTRADA para modificar. Lleva id porque hay que saber a quien editar. */
public record CategoriaEdit(
        Long id,
        String nombre,
        String descripcion
) {}
