package Ejercicio3;

public abstract class Empleado {

    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularSueldo();

    public void mostrarSueldo() {
        System.out.printf("%s → Sueldo: %.2f%n", nombre, calcularSueldo());
    }

}
