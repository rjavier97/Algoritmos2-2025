package aed;

public class Horario {

    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        // Implementar
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        // Implementar
        return this.hora;
    }

    public int minutos() {
        // Implementar
        return this.minutos;
    }

    @Override
    public String toString() {
        // Implementar
        return this.hora+":"+this.minutos;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta  = otro.getClass() != this.getClass();

        if (otroEsNull || claseDistinta) {
            return false;
        }

        Horario otroHorario = (Horario) otro ;

        return (hora == otroHorario.hora())  &&  (minutos == otroHorario.minutos()) ;
    }

}
