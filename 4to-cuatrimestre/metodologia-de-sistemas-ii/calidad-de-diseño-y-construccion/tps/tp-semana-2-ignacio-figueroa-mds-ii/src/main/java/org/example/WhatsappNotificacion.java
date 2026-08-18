package org.example;

public class WhatsappNotificacion implements Notificacion {

    private final String numeroTelefono;

    public WhatsappNotificacion(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[WHATSAPP] Enviando a " + numeroTelefono + ": " + mensaje);
    }
}
