package com.example.pruebasubibueno;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebasubibueno.RetrofitAPI.RetrofitClient;
import com.example.pruebasubibueno.entities.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ficha_tecnica extends AppCompatActivity {
    ListView superListView;
    TextView function;
    String data = "";
    TextView fichaTitulo;
    TextView fichaAnio;
    ImageView fichaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha_tecnica);

        Intent intent = getIntent();
        //String idPelicula = intent.getStringExtra(Lst_Peliculas.EXTRA_ID);
        //Toast.makeText(this, idPelicula, Toast.LENGTH_SHORT).show();
        int idPelicula = Integer.parseInt(intent.getStringExtra(Lst_Peliculas.EXTRA_ID));


        fichaTitulo = findViewById(R.id.fichaTitulo);
        String titulo = String.valueOf(fichaTitulo);
        fichaAnio = findViewById(R.id.fichaAnio);
        String anio = String.valueOf(fichaAnio);
        fichaImagen = findViewById(R.id.fichaImagen);



        findOne(idPelicula);


    }


    private void findOne(int idPelicula) {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().findOne(idPelicula);
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    fichaTitulo.setText(peliculas.get(i).getTitulo());
                    fichaAnio.setText(peliculas.get(i).getAnio());
                    //if (peliculas.get(i).get)
                    //fichaImagen.
                }
                //superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, unaPelicula));
            }

            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }


}
