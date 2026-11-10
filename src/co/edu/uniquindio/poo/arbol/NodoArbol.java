package src.co.edu.uniquindio.poo.arbol;
import src.co.edu.uniquindio.poo.pilas.Nodo;

public class NodoArbol<T extends Comparable> {

    private T elemento;
    private NodoArbol<T> hijoIzquierdo;
    private NodoArbol<T> hijoDerecho;
    private NodoArbol<T> padre;

    int fe;

    public NodoArbol(T elemento, NodoArbol<T> padre) {
        this.elemento = elemento;
        this.padre = padre; // (agregado) el constructor original no guardaba el padre y eliminar() fallaba
        this.fe = 0;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbol<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbol<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbol<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public NodoArbol<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol<T> padre) {
        this.padre = padre;
    }

    public void insertar(){

    }
}

