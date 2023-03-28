package com.example.pruebasubibueno.RetrofitAPI;

import com.example.pruebasubibueno.entities.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    /*
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<Results>> getsuperHeroes();
    */

    //String BASE_URL = "http://localhost:8080/AndroidPeliculas/webresources/api/";
    String BASE_URL = "http://192.168.104.53:8080/AndroidPeliculas/webresources/api/";
    @GET("findAll")
    Call<List<Peliculas>> findAll();

    @GET("filtradoTitulo/{titulo}")
    Call<List<Peliculas>> filtradoTitulo(@Path("titulo") String titulo);

    @GET("top10")
    Call<List<Peliculas>> top10();
}
