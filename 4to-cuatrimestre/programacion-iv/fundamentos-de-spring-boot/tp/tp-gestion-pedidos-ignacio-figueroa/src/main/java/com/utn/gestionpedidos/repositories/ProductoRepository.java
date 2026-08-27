package com.utn.gestionpedidos.repositories;

import com.utn.gestionpedidos.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoriaId(Long categoriaId);

    List<Producto> findByDisponibleTrue();

    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
