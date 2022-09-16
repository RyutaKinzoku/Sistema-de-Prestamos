package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
public class Sistema  implements Serializable{
    private ArrayList<Persona> personas;
    private ArrayList<Item> items;
    private ArrayList<Tipo> tipos;
    private ArrayList<Categoria> categorias;
    private ArrayList<Prestamo> prestamos;
    private static Sistema instance = null;

    private Sistema() {
        personas = new ArrayList<>();
        items = new ArrayList<>();
        tipos = new ArrayList<>();
        Tipo t = new Tipo("Sin Tipo");
        tipos.add(t);
        categorias = new ArrayList<>();
        prestamos = new ArrayList<>();
    }
    public static Sistema getInstance(){
        if(instance == null){
            try {
                instance = Sistema.CargarDatos();
            } catch (Exception ex) {
                instance = new Sistema();
            }
        }
        return instance;
    }
    public void crearItem(String nombre){
        Item item = new Item(nombre, tipos.get(0));
        items.add(item);
    }
    public void modificarItem(String nombre, String newNombre, String tipo) throws Exception{
        Item i = getItem(nombre);
        Tipo t = getTipo(tipo);
        i.setTipo(t);
        i.setNombre(newNombre);
    }
    private ArrayList<Item> getItems() {
        return items;
    }
    private Item getItem(String nombre) throws Exception {
        for(Item i: items){
            if (i.getNombre().equals(nombre))
                return i;
        }
        throw new Exception("No existe ese Item");
    }
    public boolean existeItem(String nombre){
        try {
            getItem(nombre);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean itemContainsCategoria(String item, String categoria){
        try {
            Item i = getItem(item);
            ArrayList<Categoria> categoriasI =  i.getCategorias();
            for (Categoria c : categoriasI)
                if (c.getNombre() == categoria)
                    return true;
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void borrarItem(String nombre) throws Exception{
        Item i = getItem(nombre);
        items.remove(i);
    }
    public String getTipoItem(String nombre) throws Exception{
        Item i = getItem(nombre);
        return i.getTipo().getNombre();
    }
    public void agregarCategoriaItem(String item, String categoria) throws Exception{
        Item i = getItem(item);
        Categoria c = getCategoria(categoria);
        i.agregarCategoria(c);
    }
    public void borrarCategoriaItem(String item, String categoria) throws Exception{
        Item i = getItem(item);
        Categoria c = getCategoria(categoria);
        i.eliminarCategoria(c);
    }
    public ArrayList<String> getCategoriasItem(String nombre) throws Exception{
        Item i = getItem(nombre);
        ArrayList<Categoria> categoriasI = i.getCategorias();
        ArrayList<String> res = new ArrayList<>();
        for(Categoria c : categoriasI)
            res.add(c.getNombre());
        return res;
    }
    public ArrayList<String> itemsDisponibles(){
        ArrayList<Item> items = getItems();
        ArrayList<String> res = new ArrayList<>();
        for(Item i : items)
            if (!i.isPrestado())
                res.add(i.getNombre());
        return res;
    }
    public ArrayList<String> itemsToString(){
        ArrayList<Item> items = getItems();
        ArrayList<String> res = new ArrayList<>();
        for(Item i : items)
            res.add(i.getNombre());
        return res;
    }
    private ArrayList<Persona> getPersonas() {
        return personas;
    }
    public void crearPersona(String nombre, String numero, String correo){
        Persona persona = new Persona(nombre, numero, correo);
        personas.add(persona);
    }
    public void modificarPersona(String correo, String nombre, String numero, String newCorreo) throws Exception{
        Persona p = getPersona(correo);
        p.setNombre(nombre);
        p.setNumero(numero);
        p.setCorreo(newCorreo);
    }
    public void borrarPersona(String correo) throws Exception{
        Persona p = getPersona(correo);
        personas.remove(p);
    }
    private Persona getPersona(String correo) throws Exception {
        for(Persona p: personas){
            if (p.getCorreo() == correo)
                return p;
        }
        throw new Exception("No existe esa Persona");
    }
    public boolean existePersona(String correo){
        try {
            getPersona(correo);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public ArrayList<String> personaToArray(String correo) throws Exception{
        Persona p = getPersona(correo);
        return p.toArray();
    }
    public ArrayList<String> personasToString(){
        ArrayList<Persona> personas = getPersonas();
        ArrayList<String> res = new ArrayList<>();
        for(Persona p : personas)
            res.add(p.getCorreo());
        return res;
    }
    public void crearTipo(String nombre){
        Tipo tipo = new Tipo(nombre);
        tipos.add(tipo);
    }
    public void modificarTipo(String nombre, String newNombre) throws Exception {
        Tipo t = getTipo(nombre);
        t.setNombre(newNombre);
    }
    private ArrayList<Tipo> getTipos() {
        return tipos;
    }
    public void borrarTipo(String nombre) throws Exception{
        if(nombre == "Sin Tipo") throw new Exception("No se puede eliminar ese Tipo");
        Tipo t = getTipo(nombre);
        tipos.remove(t);
    }
    private Tipo getTipo(String nombre) throws Exception {
        for(Tipo t: tipos){
            if (t.getNombre().equals(nombre))
                return t;
        }
        throw new Exception("No existe ese Tipo");
    }
    public boolean existeTipo(String nombre){
        try {
            getTipo(nombre);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public ArrayList<String> tiposToString(){
        ArrayList<Tipo> tipos = getTipos();
        ArrayList<String> res = new ArrayList<>();
        for(Tipo t: tipos)
            res.add(t.getNombre());
        return res;
    }
    public ArrayList<String> getItemsTipo(String nombre) throws Exception{
        Tipo t = getTipo(nombre);
        ArrayList<Item> itemsT = t.getItems();
        ArrayList<String> res = new ArrayList<>();
        for (Item i : itemsT)
            res.add(i.getNombre());
        return res;
    }
    public void crearCategoria(String nombre){
        Categoria categoria = new Categoria(nombre);
        categorias.add(categoria);
    }
    public void modificarCategoria(String nombre, String newNombre) throws Exception {
        Categoria c = getCategoria(nombre);
        c.setNombre(newNombre);
    }
    private ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    private Categoria getCategoria(String nombre) throws Exception {
        for(Categoria c: categorias){
            if (c.getNombre() == nombre)
                return c;
        }
        throw new Exception("No existe esa Categoria");
    }
    public boolean existeCategoria(String nombre){
        try {
            getCategoria(nombre);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public void borrarCategoria(String nombre) throws Exception{
        Categoria c = getCategoria(nombre);
        categorias.remove(c);
    }
    public ArrayList<String> categoriasToString(){
        ArrayList<String> res = new ArrayList<>();
        for(Categoria c : categorias)
            res.add(c.getNombre());
        return res;
    }
    public ArrayList<String> getItemsCategoria(String nombre) throws Exception{
        Categoria c = getCategoria(nombre);
        ArrayList<Item> itemsC = c.getItems();
        ArrayList<String> res = new ArrayList<>();
        for (Item i : itemsC)
            res.add(i.getNombre());
        return res;
    }
    private ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    public int crearPrestamo(String persona) throws Exception{
        Persona per = getPersona(persona);
        Prestamo p = new Prestamo(per);
        prestamos.add(p);
        return p.getNumero();
    }
    public void modificarPrestamo(int prestamo, String persona) throws Exception{
        Prestamo prestam = getPrestamo(prestamo);
        Persona person = getPersona(persona);
        prestam.setPersona(person);
    }
    public void borrarPrestamo(int prestamo) throws Exception{
        Prestamo p = getPrestamo(prestamo);
        p.clearItems();
        prestamos.remove(p);
    }
    private Prestamo getPrestamo(int prestamo) throws Exception{
        for(Prestamo p : prestamos)
            if (prestamo == p.getNumero())
                return p;
        throw new Exception("No existe ese Préstamo");
    }
    public boolean existePrestamo(int prestamo) {
        try {
            getPrestamo(prestamo);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public void agregarItemPrestamo(String item, int prestamo) throws Exception{
        Item i = getItem(item);
        Prestamo p = getPrestamo(prestamo);
        p.addItem(i);
    }
    public void eliminarItemPrestamo(String item, int prestamo) throws Exception{
        Item i = getItem(item);
        Prestamo p = getPrestamo(prestamo);
        p.removeItem(i);
    }
    public void crearAlarmaPrestamo(int prestamo, String persona, int dias) throws Exception{
        Prestamo p = getPrestamo(prestamo);
        if(existePersona(persona)){
            Date momento = p.getAlarma().getMomento();
            momento = sumarDias(momento, dias);
            p.crearAlarmaUnica(momento);
        }
    }
    public void crearAlarmaPrestamo(int prestamo, String persona, int dias, int cantidad) throws Exception{
        Prestamo p = getPrestamo(prestamo);
        if(existePersona(persona)){
            Date momento = p.getAlarma().getMomento();
            momento = sumarDias(momento, dias);
            p.crearAlarmaRecurrente(momento, cantidad);
        }
    }
    public boolean tieneAlarma(int prestamo) throws Exception{
        Prestamo p = getPrestamo(prestamo);
        return p.getAlarma() != null;
    }
    public boolean tieneAlarmaRecurrente(int prestamo) throws Exception{
        Prestamo p = getPrestamo(prestamo);
        return p.getAlarma().isRecurrente();
    }
    public int getCantidadRecurrente(int prestamo) throws Exception{
        Prestamo p = getPrestamo(prestamo);
        if (tieneAlarmaRecurrente(prestamo)){
            Recurrente a =(Recurrente) p.getAlarma();
            return a.getCantidad();
        }
        return 0;
    }
    public int getDiasAlarma(int prestamo) throws Exception{
        Prestamo p;
        if (tieneAlarma(prestamo)){
            p = getPrestamo(prestamo);
            Date momento = p.getAlarma().getMomento();
            Date creacion = p.getFecha();
            int res = (int)((momento.getTime()-creacion.getTime())/86400000);
            return res;
        }
        return 0;
    }
    private Date sumarDias(Date momento, int dias){
        Calendar c = Calendar.getInstance();
        c.setTime(momento);
        c.add(Calendar.DAY_OF_YEAR, dias);
        return c.getTime();
    }
    public String revisarAlarmas(){
        String res;
        for (Prestamo p : prestamos){
            res = p.mostrarAlarma();
            if(res != null)
                return res;
        }
        return null;
    }
    public ArrayList<String> prestamosToString(){
        ArrayList<Prestamo> prestamos = getPrestamos();
        ArrayList<String> res = new ArrayList<>();
        for(Prestamo p : prestamos)
            res.add(String.valueOf(p.getNumero()));
        return res;
    }
    public String prestamoToString(int numero) throws Exception{
        Prestamo prestamo = getPrestamo(numero);
        return String.valueOf(prestamo.getNumero());
    }
    public ArrayList<String> getItemsPrestamo(int numero) throws Exception{
        Prestamo p = getPrestamo(numero);
        ArrayList<Item> items = p.getItems();
        ArrayList<String> itemsR = new ArrayList<>();
        for (Item i : items)
            itemsR.add(i.getNombre());
        return itemsR;
    }
    public static Sistema CargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("prestamos.info");
        ObjectInputStream stream = new ObjectInputStream(file);
        instance = (Sistema) stream.readObject();
        Prestamo.setConsecutivo(instance.prestamos.size()+1);
        return instance;
    }
    public static void GuardarDatos() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("prestamos.info");
        ObjectOutputStream stream = new ObjectOutputStream(file);
        stream.writeObject(instance);
        stream.close();
    }
}

