package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LocalDateTime ahora = LocalDateTime.now();

        // 1. Instanciar 3 Categorías
        Categoria catElectro = new Categoria(1L, false, ahora, "Electrónica", "Dispositivos tecnológicos");
        Categoria catHogar = new Categoria(2L, false, ahora, "Hogar", "Artículos para casa");
        Categoria catBazar = new Categoria(3L, false, ahora, "Bazar", "Cosas de cocina");

        // 2. Instanciar 10 Productos
        Set<Producto> catalogoProductos = new HashSet<>();
        Producto p1 = new Producto(1L, false, ahora, "Televisor 4K", 450000.0, "Smart TV 55'", 10, "tv.png", true);
        Producto p2 = new Producto(2L, false, ahora, "Auriculares Bluetooth", 35000.0, "Noise cancelling", 25, "auri.png", true);
        Producto p3 = new Producto(3L, false, ahora, "Microondas", 120000.0, "20 Litros digital", 8, "micro.png", true);
        Producto p4 = new Producto(4L, false, ahora, "Licuadora", 45000.0, "Vaso de vidrio", 15, "licuadora.png", true);
        Producto p5 = new Producto(5L, false, ahora, "Cafetera Espresso", 180000.0, "15 bares de presión", 5, "cafetera.png", true);
        Producto p6 = new Producto(6L, false, ahora, "Pava Eléctrica", 28000.0, "Corte mate", 30, "pava.png", true);
        Producto p7 = new Producto(7L, false, ahora, "Tostadora", 22000.0, "6 niveles de tostado", 12, "tostadora.png", true);
        Producto p8 = new Producto(8L, false, ahora, "Sillón 2 Cuerpos", 250000.0, "Tapizado en lino", 3, "sillon.png", true);
        Producto p9 = new Producto(9L, false, ahora, "Mesa de Luz", 35000.0, "Madera de pino", 20, "mesa.png", true);
        Producto p10 = new Producto(10L, false, ahora, "Lámpara LED", 8000.0, "Luz cálida", 50, "lampara.png", true);

        catalogoProductos.add(p1); catalogoProductos.add(p2); catalogoProductos.add(p3);
        catalogoProductos.add(p4); catalogoProductos.add(p5); catalogoProductos.add(p6);
        catalogoProductos.add(p7); catalogoProductos.add(p8); catalogoProductos.add(p9);
        catalogoProductos.add(p10);

        // 3. Instanciar 2 Usuarios
        Usuario user1 = new Usuario(1L, false, ahora, "Juan", "Pérez", "juan@mail.com", "11223344", "123", Rol.USUARIO);
        Usuario user2 = new Usuario(2L, false, ahora, "Ana", "Gómez", "ana@mail.com", "55667788", "456", Rol.ADMIN);

        // 4. Instanciar 3 Pedidos (Mínimo 2 detalles por cada uno)
        Pedido ped1 = new Pedido(101L, false, ahora, LocalDate.now(), Estado.PENDIENTE, FormaPago.EFECTIVO);
        ped1.addDetallePedido(1, p1);
        ped1.addDetallePedido(2, p2);

        Pedido ped2 = new Pedido(102L, false, ahora, LocalDate.now(), Estado.CONFIRMADO, FormaPago.TARJETA);
        ped2.addDetallePedido(1, p3);
        ped2.addDetallePedido(4, p10);

        Pedido ped3 = new Pedido(103L, false, ahora, LocalDate.now(), Estado.TERMINADO, FormaPago.TRANSFERENCIA);
        ped3.addDetallePedido(2, p6);
        ped3.addDetallePedido(1, p5);

        // Relacionamos los pedidos a los usuarios (User1 tendrá 2 pedidos, User2 tendrá 1)
        user1.addPedido(ped1);
        user1.addPedido(ped2);
        user2.addPedido(ped3);

        // === SALIDAS REQUERIDAS POR CONSOLA ===
        System.out.println("====== REQUERIMIENTO 4 ======");

        System.out.println("\n--> Mostrar un producto usando toString():");
        System.out.println(p1);

        System.out.println("\n--> Listado completo de productos cargados:");
        for (Producto prod : catalogoProductos) {
            System.out.println(prod);
        }

        System.out.println("\n--> Pedidos del usuario con mayor cantidad de pedidos:");
        Usuario conMasPedidos = (user1.getPedidos().size() > user2.getPedidos().size()) ? user1 : user2;
        System.out.println("Usuario: " + conMasPedidos.getNombre() + " " + conMasPedidos.getApellido());
        for (Pedido p : conMasPedidos.getPedidos()) {
            System.out.println(p);
        }

        System.out.println("\n====== REQUERIMIENTO 5 ======");
        // Instancia idéntica en ID (Contrato de Unicidad de los Objetos)
        Producto clonP1 = new Producto(1L, false, ahora, "Televisor Clonado", 99999.0, "Mismo ID", 1, "test.png", true);

        System.out.println("¿Contiene la colección al clonP1?: " + catalogoProductos.contains(clonP1));

        boolean insertado = catalogoProductos.add(clonP1);
        System.out.println("¿Se pudo agregar el clon al Set?: " + insertado);
        System.out.println("Cantidad final de elementos en el catálogo Set: " + catalogoProductos.size());
    }
}