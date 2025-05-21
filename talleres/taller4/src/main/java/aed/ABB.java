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

    public Nodo busqueda_minimo(Nodo nodo){
        if (nodo.izq == null){
            return nodo ;
        } else {
            return busqueda_minimo(nodo.izq);
        }
    }

    public T minimo(){
        return busqueda_minimo(raiz).valor;
    }

    public Nodo busqueda_maximo(Nodo nodo){
        if (nodo.der == null){
            return nodo ;
        } else {
            return busqueda_maximo(nodo.der);
        }
    }

    public T maximo(){
        return busqueda_maximo(raiz).valor;
    }
    
    public Nodo buscar_nodo(T elem, Nodo nodo){
        if (cardinal == 0){
            return nodo;
        } else {
            if (nodo != null && elem.compareTo(nodo.valor)==0){
                return nodo;
            }    
            if (nodo != null && nodo.izq != null && elem.compareTo(nodo.valor) < 0){
                return buscar_nodo(elem, nodo.izq);
            }
            if (nodo != null && nodo.der != null && elem.compareTo(nodo.valor) > 0){
                return buscar_nodo(elem, nodo.der);
            }          
        }
        return nodo;    
    }

    public void insertar(T elem){
        Nodo nuevo = new Nodo(elem);
        Nodo ultimo_nodo_buscado = buscar_nodo(elem, raiz);
        if (ultimo_nodo_buscado != null && elem.compareTo(ultimo_nodo_buscado.valor)==0 ){
        } else {
            if (ultimo_nodo_buscado == null){
            raiz = nuevo;
            nuevo.padre = raiz;
            cardinal ++;
            altura +=1 ;
            } else {
                if (elem.compareTo(ultimo_nodo_buscado.valor) <0){
                    ultimo_nodo_buscado.izq = nuevo ;
                    nuevo.padre = ultimo_nodo_buscado;
                    cardinal ++;
                    altura +=1 ;
                }
                if (elem.compareTo(ultimo_nodo_buscado.valor)>0){
                    ultimo_nodo_buscado.der = nuevo ;
                    nuevo.padre = ultimo_nodo_buscado;
                    cardinal ++;
                    altura +=1 ;
                }
            }    
        }
    }

    public boolean pertenece(T elem){
        Nodo ultimo_nodo_buscado = buscar_nodo(elem, raiz);
        return raiz != null && elem.compareTo(ultimo_nodo_buscado.valor)==0 ;
        // boolean res = false;
        // if (raiz == null){   
        // } else {
        //     if (elem.compareTo(ultimo_nodo_buscado.valor)==0 ){
        //         res = true;
        //     }             
        // }
        //return res ;
    }       

    public void eliminar(T elem){
        Nodo ultimo_nodo_buscado = buscar_nodo(elem, raiz) ;
        if (ultimo_nodo_buscado.valor.compareTo(elem) == 0){ //si el nodo pertenece al ABB entonces se puede eliminar
            if (ultimo_nodo_buscado == raiz){ // El ABB tiene solo la raiz, y la raiz es el nodo a eliminar
                raiz = null;
                cardinal --;
            }
            if (ultimo_nodo_buscado.padre != null && ultimo_nodo_buscado.izq==null && ultimo_nodo_buscado.der==null){ // No tiene hijos 
                if (ultimo_nodo_buscado.valor.compareTo(ultimo_nodo_buscado.padre.valor)<0){
                    ultimo_nodo_buscado.padre.izq = null; 
                    ultimo_nodo_buscado = null;
                    cardinal --;
                } else {
                    ultimo_nodo_buscado.padre.der = null; 
                    ultimo_nodo_buscado = null;
                    cardinal --;
                }
            }
            if (ultimo_nodo_buscado.der == null || ultimo_nodo_buscado.izq == null){  //Tiene solo un hijo
                if(ultimo_nodo_buscado.der != null){  // el hijo del elemento, esta del lado derecho
                    if (ultimo_nodo_buscado.valor.compareTo(ultimo_nodo_buscado.padre.valor)<0){
                        ultimo_nodo_buscado = ultimo_nodo_buscado.der ;
                        ultimo_nodo_buscado.padre.izq = ultimo_nodo_buscado;         
                        cardinal --;  // el elemento a eliminar es menor que el padre
                    } else {
                        ultimo_nodo_buscado.padre.der = ultimo_nodo_buscado.der ;
                        ultimo_nodo_buscado.der.padre = ultimo_nodo_buscado.padre;
                        cardinal --;  // el elemento a eliminar es mayor que el padre                
                    }
                } else {  // el hijo del elemento, esta del lado izquierdo
                    if (ultimo_nodo_buscado.valor.compareTo(ultimo_nodo_buscado.padre.valor)<0){ 
                        ultimo_nodo_buscado = ultimo_nodo_buscado.izq ;
                        ultimo_nodo_buscado.padre.izq = ultimo_nodo_buscado;         
                        cardinal --;  // el elemento a eliminar es menor que el padre
                    } else {
                        ultimo_nodo_buscado.padre.der = ultimo_nodo_buscado.izq ;
                        ultimo_nodo_buscado.izq.padre = ultimo_nodo_buscado.padre;
                        cardinal --;   // el elemento a eliminar es mayor que el padre                  
                    }  
           
                }        
            } else { // Tiene 2 hijos
                Nodo sucesor = busqueda_minimo(ultimo_nodo_buscado.der);
                if (sucesor.izq==null && sucesor.der==null){ // si el sucesor no tiene hijos
                    ultimo_nodo_buscado = sucesor ;
                    ultimo_nodo_buscado.padre.der = ultimo_nodo_buscado ;
                    ultimo_nodo_buscado.der.padre = ultimo_nodo_buscado;
                    cardinal --;
                }
            }
        }
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
