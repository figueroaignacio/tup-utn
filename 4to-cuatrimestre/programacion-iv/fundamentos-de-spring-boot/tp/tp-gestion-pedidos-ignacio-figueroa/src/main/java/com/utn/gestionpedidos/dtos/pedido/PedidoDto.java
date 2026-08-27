package com.utn.gestionpedidos.dtos.pedido;

import com.utn.gestionpedidos.dtos.detallePedido.DetallePedidoDto;
import com.utn.gestionpedidos.dtos.usuario.UsuarioDto;
import com.utn.gestionpedidos.enums.Estado;
import com.utn.gestionpedidos.enums.FormaPago;

import java.time.LocalDate;
import java.util.List;

public record PedidoDto(
        Long id,
        LocalDate fecha,
        Estado estado,
        FormaPago formaPago,
        Double total,
        UsuarioDto usuario,
        List<DetallePedidoDto> detalles
) {}
