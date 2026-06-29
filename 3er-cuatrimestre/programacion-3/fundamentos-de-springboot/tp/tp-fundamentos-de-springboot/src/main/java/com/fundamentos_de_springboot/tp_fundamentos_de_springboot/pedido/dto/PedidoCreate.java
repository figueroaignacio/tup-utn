package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido.dto;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.detallePedido.dto.DetallePedidoCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.FormaPago;
import lombok.Data;

import java.util.List;

@Data
public class PedidoCreate {
    private Long usuarioId;
    private FormaPago formaPago;
    private List<DetallePedidoCreate> detalles;
}