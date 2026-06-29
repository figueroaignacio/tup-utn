package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.dto;
import lombok.Data;

@Data
public class UsuarioEdit {
    private String nombre;
    private String apellido;
    private String celular;
}