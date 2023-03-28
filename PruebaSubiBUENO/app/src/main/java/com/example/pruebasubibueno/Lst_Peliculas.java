package com.example.pruebasubibueno;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebasubibueno.RetrofitAPI.RetrofitClient;
import com.example.pruebasubibueno.entities.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lst_Peliculas extends AppCompatActivity {
    ListView superListView;
    TextView function;
    String data = "";
    String nombrePelicula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lst_peliculas);

        superListView = findViewById(R.id.superListView);



        Intent intent = getIntent();
        data = intent.getStringExtra(MainActivity.EXTRA_FUNCTION);
        function = (TextView) findViewById(R.id.data);
        //function.setText(data);
        //String data = function.toString();

        switch (data) {
            case "findAll":
                findAll();
                break;
            case "top10":
                top10();
                break;
            case "filtrarTitulo":
                nombrePelicula = intent.getStringExtra(MainActivity.EXTRA_TEXT);
                function.setText(nombrePelicula);
                filtradoTitulo(nombrePelicula);
                break;
        }

    }


    private void findAll() {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().findAll();
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = peliculas.get(i).getTitulo();
                    unaPelicula[i] += " (" + peliculas.get(i).getAnio() + ")";
                }
                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, unaPelicula));
            }

            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void top10() {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().top10();
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = peliculas.get(i).getTitulo();
                    unaPelicula[i] += " (" + peliculas.get(i).getAnio() + ")";
                }
                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, unaPelicula));
            }

            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void filtradoTitulo(String titulo) {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().filtradoTitulo(titulo);
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = peliculas.get(i).getTitulo();
                    unaPelicula[i] += " (" + peliculas.get(i).getAnio() + ")";
                }
                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, unaPelicula));
            }

            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }
}
