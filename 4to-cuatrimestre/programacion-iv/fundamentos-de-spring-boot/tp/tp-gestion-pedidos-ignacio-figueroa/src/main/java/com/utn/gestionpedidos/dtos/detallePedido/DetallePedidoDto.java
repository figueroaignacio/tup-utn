package com.utn.gestionpedidos.dtos.detallePedido;

import com.utn.gestionpedidos.dtos.producto.ProductoDto;

public record DetallePedidoDto(
        Long id,
        int cantidad,
        Double subtotal,
        ProductoDto producto
) {}
