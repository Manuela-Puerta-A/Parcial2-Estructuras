package co.edu.uniquindio.poo.colas;


public class Solicitud {

    private String codigo;
    private String prioridad;
    private int duracion;

    public Solicitud(String codigo, String prioridad, int duracion) {
        this.codigo = codigo;
        this.prioridad = prioridad;
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return codigo + "(" + prioridad + " " + duracion + "min)";
    }
}
