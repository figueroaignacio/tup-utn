package org.utn.tp;

import org.utn.tp.enums.FormaPago;
import org.utn.tp.entities.DetallePedido;
import org.utn.tp.entities.Pedido;
import org.utn.tp.entities.Producto;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Producto p1 = new Producto(1L, false, "Pancho", 1500.0, 10, true);
        Producto p2 = new Producto(2L, false, "Bebida Cola", 1200.0, 3, true);
        Producto p3 = new Producto(3L, false, "Papas Fritas", 2000.0, 2, false);
        Producto p4 = new Producto(4L, false, "Empanada", 800.0, 25, true);

        List<Producto> listaProductos = List.of(p1, p2, p3, p4);

        // 2) Mostrar por consola productos disponibles
        System.out.println("2) PRODUCTOS DISPONIBLES");
        listaProductos.stream()
                .filter(Producto::getDisponible)
                .forEach(p -> System.out.println("- " + p.getNombre() + " ($" + p.getPrecio() + ")"));

        System.out.println();

        // se arma un pedido de prueba
        Pedido pedido = new Pedido(100L, false, FormaPago.EFECTIVO);
        pedido.addDetallePedido(2, p1); // 2 Panchos
        pedido.addDetallePedido(2, p2); // 2 Bebidas

        // ejecutamos el punto 1 interno del Pedido
        pedido.calcularTotal();
        System.out.println("Total del Pedido Calculado (Punto 1): $" + pedido.getTotal());
        System.out.println();


        // 3) Mostrar por consola la cantidad de ítems que tiene un pedido
        System.out.println("3) CANTIDAD TOTAL DE ÍTEMS EN EL PEDIDO");
        int totalItems = pedido.getDetalles().stream()
                .mapToInt(DetallePedido::getCantidad)
                .sum();

        System.out.println("El pedido tiene un total de " + totalItems + " ítems.");
        System.out.println();


        // 4) Detectar productos que tengan menos de 5 como valor en stock
        System.out.println("4) ALERTAS DE STOCK (MENOS DE 5 UNIDADES)");
        listaProductos.stream()
                .filter(p -> p.getStock() < 5)
                .forEach(p -> System.out.println("¡Alerta! Al producto '" + p.getNombre() + "' le quedan solo " + p.getStock() + " unidades."));
    }
}