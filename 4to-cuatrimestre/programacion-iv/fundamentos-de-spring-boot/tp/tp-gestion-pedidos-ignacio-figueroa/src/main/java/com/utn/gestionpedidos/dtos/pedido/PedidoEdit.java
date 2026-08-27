package com.utn.gestionpedidos.dtos.pedido;

import com.utn.gestionpedidos.dtos.detallePedido.DetallePedidoCreate;
import com.utn.gestionpedidos.enums.Estado;
import com.utn.gestionpedidos.enums.FormaPago;

import java.util.List;

/**
 * Para editar un pedido: cambiar estado, forma de pago y/o reemplazar
 * la lista de detalles. Si detalles viene null, se dejan los que ya estaban.
 */
public record PedidoEdit(
        Long id,
        Estado estado,
        FormaPago formaPago,
        List<DetallePedidoCreate> detalles
) {}
