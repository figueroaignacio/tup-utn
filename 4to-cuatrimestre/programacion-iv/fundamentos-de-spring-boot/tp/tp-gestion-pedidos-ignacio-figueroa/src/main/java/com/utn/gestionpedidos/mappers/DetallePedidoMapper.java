package com.utn.gestionpedidos.mappers;

import com.utn.gestionpedidos.dtos.detallePedido.DetallePedidoDto;
import com.utn.gestionpedidos.entities.DetallePedido;
import org.springframework.stereotype.Component;

@Component
public class DetallePedidoMapper {

    private final ProductoMapper productoMapper;

    // INYECCION POR CONSTRUCTOR: un mapper usa a otro
    public DetallePedidoMapper(ProductoMapper productoMapper) {
        this.productoMapper = productoMapper;
    }

    public DetallePedidoDto toDto(DetallePedido d) {
        return new DetallePedidoDto(
                d.getId(),
                d.getCantidad(),
                d.getSubtotal(),
                d.getProducto() != null ? productoMapper.toDto(d.getProducto()) : null
        );
    }
}
