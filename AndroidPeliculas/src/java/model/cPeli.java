/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author S1-PC53
 */
public class cPeli {
    private String nombreCine, nombrePelicula;

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
        return "cPeli{" + "nombreCine=" + nombreCine + ", nombrePelicula=" + nombrePelicula + '}';
    }
    
    public static String toArrayJSon(ArrayList<cPeli> cPeli) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(cPeli);
        //resp = "{\"data\":" + resp + "}";
        return resp;
    }
    
}
