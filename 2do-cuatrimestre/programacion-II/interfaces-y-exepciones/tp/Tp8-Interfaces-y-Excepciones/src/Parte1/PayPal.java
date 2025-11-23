package Parte1;

public class PayPal implements Pago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago mediante PayPal procesado por $" + monto);
    }
}
