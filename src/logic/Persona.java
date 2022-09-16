package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
class Persona implements Serializable{
    private String nombre;
    private String numero;
    private String correo;
    private ArrayList<Prestamo> prestamos;
    
    public Persona(String nombre, String numero, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
        prestamos = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    public void addPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    public ArrayList<String> toArray(){
        ArrayList<String> res = new ArrayList<>();
        res.add(nombre);
        res.add(numero);
        res.add(correo);
        return res;
    }
}

