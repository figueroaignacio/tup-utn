package Ejercicio3;

public class Curso {

    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor p) {
        if (this.profesor == p) {
            return;
        }

        if (this.profesor != null) {
            Profesor old = this.profesor;
            this.profesor = null;
            old.eliminarCurso(this);
        }

        this.profesor = p;

        if (p != null && !p.getCursos().contains(this)) {
            p.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        System.out.println("Curso: " + codigo + " - " + nombre
                + " | Profesor: " + (profesor != null ? profesor.getNombre() : "Sin asignar"));
    }
}
