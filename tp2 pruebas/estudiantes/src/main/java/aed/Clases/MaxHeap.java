package aed.Clases;

import java.util.ArrayList;

// public class MaxHeap<T extends Comparable<T> >{
public class MaxHeap{
    // private Monto[] MontosOrdenados ;
    private Usuario[] heapUsuarios;
    private int tamaño ;
    private int elementosUsados;
    private int[] handle;

    public MaxHeap(int n_usuarios) {
        // this.heapUsuarios = new Usuario[n_usuarios];
        // Usuario[] array = new Usuario[n_usuarios];
        // for (int i=1 ; i <= n_usuarios ; i++){
        //     array[i] = new Usuario(i,0);
        // }
        this.heapUsuarios = new Usuario[n_usuarios +1];
        this.tamaño = n_usuarios;
        this.elementosUsados = 0;
        this.handle = new int[n_usuarios +1];
        for (int i =0 ; i< n_usuarios ; i++){
            handle[i] = -1 ;
        }
    }

    public void inicializarUsuarios() {
        for (int i = 1; i <= tamaño; i++) {
            Usuario u = new Usuario(i, 0);
            heapUsuarios[elementosUsados] = u;
            handle[u.obtenerId()] = elementosUsados;
            reordenarHaciaArriba(elementosUsados);
            elementosUsados++;
        }
    }

    public int cardinal() {
        return this.elementosUsados;
    }

    // public void insertarUsuario (Usuario usuario){
    //     int id = usuario.obtenerId();
    //     int indice = elementosUsados;
    //     int padre = 0;
    //     Usuario otro;
    //     if (elementosUsados == 0){
    //         heapUsuarios[0] = usuario;
    //     } else {
    //         padre = (indice-1) /2 ;
    //         while (usuario != heapUsuarios[0] && usuario.compareTo(heapUsuarios[padre])==1 ) {
    //             otro = heapUsuarios[padre];
    //             heapUsuarios[padre] = usuario ; 
    //             heapUsuarios[indice] = otro ;
    //             padre = (padre-1) /2 ;
    //             indice = (indice-1) /2 ;

    //         }
    //     }
    //     elementosUsados ++ ;
    // }

    public void insertarUsuario(Usuario usuario) {
        int id = usuario.obtenerId();

        if (handle[id] == -1) {
            // No estaba en el heap → lo agrego
            heapUsuarios[elementosUsados] = usuario;
            handle[id] = elementosUsados;
            reordenarHaciaArriba(elementosUsados);
            elementosUsados++;
        } else {
            // Ya estaba → actualizar monto y reordenar
            int pos = handle[id];
            int nuevoMonto = heapUsuarios[pos].obtenerMonto() + usuario.obtenerMonto();
            heapUsuarios[pos].setearMonto(nuevoMonto);
            reordenarHaciaArriba(pos);
            reordenarHaciaAbajo(pos);
        }
    }

    private void reordenarHaciaArriba(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (heapUsuarios[i].compareTo(heapUsuarios[padre]) > 0) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    private void reordenarHaciaAbajo(int i) {
        while (true) {
            int izq = 2 * i + 1;
            int der = 2 * i + 2;
            int mayor = i;

            if (izq < elementosUsados && heapUsuarios[izq].compareTo(heapUsuarios[mayor]) > 0) {
                mayor = izq;
            }

            if (der < elementosUsados && heapUsuarios[der].compareTo(heapUsuarios[mayor]) > 0) {
                mayor = der;
            }

            if (mayor != i) {
                intercambiar(i, mayor);
                i = mayor;
            } else {
                break;
            }
        }
    }

    private void intercambiar(int i, int j) {
        Usuario otro = heapUsuarios[i];
        heapUsuarios[i] = heapUsuarios[j];
        heapUsuarios[j] = otro;

        handle[heapUsuarios[i].obtenerId()] = i;
        handle[heapUsuarios[j].obtenerId()] = j;
    }

    public int obtenerMaximo() {
        return heapUsuarios[0].obtenerId();
    }
}
