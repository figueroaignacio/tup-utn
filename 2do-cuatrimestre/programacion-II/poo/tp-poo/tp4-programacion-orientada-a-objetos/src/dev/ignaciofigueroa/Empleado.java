package dev.ignaciofigueroa;

/**
 *
 * @author Ignacio Figueroa
 */
public class Empleado {

    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    static int totalEmpleados = 0;
    private static int contadorId = 0;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.id = ++contadorId;
        totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 100000; // salario por defecto
        totalEmpleados++;
    }

    public Empleado(String nombre) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.puesto = "Sin asignar";
        this.salario = 80000;
        totalEmpleados++;
    }

    public void actualizarSalario(double porcentaje) {
        this.salario += this.salario * (porcentaje / 100);
    }

    public void actualizarSalario(int cantidadFija) {
        this.salario += cantidadFija;
    }

    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", puesto=" + puesto + ", salario=" + salario + '}';
    }

}
