package com.example.pruebasubibueno.RetrofitAPI;

import com.example.pruebasubibueno.entities.Peliculas;
import com.example.pruebasubibueno.entities.cPeli;

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
    //          CLASE
    String BASE_URL = "http://192.168.104.53:8080/AndroidPeliculas/webresources/api/";
    //          CASA
    //String BASE_URL = "http://192.168.0.31:8080/AndroidPeliculas/webresources/api/";
    @GET("findAll")
    Call<List<Peliculas>> findAll();

    @GET("findOne/{idPelicula}")
    Call<List<Peliculas>> findOne(@Path("idPelicula") int idPelicula);

    @GET("top10")
    Call<List<Peliculas>> top10();

    @GET("tematicas")
    Call<List<String>> tematicas();

    @GET("filtrarTitulo/{titulo}")
    Call<List<Peliculas>> filtrarTitulo(@Path("titulo") String titulo);

    @GET("filtrarTematica/{tematica}")
    Call<List<Peliculas>> filtrarTematica(@Path("tematica") String tematica);

    @GET("filtrarAmbas/{titulo}/{tematica}")
    Call<List<Peliculas>> filtrarAmbas(@Path("titulo") String titulo, @Path("tematica") String tematica);

    @GET("puntuar/{idPelicula}/{puntuacion}")
    Call<List<Peliculas>> puntuar(@Path("idPelicula") int idPelicula, @Path("puntuacion") int puntuacion);

    @GET("historico")
    Call<List<Peliculas>> historico();

    @GET("peliculasCine/{idPelicula}")
    Call<List<cPeli>> peliculasCine(@Path("idPelicula") int idPelicula);
}
