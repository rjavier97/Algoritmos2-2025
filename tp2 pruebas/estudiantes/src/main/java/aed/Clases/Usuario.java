package aed.Clases;

import java.util.ArrayList;

import aed.Transaccion;

public class Usuario implements Comparable<Usuario>{

    private int id_usuario;
    private int monto_usuario;

    public Usuario (int id, int monto){
        this.id_usuario = id;
        this.monto_usuario = monto ;
    }

    @Override
    public int compareTo(Usuario otro) {    
        int res = 0;
        if (this.monto_usuario > otro.monto_usuario) {
            res = 1;
        } else if (this.monto_usuario < otro.monto_usuario) {
            res = -1;
        } else {
            if (this.id_usuario < otro.id_usuario){
                res = 1;
            } else {
                res = -1 ;
            }
        }
        return res ;
    }        
    //     } else {
    //         if (this.monto_usuario - otro.monto_usuario > 0 ){
    //             res = 1;
    //         } else if (this.monto_usuario - otro.monto_usuario < 0){
    //             res = -1;           
    //         } else {
    //             if (otro.id_usuario < this.id_usuario){
    //                 res = 1;
    //             } else {
    //                 res = -1 ;
    //             }
    //         }
    //     }    
    //     return res ;                       
    // }
         
    
    public int obtenerId (){
        return id_usuario;
    }

    public int obtenerMonto(){
        return monto_usuario;
    }

    public void setearMonto(int monto){
        this.monto_usuario = monto;
    }

}
