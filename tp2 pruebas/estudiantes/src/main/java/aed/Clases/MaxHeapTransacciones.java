// package aed.Clases;

// import java.util.ArrayList;

// import aed.Transaccion;

// public class MaxHeapTransacciones{
//     // private Transaccion[] ultimoBloqueOrdenado;
//     private Transaccion[] transaccionesOriginal;
//     private Transaccion[] heapTransacciones ;
//     private int tamaño;
//     private int capacidad;
//     private int capacidadSinCreacion ;
//     private int montoTotal;

//     public MaxHeapTransacciones (Transaccion[] transacciones){
//         this.transaccionesOriginal = transacciones ;
//         this.capacidad = 0;
//         this.capacidadSinCreacion = 0;
//         this.montoTotal = 0;
//         this.tamaño = transacciones.length;
//         this.heapTransacciones = new Transaccion[tamaño];
//         for (int i=0 ; i<tamaño ; i++){
//             insertarTransaccion(transacciones[i]);
//         }
//     }

//     public int montoTotalDeBloque(){
//         return montoTotal ;
//     }

//     public void insertarTransaccion (Transaccion transaccion){
//         int indice = capacidad;
//         int padre = 0;
//         Transaccion otro;
//         if (capacidad == 0){
//             heapTransacciones[0] = transaccion;
//         } else {
//             padre = (indice-1) /2 ;
//             while (transaccion != heapTransacciones[0] && transaccion.compareTo(heapTransacciones[padre])==1 ) {
//                 otro = heapTransacciones[padre];
//                 heapTransacciones[padre] = transaccion ; 
//                 heapTransacciones[indice] = otro ;
//                 padre = (padre-1) /2 ;
//                 indice = (indice-1) /2 ;
//             }
//         }
//         capacidad ++ ;
//         if (transaccion.id_comprador() != 0){
//             capacidadSinCreacion ++ ;
//         }
//         montoTotal = montoTotal + transaccion.monto() ;
//     }

//     // public void desencolarTransaccion (){
//     //     int indice = capacidad ;
//     //     int izq = 0;
//     //     int der = 0;
//     //     Transaccion otro;
//     //     if (capacidad==1){
//     //         capacidad = 0;
//     //         capacidadSinCreacion = 0;
//     //         montoTotal = 0;
//     //         heapTransacciones = new Transaccion[tamaño];
//     //         transaccionesOriginal = new Transaccion[tamaño];
//     //     } else {
//     //         otro = heapTransacciones[0];
//     //         heapTransacciones[0] = heap
//     //     }
//     // }

//     public void desencolarTransaccion () {
//         if (capacidad == 0) return;  // Heap vacío

//         Transaccion raiz = heapTransacciones[0];
//         montoTotal -= raiz.monto();
//         if (raiz.id_comprador() != 0) {
//             capacidadSinCreacion--;
//         }

//         capacidad--;
//         if (capacidad == 0) {
//             heapTransacciones[0] = null;
//             return;
//         }

//         heapTransacciones[0] = heapTransacciones[capacidad];
//         heapTransacciones[capacidad] = null;

//         int pos = 0;
//         while (true) {
//             int hijoIzq = 2 * pos + 1;
//             int hijoDer = 2 * pos + 2;
//             int mayor = pos;

//             if (hijoIzq < capacidad 
//                 && heapTransacciones[hijoIzq] != null 
//                 && heapTransacciones[mayor] != null
//                 && heapTransacciones[hijoIzq].compareTo(heapTransacciones[mayor]) > 0) {
//                 mayor = hijoIzq;
//             }

//             if (hijoDer < capacidad 
//                 && heapTransacciones[hijoDer] != null 
//                 && heapTransacciones[mayor] != null
//                 && heapTransacciones[hijoDer].compareTo(heapTransacciones[mayor]) > 0) {
//                 mayor = hijoDer;
//             }

//             if (mayor == pos) break;

//             Transaccion temp = heapTransacciones[pos];
//             heapTransacciones[pos] = heapTransacciones[mayor];
//             heapTransacciones[mayor] = temp;
//             pos = mayor;
//         }
//     }


//     public Transaccion mayorTransaccion() {
//         return heapTransacciones[0];
//     }

//     public int tamaño (){
//         return tamaño;
//     }

//     public int tamañoSinCreaciones (){
//         return capacidadSinCreacion;
//     }

//     public Transaccion[] transaccionesOriginal(){
//         return transaccionesOriginal;
//     } 

//     public void setTransaccionesOriginal(Transaccion[] nuevas) {
//     this.transaccionesOriginal = nuevas;
//     }

//     public void setTamaño(int nuevoTamaño) {
//         this.tamaño = nuevoTamaño;
//     }

//     // public void eliminarDeOriginal(Transaccion t) {
//     //     for (int i = 0; i < tamaño; i++) {
//     //         if (transaccionesOriginal[i] != null && transaccionesOriginal[i].equals(t)) {
//     //             // Reemplazamos por la última transacción válida si es posible
//     //             for (int j = capacidadSinCreacion - 1; j >= 0; j--) {
//     //                 if (transaccionesOriginal[j] != null) {
//     //                     transaccionesOriginal[i] = transaccionesOriginal[j];
//     //                     transaccionesOriginal[j] = null;
//     //                     return;
//     //                 }
//     //             }
//     //             // Si no había otra, solo lo ponemos en null
//     //             transaccionesOriginal[i] = null;
//     //             return;
//     //         }
//     //     }
//     // }
//     public void eliminarDeOriginal(Transaccion t) {
//         for (int i = 0; i < tamaño; i++) {
//             if (transaccionesOriginal[i] != null && transaccionesOriginal[i].equals(t)) {
//                 // Reemplazamos por la última transacción válida si es posible
//                 for (int j = tamaño - 1; j >= 0; j--) {
//                     if (transaccionesOriginal[j] != null) {
//                         transaccionesOriginal[i] = transaccionesOriginal[j];
//                         transaccionesOriginal[j] = null;
//                         return;
//                     }
//                 }
//                 // Si no había otra, solo lo ponemos en null
//                 transaccionesOriginal[i] = null;
//                 return;
//             }
//         }
//     }


//     public void decrementarTamaño(){
//         this.tamaño--;
//     }


// }



package aed.Clases;

import aed.Transaccion;

public class MaxHeapTransacciones {

    private Transaccion[] transaccionesOriginal;  // Arreglo original del bloque recibido
    private Transaccion[] heapTransacciones;      // Heap con las transacciones del bloque
    private int tamaño;                           // Tamaño fijo del bloque (longitud del arreglo)
    private int capacidad;                        // Cantidad de elementos válidos en el heap
    private int capacidadSinCreacion;            // Cantidad válida según id_comprador != 0
    private int montoTotal;                       // Suma total de montos en el heap

    // Constructor que recibe el bloque completo (arreglo lleno)
    public MaxHeapTransacciones(Transaccion[] transacciones) {
        this.tamaño = transacciones.length;
        this.capacidad = tamaño;            // Como el arreglo ya está lleno con transacciones, capacidad = tamaño
        this.capacidadSinCreacion = 0;
        this.montoTotal = 0;

        this.transaccionesOriginal = new Transaccion[tamaño];
        this.heapTransacciones = new Transaccion[tamaño];

        // Copiamos las transacciones recibidas a ambos arreglos y calculamos montos y cantidad sin creación
        for (int i = 0; i < tamaño; i++) {
            transaccionesOriginal[i] = transacciones[i];
            heapTransacciones[i] = transacciones[i];
            montoTotal += transacciones[i].monto();
            if (transacciones[i].id_comprador() != 0) {
                capacidadSinCreacion++;
            }
        }

        // Construimos el heap a partir del arreglo completo (heapify)
        for (int i = (tamaño / 2) - 1; i >= 0; i--) {
            heapifyAbajo(i);
        }
    }

    // Método para mantener la propiedad heap bajando el elemento en la posición i
    private void heapifyAbajo(int i) {
        int mayor = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;

        if (izq < capacidad && heapTransacciones[izq].compareTo(heapTransacciones[mayor]) > 0) {
            mayor = izq;
        }
        if (der < capacidad && heapTransacciones[der].compareTo(heapTransacciones[mayor]) > 0) {
            mayor = der;
        }

        if (mayor != i) {
            Transaccion temp = heapTransacciones[i];
            heapTransacciones[i] = heapTransacciones[mayor];
            heapTransacciones[mayor] = temp;
            heapifyAbajo(mayor);
        }
    }

    // Método opcional para insertar una transacción en el heap si queda espacio
    public void insertarTransaccion(Transaccion transaccion) {
        if (capacidad == tamaño) {
            // No hay espacio para insertar más transacciones
            return;
        }

        heapTransacciones[capacidad] = transaccion;
        int i = capacidad;
        capacidad++;
        montoTotal += transaccion.monto();
        if (transaccion.id_comprador() != 0) {
            capacidadSinCreacion++;
        }

        // Sift-up para mantener propiedad heap
        while (i != 0 && heapTransacciones[(i - 1) / 2].compareTo(heapTransacciones[i]) < 0) {
            Transaccion temp = heapTransacciones[i];
            heapTransacciones[i] = heapTransacciones[(i - 1) / 2];
            heapTransacciones[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    // // Eliminar la mayor transacción (raíz) y mantener el heap
    // public void desencolarTransaccion() {
    //     if (capacidad == 0) return;

    //     Transaccion raiz = heapTransacciones[0];
    //     montoTotal -= raiz.monto();
    //     if (raiz.id_comprador() != 0) {
    //         capacidadSinCreacion--;
    //     }

    //     capacidad--;
    //     if (capacidad == 0) {
    //         heapTransacciones[0] = null;
    //         return;
    //     }

    //     heapTransacciones[0] = heapTransacciones[capacidad];
    //     heapTransacciones[capacidad] = null;

    //     int pos = 0;
    //     while (true) {
    //         int hijoIzq = 2 * pos + 1;
    //         int hijoDer = 2 * pos + 2;
    //         int mayor = pos;

    //         if (hijoIzq < capacidad && heapTransacciones[hijoIzq].compareTo(heapTransacciones[mayor]) > 0) {
    //             mayor = hijoIzq;
    //         }

    //         if (hijoDer < capacidad && heapTransacciones[hijoDer].compareTo(heapTransacciones[mayor]) > 0) {
    //             mayor = hijoDer;
    //         }

    //         if (mayor == pos) break;

    //         Transaccion temp = heapTransacciones[pos];
    //         heapTransacciones[pos] = heapTransacciones[mayor];
    //         heapTransacciones[mayor] = temp;
    //         pos = mayor;
    //     }
    // }

    public Transaccion desencolarTransaccion() {
        if (capacidad == 0) return null;

        Transaccion raiz = heapTransacciones[0];
        montoTotal -= raiz.monto();
        if (raiz.id_comprador() != 0) {
            capacidadSinCreacion--;
        }

        capacidad--;
        if (capacidad == 0) {
            heapTransacciones[0] = null;
            return raiz;
        }

        heapTransacciones[0] = heapTransacciones[capacidad];
        heapTransacciones[capacidad] = null;

        int pos = 0;
        while (true) {
            int hijoIzq = 2 * pos + 1;
            int hijoDer = 2 * pos + 2;
            int mayor = pos;

            if (hijoIzq < capacidad && heapTransacciones[hijoIzq].compareTo(heapTransacciones[mayor]) > 0) {
                mayor = hijoIzq;
            }

            if (hijoDer < capacidad && heapTransacciones[hijoDer].compareTo(heapTransacciones[mayor]) > 0) {
                mayor = hijoDer;
            }

            if (mayor == pos) break;

            Transaccion temp = heapTransacciones[pos];
            heapTransacciones[pos] = heapTransacciones[mayor];
            heapTransacciones[mayor] = temp;
            pos = mayor;
        }

        return raiz;
    }

    public Transaccion mayorTransaccion() {
        return heapTransacciones[0];
    }

    public int montoTotalDeBloque(){
        return montoTotal;
    }

    public int tamaño() {
        return tamaño;
    }

    public int tamañoSinCreaciones() {
        return capacidadSinCreacion;
    }

    public Transaccion[] transaccionesOriginal() {
        return transaccionesOriginal;
    }

    public void setTransaccionesOriginal(Transaccion[] nuevas) {
        this.transaccionesOriginal = nuevas;
    }

    public void setTamaño(int nuevoTamaño) {
        this.tamaño = nuevoTamaño;
    }

    // Elimina una transacción del arreglo original (transaccionesOriginal)
    public void eliminarDeOriginal(Transaccion t) {
        for (int i = 0; i < tamaño; i++) {
            if (transaccionesOriginal[i] != null && transaccionesOriginal[i].equals(t)) {
                // Reemplazamos por la última transacción válida si es posible
                for (int j = tamaño - 1; j >= 0; j--) {
                    if (transaccionesOriginal[j] != null) {
                        transaccionesOriginal[i] = transaccionesOriginal[j];
                        transaccionesOriginal[j] = null;
                        return;
                    }
                }
                // Si no había otra, solo lo ponemos en null
                transaccionesOriginal[i] = null;
                return;
            }
        }
    }

    public void decrementarTamaño(){
    this.tamaño--;
    }
}    

