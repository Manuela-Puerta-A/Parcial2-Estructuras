package src.co.edu.uniquindio.poo.pilas;


public class Pila<T> {

    private int size;
    private Nodo<T> cima;

    public Pila (int limite){
        size = 0;
        cima = null;
    }
    public Pila (){
        size = 0;
        cima = null;
    }

    public boolean isEmpty(){
        return cima == null;
    }

    public void limpiarPila(){
        cima = null;
        size = 0;
    }

    public void push(T dato){
        Nodo<T> nuevoNodo = new Nodo<T>(dato);
        if(isEmpty()){
            cima = nuevoNodo;
        }else{
            nuevoNodo.setSiguiente(cima);
            cima = nuevoNodo;
        }
        size++;
    }

    public T pop(){
        if(cima == null){
            throw new RuntimeException("NO hay elementos en la pila");
        }else {
            T data = cima.getDato();
            cima = cima.getSiguiente();
            size--;
            return data;
        }
    }

    public void imprimir() {
        Nodo<T> aux = cima;
        while (aux != null){
            System.out.println("Elemento :" + aux.getDato()+"\t");
            aux = aux.getSiguiente();
        }
    }

    public void merge(Pila<T> pila2){
        Pila<T> clone = pila2.clone();

    }

    public Pila<T> clone() {
        Pila<T> pilaAuxiliar = new Pila<>();
        Pila<T> pilaClon = new Pila<>();

        Nodo<T> actual = cima;
        while (actual != null) {
            pilaAuxiliar.push(actual.getDato());
            actual = actual.getSiguiente();
        }

        while (!pilaAuxiliar.isEmpty()) {
            pilaClon.push(pilaAuxiliar.pop());
        }

        return pilaClon;
    }

    public void add(Pila<T> other) {
        Pila<T> aux = new Pila<>();

        for (Nodo<T> n = other.cima; n != null; n = n.getSiguiente()) {
            aux.push(n.getDato());
        }
        while (!aux.isEmpty()) {
            push(aux.pop());
        }
    }
}

