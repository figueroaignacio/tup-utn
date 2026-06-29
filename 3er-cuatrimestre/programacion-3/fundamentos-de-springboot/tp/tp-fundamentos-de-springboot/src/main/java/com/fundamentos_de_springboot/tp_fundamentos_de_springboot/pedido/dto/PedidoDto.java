package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido.dto;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.Estado;
import lombok.Data;

@Data
public class PedidoDto {
    private Long id;
    private Double total;
    private Estado estado;
}