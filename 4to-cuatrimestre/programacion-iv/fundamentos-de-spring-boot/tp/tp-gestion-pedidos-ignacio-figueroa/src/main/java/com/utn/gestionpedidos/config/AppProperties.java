package com.utn.gestionpedidos.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * "Configurar aplicaciones con properties".
 *
 * @ConfigurationProperties toma todas las claves que empiezan con "app."
 * del application.properties y las mapea a estos campos (necesita setters).
 * Despues se inyecta como cualquier otro bean.
 */
@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {

    private String nombre = "Sistema de Gestion de Pedidos";
    private String version = "1.0.0";
    private boolean cargarDatosIniciales = true;   // app.cargar-datos-iniciales
    private String moneda = "ARS";
}
