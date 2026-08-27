package org.example;

public class GestorTurnos {

    private Notificacion canalNotificacion;

    public GestorTurnos(Notificacion canalNotificacion) {
        this.canalNotificacion = canalNotificacion;
    }

    public void setCanalNotificacion(Notificacion canalNotificacion) {
        this.canalNotificacion = canalNotificacion;
    }

    public void confirmarTurno(String paciente, String especialidad, String fechaHora) {

        String mensaje = String.format("Estimado/a %s, su turno de %s ha sido confirmado para el %s.",
                paciente, especialidad, fechaHora);

        if (this.canalNotificacion != null) {
            this.canalNotificacion.enviar(mensaje);
        } else {
            System.err.println("Error: No se ha configurado un canal de notificación.");
        }

    }

}
