package aed;

import java.util.ArrayList;

public class Transaccion implements Comparable<Transaccion> {
    private int id;
    private int id_comprador;
    private int id_vendedor;
    private int monto;

    public Transaccion(int id, int id_comprador, int id_vendedor, int monto) {
        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
    }

    @Override
    public int compareTo(Transaccion otro) {    
        int res = 0;
        if (this.monto - otro.monto > 0){
            res = 1;
        } else {
            if (this.monto - otro.monto <0){
                res = -1 ;
            } else {
                if (this.id > otro.id){
                    res = 1;
                } else {
                    res = -1 ;
                }
            }     
        }
        return res ;
    }

    // @Override
    // public boolean equals(Object otro){
    //     boolean otroEsNull = (otro == null);
    //     boolean claseDistinta = otro.getClass() != this.getClass();

    //     if (otroEsNull || claseDistinta){
    //         return false;
    //     }

    //     Transaccion otraTransaccion = (Transaccion) otro ;

    //     return (id == otraTransaccion.id && id_comprador == otraTransaccion.id_comprador 
    //     && id_vendedor == otraTransaccion.id_vendedor && monto == otraTransaccion.monto);

    // }
    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;  // misma referencia, son iguales
        if (otro == null) return false; // si es null, no son iguales
        if (getClass() != otro.getClass()) return false; // diferente clase, no son iguales
        
        Transaccion otraTransaccion = (Transaccion) otro;
        
        return this.id == otraTransaccion.id &&
            this.id_comprador == otraTransaccion.id_comprador &&
            this.id_vendedor == otraTransaccion.id_vendedor &&
            this.monto == otraTransaccion.monto;
    }


    public int id(){
        return id;
    }

    public int monto() {
        return monto;
    }

    public int id_comprador() {
        return id_comprador;
    }
    
    public int id_vendedor() {
        return id_vendedor;
    }
}