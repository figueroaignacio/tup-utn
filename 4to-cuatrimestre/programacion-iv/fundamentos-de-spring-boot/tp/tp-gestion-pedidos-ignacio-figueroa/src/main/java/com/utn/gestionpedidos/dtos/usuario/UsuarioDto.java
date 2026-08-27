package com.utn.gestionpedidos.dtos.usuario;

import com.utn.gestionpedidos.enums.Rol;

/**
 * Fijate que NO tiene contrasenia. Este es el motivo principal
 * por el que existen los DTOs: no exponer la entidad tal cual.
 */
public record UsuarioDto(
        Long id,
        String nombre,
        String apellido,
        String mail,
        String celular,
        Rol rol
) {}
