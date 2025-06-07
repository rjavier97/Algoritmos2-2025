package aed;

public class MaxHeap<T extends Comparable<T> >{
    // private Monto[] MontosOrdenados ;
    private Nodo raiz ;
    private int cardinal ;

    private class Nodo {
        T valor ;
        Nodo izq ;
        Nodo der ;
        Nodo padre ;
        int posicion ;

        Nodo (T v) {
            valor = v ;
            izq = null ;
            der = null ;
            padre = null ;
            posicion = 0 ;
        }
    }

    public MaxHeap() {
        raiz = null ;
        cardinal = 0 ;
    }

    public int cardinal() {
        return cardinal ;
    }

    public void insertar (T elem){
        Nodo nuevo = new Nodo(elem);
        if ()

    } 

    

    

}