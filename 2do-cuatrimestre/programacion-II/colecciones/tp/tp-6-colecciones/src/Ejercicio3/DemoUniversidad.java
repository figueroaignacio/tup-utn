package Ejercicio3;

public class DemoUniversidad {

    public static void ejecutar() {
        Universidad u = new Universidad("Universidad Nacional");

        Profesor p1 = new Profesor("P001", "Ana Gómez", "Matemáticas");
        Profesor p2 = new Profesor("P002", "Luis Pérez", "Informática");
        Profesor p3 = new Profesor("P003", "María Ruiz", "Física");

        Curso c1 = new Curso("C101", "Cálculo I");
        Curso c2 = new Curso("C102", "Programación I");
        Curso c3 = new Curso("C103", "Física General");
        Curso c4 = new Curso("C104", "Algoritmos");

        u.agregarProfesor(p1);
        u.agregarProfesor(p2);
        u.agregarProfesor(p3);

        u.agregarCurso(c1);
        u.agregarCurso(c2);
        u.agregarCurso(c3);
        u.agregarCurso(c4);

        u.asignarProfesor("C101", "P001");
        u.asignarProfesor("C102", "P002");
        u.asignarProfesor("C103", "P003");
        u.asignarProfesor("C104", "P002");

        System.out.println("--- Cursos ---");
        u.listarCursos();

        System.out.println("\n--- Profesores ---");
        u.listarProfesores();

        System.out.println("\n--- Cambiar profesor de C104 a P003 ---");
        u.asignarProfesor("C104", "P003");
        u.listarCursos();

        System.out.println("\n--- Eliminar curso C103 ---");
        u.eliminarCurso("C103");
        u.listarCursos();

        System.out.println("\n--- Eliminar profesor P001 ---");
        u.eliminarProfesor("P001");
        u.listarProfesores();
        u.listarCursos();
    }
}
