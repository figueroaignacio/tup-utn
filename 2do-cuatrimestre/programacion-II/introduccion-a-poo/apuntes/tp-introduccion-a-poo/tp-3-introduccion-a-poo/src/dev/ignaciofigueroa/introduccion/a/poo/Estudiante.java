package dev.ignaciofigueroa.introduccion.a.poo;

/**
 *
 * @author Ignacio Figueroa
 */
public class Estudiante {

    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
    }

    public void subirCalificacion(double puntos) {
        calificacion += puntos;
        System.out.println("La calificación aumentó. Nueva calificación: " + calificacion);
    }

    public void bajarCalificacion(double puntos) {
        calificacion -= puntos;
        if (calificacion < 0) {
            calificacion = 0;
        }

        System.out.println("La calificación disminuyó. Nueva calificación: " + calificacion);
    }
}
