package com.utn.gestionpedidos.mappers;

import com.utn.gestionpedidos.dtos.categoria.CategoriaCreate;
import com.utn.gestionpedidos.dtos.categoria.CategoriaDto;
import com.utn.gestionpedidos.dtos.categoria.CategoriaEdit;
import com.utn.gestionpedidos.entities.Categoria;
import org.springframework.stereotype.Component;

/**
 * ESTEREOTIPO @Component: bean generico. No es servicio ni repositorio,
 * simplemente traduce Entidad <-> DTO. Al ser un bean, se puede inyectar.
 */
@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaCreate dto) {
        Categoria c = new Categoria();
        c.setNombre(dto.nombre());
        c.setDescripcion(dto.descripcion());
        return c;
    }

    /** Copia los datos del DTO sobre una entidad YA existente (update). */
    public void updateEntity(Categoria c, CategoriaEdit dto) {
        c.setNombre(dto.nombre());
        c.setDescripcion(dto.descripcion());
    }

    public CategoriaDto toDto(Categoria c) {
        return new CategoriaDto(
                c.getId(),
                c.getNombre(),
                c.getDescripcion(),
                c.getProductos() == null ? 0 : c.getProductos().size()
        );
    }
}
