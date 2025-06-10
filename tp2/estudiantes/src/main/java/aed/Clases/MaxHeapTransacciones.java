package aed.Clases;

import aed.*;

public class MaxHeapTransacciones {
    private Transaccion[] heap;
    private Transaccion[] transaccionesOriginal;
    private int tamaño;
    private int montoTotalSinCreacion;
    private int tamañoSinCreacion;

    public MaxHeapTransacciones(Transaccion[] transacciones) {
        this.tamaño = transacciones.length;
        this.heap = new Transaccion[tamaño];
        this.transaccionesOriginal = transacciones;

        for (int i = 0; i < tamaño; i++) {
            heap[i] = transacciones[i];
        }

        // Heapify
        for (int i = tamaño / 2 - 1; i >= 0; i--) {
            bajar(i);
        }
    }

    public boolean estaVacio() {
        return tamaño == 0;
    }

    public Transaccion desencolar() {
        if (estaVacio()) 
        return null;
        Transaccion max = heap[0];
        heap[0] = heap[--tamaño];
        bajar(0);
        return max;
    }

    private void bajar(int i) {
        while (true) {
            int izq = 2 * i + 1, der = 2 * i + 2, mayor = i;

            if (izq < tamaño && heap[izq].compareTo(heap[mayor]) > 0) mayor = izq;
            if (der < tamaño && heap[der].compareTo(heap[mayor]) > 0) mayor = der;

            if (mayor != i) {
                Transaccion tmp = heap[i];
                heap[i] = heap[mayor];
                heap[mayor] = tmp;
                i = mayor;
            } else break;
        }
    }

    public Transaccion transaccionMayorValor(){
        return heap[0];
    }

    public Transaccion[] copia (){
        Transaccion[] copiaTransacciones = new Transaccion[tamaño];
        for(int i =0 ; i<tamaño-1 ; i++){
            copiaTransacciones[i] = transaccionesOriginal[i] ;
        }
        return copiaTransacciones;
    }
}
