package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Pelicula {

    private String titulo, tematica, trailer, imagen;
    private int idPelicula, anio, edadRecomendada, butacasLibres, butacasOcupadas, calificacion, vecesPuntuado;

    public Pelicula(String titulo, String tematica, String trailer, int idPelicula, int anio, int edadRecomendada, int butacasLibres, int butacasOcupadas, int calificacion, int vecesPuntuado) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.tematica = tematica;
        this.trailer = trailer;
        this.anio = anio;
        this.edadRecomendada = edadRecomendada;
        this.butacasLibres = butacasLibres;
        this.butacasOcupadas = butacasOcupadas;
        this.calificacion = calificacion;
        this.vecesPuntuado = vecesPuntuado;
    }

    public Pelicula(String titulo, String tematica, String trailer, int anio, int edadRecomendada, int butacasLibres, int butacasOcupadas, int calificacion, int vecesPuntuado) {
        this.titulo = titulo;
        this.tematica = tematica;
        this.trailer = trailer;
        this.anio = anio;
        this.edadRecomendada = edadRecomendada;
        this.butacasLibres = butacasLibres;
        this.butacasOcupadas = butacasOcupadas;
        this.calificacion = calificacion;
        this.vecesPuntuado = vecesPuntuado;
    }

    public Pelicula(String titulo, String tematica, String trailer, String imagen, int idPelicula, int anio, int edadRecomendada, int butacasLibres, int butacasOcupadas, int calificacion, int vecesPuntuado) {
        this.titulo = titulo;
        this.tematica = tematica;
        this.trailer = trailer;
        this.imagen = imagen;
        this.idPelicula = idPelicula;
        this.anio = anio;
        this.edadRecomendada = edadRecomendada;
        this.butacasLibres = butacasLibres;
        this.butacasOcupadas = butacasOcupadas;
        this.calificacion = calificacion;
        this.vecesPuntuado = vecesPuntuado;
    }
    
    

    public Pelicula() {
    }

    //GETTERS & SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public int getButacasLibres() {
        return butacasLibres;
    }

    public void setButacasLibres(int butacasLibres) {
        this.butacasLibres = butacasLibres;
    }

    public int getButacasOcupadas() {
        return butacasOcupadas;
    }

    public void setButacasOcupadas(int butacasOcupadas) {
        this.butacasOcupadas = butacasOcupadas;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getVecesPuntuado() {
        return vecesPuntuado;
    }

    public void setVecesPuntuado(int vecesPuntuado) {
        this.vecesPuntuado = vecesPuntuado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", tematica=" + tematica + ", trailer=" + trailer + ", imagen=" + imagen + ", idPelicula=" + idPelicula + ", anio=" + anio + ", edadRecomendada=" + edadRecomendada + ", butacasLibres=" + butacasLibres + ", butacasOcupadas=" + butacasOcupadas + ", calificacion=" + calificacion + ", vecesPuntuado=" + vecesPuntuado + '}';
    }
    
    

    /*
    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", tematica=" + tematica + ", trailer=" + trailer + ", idPelicula=" + idPelicula + ", anio=" + anio + ", edadRecomendada=" + edadRecomendada + ", butacasLibres=" + butacasLibres + ", butacasOcupadas=" + butacasOcupadas + ", calificacion=" + calificacion + ", vecesPuntuado=" + vecesPuntuado + '}';
    }/*

    
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
    public static String toArrayJSon(ArrayList<Pelicula> peliculas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(peliculas);
        //resp = "{\"data\":" + resp + "}";
        return resp;
    }
    
    

    public static String toObjectJSon(Pelicula pelicula) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);
        return resp;
    }
}
