package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.dto.UsuarioCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.dto.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto crear(UsuarioCreate dto) {
        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .mail(dto.getMail())
                .celular(dto.getCelular())
                .contrasena(dto.getContrasena())
                .rol(dto.getRol())
                .build();

        Usuario guardado = usuarioRepository.save(usuario);
        return mapearADto(guardado);
    }

    public Usuario buscarEntidad(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    private UsuarioDto mapearADto(Usuario u) {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(u.getId());
        dto.setNombre(u.getNombre());
        dto.setApellido(u.getApellido());
        dto.setMail(u.getMail());
        dto.setCelular(u.getCelular());
        dto.setRol(u.getRol());
        return dto;
    }
}