package logic;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
class Recurrente extends Alarma implements Serializable{
    private int cantidad; 
    
    public Recurrente(String persona, Date momento, int cantidad) {
        super(persona, momento);
        recurrente = true;
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }
    public String mostrarAlarma(){
        String alarma = "";
        if (cantidad > 0){
            alarma = super.mostrarAlarma();
            cantidad--;
            if (cantidad == 0) super.desactivarAlarma();
        }
        return alarma;
    }
}
