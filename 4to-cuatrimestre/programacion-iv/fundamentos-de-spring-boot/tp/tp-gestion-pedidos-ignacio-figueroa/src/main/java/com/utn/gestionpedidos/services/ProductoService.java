package com.utn.gestionpedidos.services;

import com.utn.gestionpedidos.dtos.producto.ProductoCreate;
import com.utn.gestionpedidos.dtos.producto.ProductoDto;
import com.utn.gestionpedidos.dtos.producto.ProductoEdit;
import com.utn.gestionpedidos.entities.Categoria;
import com.utn.gestionpedidos.entities.Producto;
import com.utn.gestionpedidos.exceptions.NotFoundException;
import com.utn.gestionpedidos.mappers.ProductoMapper;
import com.utn.gestionpedidos.repositories.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaService categoriaService; // un service puede usar otro
    private final ProductoMapper productoMapper;

    public ProductoService(ProductoRepository productoRepository,
                           CategoriaService categoriaService,
                           ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.categoriaService = categoriaService;
        this.productoMapper = productoMapper;
    }

    @Transactional
    public ProductoDto crear(ProductoCreate dto) {
        Categoria categoria = categoriaService.buscarEntidad(dto.categoriaId());
        Producto producto = productoMapper.toEntity(dto, categoria);
        return productoMapper.toDto(productoRepository.save(producto));
    }

    @Transactional
    public ProductoDto actualizar(ProductoEdit dto) {
        Producto producto = buscarEntidad(dto.id());
        Categoria categoria = dto.categoriaId() != null
                ? categoriaService.buscarEntidad(dto.categoriaId())
                : null;
        productoMapper.updateEntity(producto, dto, categoria);
        return productoMapper.toDto(productoRepository.save(producto));
    }

    @Transactional(readOnly = true)
    public List<ProductoDto> listar() {
        return productoRepository.findAll().stream()
                .filter(p -> !p.isEliminado())
                .map(productoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ProductoDto> listarPorCategoria(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId).stream()
                .map(productoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductoDto buscarPorId(Long id) {
        return productoMapper.toDto(buscarEntidad(id));
    }

    @Transactional
    public void eliminar(Long id) {
        Producto producto = buscarEntidad(id);
        producto.setEliminado(true);
        producto.setDisponible(false);
        productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public Producto buscarEntidad(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto", id));
    }
}
