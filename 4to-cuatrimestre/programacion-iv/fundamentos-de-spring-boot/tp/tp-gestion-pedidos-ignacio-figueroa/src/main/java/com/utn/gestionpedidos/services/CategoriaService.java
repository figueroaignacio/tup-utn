package com.utn.gestionpedidos.services;

import com.utn.gestionpedidos.dtos.categoria.CategoriaCreate;
import com.utn.gestionpedidos.dtos.categoria.CategoriaDto;
import com.utn.gestionpedidos.dtos.categoria.CategoriaEdit;
import com.utn.gestionpedidos.entities.Categoria;
import com.utn.gestionpedidos.exceptions.NotFoundException;
import com.utn.gestionpedidos.mappers.CategoriaMapper;
import com.utn.gestionpedidos.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ESTEREOTIPO @Service: capa de logica de negocio.
 *
 * INYECCION POR CONSTRUCTOR:
 *  - los campos son final -> no se pueden cambiar despues (inmutable)
 *  - la clase no puede existir sin sus dependencias -> nunca hay NullPointer
 *  - es facil de testear: en un test le paso mocks por el constructor
 *
 * Desde Spring 4.3, si la clase tiene UN SOLO constructor, @Autowired es opcional.
 */
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository,
                            CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Transactional
    public CategoriaDto crear(CategoriaCreate dto) {
        Categoria categoria = categoriaMapper.toEntity(dto);
        return categoriaMapper.toDto(categoriaRepository.save(categoria));
    }

    @Transactional
    public CategoriaDto actualizar(CategoriaEdit dto) {
        Categoria categoria = buscarEntidad(dto.id());
        categoriaMapper.updateEntity(categoria, dto);
        return categoriaMapper.toDto(categoriaRepository.save(categoria));
    }

    @Transactional(readOnly = true)
    public List<CategoriaDto> listar() {
        return categoriaRepository.findAll().stream()
                .filter(c -> !c.isEliminado())
                .map(categoriaMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDto buscarPorId(Long id) {
        return categoriaMapper.toDto(buscarEntidad(id));
    }

    /** Baja logica: no se borra el registro, se marca eliminado = true. */
    @Transactional
    public void eliminar(Long id) {
        Categoria categoria = buscarEntidad(id);
        categoria.setEliminado(true);
        categoriaRepository.save(categoria);
    }

    /** Uso interno / entre services: devuelve la ENTIDAD, no el DTO. */
    @Transactional(readOnly = true)
    public Categoria buscarEntidad(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria", id));
    }
}
