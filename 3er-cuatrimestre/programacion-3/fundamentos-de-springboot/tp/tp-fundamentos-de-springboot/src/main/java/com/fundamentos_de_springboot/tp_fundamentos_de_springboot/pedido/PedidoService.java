package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.detallePedido.DetallePedido;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.Estado;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido.dto.PedidoCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido.dto.PedidoDto;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto.ProductoService;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final UsuarioService usuarioService;
    private final ProductoService productoService;

    // Inyección explícita por constructor obligatoria por la consigna
    public PedidoService(PedidoRepository pedidoRepository, UsuarioService usuarioService, ProductoService productoService) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioService = usuarioService;
        this.productoService = productoService;
    }

    public PedidoDto crear(PedidoCreate dto) {
        Pedido pedido = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(Estado.PENDIENTE)
                .formaPago(dto.getFormaPago())
                .usuario(usuarioService.buscarEntidad(dto.getUsuarioId()))
                .detalles(dto.getDetalles().stream().map(dDto -> {
                    DetallePedido det = DetallePedido.builder()
                            .cantidad(dDto.getCantidad())
                            .producto(productoService.buscarEntidad(dDto.getProductoId()))
                            .build();
                    det.calcularSubtotal();
                    return det;
                }).collect(Collectors.toList()))
                .build();

        pedido.calcularTotal();
        Pedido guardado = pedidoRepository.save(pedido);

        PedidoDto res = new PedidoDto();
        res.setId(guardado.getId());
        res.setTotal(guardado.getTotal());
        res.setEstado(guardado.getEstado());
        return res;
    }
}