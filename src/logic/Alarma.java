package logic;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
abstract class Alarma implements Serializable{
    private String persona;
    private boolean pendiente; 
    private Date momento;
    protected boolean recurrente = false;

    public Alarma(String persona, Date momento) {
        this.persona = persona;
        this.momento = momento;
        pendiente = true;
    }
    public void cambiarAlarma(String persona, Date momento){
        this.persona = persona;
        this.momento = momento;
    }
    public String getPersona() {
        return persona;
    }
    public void setPersona(String mensaje) {
        this.persona = mensaje;
    }
    public boolean isPendiente() {
        return pendiente;
    }
    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }
    public Date getMomento() {
        return momento;
    }
    public void setMomento(Date momento) {
        this.momento = momento;
    }
    public void desactivarAlarma(){
        pendiente = false;
    }
    public String mostrarAlarma(){
        return persona;
    }
    public boolean isRecurrente() {
        return recurrente;
    }
}


