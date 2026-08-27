package com.utn.gestionpedidos.dtos.detallePedido;

/** Para cargar un detalle solo hace falta que producto y cuantos. */
public record DetallePedidoCreate(
        Long productoId,
        int cantidad
) {}
