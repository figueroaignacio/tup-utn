package com.utn.gestionpedidos.mappers;

import com.utn.gestionpedidos.dtos.producto.ProductoCreate;
import com.utn.gestionpedidos.dtos.producto.ProductoDto;
import com.utn.gestionpedidos.dtos.producto.ProductoEdit;
import com.utn.gestionpedidos.entities.Categoria;
import com.utn.gestionpedidos.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoCreate dto, Categoria categoria) {
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setDescripcion(dto.descripcion());
        p.setStock(dto.stock());
        p.setImagen(dto.imagen());
        p.setDisponible(dto.stock() > 0);
        p.setCategoria(categoria);
        return p;
    }

    public void updateEntity(Producto p, ProductoEdit dto, Categoria categoria) {
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setDescripcion(dto.descripcion());
        p.setStock(dto.stock());
        p.setImagen(dto.imagen());
        p.setDisponible(dto.disponible() != null ? dto.disponible() : dto.stock() > 0);
        if (categoria != null) {
            p.setCategoria(categoria);
        }
    }

    public ProductoDto toDto(Producto p) {
        return new ProductoDto(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getDescripcion(),
                p.getStock(),
                p.getImagen(),
                p.getDisponible(),
                p.getCategoria() != null ? p.getCategoria().getId() : null,
                p.getCategoria() != null ? p.getCategoria().getNombre() : null
        );
    }
}
