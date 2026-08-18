package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE TURNOS - HOSPITAL CENTRAL ===\n");

        // 1. Notificación inicial por Email
        Notificacion email = new EmailNotificacion("paciente1@email.com");
        GestorTurnos gestor = new GestorTurnos(email);
        gestor.confirmarTurno("Juan Pérez", "Cardiología", "20/09/2026 10:00 hs");

        // 2. Cambio dinámico a SMS
        Notificacion sms = new SmsNotificacion("+5491100001111");
        gestor.setCanalNotificacion(sms);
        gestor.confirmarTurno("Roberto Gómez", "Oftalmología", "20/09/2026 11:30 hs");

        // 3. Cambio dinámico a WhatsApp
        Notificacion whatsapp = new WhatsappNotificacion("+5491122334455");
        gestor.setCanalNotificacion(whatsapp);
        gestor.confirmarTurno("María García", "Dermatología", "21/09/2026 14:30 hs");

        // 4. Extensión con Telegram (sin modificar GestorTurnos)
        Notificacion telegram = new TelegramNotificacion("@maria_g");
        gestor.setCanalNotificacion(telegram);
        gestor.confirmarTurno("María García", "Dermatología (Recordatorio)", "21/09/2026 14:30 hs");

        // 5. Extensión con Push Notification
        Notificacion push = new PushNotificacion("TOKEN_DEVICE_XYZ987");
        gestor.setCanalNotificacion(push);
        gestor.confirmarTurno("Carlos López", "Traumatología", "22/09/2026 09:15 hs");
    }
}