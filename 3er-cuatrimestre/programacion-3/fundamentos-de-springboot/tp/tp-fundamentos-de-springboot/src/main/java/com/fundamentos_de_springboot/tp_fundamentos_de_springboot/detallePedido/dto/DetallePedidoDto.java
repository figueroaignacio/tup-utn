package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.detallePedido.dto;

import lombok.Data;

@Data
public class DetallePedidoDto {
    private Long id;
    private int cantidad;
    private Double subtotal;
    private Long productoId;
}