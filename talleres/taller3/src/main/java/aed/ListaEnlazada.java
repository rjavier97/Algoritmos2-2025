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
         if (primero == null) {     // aca es la misma logica de agregarAtras , podria haber puesto ultimo=null que significaria lo mismo
            primero = nuevo;    //  osea que la lista es vacia
            ultimo = nuevo;
        } else {    
        nuevo.siguiente = primero ;
        primero.anterior = nuevo ;
        primero = nuevo ;
        }

        this.longitud +=1 ;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null) { // aca es la misma logica de agregarAtras , podria haber puesto ultimo=null que significaria lo mismo
            primero = nuevo;   //  osea que la lista es vacia
            ultimo = nuevo;
        } else {
        nuevo.anterior = ultimo ;
        ultimo.siguiente = nuevo ;
        ultimo = nuevo;
        }
        this.longitud +=1 ;
    }

    public T obtener(int i) {
        int j = 0 ;
        // Nodo actual = new Nodo();     // no sirve crear uno nuevo porque jamas lo uso, al hacer Nodo actual = primero, no hace falta crear una nueva instancia vacia
        Nodo actual = this.primero ;
        while (j<i && actual.siguiente!= null ) {
            j += 1 ;
            actual = actual.siguiente ;
        }
        return actual.valor() ;

    }

    public void eliminar(int i) {
        Nodo actual = primero ;
        Nodo previo = primero ;
        for (int j=0 ; j<i ; j++){
            previo = actual ;
            actual = actual.siguiente ;
        }
        if (i ==0){
            primero = actual.siguiente ;
        } else {
            previo.siguiente = actual.siguiente ;
        }

        this.longitud -=1 ;  
    }

    public void modificarPosicion(int indice, T elem) {
        int j = 0 ;
        // Nodo actual = new Nodo();     // no sirve crear uno nuevo porque jamas lo uso, al hacer Nodo actual = primero, no hace falta crear una nueva instancia vacia
        Nodo actual = this.primero ;
        while (j<indice && actual.siguiente!= null ) {
            j += 1 ;
            actual = actual.siguiente ;
        }
        actual.valor = elem ;  // Aca estoy modificando el atributo privado valor de la clase Nodo.
        //  Ojo que no es lo mismo hacer actual.valor() = elem . De hecho no se puede, ya que () es una funcion y me retorna algo.
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        // throw new UnsupportedOperationException("No implementada aun");
        Nodo actual = lista.primero ;
        while (actual != null){
            this.agregarAtras(actual.valor);
            actual = actual.siguiente;
        } 

    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        // int dedito ;

        // Iterador(){
        //     dedito = 0;
        // }

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
            // return dedito != longitud ;
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
            // int i = dedito;
            // dedito = dedito + 1;
            // return 
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
