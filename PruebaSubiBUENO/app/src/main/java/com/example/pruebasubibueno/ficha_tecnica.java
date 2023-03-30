package com.example.pruebasubibueno;

import static com.example.pruebasubibueno.Lst_Peliculas.EXTRA_ID;
import static com.example.pruebasubibueno.MainActivity.EXTRA_FUNCTION;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;
import com.example.pruebasubibueno.RetrofitAPI.RetrofitClient;
import com.example.pruebasubibueno.entities.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ficha_tecnica extends AppCompatActivity {
    //public static final String EXTRA_FUNCTION = "com.example.application.example.EXTRA_FUNCTION";
    public static final String EXTRA_ID_FICHA = "com.example.application.example.EXTRA_ID_FICHA";
    private TextView function;
    private String data = "";
    private TextView fichaTitulo;
    private TextView fichaAnio;
    private ImageView fichaImagen;
    private Button fichaReservar;
    private RatingBar fichaPuntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha_tecnica);

        Intent intent = getIntent();
        Intent intent2 = new Intent(this, Lst_Peliculas.class);
        //String idPelicula = intent.getStringExtra(Lst_Peliculas.EXTRA_ID);
        //Toast.makeText(this, idPelicula, Toast.LENGTH_SHORT).show();
        int idPelicula = Integer.parseInt(intent.getStringExtra(EXTRA_ID));

        fichaTitulo = findViewById(R.id.fichaTitulo);
        String titulo = String.valueOf(fichaTitulo);
        fichaAnio = findViewById(R.id.fichaAnio);
        String anio = String.valueOf(fichaAnio);
        fichaImagen = findViewById(R.id.fichaImagen);
        fichaReservar = findViewById(R.id.fichaReservar);
        fichaReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openActivityLstPeliculasCine("peliculasCine", idPelicula);
                AlertDialog.Builder builder = new AlertDialog.Builder(ficha_tecnica.this);
                builder.setMessage("¿Está seguro de que desea reservar esta película?")
                        .setCancelable(false)
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Código para reservar la película
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Código para cerrar el diálogo
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        fichaPuntuacion = findViewById(R.id.fichaPuntuacion);
        fichaPuntuacion.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (fromUser) {
                puntuar(idPelicula, (int) rating);
            }
        });

        findOne(idPelicula);
    }

    public void openActivityLstPeliculasCine(String metodo, int idPelicula) {
        //EditText function = (EditText) findViewById(R.id.filtrarTitulo);
        //String text = function.getText().toString();
        Intent intent = new Intent(this, Lst_Peliculas.class);
        intent.putExtra(EXTRA_FUNCTION, metodo);
        intent.putExtra("EXTRA_ID_FICHA", idPelicula);
        startActivity(intent);
    }

    private void findOne(int idPelicula) {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().findOne(idPelicula);
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                //String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    fichaTitulo.setText(peliculas.get(i).getTitulo());
                    fichaAnio.setText(String.valueOf(peliculas.get(i).getAnio()));
                    fichaPuntuacion.setRating((float) peliculas.get(i).getCalificacion());
                    String img = peliculas.get(i).getImagen();
                    if (peliculas.get(i).getImagen() != null || peliculas.get(i).getImagen() != ""){
                        Glide.with(ficha_tecnica.this).load(peliculas.get(i).getImagen()).into(fichaImagen);
                    } else {
                        Toast.makeText(ficha_tecnica.this, "ERROR IMAGEN", Toast.LENGTH_LONG).show();
                    }
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

    private void puntuar(int idPelicula, int calificacion) {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().puntuar(idPelicula, calificacion);
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                for (int i = 0; i < peliculas.size(); i++) {
                    fichaPuntuacion.setRating((float) peliculas.get(i).getCalificacion());
                }
            }

            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }


}
