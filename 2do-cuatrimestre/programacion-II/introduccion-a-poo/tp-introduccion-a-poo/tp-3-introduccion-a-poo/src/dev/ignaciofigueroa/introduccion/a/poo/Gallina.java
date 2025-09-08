package dev.ignaciofigueroa.introduccion.a.poo;

/**
 *
 * @author Ignacio Figueroa
 */
public class Gallina {

    int idGallina;
    int edad;
    int huevosPuestos;

    public Gallina(int idGallina, int edad, int huevosPuestos) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = huevosPuestos;
    }

    public void ponerHuevo() {
        huevosPuestos++;
        System.out.println("La gallina: " + idGallina + " puso un huevo. Total: " + huevosPuestos);
    }

    public void envejecer() {
        edad++;
        System.out.println("La gallina: " + idGallina + " ahora tiene " + edad + " años");
    }

    public void mostrarEstado() {
        System.out.println("ID: " + idGallina);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Huevos puestos: " + huevosPuestos);
        System.out.println("-----------------------");
    }
}
