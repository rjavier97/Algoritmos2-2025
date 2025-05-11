package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero ;     // el de la izquierda
    private Nodo ultimo ;     // el de la derecha
    private int longitud ;

    private class Nodo {
        // Completar
        private T valor ;
        private Nodo anterior ;
        private Nodo siguiente ;

        Nodo(T v) { 
            valor = v; }    

        Nodo(){}

        
        public T valor() {
            return this.valor ;
        }    

    }


    public ListaEnlazada() {    // Vacia
        this.primero = null ;
        this.ultimo = null ;
        this.longitud = 0;
    }

    public int longitud() {
        return longitud ;
        // int tamaño = 0 ;
        // while (primero.siguiente != null) ;         // no sirve
        //     tamaño += 1 ;
        // return tamaño ;
        
    }

    public void agregarAdelante(T elem) {
        // this.primero.anterior (elem) ;
        Nodo nuevo = new Nodo(elem);
        nuevo.siguiente = primero ;
        primero.anterior = nuevo ;
        primero = nuevo ;

        this.longitud +=1 ;

    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null) {
            primero = nuevo ;
            this.longitud +=1 ;
        } else {
        nuevo.anterior = ultimo ;
        ultimo = nuevo ;
        this.longitud +=1 ;
        }
    }

    public T obtener(int i) {
        int j = 0 ;
        // Nodo actual = new Nodo();     // no sirve crear uno nuevo porque jamas lo uso, al hacer Nodo actual = primero, no hace falta crear una nueva instancia vacia
        Nodo actual = primero ;
        while (j<i && actual.siguiente!= null ) {
            j += 1 ;
            actual = actual.siguiente ;
        }

        return actual.valor() ;

    }

    public void eliminar(int i) {
        // int j = 0 ;
        // Nodo actual = 
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
