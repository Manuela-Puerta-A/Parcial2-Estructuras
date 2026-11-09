package src.co.edu.uniquindio.poo.pilas;

public class Operacion {

    private String codigo;
    private String estado;

    public Operacion(String codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public boolean esConfirmada() {
        return estado.equals("CONFIRMADA");
    }

    @Override
    public String toString() {
        return codigo + " " + estado;
    }
}
