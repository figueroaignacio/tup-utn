package org.example;

public class PushNotificacion implements Notificacion {

    private final String deviceToken;

    public PushNotificacion(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[Push Notification] Enviando a token " + deviceToken + ": " + mensaje);
    }

}
