package com.utn.gestionpedidos.services;

import com.utn.gestionpedidos.dtos.usuario.UsuarioCreate;
import com.utn.gestionpedidos.dtos.usuario.UsuarioDto;
import com.utn.gestionpedidos.dtos.usuario.UsuarioEdit;
import com.utn.gestionpedidos.entities.Usuario;
import com.utn.gestionpedidos.exceptions.NotFoundException;
import com.utn.gestionpedidos.mappers.UsuarioMapper;
import com.utn.gestionpedidos.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Transactional
    public UsuarioDto crear(UsuarioCreate dto) {
        if (usuarioRepository.existsByMail(dto.mail())) {
            throw new IllegalArgumentException("Ya existe un usuario con el mail " + dto.mail());
        }
        Usuario usuario = usuarioMapper.toEntity(dto);
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Transactional
    public UsuarioDto actualizar(UsuarioEdit dto) {
        Usuario usuario = buscarEntidad(dto.id());
        usuarioMapper.updateEntity(usuario, dto);
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDto> listar() {
        return usuarioRepository.findAll().stream()
                .filter(u -> !u.isEliminado())
                .map(usuarioMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public UsuarioDto buscarPorId(Long id) {
        return usuarioMapper.toDto(buscarEntidad(id));
    }

    @Transactional
    public void eliminar(Long id) {
        Usuario usuario = buscarEntidad(id);
        usuario.setEliminado(true);
        usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarEntidad(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario", id));
    }
}
