package src.co.edu.uniquindio.poo.colas;

import java.util.NoSuchElementException;

public class Cola<T> {

    private int size;
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int limite;
  
    public Cola(int limite ) {
        size = 0;
        nodoPrimero = null;
        nodoUltimo = null;
        this.limite = limite;
    }

    public int getSize() {
        return size;
    }

    public void encolar(T dato){
        if(size == limite){
            throw new ColaLlena("La cola esta llena");
        }

        Nodo<T> nuevoNodo = new Nodo<T>(dato);
        if(isEmpty()){
            nodoPrimero = nuevoNodo;
            nodoUltimo = nuevoNodo;
        }else{
            nodoUltimo.setSiguiente(nuevoNodo);
            nodoUltimo = nuevoNodo;
        }
        size++;
    }
  
    public T desencolar(){
        if(isEmpty()){
           throw new NoSuchElementException("No hay elemntos en la cola");
        }else{
            T dato = nodoPrimero.getDato();
            nodoPrimero = nodoPrimero.getSiguiente();
            if(nodoPrimero == null){
                nodoUltimo = null;
            }
            size--;
            return dato;
        }

    }

    private boolean isEmpty() {
        return size == 0;
    }


    public void imprimir() {
        Nodo<T> auxiliar = nodoPrimero;
        while(auxiliar != null){
            System.out.print(auxiliar.getDato()+" -> ");
            auxiliar = auxiliar.getSiguiente();//incremento
        }
    }
    public void imprimir2() {
    
        for(Nodo<T> auxiliar = nodoPrimero; auxiliar != null; auxiliar = auxiliar.getSiguiente()){
           
            System.out.print(auxiliar.getDato()+" -> ");
        }
    }

    public void imprimir3( ) {
        imprimir3(nodoPrimero);
    }

    private void imprimir3(Nodo<T> aux ) {
        if(aux == null){
            return;
        }else {
            imprimir3(aux.getSiguiente());
            System.out.print(aux.getDato()+" -> ");
        }
    }


}
