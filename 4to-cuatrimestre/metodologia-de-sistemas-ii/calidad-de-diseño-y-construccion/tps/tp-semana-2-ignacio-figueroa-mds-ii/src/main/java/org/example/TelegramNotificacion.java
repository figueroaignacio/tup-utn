package org.example;

public class TelegramNotificacion implements Notificacion {

    private final String chatId;

    public TelegramNotificacion(String chatId) {
        this.chatId = chatId;
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[TELEGRAM] Enviando a " + chatId + ": " + mensaje);
    }
}

