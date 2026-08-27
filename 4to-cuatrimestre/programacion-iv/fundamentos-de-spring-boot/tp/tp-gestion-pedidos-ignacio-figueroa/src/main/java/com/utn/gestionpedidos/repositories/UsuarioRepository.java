package com.utn.gestionpedidos.repositories;

import com.utn.gestionpedidos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ESTEREOTIPO @Repository: capa de acceso a datos.
 * No hace falta escribir la implementacion: Spring Data JPA genera
 * un bean proxy en tiempo de ejecucion con todos los metodos.
 *
 * Ademas traduce las excepciones de JDBC/Hibernate a excepciones de Spring.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Query methods: Spring arma el SQL leyendo el NOMBRE del metodo
    Optional<Usuario> findByMail(String mail);

    boolean existsByMail(String mail);
}
