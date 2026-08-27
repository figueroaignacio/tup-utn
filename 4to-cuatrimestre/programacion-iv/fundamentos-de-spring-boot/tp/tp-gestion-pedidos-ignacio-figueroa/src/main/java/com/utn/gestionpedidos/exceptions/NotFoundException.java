package com.utn.gestionpedidos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Excepcion propia: si llega a un controller, Spring responde 404. */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String entidad, Long id) {
        super("No se encontro " + entidad + " con id " + id);
    }
}
