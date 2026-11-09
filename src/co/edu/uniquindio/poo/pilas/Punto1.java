package src.co.edu.uniquindio.poo.pilas;

public class Punto1 {

    public static Pila<Operacion> obtenerUltimasConfirmadas(Pila<Operacion> historial, int n) {
        Pila<Operacion> resultado = new Pila<>();

        if (n <= 0) {
            return resultado;
        }

        Pila<Operacion> aux = new Pila<>();
        Pila<Operacion> confirmadas = new Pila<>();
        int contador = 0;

        while (!historial.isEmpty()) {
            Operacion op = historial.pop();
            aux.push(op);
            if (op.esConfirmada() && contador < n) {
                confirmadas.push(op);
                contador++;
            }
        }

        while (!aux.isEmpty()) {
            historial.push(aux.pop());
        }

        while (!confirmadas.isEmpty()) {
            resultado.push(confirmadas.pop());
        }

        return resultado;
    }

    public static void main(String[] args) {
        Pila<Operacion> historial = new Pila<>();

        historial.push(new Operacion("O1", "ANULADA"));
        historial.push(new Operacion("O2", "CONFIRMADA"));
        historial.push(new Operacion("O3", "CONFIRMADA"));
        historial.push(new Operacion("O4", "ANULADA"));
        historial.push(new Operacion("O5", "CONFIRMADA"));

        System.out.println("Historial original:");
        historial.imprimir();

        Pila<Operacion> resultado = obtenerUltimasConfirmadas(historial, 2);
        System.out.println("Resultado con n = 2:");
        resultado.imprimir();

        System.out.println("Historial despues (debe ser igual):");
        historial.imprimir();

        System.out.println("Con n = 10 (hay menos de 10 confirmadas):");
        obtenerUltimasConfirmadas(historial, 10).imprimir();

        System.out.println("Con n = 0 (vacia):");
        System.out.println(obtenerUltimasConfirmadas(historial, 0).isEmpty());
    }
}
