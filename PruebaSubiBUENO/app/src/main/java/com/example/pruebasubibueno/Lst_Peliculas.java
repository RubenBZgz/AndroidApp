package com.example.pruebasubibueno;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebasubibueno.entities.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lst_Peliculas extends AppCompatActivity {
    ListView superListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lst_peliculas);

        superListView = findViewById(R.id.superListView);
        findAll();
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
