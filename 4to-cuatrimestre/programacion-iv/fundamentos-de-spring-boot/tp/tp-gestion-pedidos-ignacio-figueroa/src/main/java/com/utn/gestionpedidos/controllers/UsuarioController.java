package com.utn.gestionpedidos.controllers;

import com.utn.gestionpedidos.dtos.usuario.UsuarioCreate;
import com.utn.gestionpedidos.dtos.usuario.UsuarioDto;
import com.utn.gestionpedidos.dtos.usuario.UsuarioEdit;
import com.utn.gestionpedidos.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDto> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public UsuarioDto buscar(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> crear(@RequestBody UsuarioCreate dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crear(dto));
    }

    @PutMapping("/{id}")
    public UsuarioDto actualizar(@PathVariable Long id, @RequestBody UsuarioEdit dto) {
        return usuarioService.actualizar(new UsuarioEdit(
                id, dto.nombre(), dto.apellido(), dto.mail(), dto.celular(), dto.rol()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
