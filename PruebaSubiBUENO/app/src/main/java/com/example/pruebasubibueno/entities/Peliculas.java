package com.example.pruebasubibueno.entities;

import com.google.gson.annotations.SerializedName;

public class Peliculas {
    @SerializedName("idPelicula")
    private int idPelicula;

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("tematica")
    private String tematica;

    @SerializedName("trailer")
    private String trailer;

    @SerializedName("anio")
    private int anio;

    @SerializedName("edadRecomendada")
    private int edadRecomendada;

    @SerializedName("butacasLibres")
    private int butacasLibres;

    @SerializedName("butacasOcupadas")
    private int butacasOcupadas;

    @SerializedName("calificacion")
    private double calificacion;

    @SerializedName("vecesPuntuado")
    private int vecesPuntuado;

    @SerializedName("imagen")
    private String imagen;

    public Peliculas() {
    }

    public Peliculas(int idPelicula, String titulo, String tematica, String trailer, int anio, int edadRecomendada, int butacasLibres, int butacasOcupadas, double calificacion, int vecesPuntuado) {
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

    public Peliculas(int idPelicula, String titulo, String tematica, String trailer, int anio, int edadRecomendada, int butacasLibres, int butacasOcupadas, double calificacion, int vecesPuntuado, String imagen) {
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
        this.imagen = imagen;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

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

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
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
}
