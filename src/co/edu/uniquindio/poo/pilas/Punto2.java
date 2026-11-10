package src.co.edu.uniquindio.poo.pilas;

public class Punto2 {

    public static Pila<String> obtenerSegmento(Pila<String> original, int inicio, int fin) {
        Pila<String> resultado = new Pila<>();
        if (inicio < 1 || inicio > fin) {
            return resultado;
        }

        Pila<String> aux = new Pila<>();
        Pila<String> segmento = new Pila<>();  // aqui quedan al reves
        int posicion = 0;                     

        while (!original.isEmpty()) {
            String accion = original.pop();
            posicion++;
            aux.push(accion);
            if (posicion >= inicio && posicion <= fin) {
                segmento.push(accion);
            }
        }

        // 2 deja la original como estaba
        while (!aux.isEmpty()) {
            original.push(aux.pop());
        }

        //se retorna vacia
        if (fin > posicion) {
            return resultado;
        }

        while (!segmento.isEmpty()) {
            resultado.push(segmento.pop());
        }

        return resultado;
    }

    public static void main(String[] args) {
        Pila<String> acciones = new Pila<>();
        acciones.push("A1");
        acciones.push("A2");
        acciones.push("A3");
        acciones.push("A4");
        acciones.push("A5");
        acciones.push("A6"); 

        System.out.println("Original:");
        acciones.imprimir();

        System.out.println("Segmento inicio = 2, fin = 4:");
        obtenerSegmento(acciones, 2, 4).imprimir();

        System.out.println("Original despues (debe ser igual):");
        acciones.imprimir();

        System.out.println("inicio = fin = 3:");
        obtenerSegmento(acciones, 3, 3).imprimir();

        System.out.println("fin = 9 (supera la cantidad), esta vacia? "
                + obtenerSegmento(acciones, 2, 9).isEmpty());
        System.out.println("inicio = 0, esta vacia? " + obtenerSegmento(acciones, 0, 3).isEmpty());
        System.out.println("inicio > fin, esta vacia? " + obtenerSegmento(acciones, 4, 2).isEmpty());
    }
}

