package aed;

public class Fecha {

    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        // Implementar
        this.dia = dia;
        this.mes = mes; 

    }

    public Fecha(Fecha otro) {
        // Implementar
        dia = otro.dia() ; 
        mes = otro.mes() ;
    }

    public Integer dia() {
        // Implementar

        return this.dia ;
    }

    public Integer mes() {
        // Implementar
        return this.mes ;
    }

    @Override
    public String toString() {
        // Implementar
        return this.dia()+"/"+this.mes() ;
    }

    @Override
    public boolean equals(Object otra) {
        // Implementar
        boolean otroEsNull = (otra == null);
        boolean claseDistinta  = otra.getClass() != this.getClass();

        if (otroEsNull || claseDistinta) {
            return false;
        }

        Fecha otraFecha = (Fecha) otra ;

        return (dia == otraFecha.dia)  &&  (mes == otraFecha.mes) ;
    }

    public void incrementarDia() {
        // Implementar
        if (this.dia < diasEnMes(this.mes)) {
            this.dia = dia+1 ;
        } else if (this.mes != 12) {
            this.dia = 1;
            this.mes = mes+1 ;         
        } else {
            this.dia = 1;
            this.mes = 1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}

// el override trabaja solo para la funcion de abajo, es decir, solo para una funcion