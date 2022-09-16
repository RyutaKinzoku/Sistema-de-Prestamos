package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
class Item implements Serializable{
    private String nombre;
    private Tipo tipo;
    private ArrayList<Categoria> categorias;
    private boolean prestado = false;

    public Item(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        tipo.addItem(this);
        categorias = new ArrayList<>();
    }
    public Tipo getTipo() throws Exception {
        return tipo;
    }
    public void setTipo(Tipo tipo){
        this.tipo.removeItem(this);
        this.tipo = tipo;
        tipo.addItem(this);
    }
    public void agregarCategoria(Categoria categoria){
        categoria.addItem(this);
        categorias.add(categoria);
    }
    public void eliminarCategoria(Categoria categoria){
        categoria.removeItem(this);
        categorias.remove(categoria);
    }
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
