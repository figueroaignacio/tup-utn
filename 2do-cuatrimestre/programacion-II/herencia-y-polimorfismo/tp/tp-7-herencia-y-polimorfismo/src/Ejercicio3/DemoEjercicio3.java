package Ejercicio3;

public class DemoEjercicio3 {

    public static void run() {
        System.out.println("=== Ejercicio 3: Empleados ===");

        Empleado[] empleados = {
            new EmpleadoPlanta("Ana", 80000),
            new EmpleadoTemporal("Luis", 120, 1500)
        };

        for (Empleado e : empleados) {
            e.mostrarSueldo();
        }

        System.out.println();
    }

}
