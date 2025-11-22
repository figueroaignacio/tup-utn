package Ejercicio4;

public class DemoEjercicio4 {

    public static void run() {
        System.out.println("=== Ejercicio 4: Animales ===");

        Animal[] animales = {
            new Perro("Rex"),
            new Gato("Michi"),
            new Vaca("Lola")
        };

        for (Animal a : animales) {
            a.describirAnimal();
            a.hacerSonido();
            System.out.println();
        }
    }
}
