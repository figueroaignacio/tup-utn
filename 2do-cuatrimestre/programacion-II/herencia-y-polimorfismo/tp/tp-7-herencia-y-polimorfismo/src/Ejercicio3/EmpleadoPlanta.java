package Ejercicio3;

public class EmpleadoPlanta extends Empleado {

    private final double sueldoFijo;

    public EmpleadoPlanta(String nombre, double sueldoFijo) {
        super(nombre);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularSueldo() {
        return sueldoFijo;
    }

}
