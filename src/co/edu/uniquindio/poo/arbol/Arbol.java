package src.co.edu.uniquindio.poo.arbol;

import src.co.edu.uniquindio.poo.pilas.Nodo;

public class Arbol<T extends Comparable> {

    private NodoArbol<T> raiz;
    private int peso;

    Arbol() {
        peso = 0;
        raiz = null;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void inorden() {
        inorden(raiz);
    }

    private void inorden(NodoArbol<T> raizAux) {
        if (raizAux == null) {
            return;
        }
        inorden(raizAux.getHijoIzquierdo());
        System.out.print(raizAux.getElemento());
        inorden(raizAux.getHijoDerecho());
    }

    public void preorden() {
        preorden(raiz);
    }

    private void preorden(NodoArbol<T> raizAux) {
        if (raizAux == null) {
            return;
        }
        System.out.println(raizAux.getElemento());
        preorden(raizAux.getHijoIzquierdo());
        preorden(raizAux.getHijoDerecho());
    }

    public void postorden() {
        postorden(raiz);
    }

    private void postorden(NodoArbol<T> raizAux) {
        if (raizAux == null) {
            return;
        }
        postorden(raizAux.getHijoIzquierdo());
        postorden(raizAux.getHijoDerecho());
        System.out.println(raizAux.getElemento());
    }

    public int obtenerPeso() {
        return obtenerPeso(raiz);
    }

    private int obtenerPeso(NodoArbol<T> raizAux) {
        if (raizAux == null) {
            return 0;
        }
        return 1 + obtenerPeso(raizAux.getHijoIzquierdo())
                + obtenerPeso(raizAux.getHijoDerecho());
    }

    public int calcularAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(NodoArbol<T> raizAux) {
        if (raizAux == null) {
            return 0;
        }
        int alturaIzquierda = 1 + calcularAltura(raizAux.getHijoIzquierdo());
        int alturaDerecha = 1 + calcularAltura(raizAux.getHijoDerecho());

        if (alturaIzquierda > alturaDerecha) {
            return alturaIzquierda;
        } else
            return alturaDerecha;
    }

    public boolean buscarNodo(T buscado) {
        return buscarNodo(raiz, buscado);
    }

    private boolean buscarNodo(NodoArbol<T> rootAux, T buscado) {
        if (rootAux == null) {
            return false;
        }
        int cmp = rootAux.getElemento().compareTo(buscado);
        if (cmp == 0) {
            return true;
        }
        if (cmp > 0) {
            return buscarNodo(rootAux.getHijoIzquierdo(), buscado);
        }
        return buscarNodo(rootAux.getHijoDerecho(), buscado);
    }

    private NodoArbol<T> buscarNodo2(NodoArbol<T> rootAux, T buscado) {
        if (rootAux == null) {
            return null;
        }
        int cmp = rootAux.getElemento().compareTo(buscado);
        if (cmp == 0) {
            return rootAux;
        }
        if (cmp > 0) {
            return buscarNodo2(rootAux.getHijoIzquierdo(), buscado);
        }
        return buscarNodo2(rootAux.getHijoDerecho(), buscado);
    }

    public void insertar(T elemento) {

        raiz = insertar(raiz, elemento, null);
    }

    private NodoArbol<T> insertar(NodoArbol<T> raizAux, T elemento, NodoArbol<T> padre) {
        if (raizAux == null) {
            NodoArbol<T> nuevoNodo = new NodoArbol<>(elemento, padre);
            peso++;
            return nuevoNodo;
        } else {
            int cmp = raizAux.getElemento().compareTo(elemento);
            if (cmp == 0) {
                throw new RuntimeException("El nodo ya existe");
            }
            if (cmp > 0) {
                raizAux.setHijoIzquierdo(insertar(raizAux.getHijoIzquierdo(), elemento, raizAux));
            } else {
                raizAux.setHijoDerecho(insertar(raizAux.getHijoDerecho(), elemento, raizAux));
            }

            return raizAux;
        }
    }

    public void eliminar(T element) {
        eliminar(raiz, element);
    }

    private void eliminar(NodoArbol<T> rootAux, T element) {

        NodoArbol<T> encontrado = buscarNodo2(rootAux, element);

        if (encontrado == null) {
            System.out.println("El elemento no existe en el arbol");
            return;
        }

        if (encontrado == raiz && !(encontrado.getHijoIzquierdo() != null
                && encontrado.getHijoDerecho() != null)) { /// Es la Raiz y tiene solo 0 o 1 hijos
            if (encontrado.getHijoIzquierdo() == null && encontrado.getHijoDerecho() == null) { // si no tiene hijos
                raiz = null;
            } else if (encontrado.getHijoIzquierdo() == null && encontrado.getHijoDerecho() != null) { // el hijo esta a
                                                                                                       // la derecha
                raiz = encontrado.getHijoDerecho();
                raiz.setPadre(null);
            } else {
                raiz = encontrado.getHijoIzquierdo();
                raiz.setPadre(null);
            }
            System.out.println("Nodo eliminado");
            peso--;
            return;
        }

        if (encontrado.getHijoIzquierdo() == null && encontrado.getHijoDerecho() == null) {
            int cmp = encontrado.getPadre().getElemento().compareTo(element);

            if (cmp > 0) {
                encontrado.getPadre().setHijoIzquierdo(null);
            } else {
                encontrado.getPadre().setHijoDerecho(null);
            }
            System.out.println("Nodo eliminado");
            peso--;
            return;
        }

        if (!(encontrado.getHijoIzquierdo() != null && encontrado.getHijoDerecho() != null)) {
            int cmp = encontrado.getPadre().getElemento().compareTo(element);

            if (cmp > 0) {
                if (encontrado.getHijoIzquierdo() != null) {
                    encontrado.getHijoIzquierdo().setPadre(encontrado.getPadre());
                    encontrado.getPadre().setHijoIzquierdo(encontrado.getHijoIzquierdo());
                } else {
                    encontrado.getHijoDerecho().setPadre(encontrado.getPadre());
                    encontrado.getPadre().setHijoIzquierdo(encontrado.getHijoDerecho());
                }
            } else {
                if (encontrado.getHijoIzquierdo() != null) {
                    encontrado.getHijoIzquierdo().setPadre(encontrado.getPadre());
                    encontrado.getPadre().setHijoDerecho(encontrado.getHijoIzquierdo());
                } else {
                    encontrado.getHijoDerecho().setPadre(encontrado.getPadre());
                    encontrado.getPadre().setHijoDerecho(encontrado.getHijoDerecho());
                }
            }

        } else {
            NodoArbol<T> nodoAux = encontrarNodoAux(encontrado.getHijoIzquierdo());
            encontrado.setElemento(nodoAux.getElemento());

            if (nodoAux.getPadre() == encontrado) {
                encontrado.setHijoIzquierdo(nodoAux.getHijoIzquierdo());
            } else {
                nodoAux.getPadre().setHijoDerecho(nodoAux.getHijoIzquierdo());
            }
            if (nodoAux.getHijoIzquierdo() != null) {
                nodoAux.getHijoIzquierdo().setPadre(nodoAux.getPadre());
            }
        }

        System.out.println("Nodo eliminado");
        peso--;
    }

    private NodoArbol<T> encontrarNodoAux(NodoArbol<T> rootAux) {
        if (rootAux.getHijoDerecho() == null) {
            return rootAux;
        }
        return encontrarNodoAux(rootAux.getHijoDerecho());
    }

    public void borrarArbol() {
        raiz = null;
        peso = 0;
    }

}
