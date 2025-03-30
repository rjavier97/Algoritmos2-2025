package aed;

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] recordatorios ; 

    public ArregloRedimensionableDeRecordatorios() {
        // Implementar
        this.recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        // Implementar
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        // Implementar
        Recordatorio[]otroRecordatorios = new Recordatorio[this.longitud()+1];
        for (int j = 0; j < this.longitud(); j++) {
            otroRecordatorios[j] = this.recordatorios[j] ;
        }
        otroRecordatorios[this.longitud()] = i ;
        recordatorios = otroRecordatorios ;

    }

    public Recordatorio obtener(int i) {
        // Implementar
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        // Implementar
        Recordatorio[]otroRecordatorios = new Recordatorio[this.longitud()-1];
        for (int j = 0; j < this.longitud()-1; j++) {
            otroRecordatorios[j] = this.recordatorios[j] ;
        }
        recordatorios = otroRecordatorios ;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        // Implementar
        recordatorios[indice] = valor ;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {  //constructor
        // Implementar
        this.recordatorios = new Recordatorio[vector.longitud()];
        for (int j = 0; j < vector.longitud(); j++) {
            this.recordatorios[j] = vector.obtener(j);
        }    
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        ArregloRedimensionableDeRecordatorios copiaArreglo = new ArregloRedimensionableDeRecordatorios();
        for (int j = 0; j < this.longitud(); j++) {
            copiaArreglo.agregarAtras(this.recordatorios[j]);
        }
        return copiaArreglo;
    }

}
