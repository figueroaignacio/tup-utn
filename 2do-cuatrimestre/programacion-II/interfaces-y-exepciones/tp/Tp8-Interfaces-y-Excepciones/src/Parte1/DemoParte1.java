package Parte1;

public class DemoParte1 {

    public static void run() {
        System.out.println("=== PARTE 1: SISTEMA E-COMMERCE ===");

        Cliente cliente = new Cliente("Ignacio");
        Pedido pedido = new Pedido(cliente);

        Producto p1 = new Producto("Mouse", 5000);
        Producto p2 = new Producto("Teclado", 12000);

        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);

        System.out.println("Total pedido: $" + pedido.calcularTotal());

        pedido.cambiarEstado("En preparación");

        PagoConDescuento tarjeta = new TarjetaCredito();
        double conDescuento = tarjeta.aplicarDescuento(pedido.calcularTotal());

        tarjeta.procesarPago(conDescuento);

        PayPal paypal = new PayPal();
        paypal.procesarPago(pedido.calcularTotal());

        System.out.println();
    }

}
