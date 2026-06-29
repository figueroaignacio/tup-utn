package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.categoria;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.categoria.dto.CategoriaCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.categoria.dto.CategoriaDto;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaDto crear(CategoriaCreate dto) {
        Categoria categoria = Categoria.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
        Categoria guardada = categoriaRepository.save(categoria);

        CategoriaDto response = new CategoriaDto();
        response.setId(guardada.getId());
        response.setNombre(guardada.getNombre());
        response.setDescripcion(guardada.getDescripcion());
        return response;
    }
}