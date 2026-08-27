package com.utn.gestionpedidos.controllers;

import com.utn.gestionpedidos.dtos.pedido.PedidoCreate;
import com.utn.gestionpedidos.dtos.pedido.PedidoDto;
import com.utn.gestionpedidos.dtos.pedido.PedidoEdit;
import com.utn.gestionpedidos.enums.Estado;
import com.utn.gestionpedidos.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoDto> listar(@RequestParam(required = false) Long usuarioId) {
        return usuarioId == null
                ? pedidoService.listar()
                : pedidoService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public PedidoDto buscar(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> crear(@RequestBody PedidoCreate dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.crear(dto));
    }

    @PutMapping("/{id}")
    public PedidoDto actualizar(@PathVariable Long id, @RequestBody PedidoEdit dto) {
        return pedidoService.actualizar(
                new PedidoEdit(id, dto.estado(), dto.formaPago(), dto.detalles()));
    }

    @PatchMapping("/{id}/estado")
    public PedidoDto cambiarEstado(@PathVariable Long id, @RequestParam Estado estado) {
        return pedidoService.cambiarEstado(id, estado);
    }

    @DeleteMapping("/{id}/productos/{productoId}")
    public PedidoDto quitarProducto(@PathVariable Long id, @PathVariable Long productoId) {
        return pedidoService.quitarProducto(id, productoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
