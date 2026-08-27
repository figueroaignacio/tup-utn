package com.utn.gestionpedidos.dtos.usuario;

import com.utn.gestionpedidos.enums.Rol;

/** La contrasenia ENTRA (para dar de alta) pero nunca SALE. */
public record UsuarioCreate(
        String nombre,
        String apellido,
        String mail,
        String celular,
        String contrasenia,
        Rol rol
) {}
