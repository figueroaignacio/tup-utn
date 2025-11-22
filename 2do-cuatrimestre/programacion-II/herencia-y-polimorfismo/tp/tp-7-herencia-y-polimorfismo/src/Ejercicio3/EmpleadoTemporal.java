package Ejercicio3;

public class EmpleadoTemporal extends Empleado {

    private final int horasTrabajadas;
    private final double tarifa;

    public EmpleadoTemporal(String nombre, int horas, double tarifa) {
        super(nombre);
        this.horasTrabajadas = horas;
        this.tarifa = tarifa;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas * tarifa;
    }

}
