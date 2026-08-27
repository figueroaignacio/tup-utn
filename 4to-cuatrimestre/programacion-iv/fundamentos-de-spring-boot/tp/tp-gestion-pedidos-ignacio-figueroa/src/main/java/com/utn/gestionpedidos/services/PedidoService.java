package com.utn.gestionpedidos.services;

import com.utn.gestionpedidos.dtos.detallePedido.DetallePedidoCreate;
import com.utn.gestionpedidos.dtos.pedido.PedidoCreate;
import com.utn.gestionpedidos.dtos.pedido.PedidoDto;
import com.utn.gestionpedidos.dtos.pedido.PedidoEdit;
import com.utn.gestionpedidos.entities.Pedido;
import com.utn.gestionpedidos.entities.Producto;
import com.utn.gestionpedidos.entities.Usuario;
import com.utn.gestionpedidos.enums.Estado;
import com.utn.gestionpedidos.exceptions.NotFoundException;
import com.utn.gestionpedidos.mappers.PedidoMapper;
import com.utn.gestionpedidos.repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Este es el service mas interesante: coordina 3 dependencias
 * (repository + 2 services) y aplica las reglas de negocio del pedido.
 */
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioService usuarioService;
    private final ProductoService productoService;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository,
                         UsuarioService usuarioService,
                         ProductoService productoService,
                         PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioService = usuarioService;
        this.productoService = productoService;
        this.pedidoMapper = pedidoMapper;
    }

    @Transactional
    public PedidoDto crear(PedidoCreate dto) {
        Usuario usuario = usuarioService.buscarEntidad(dto.usuarioId());

        Pedido pedido = new Pedido();
        pedido.setFecha(LocalDate.now());
        pedido.setEstado(Estado.PENDIENTE);
        pedido.setFormaPago(dto.formaPago());
        pedido.setUsuario(usuario);

        for (DetallePedidoCreate detalle : dto.detalles()) {
            Producto producto = productoService.buscarEntidad(detalle.productoId());
            // el metodo del UML: crea o acumula el detalle y recalcula el total
            pedido.addDetallePedido(detalle.cantidad(), producto);
            producto.descontarStock(detalle.cantidad());
        }

        pedido.calcularTotal();
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Transactional
    public PedidoDto actualizar(PedidoEdit dto) {
        Pedido pedido = buscarEntidad(dto.id());

        if (dto.estado() != null) pedido.setEstado(dto.estado());
        if (dto.formaPago() != null) pedido.setFormaPago(dto.formaPago());

        if (dto.detalles() != null) {
            pedido.getDetalles().clear(); // orphanRemoval borra los viejos
            for (DetallePedidoCreate detalle : dto.detalles()) {
                Producto producto = productoService.buscarEntidad(detalle.productoId());
                pedido.addDetallePedido(detalle.cantidad(), producto);
            }
        }

        pedido.calcularTotal();
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    /** Usa el metodo deleteDetallePedidoByProducto del UML. */
    @Transactional
    public PedidoDto quitarProducto(Long pedidoId, Long productoId) {
        Pedido pedido = buscarEntidad(pedidoId);
        Producto producto = productoService.buscarEntidad(productoId);
        pedido.deleteDetallePedidoByProducto(producto);
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Transactional
    public PedidoDto cambiarEstado(Long pedidoId, Estado estado) {
        Pedido pedido = buscarEntidad(pedidoId);
        pedido.setEstado(estado);
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Transactional(readOnly = true)
    public List<PedidoDto> listar() {
        return pedidoRepository.findAll().stream()
                .filter(p -> !p.isEliminado())
                .map(pedidoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<PedidoDto> listarPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId).stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public PedidoDto buscarPorId(Long id) {
        return pedidoMapper.toDto(buscarEntidad(id));
    }

    @Transactional
    public void eliminar(Long id) {
        Pedido pedido = buscarEntidad(id);
        pedido.setEliminado(true);
        pedido.setEstado(Estado.CANCELADO);
        pedidoRepository.save(pedido);
    }

    @Transactional(readOnly = true)
    public Pedido buscarEntidad(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido", id));
    }
}
