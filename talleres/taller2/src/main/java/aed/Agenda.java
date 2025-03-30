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
        String fechaActual = (this.fechaActual()+"\n").concat("=====");
        String recordatoriosActuales = "";
        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            if (this.fecha.equals(this.recordatorios.obtener(i).fecha()) )
            recordatoriosActuales = recordatoriosActuales.concat("\n"+this.recordatorios.obtener(i).toString());
            }
        
        return fechaActual+recordatoriosActuales+"\n";
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


// @Override
// public String toString() {
//     String fechaActual = (this.fechaActual()+"\n").concat("=====\n");
//     String recordatoriosActuales = "";
//     for (int i = 0; i < this.recordatorios.longitud(); i++ ) {
//         if (i == this.recordatorios.longitud()-1 ){
//             recordatoriosActuales = recordatoriosActuales.concat(this.recordatorios.obtener(i).toString());
//         } else if (i != this.recordatorios.longitud()-1) {
//             recordatoriosActuales = recordatoriosActuales.concat(this.recordatorios.obtener(i).toString()).concat("\n");
//         }
//     }
//     return fechaActual+recordatoriosActuales+"\n";