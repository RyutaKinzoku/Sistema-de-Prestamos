package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
class Tipo implements Serializable{
    private String nombre;
    ArrayList<Item> items;

    public Tipo(String nombre) {
        this.nombre = nombre;
        items = new ArrayList<>();
    }
    public Tipo(String nombre, Item item) {
        this.nombre = nombre;
        items = new ArrayList<>();
        items.add(item);
    }
    public void modificarTipo(String pnombre) {
        nombre = pnombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void addItem(Item i){
        items.add(i);
    }
    public void removeItem(Item i){
        items.remove(i);
    }
    public String toString()
    {
        return nombre;
    }
}
