package com.utn.gestionpedidos.mappers;

import com.utn.gestionpedidos.dtos.detallePedido.DetallePedidoDto;
import com.utn.gestionpedidos.dtos.pedido.PedidoDto;
import com.utn.gestionpedidos.entities.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    private final UsuarioMapper usuarioMapper;
    private final DetallePedidoMapper detallePedidoMapper;

    public PedidoMapper(UsuarioMapper usuarioMapper, DetallePedidoMapper detallePedidoMapper) {
        this.usuarioMapper = usuarioMapper;
        this.detallePedidoMapper = detallePedidoMapper;
    }

    public PedidoDto toDto(Pedido p) {
        List<DetallePedidoDto> detalles = p.getDetalles().stream()
                .map(detallePedidoMapper::toDto)
                .toList();

        return new PedidoDto(
                p.getId(),
                p.getFecha(),
                p.getEstado(),
                p.getFormaPago(),
                p.getTotal(),
                p.getUsuario() != null ? usuarioMapper.toDto(p.getUsuario()) : null,
                detalles
        );
    }
}
