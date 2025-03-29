package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        // Implementar
        this.mensaje = new String (mensaje);
        this.fecha = new Fecha (fecha);
        this.horario = new Horario (horario.hora(), horario.minutos() );          // new Horario (horario)

    }

    public Horario horario() {
        // Implementar
        return this.horario;
    }

    public Fecha fecha() {
        // Implementar
        // Fecha fecha1 = new Fecha (this.fecha.dia(), this.fecha.mes());  // Esta opcion es valida tambien
        Fecha fecha1 = new Fecha (fecha);
        return fecha1;
    }

    public String mensaje() {
        // Implementar
        return this.mensaje;
    }

    @Override
    public String toString() {
        // Implementar
        return this.mensaje+" @ "+this.fecha+" "+this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        // Implementar
        boolean otroEsNull = (otro == null);
        boolean claseDistinta  = otro.getClass() != this.getClass();

        if (otroEsNull || claseDistinta) {
            return false;
        }

        Recordatorio otroRecordatorio = (Recordatorio) otro ;

        return (mensaje.equals(otroRecordatorio.mensaje))  &&  (fecha.equals(otroRecordatorio.fecha)) && (horario.equals(otroRecordatorio.horario)) ;
        
    }

}
