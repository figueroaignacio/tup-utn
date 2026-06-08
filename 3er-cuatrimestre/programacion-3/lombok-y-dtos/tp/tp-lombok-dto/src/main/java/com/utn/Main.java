package com.utn;

import com.utn.dtos.UsuarioDTO;
import com.utn.entities.Categoria;
import com.utn.entities.Pedido;
import com.utn.entities.Producto;
import com.utn.entities.Usuario;
import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.enums.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Punto 3: Instanciaciones con patrón Builder / SuperBuilder

        // a. 2 Usuarios
        Usuario user1 = Usuario.builder()
                .id(1L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Ignacio").apellido("Figueroa").mail("ignaciofigueroadev@gmail.com").celular("123456")
                .contrasena("secreto123").rol(Rol.ADMIN)
                .build();

        Usuario user2 = Usuario.builder()
                .id(2L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Valentin").apellido("Igler").mail("valen@mail.com").celular("789101")
                .contrasena("password456").rol(Rol.USUARIO)
                .build();

        // c. 3 Categorías
        Categoria catComponentes = Categoria.builder().id(1L).nombre("Componentes").descripcion("Hardware").build();
        Categoria catPerifericos = Categoria.builder().id(2L).nombre("Periféricos").descripcion("Accesorios").build();
        Categoria catAudio = Categoria.builder().id(3L).nombre("Audio").descripcion("Dispositivos de sonido").build();

        // d. 10 Productos
        List<Producto> productos = new ArrayList<>();
        String[] nombresProd = {"Teclado Mecánico", "Mouse Gamer", "Monitor 24'", "Gabinete ATX", "Placa de Video", "Memoria RAM", "Procesador i7", "Auriculares", "Micrófono", "Fuente 750W"};
        Double[] preciosProd = {85.0, 45.0, 180.0, 90.0, 350.0, 70.0, 290.0, 60.0, 110.0, 95.0};

        for (int i = 0; i < 10; i++) {
            productos.add(Producto.builder()
                    .id((long) (i + 1))
                    .nombre(nombresProd[i])
                    .precio(preciosProd[i])
                    .descripcion("Descripción de " + nombresProd[i])
                    .stock(20)
                    .disponible(true)
                    .build());
        }

        // b. 3 Pedidos (al menos 2 detalles pedido por cada uno)
        List<Pedido> pedidos = new ArrayList<>();

        // Pedido 1
        Pedido p1 = Pedido.builder().id(1L).fecha(LocalDate.now()).estado(Estado.PENDIENTE).formaPago(FormaPago.TARJETA).usuario(user1).build();
        p1.addDetallePedido(2, productos.get(0)); // 2 Teclados
        p1.addDetallePedido(1, productos.get(1)); // 1 Mouse

        // Pedido 2
        Pedido p2 = Pedido.builder().id(2L).fecha(LocalDate.now()).estado(Estado.CONFIRMADO).formaPago(FormaPago.EFECTIVO).usuario(user1).build();
        p2.addDetallePedido(1, productos.get(2)); // 1 Monitor
        p2.addDetallePedido(4, productos.get(5)); // 4 RAMs

        // Pedido 3
        Pedido p3 = Pedido.builder().id(3L).fecha(LocalDate.now()).estado(Estado.TERMINADO).formaPago(FormaPago.TRANSFERENCIA).usuario(user2).build();
        p3.addDetallePedido(1, productos.get(6)); // 1 Procesador
        p3.addDetallePedido(2, productos.get(7)); // 2 Auriculares

        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);

        // Punto 4: Salidas por consola usando toString
        System.out.println("====== PUNTO 4 ======");
        System.out.println("\n--> Un Producto individual:");
        System.out.println(productos.getFirst().toString());

        System.out.println("\n--> Listado completo de Productos cargados:");
        productos.forEach(p -> System.out.println(p.toString()));

        System.out.println("\n--> Pedidos del usuario con mayor cantidad de pedidos (Edgar):");
        pedidos.stream()
                .filter(p -> p.getUsuario().getId().equals(user1.getId()))
                .forEach(p -> System.out.println(p.toString()));


        // Punto 5: Comparación usando Equals (por campo Nombre)
        System.out.println("\n====== PUNTO 5 ======");

        Producto productoClon = Producto.builder()
                .id(99L)
                .nombre("Mouse Gamer")
                .precio(999.9)
                .build();

        System.out.println("Instancia nueva a comparar: " + productoClon);
        System.out.println("Resultados de la comparación en la lista de productos:");

        for (Producto p : productos) {
            if (productoClon.equals(p)) {
                System.out.println(" MATCH ENCONTRADO -> Es igual a: " + p.getNombre() + " (ID original: " + p.getId() + ")");
            } else {
                System.out.println("No es igual a: " + p.getNombre());
            }
        }

        // Punto 6: Mapeo y Ocultamiento usando el Record DTO
        System.out.println("\n====== PUNTO 6 ======");
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                user1.getId(),
                user1.getNombre(),
                user1.getApellido(),
                user1.getMail(),
                user1.getCelular()
        );

        System.out.println("Objeto Original de tipo Usuario (con datos sensibles):");
        System.out.println(user1);
        System.out.println("\nObjeto Seguro de tipo UsuarioDTO (Inmutable):");
        System.out.println(usuarioDTO);
    }
}