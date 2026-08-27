package com.utn.gestionpedidos.controllers;

import com.utn.gestionpedidos.dtos.producto.ProductoCreate;
import com.utn.gestionpedidos.dtos.producto.ProductoDto;
import com.utn.gestionpedidos.dtos.producto.ProductoEdit;
import com.utn.gestionpedidos.services.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoDto> listar(@RequestParam(required = false) Long categoriaId) {
        return categoriaId == null
                ? productoService.listar()
                : productoService.listarPorCategoria(categoriaId);
    }

    @GetMapping("/{id}")
    public ProductoDto buscar(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ProductoDto> crear(@RequestBody ProductoCreate dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crear(dto));
    }

    @PutMapping("/{id}")
    public ProductoDto actualizar(@PathVariable Long id, @RequestBody ProductoEdit dto) {
        return productoService.actualizar(new ProductoEdit(
                id, dto.nombre(), dto.precio(), dto.descripcion(),
                dto.stock(), dto.imagen(), dto.disponible(), dto.categoriaId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
