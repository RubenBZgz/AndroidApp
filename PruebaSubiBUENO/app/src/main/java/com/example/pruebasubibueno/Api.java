package com.example.pruebasubibueno;

import com.example.pruebasubibueno.entities.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    /*
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<Results>> getsuperHeroes();
    */

    //String BASE_URL = "http://localhost:8080/AndroidPeliculas/webresources/api/";
    String BASE_URL = "http://192.168.0.31:8080/AndroidPeliculas/webresources/api/";
    @GET("findAll")
    Call<List<Peliculas>> findAll();
}
