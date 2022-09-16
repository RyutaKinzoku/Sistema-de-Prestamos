package logic;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
class Prestamo implements Serializable{
    private static int consecutivo = 1;
    private int numero;
    private Date fecha;
    private Persona persona;
    private ArrayList<Item> items;
    private Alarma alarma;
    
    public Prestamo(Persona persona){
        numero = consecutivo;
        this.persona = persona;
        items = new ArrayList<>();
        fecha = Date.from(Instant.now());
        consecutivo++;
    }    
    public Prestamo(Persona persona, Date momento){
        numero = consecutivo;
        this.persona = persona;
        items = new ArrayList<>();
        crearAlarmaUnica(momento);
        fecha = Date.from(Instant.now());
        consecutivo++;
    }    
    public Prestamo(Persona persona, Date momento, int cantidad){
        numero = consecutivo;
        this.persona = persona;
        this.items = new ArrayList<>();
        crearAlarmaRecurrente(momento, cantidad);
        fecha = Date.from(Instant.now());
        consecutivo++;
    }
    public int getNumero() {
        return numero;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void clearItems(){
        for(Item i : items)
            i.setPrestado(false);
        items.clear();
    }
    public void addItem(Item item) {
        item.setPrestado(true);
        items.add(item);
    }
    public void removeItem(Item item) {
        item.setPrestado(false);
        items.remove(item);
    }
    public static int getConsecutivo() {
        return consecutivo;
    }
    public Date getFecha() {
        return fecha;
    }
    public static void setConsecutivo(int consecutivo) {
        Prestamo.consecutivo = consecutivo;
    }
    public void crearAlarmaUnica(Date momento){
        String mensaje = "Recuerde el préstamo que le hizo a ";
        mensaje += persona.getNombre();
        alarma = new Unica (mensaje, momento);
    }
    public void crearAlarmaRecurrente(Date momento, int cantidad){
        String mensaje = "Recuerde el préstamo que le hizo a ";
        mensaje += persona.getNombre();
        alarma = new Recurrente (mensaje, momento, cantidad);
    }
    public void modificarAlarma(Date momento){
        if (alarma != null)
            alarma.cambiarAlarma(persona.getNombre(), momento);
    }
    public Alarma getAlarma() {
        return alarma;
    }
    public String mostrarAlarma(){
        if (diaDeAlarma(alarma.getMomento()))
            return alarma.mostrarAlarma();
        return null;
    }
    private boolean diaDeAlarma(Date dia){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(Date.from(Instant.now()));
        c1.setTime(dia);
        return c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR) && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);
    }
}

