package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.dto;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.Rol;
import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private Rol rol;
}