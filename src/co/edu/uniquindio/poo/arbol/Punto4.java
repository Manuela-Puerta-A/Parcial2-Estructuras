package src.co.edu.uniquindio.poo.arbol;

public class Punto4 {
    public static int contarEquiposEnRango(NodoArbol<Integer> raiz, int inferior, int superior) {
        if (raiz == null || inferior > superior) {
            return 0;
        }

        int codigo = raiz.getElemento();

        if (codigo < inferior) {
            return contarEquiposEnRango(raiz.getHijoDerecho(), inferior, superior);
        }
        if (codigo > superior) {
            return contarEquiposEnRango(raiz.getHijoIzquierdo(), inferior, superior);
        }
        return 1 + contarEquiposEnRango(raiz.getHijoIzquierdo(), inferior, superior)
                + contarEquiposEnRango(raiz.getHijoDerecho(), inferior, superior);
    }

    public static void inorden(NodoArbol<Integer> raiz) {
        if (raiz == null) {
            return;
        }
        inorden(raiz.getHijoIzquierdo());
        System.out.print(raiz.getElemento() + " ");
        inorden(raiz.getHijoDerecho());
    }

    public static void main(String[] args) {
        Arbol<Integer> arbol = new Arbol<>();
        int[] codigos = { 50, 30, 70, 20, 40, 60, 80, 55, 65 };
        for (int i = 0; i < codigos.length; i++) {
            arbol.insertar(codigos[i]);
        }

        System.out.println("Equipos entre 35 y 65: " + contarEquiposEnRango(arbol.getRaiz(), 35, 65));
        System.out.println("Equipos entre 20 y 80: " + contarEquiposEnRango(arbol.getRaiz(), 20, 80));
        System.out.println("Equipos entre 81 y 99: " + contarEquiposEnRango(arbol.getRaiz(), 81, 99));
        System.out.println("Inferior > superior: " + contarEquiposEnRango(arbol.getRaiz(), 70, 30));
        System.out.println("Arbol vacio: " + contarEquiposEnRango(null, 1, 100));

        System.out.print("Inorden antes: ");
        inorden(arbol.getRaiz());
        System.out.println();

        arbol.eliminar(50);
        System.out.println("Nueva raiz: " + arbol.getRaiz().getElemento());
        System.out.print("Inorden despues: ");
        inorden(arbol.getRaiz());
        System.out.println();
    }
}
