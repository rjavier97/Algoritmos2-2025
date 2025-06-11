// package aed;

// import aed.Clases.*;

// import java.lang.reflect.Array;

// public class Berretacoin {
//     // private Bloque bloque;
//     private MaxHeap prioridadUsuarios ;
//     private MaxHeapTransacciones prioridadTransacciones ;

//     // MaxHeap n_usuarios combinando con arreglos (HAnddles)
//     // aca vamos almacenando la informacion de los demas bloques junto con el ultimobloque
//     // tomando el monto de las transacciones, y ordenados por monto

//     // Bloque ultimobloque 
//     // Bloque tiene 4 atributos
//     // uoo es un MaxHeap de transacciones que van a estar ordenados por monto
//     // el 2do es un arreglo de transacciones tal cual nos lo dan (seria el original)
//     // el 3ero es la cantidad de transacciones (tamaño)
//     // el 4to es el montoTotal de todas las transacciones del bloque 

//     public Berretacoin(int cantidadUsuarios) {
//         this.prioridadUsuarios = new MaxHeap(cantidadUsuarios);
//         this.prioridadUsuarios.inicializarUsuarios();
//     }

//     public void agregarBloque(Transaccion[] transacciones){
//         for (Transaccion tx : transacciones) {
//         int idComprador = tx.id_comprador();
//         int idVendedor = tx.id_vendedor();
//         int monto = tx.monto();

//         // Al comprador se le resta el monto
//         Usuario comprador = new Usuario(idComprador, -monto);
//         prioridadUsuarios.insertarUsuario(comprador);

//         // Al vendedor se le suma el monto
//         Usuario vendedor = new Usuario(idVendedor, monto);
//         prioridadUsuarios.insertarUsuario(vendedor);
//         }
//         prioridadTransacciones = new MaxHeapTransacciones(transacciones);

//     }

//     public Transaccion txMayorValorUltimoBloque(){
//         return prioridadTransacciones.mayorTransaccion();
//     }

//     public Transaccion[] txUltimoBloque(){
//         Transaccion[] copia = new Transaccion[prioridadTransacciones.tamaño()] ;
//         for (int i=0 ; i<prioridadTransacciones.tamaño() ; i++){
//             copia[i] = prioridadTransacciones.transaccionesOriginal()[i];
//         }
//         return copia ;
//     }

//     public int maximoTenedor() {
//         return prioridadUsuarios.obtenerMaximo();
//     }
    
//     public int montoMedioUltimoBloque(){
//         if (prioridadTransacciones.tamañoSinCreaciones() == 0){
//             return 0;
//         } else {
//         int montoDeCreacion = prioridadTransacciones.transaccionesOriginal()[0].monto();
//             return (prioridadTransacciones.montoTotalDeBloque() - montoDeCreacion) / prioridadTransacciones.tamañoSinCreaciones() ;
//         }
//     }

//     // public void hackearTx(){
//     //     prioridadTransacciones.desencolarTransaccion();
//     // }
//     public void hackearTx() {
//         // 1. Sacamos la transacción de mayor monto
//         Transaccion mayor = prioridadTransacciones.mayorTransaccion();
//         prioridadTransacciones.desencolarTransaccion();
//         prioridadTransacciones.eliminarDeOriginal(mayor); // implementá esto
//         prioridadTransacciones.decrementarTamaño();

//         // 2. Revertimos su efecto en los usuarios
//         int compr = mayor.id_comprador();
//         int vend = mayor.id_vendedor();
//         int mont = mayor.monto();

//         if (compr != 0) {
//             // si no fue creación, el comprador había perdido: devolvérselo
//             Usuario uCompr = new Usuario(compr, mont);
//             prioridadUsuarios.insertarUsuario(uCompr);
//         }
//         // el vendedor había ganado, revertimos
//         Usuario uVend = new Usuario(vend, -mont);
//         prioridadUsuarios.insertarUsuario(uVend);
//     }



// }

package aed;

import aed.Clases.*;

public class Berretacoin {
    private MaxHeap prioridadUsuarios;
    private MaxHeapTransacciones prioridadTransacciones;

    public Berretacoin(int cantidadUsuarios) {
        this.prioridadUsuarios = new MaxHeap(cantidadUsuarios);
        this.prioridadUsuarios.inicializarUsuarios();
    }

    public void agregarBloque(Transaccion[] transacciones) {
        // Creamos el heap de transacciones
        prioridadTransacciones = new MaxHeapTransacciones(transacciones);

        for (Transaccion tx : transacciones) {
            int idComprador = tx.id_comprador();
            int idVendedor = tx.id_vendedor();
            int monto = tx.monto();

            // El comprador pierde plata (si no es transacción de creación)
            if (idComprador != 0) {
                Usuario comprador = new Usuario(idComprador, -monto);
                prioridadUsuarios.insertarUsuario(comprador);
            }

            // El vendedor gana plata
            Usuario vendedor = new Usuario(idVendedor, monto);
            prioridadUsuarios.insertarUsuario(vendedor);
        }
    }

    public Transaccion txMayorValorUltimoBloque() {
        if (prioridadTransacciones == null) return null;
        return prioridadTransacciones.mayorTransaccion();
    }

    public Transaccion[] txUltimoBloque() {
        if (prioridadTransacciones == null) return new Transaccion[0];

        Transaccion[] copia = new Transaccion[prioridadTransacciones.tamaño()];
        for (int i = 0; i < copia.length; i++) {
            copia[i] = prioridadTransacciones.transaccionesOriginal()[i];
        }
        return copia;
    }

    public int maximoTenedor() {
        return prioridadUsuarios.obtenerMaximo();
    }

    public int montoMedioUltimoBloque() {
        if (prioridadTransacciones == null || prioridadTransacciones.tamañoSinCreaciones() == 0) {
            return 0;
        } else {
            int montoTotal = prioridadTransacciones.montoTotalDeBloque();
            int montoCreacion = prioridadTransacciones.transaccionesOriginal()[0].monto();
            int nSinCreacion = prioridadTransacciones.tamañoSinCreaciones();
            return (montoTotal - montoCreacion) / nSinCreacion;
        }
    }

    public void hackearTx() {
        if (prioridadTransacciones == null || prioridadTransacciones.tamaño() == 0) return;

        // 1. Sacar la transacción de mayor valor
        Transaccion mayor = prioridadTransacciones.mayorTransaccion();
        prioridadTransacciones.desencolarTransaccion();
        prioridadTransacciones.eliminarDeOriginal(mayor);
        prioridadTransacciones.decrementarTamaño();

        // 2. Revertir el efecto sobre usuarios
        int compr = mayor.id_comprador();
        int vend = mayor.id_vendedor();
        int mont = mayor.monto();

        if (compr != 0) {
            // comprador había perdido => devolvérselo
            Usuario uCompr = new Usuario(compr, mont);
            prioridadUsuarios.insertarUsuario(uCompr);
        }

        // vendedor había ganado => quitárselo
        Usuario uVend = new Usuario(vend, -mont);
        prioridadUsuarios.insertarUsuario(uVend);
    }
}

