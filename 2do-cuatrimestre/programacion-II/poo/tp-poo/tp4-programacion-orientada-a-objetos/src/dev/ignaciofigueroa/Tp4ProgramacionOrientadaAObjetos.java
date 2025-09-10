package dev.ignaciofigueroa;

/**
 *
 * @author Ignacio Figueroa
 */
public class Tp4ProgramacionOrientadaAObjetos {

    public static void main(String[] args) {
        // Usando el constructor completo
        Empleado e1 = new Empleado("Juan Pérez", "Desarrollador", 150000);

        // Usando constructor sobrecargado (nombre + puesto)
        Empleado e2 = new Empleado("María López", "Diseñadora");

        // Usando constructor sobrecargado (solo nombre)
        Empleado e3 = new Empleado("Carlos Gómez");

        e1.actualizarSalario(10.0);    // +10%
        e2.actualizarSalario(20000);   // +20.000

        // Mostrar info
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        // Mostrar total de empleados creados
        System.out.println("\nTotal de empleados creados: " + Empleado.mostrarTotalEmpleados());

    }

}
