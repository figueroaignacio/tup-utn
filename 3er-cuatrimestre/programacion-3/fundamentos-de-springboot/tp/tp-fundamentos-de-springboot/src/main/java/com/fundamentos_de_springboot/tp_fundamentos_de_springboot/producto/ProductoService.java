package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto.dto.ProductoCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto.dto.ProductoDto;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ProductoDto crear(ProductoCreate dto) {
        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .descripcion(dto.getDescripcion())
                .stock(dto.getStock())
                .imagen(dto.getImagen())
                .disponible(dto.getDisponible())
                .build();
        Producto guardado = productoRepository.save(producto);
        return mapearADto(guardado);
    }

    public Producto buscarEntidad(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    private ProductoDto mapearADto(Producto p) {
        ProductoDto dto = new ProductoDto();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());
        dto.setDescripcion(p.getDescripcion());
        dto.setStock(p.getStock());
        dto.setImagen(p.getImagen());
        dto.setDisponible(p.getDisponible());
        return dto;
    }
}