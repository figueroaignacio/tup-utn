package org.example;

public class EmailNotificacion implements Notificacion {

    private final String destinatarioEmail;

    public EmailNotificacion(String destinatarioEmail) {
        this.destinatarioEmail = destinatarioEmail;
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[EMAIL] Enviando a " + destinatarioEmail + ": " + mensaje);
    }

}