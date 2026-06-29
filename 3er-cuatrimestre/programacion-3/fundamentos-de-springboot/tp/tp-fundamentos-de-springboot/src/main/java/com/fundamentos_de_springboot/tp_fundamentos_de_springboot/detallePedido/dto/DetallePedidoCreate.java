package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.detallePedido.dto;

import lombok.Data;

@Data
public class DetallePedidoCreate {
    private int cantidad;
    private Long productoId;
}