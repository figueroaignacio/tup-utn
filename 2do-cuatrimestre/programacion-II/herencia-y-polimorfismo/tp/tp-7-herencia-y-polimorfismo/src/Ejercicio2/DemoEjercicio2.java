package Ejercicio2;

public class DemoEjercicio2 {

    public static void run() {
        System.out.println("=== Ejercicio 2: Figuras ===");

        Figura[] figuras = {
            new Circulo(3),
            new Rectangulo(4, 6)
        };

        for (Figura f : figuras) {
            f.mostrarArea();
        }

        System.out.println();
    }
}
