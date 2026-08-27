package com.utn.gestionpedidos.controllers;

import com.utn.gestionpedidos.dtos.categoria.CategoriaCreate;
import com.utn.gestionpedidos.dtos.categoria.CategoriaDto;
import com.utn.gestionpedidos.dtos.categoria.CategoriaEdit;
import com.utn.gestionpedidos.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ESTEREOTIPO @RestController = @Controller + @ResponseBody.
 * Solo recibe la request, delega en el service y devuelve DTOs.
 * NUNCA devuelve entidades.
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaDto> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public CategoriaDto buscar(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> crear(@RequestBody CategoriaCreate dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.crear(dto));
    }

    @PutMapping("/{id}")
    public CategoriaDto actualizar(@PathVariable Long id, @RequestBody CategoriaEdit dto) {
        return categoriaService.actualizar(
                new CategoriaEdit(id, dto.nombre(), dto.descripcion()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
