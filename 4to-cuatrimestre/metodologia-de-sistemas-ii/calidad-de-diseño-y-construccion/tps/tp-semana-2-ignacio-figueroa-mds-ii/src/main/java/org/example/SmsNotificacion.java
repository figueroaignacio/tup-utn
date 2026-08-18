package org.example;

public class SmsNotificacion implements Notificacion {

    private final String numeroTelefono;

    public SmsNotificacion(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[SMS] Enviando a " + numeroTelefono + ": " + mensaje);
    }

}
