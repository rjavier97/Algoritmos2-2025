package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int cardinal;
    private int altura;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre; 

        // Crear Constructor del nodo
        Nodo (T v) {
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        raiz = null ;
        cardinal = 0;
        altura = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T maximo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void insertar(T elem){
        Nodo nuevo = new Nodo(elem);
        // if (elem.compareTo(raiz.valor)>0) {  //caso en el que elem es mayor que el valor de la raiz
        //     nuevo.padre = raiz;
        // }
        if (cardinal == 0){
            raiz = nuevo;
            nuevo.padre = raiz;
            cardinal +=1;
        }
    }

    public boolean pertenece(T elem){
        boolean res = false ;
        if (this.raiz == null) {
        }
        if (this.raiz.valor == elem){
            res = true;
        }
        if ()
        return res ;   
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
