package com.utn.gestionpedidos.dtos.usuario;

import com.utn.gestionpedidos.enums.Rol;

public record UsuarioEdit(
        Long id,
        String nombre,
        String apellido,
        String mail,
        String celular,
        Rol rol
) {}
