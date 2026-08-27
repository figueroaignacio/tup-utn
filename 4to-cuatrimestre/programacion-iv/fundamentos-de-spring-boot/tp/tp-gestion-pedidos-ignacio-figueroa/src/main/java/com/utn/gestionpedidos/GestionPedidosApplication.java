package com.utn.gestionpedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicacion.
 *
 * @SpringBootApplication es en realidad 3 anotaciones juntas:
 *   - @Configuration        -> esta clase puede definir beans
 *   - @EnableAutoConfiguration -> Spring configura solo el DataSource, JPA, Tomcat, etc.
 *   - @ComponentScan        -> escanea ESTE paquete y sus subpaquetes buscando
 *                              @Component / @Service / @Repository / @Controller
 *
 * Por eso TODO el codigo tiene que colgar de com.utn.gestionpedidos.
 */
@SpringBootApplication
public class GestionPedidosApplication {

    public static void main(String[] args) {
        // Esta linea crea el ApplicationContext (el contenedor de IoC)
        SpringApplication.run(GestionPedidosApplication.class, args);
    }
}
