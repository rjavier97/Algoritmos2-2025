package aed;

public class Agenda {

    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        // Implementar
        this.fecha = new Fecha (fechaActual) ;
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        // Implementar
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        // Implementar
        String fechaActual = (this.fechaActual()+"\n").concat("=====\n");
        String recordatoriosActuales = "";
        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            if (this.fecha.equals(this.recordatorios.obtener(i).fecha()) )
            recordatoriosActuales = recordatoriosActuales.concat(this.recordatorios.obtener(i).toString()+"\n");
            }
        
        return fechaActual+recordatoriosActuales;
    }

    public void incrementarDia() {
        // Implementar
        this.fechaActual().incrementarDia();
    }

    public Fecha fechaActual() {
        // Implementar
        return this.fecha;
    }

}