package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.Base;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.Rol;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasena;
    private Rol rol;

    public Usuario() {
    }
}