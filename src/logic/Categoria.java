package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
class Categoria  implements Serializable{
    private String nombre;
    ArrayList<Item> items;

    public Categoria(String nombre, Item item){
        this.nombre = nombre;
        items = new ArrayList<>();
        items.add(item);
    }
    public Categoria(String nombre){
        this.nombre = nombre;
        items = new ArrayList<>();
    }
    public void modificarCategoria(String pnombre){
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
