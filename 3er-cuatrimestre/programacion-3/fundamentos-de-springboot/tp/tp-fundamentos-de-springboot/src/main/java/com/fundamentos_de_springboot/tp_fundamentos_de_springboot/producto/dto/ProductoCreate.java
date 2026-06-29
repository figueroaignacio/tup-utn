package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto.dto;

import lombok.Data;

@Data
public class ProductoCreate {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;
}