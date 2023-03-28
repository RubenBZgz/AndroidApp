package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Entrada {

    private int idEntrada, idUsuario, idPelicula;
    private Double precio;

    public Entrada(int idEntrada, int idUsuario, int idPelicula, Double precio) {
        this.idEntrada = idEntrada;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.precio = precio;
    }

    public Entrada(int idUsuario, int idPelicula, Double precio) {
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.precio = precio;
    }

    public Entrada() {
    }

    //GETTERS & SETTERS
    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Entrada{" + "idEntrada=" + idEntrada + ", idUsuario=" + idUsuario + ", idPelicula=" + idPelicula + ", precio=" + precio + '}';
    }

    /*public static String toCadena(Entrada pelicula) {
        return "Pelicula{" + 
                "titulo=" + pelicula.getTitulo() + ", "
                + "trailer=" + pelicula.getTrailer() + ","
                + " sinopsis=" + pelicula.getSinopsis() + ", "
                + "fechaEstreno=" + pelicula.getFechaEstreno() + ", "
                + "duracion=" + pelicula.getDuracion() + 
                ", nVotos=" + pelicula.getnVotos() + ", sPuntuacion=" 
                + pelicula.getnVotos() + ", id=" + pelicula.getId() + ", precio=" + pelicula.getPrecio() + '}';
    }*/
    public static String toArrayJSon(ArrayList<Entrada> entradas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(entradas);
        return resp;
    }
    
    public static String toObjectJSon(Entrada entrada) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(entrada);
        return resp;
    }
}
