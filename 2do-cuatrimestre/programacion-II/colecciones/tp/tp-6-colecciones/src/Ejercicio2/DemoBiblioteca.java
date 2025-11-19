package Ejercicio2;
import Ejercicio2.Biblioteca;

public class DemoBiblioteca {

    public static void ejecutar() {
        Biblioteca b = new Biblioteca("Biblioteca Central");

        Autor a1 = new Autor("A001", "Gabriel García Márquez", "Colombiana");
        Autor a2 = new Autor("A002", "J.K. Rowling", "Británica");
        Autor a3 = new Autor("A003", "Haruki Murakami", "Japonesa");

        b.agregarLibro("ISBN001", "Cien años de soledad", 1967, a1);
        b.agregarLibro("ISBN002", "Harry Potter 1", 1997, a2);
        b.agregarLibro("ISBN003", "Kafka en la orilla", 2002, a3);
        b.agregarLibro("ISBN004", "El amor en los tiempos del cólera", 1985, a1);

        System.out.println("--- Listado de libros ---");
        b.listarLibros();

        System.out.println("\n--- Buscar ISBN003 ---");
        Libro l = b.buscarLibroPorIsbn("ISBN003");
        if (l != null) {
            l.mostrarInfo();
        }

        System.out.println("\n--- Filtrar por año 1997 ---");
        b.filtrarLibrosPorAnio(1997).forEach(Libro::mostrarInfo);

        System.out.println("\n--- Eliminar ISBN002 ---");
        b.eliminarLibro("ISBN002");
        b.listarLibros();

        System.out.println("\n--- Total de libros ---");
        System.out.println(b.obtenerCantidadLibros());

        System.out.println("\n--- Autores disponibles ---");
        b.mostrarAutoresDisponibles();
    }
}
