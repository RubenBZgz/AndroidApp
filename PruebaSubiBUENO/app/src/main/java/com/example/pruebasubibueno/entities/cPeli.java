package com.example.pruebasubibueno.entities;

import com.google.gson.annotations.SerializedName;

public class cPeli {
    @SerializedName("nombreCine")
    private String nombreCine;

    @SerializedName("nombrePelicula")
    private String nombrePelicula;

    public cPeli() {
    }

    public cPeli(String nombreCine, String nombrePelicula) {
        this.nombreCine = nombreCine;
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public String toString() {
        return "cPeli{" +
                "nombreCine='" + nombreCine + '\'' +
                ", nombrePelicula='" + nombrePelicula + '\'' +
                '}';
    }
}
