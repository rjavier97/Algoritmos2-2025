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

    
    public Nodo sucesor(Nodo nodo){
        if (raiz == null){
            return null ;
        }
        if (nodo.der != null ){
            return busqueda_minimo(nodo.der);
        } 
        Nodo padre = nodo.padre;
        while (padre != null && padre.der == nodo){
            nodo = padre ;
            padre = padre.padre ;
        }
        return padre;
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
    }       
   
    public void eliminar(T elem) {
        Nodo nodo = buscar_nodo(elem, raiz);

        // Si el ABB es vacio o el elemento a eliminar no esta en el ABB 
        if (nodo == null || nodo.valor.compareTo(elem) != 0) {
            return;
        }

        // Caso en el que el Nodo tiene 2 hijos
        if (nodo.izq != null && nodo.der != null) {
            Nodo sucesor = busqueda_minimo(nodo.der);
            T valorSucesor = sucesor.valor;
            eliminar(valorSucesor); // eliminamos el nodo sucesor (que puede tener 1 hijo o ninguno)
            nodo.valor = valorSucesor; // reemplazo su valor
        }

        // Caso en el que el Nodo tiene 1 hijo o ninguno
        else {
            Nodo hijo = null;   // puede ser null si es hoja
            if (nodo.izq != null){
                hijo = nodo.izq;  
            } else {
                hijo = nodo.der;
            }     

            if (nodo == raiz) {
                raiz = hijo;
                if (hijo != null) hijo.padre = null;
            } else {
                Nodo padre = nodo.padre;
                if (padre.izq == nodo) {
                    padre.izq = hijo;
                } else {
                    padre.der = hijo;
                }
                if (hijo != null) {
                    hijo.padre = padre;
                }    
            }

            cardinal--;
        }
    }

    public void inorder(Nodo nodo, StringBuilder lista){
        if (nodo == null){
            return ;
        } else {
            inorder(nodo.izq, lista);
            lista.append(nodo.valor).append(",");
            inorder(nodo.der, lista);
        }
    }

    public String toString(){
        if (raiz == null){
            return "{}";
        }
        StringBuilder lista = new StringBuilder("{");
        inorder(raiz, lista);
        lista.deleteCharAt(lista.length()-1);
        lista.append("}");

        return lista.toString();
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual = busqueda_minimo(raiz);

        public boolean haySiguiente() {        
            // if (sucesor(actual) != null){
            //     return true ;
            // } else {
            //     return false ;
            // }   
            return actual != null ;
        }
    
        public T siguiente() {
            T elem = actual.valor ;
            if (haySiguiente()){       
                actual = sucesor(actual);
                return elem;
            } else {
                return null;
            }
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}



// Borrador ------------------------------------------------------Borrador------------------------------------------------------------------------Borrador 

// public void eliminar(T elem){
//     Nodo ultimo_nodo_buscado = buscar_nodo(elem, raiz) ;
//     if (ultimo_nodo_buscado.valor.compareTo(elem) == 0){ //si el nodo pertenece al ABB entonces se puede eliminar
//         if (ultimo_nodo_buscado == raiz){// El nodo a eliminar es la raiz
//             if (cardinal ==1){ // El nodo a eliminar es la raiz y el ABB tiene un solo elemento
//                 raiz = null;
//                 cardinal --;
//             } else { // El nodo a eliminar es la raiz y el ABB tiene mas de un elemento
//                 if (ultimo_nodo_buscado.der != null){ // El nodo a eliminar es la raiz y tiene sucesor
//                     Nodo sucesor = busqueda_minimo(ultimo_nodo_buscado.der);
//                     ultimo_nodo_buscado.valor = sucesor.valor;
//                     sucesor = null ;
//                 } else {  // El nodo a eliminar es la raiz y tiene antecesor
//                     Nodo antecesor = busqueda_maximo(ultimo_nodo_buscado.izq);
//                     ultimo_nodo_buscado.valor = antecesor.valor;
//                     antecesor = null ;
//                 }
//             }
//         } //----------------------------------------------------------------------------------------------------------------------------------------------------
//         if (ultimo_nodo_buscado.padre != null && ultimo_nodo_buscado.izq==null && ultimo_nodo_buscado.der==null){ // No tiene hijos 
//             if (ultimo_nodo_buscado.valor.compareTo(ultimo_nodo_buscado.padre.valor)<0){ // El hijo a eliminar es menor que el padre
//                 ultimo_nodo_buscado.padre.izq = null; 
//                 ultimo_nodo_buscado = null;
//                 cardinal --;
//             } else { // El hijo a eliminar es mayor que el padre 
//                 ultimo_nodo_buscado.padre.der = null; 
//                 ultimo_nodo_buscado = null;
//                 cardinal --;
//             }
//         }
//         if ( (ultimo_nodo_buscado.der == null && ultimo_nodo_buscado.izq != null) || (ultimo_nodo_buscado.izq == null && ultimo_nodo_buscado.der != null) ){  //Tiene solo un hijo
//             if(ultimo_nodo_buscado.der != null){  // el hijo del elemento a eliminar, esta del lado derecho
//                 if (ultimo_nodo_buscado.valor.compareTo(ultimo_nodo_buscado.padre.valor)<0){  // el elemento a eliminar es menor que el padre
//                     ultimo_nodo_buscado = ultimo_nodo_buscado.der ;
//                     ultimo_nodo_buscado.padre.izq = ultimo_nodo_buscado;         
//                     cardinal --;  
//                 } else { // el elemento a eliminar es mayor que el padre 
//                     ultimo_nodo_buscado.padre.der = ultimo_nodo_buscado.der ;
//                     ultimo_nodo_buscado.der.padre = ultimo_nodo_buscado.padre;
//                     cardinal --;  // el elemento a eliminar es mayor que el padre                
//                 }
//             } else {  // el hijo del elemento, esta del lado izquierdo
//                 if (ultimo_nodo_buscado.valor.compareTo(ultimo_nodo_buscado.padre.valor)<0){ 
//                     ultimo_nodo_buscado = ultimo_nodo_buscado.izq ;
//                     ultimo_nodo_buscado.padre.izq = ultimo_nodo_buscado;         
//                     cardinal --;  // el elemento a eliminar es menor que el padre
//                 } else {
//                     ultimo_nodo_buscado.padre.der = ultimo_nodo_buscado.izq ;
//                     ultimo_nodo_buscado.izq.padre = ultimo_nodo_buscado.padre;
//                     cardinal --;   // el elemento a eliminar es mayor que el padre                  
//                 }  
        
//             }        
//         } else { // Tiene 2 hijos
//                 Nodo sucesor = busqueda_minimo(ultimo_nodo_buscado.der);     
//                 ultimo_nodo_buscado.valor = sucesor.valor ;
//                 // eliminar(sucesor.valor);
//                 cardinal --;
//             }
//         } 
// }
