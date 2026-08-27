package com.utn.gestionpedidos.dtos.pedido;

import com.utn.gestionpedidos.dtos.detallePedido.DetallePedidoCreate;
import com.utn.gestionpedidos.enums.FormaPago;

import java.util.List;

/**
 * OJO: este archivo NO figura en el arbol del PDF (solo estan PedidoDto y
 * PedidoEdit), pero hace falta para poder "instanciar a partir de DTOs".
 * Si tu profe pide el arbol exacto, borralo y usa PedidoEdit para crear.
 */
public record PedidoCreate(
        Long usuarioId,
        FormaPago formaPago,
        List<DetallePedidoCreate> detalles
) {}
