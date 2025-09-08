package dev.ignaciofigueroa.introduccion.a.poo;

/**
 *
 * @author Ignacio Figueroa
 */
public class NaveEspacial {

    private String nombre;
    private double combustible;
    private final double CAPACIDAD_MAX = 100;

    public NaveEspacial(String nombre, double combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }

    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println("La nave " + nombre + " despegó. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para despegar.");
        }
    }

    public void avanzar(double distancia) {
        double consumo = distancia;

        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println("La nave avanzó " + distancia + " km. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para avanzar " + distancia + " km.");
        }
    }

    public void recargarCombustible(double cantidad) {
        if (combustible + cantidad > CAPACIDAD_MAX) {
            combustible = CAPACIDAD_MAX;
            System.out.println("⛽ Tanque lleno. Capacidad máxima alcanzada: " + CAPACIDAD_MAX);
        } else {
            combustible += cantidad;
            System.out.println("⛽ Se recargaron " + cantidad + " unidades. Combustible actual: " + combustible);
        }
    }

    public void mostrarEstado() {
        System.out.println("🛰️ Nave: " + nombre);
        System.out.println("Combustible: " + combustible + " / " + CAPACIDAD_MAX);
        System.out.println("-----------------------");
    }
}
