package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;



public class Cine {
    private String nombre;
    private int idCine, capacidad;

    public Cine(String nombre, int idCine, int capacidad) {
        this.nombre = nombre;
        this.idCine = idCine;
        this.capacidad = capacidad;
    }

    public Cine(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Cine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String 
        getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public int getCapacidad() {
        return capacidad;
    }

    //GETTERS & SETTERS
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Cine{" + "nombre=" + nombre + ", idCine=" + idCine + ", capacidad=" + capacidad + '}';
    }
    
    

    /*public static String toCadena(Pelicula pelicula) {
    return "Pelicula{" +
    "titulo=" + pelicula.getTitulo() + ", "
    + "trailer=" + pelicula.getTrailer() + ","
    + " sinopsis=" + pelicula.getSinopsis() + ", "
    + "fechaEstreno=" + pelicula.getFechaEstreno() + ", "
    + "duracion=" + pelicula.getDuracion() +
    ", nVotos=" + pelicula.getnVotos() + ", sPuntuacion="
    + pelicula.getnVotos() + ", id=" + pelicula.getId() + ", precio=" + pelicula.getPrecio() + '}';
    }*/
    public static String toArrayJSon(ArrayList<Cine> cines) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(cines);
        return resp;
    }
    
    public static String toObjectJSon(Cine cine) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(cine);
        return resp;
    }
}
