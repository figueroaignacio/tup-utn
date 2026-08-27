package com.utn.gestionpedidos.mappers;

import com.utn.gestionpedidos.dtos.usuario.UsuarioCreate;
import com.utn.gestionpedidos.dtos.usuario.UsuarioDto;
import com.utn.gestionpedidos.dtos.usuario.UsuarioEdit;
import com.utn.gestionpedidos.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioCreate dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.nombre());
        u.setApellido(dto.apellido());
        u.setMail(dto.mail());
        u.setCelular(dto.celular());
        u.setContrasenia(dto.contrasenia());
        u.setRol(dto.rol());
        return u;
    }

    public void updateEntity(Usuario u, UsuarioEdit dto) {
        u.setNombre(dto.nombre());
        u.setApellido(dto.apellido());
        u.setMail(dto.mail());
        u.setCelular(dto.celular());
        u.setRol(dto.rol());
        // la contrasenia NO se toca desde este DTO
    }

    public UsuarioDto toDto(Usuario u) {
        return new UsuarioDto(
                u.getId(),
                u.getNombre(),
                u.getApellido(),
                u.getMail(),
                u.getCelular(),
                u.getRol()
        );
    }
}
