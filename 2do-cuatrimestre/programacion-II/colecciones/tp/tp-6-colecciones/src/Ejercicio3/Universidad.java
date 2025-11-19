package Ejercicio3;

import java.util.List;
import java.util.ArrayList;

public class Universidad {

    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void agregarProfesor(Profesor p) {
        profesores.add(p);
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public Profesor buscarProfesor(String id) {
        return profesores.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public Curso buscarCurso(String codigo) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public void asignarProfesor(String codigoCurso, String idProfesor) {
        Curso c = buscarCurso(codigoCurso);
        Profesor p = buscarProfesor(idProfesor);
        if (c != null) {
            c.setProfesor(p);
        }
    }

    public void listarCursos() {
        cursos.forEach(Curso::mostrarInfo);
    }

    public void listarProfesores() {
        profesores.forEach(Profesor::mostrarInfo);
    }

    public void eliminarCurso(String codigo) {
        Curso c = buscarCurso(codigo);
        if (c != null) {
            if (c.getProfesor() != null) {
                c.getProfesor().eliminarCurso(c);
            }
            cursos.remove(c);
        }
    }

    public void eliminarProfesor(String id) {
        Profesor p = buscarProfesor(id);
        if (p != null) {
            for (Curso c : new ArrayList<>(p.getCursos())) {
                c.setProfesor(null);
            }
            profesores.remove(p);
        }
    }

}
