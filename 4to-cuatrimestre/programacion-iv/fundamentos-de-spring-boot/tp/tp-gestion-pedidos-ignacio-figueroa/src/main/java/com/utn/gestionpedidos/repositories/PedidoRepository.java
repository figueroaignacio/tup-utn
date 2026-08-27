package com.utn.gestionpedidos.repositories;

import com.utn.gestionpedidos.entities.Pedido;
import com.utn.gestionpedidos.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByUsuarioId(Long usuarioId);

    List<Pedido> findByEstado(Estado estado);
}
