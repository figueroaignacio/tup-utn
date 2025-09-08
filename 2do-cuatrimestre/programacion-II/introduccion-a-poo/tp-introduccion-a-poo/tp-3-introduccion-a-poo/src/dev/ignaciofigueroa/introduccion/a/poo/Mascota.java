package dev.ignaciofigueroa.introduccion.a.poo;

/**
 *
 * @author Ignacio Figueroa
 */
public class Mascota {

    private String nombre;
    private String especie;
    private int edad;

    public Mascota(String nombre, String especie, int edad) {
        this.edad = edad;
        this.nombre = nombre;
        this.especie = especie;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);
    }

    public void cumplirAnios(int anios) {
        edad += anios;

        System.out.println(nombre + " cumplió " + edad);
    }
}
