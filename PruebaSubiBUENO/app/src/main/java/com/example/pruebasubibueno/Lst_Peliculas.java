package com.example.pruebasubibueno;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebasubibueno.RetrofitAPI.RetrofitClient;
import com.example.pruebasubibueno.entities.Peliculas;
import com.example.pruebasubibueno.entities.cPeli;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lst_Peliculas extends AppCompatActivity {
    public static final String EXTRA_ID = "com.example.application.example.EXTRA_ID";

    ListView superListView;
    TextView function;
    String data = "";
    String nombrePelicula = "";
    String nombreTematica = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lst_peliculas);

        Intent intent2 = new Intent(this, ficha_tecnica.class);
        superListView = findViewById(R.id.superListView);

        superListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idPeli = Integer.parseInt(String.valueOf(parent.getItemAtPosition(position)).substring(0,1));
                //Toast.makeText(Lst_Peliculas.this, "Me has clicado:  " + idPeli, Toast.LENGTH_SHORT).show();
                intent2.putExtra(EXTRA_ID, String.valueOf(idPeli));
                startActivity(intent2);
                //findOne(idPeli);
            }
        });



        Intent intent = getIntent();
        data = intent.getStringExtra(MainActivity.EXTRA_FUNCTION);
        String data4 = String.valueOf(intent.getExtras());


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
                filtrarTitulo(nombrePelicula);
                break;
            case "filtrarTematica":
                nombreTematica = intent.getStringExtra(MainActivity.EXTRA_TEXT);
                function.setText(nombreTematica);
                filtrarTematica(nombreTematica);
                break;
            case "filtrarAmbas":
                nombrePelicula = intent.getStringExtra(MainActivity.EXTRA_TEXT);
                nombreTematica = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
                function.setText(nombreTematica);
                filtrarAmbas(nombrePelicula, nombreTematica);
                break;
            case "historico":
                historico();
                break;
            case "peliculasCine":
                String data5 = String.valueOf(getIntent().getExtras()); // CONSIGO TODOS LOS EXTRAS
                String[] extras = (data5.substring(8,data5.length()-2)).split(","); // QUITO EL PRIN/FIN Y ARRAY
                String idPelicula = extras[1].substring(extras[1].indexOf("=")+1);  // COJO EL VALOR QUE QUIERO

                peliculasCine(Integer.parseInt(idPelicula));
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
                    unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                    unaPelicula[i] += peliculas.get(i).getTitulo();
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
                    unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                    unaPelicula[i] += peliculas.get(i).getTitulo();
                    unaPelicula[i] += " (" + peliculas.get(i).getAnio() + ")";
                    unaPelicula[i] += "  Votos: " + peliculas.get(i).getVecesPuntuado();
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

    private void historico() {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().historico();
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                    unaPelicula[i] += peliculas.get(i).getTitulo();
                    unaPelicula[i] += " (" + peliculas.get(i).getAnio() + ")";
                    unaPelicula[i] += "  Votos: " + peliculas.get(i).getVecesPuntuado();
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


    private void filtrarTitulo(String titulo) {
            Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().filtrarTitulo(titulo);
            call.enqueue(new Callback<List<Peliculas>>() {
                @Override
                public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                    List<Peliculas> peliculas = response.body();
                    String[] unaPelicula = new String[peliculas.size()];
                    for (int i = 0; i < peliculas.size(); i++) {
                        unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                        unaPelicula[i] += peliculas.get(i).getTitulo();
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

    private void filtrarTematica(String tematica) {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().filtrarTematica(tematica);
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                    unaPelicula[i] += peliculas.get(i).getTitulo();
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

    private void filtrarAmbas(String titulo, String tematica) {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().filtrarAmbas(titulo, tematica);
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                    unaPelicula[i] += peliculas.get(i).getTitulo();
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

    /*private void peliculasCine(int idPelicula) {
        Call<List<Peliculas>> call = RetrofitClient.getInstance().getMyApi().peliculasCine(idPelicula);
        call.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                    unaPelicula[i] += peliculas.get(i).getTitulo();
                    unaPelicula[i] += " (" + peliculas.get(i).getAnio() + ")";
                    unaPelicula[i] += "  Votos: " + peliculas.get(i).getVecesPuntuado();
                }
                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, unaPelicula));
            }

            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }*/

    /*private void peliculasCine(int idPelicula) {
        Call<List<cPeli>> call = RetrofitClient.getInstance().getMyApi().peliculasCine(idPelicula);
        call.enqueue(new Callback<List<cPeli>>() {
            @Override
            public void onResponse(Call<List<cPeli>> call, Response<List<cPeli>> response) {
                List<cPeli> peliculas = response.body();
                String[] unaPelicula = new String[peliculas.size()];
                for (int i = 0; i < peliculas.size(); i++) {
                    unaPelicula[i] = String.valueOf(peliculas.get(i).getIdPelicula());
                    unaPelicula[i] += peliculas.get(i).getTitulo();
                    unaPelicula[i] += " (" + peliculas.get(i).getAnio() + ")";
                    unaPelicula[i] += "  Votos: " + peliculas.get(i).getVecesPuntuado();
                }
                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, unaPelicula));
            }

            @Override
            public void onFailure(Call<List<cPeli>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }*/

    private void peliculasCine(int idPelicula) {
        Call<List<cPeli>> call = RetrofitClient.getInstance().getMyApi().peliculasCine(idPelicula);
        call.enqueue(new Callback<List<cPeli>>() {
            @Override
            public void onResponse(Call<List<cPeli>> call, Response<List<cPeli>> response) {
                if (response.isSuccessful()) {
                    List<cPeli> peliculas = response.body();
                    List<String> unaPelicula = new ArrayList<>();
                    for (int i = 0; i < peliculas.size(); i++) {
                        /*String pelicula = String.valueOf(peliculas.get(i).getIdPelicula());
                        pelicula += " " + peliculas.get(i).getTitulo();
                        pelicula += " (" + peliculas.get(i).getAnio() + ")";
                        pelicula += "  Votos: " + peliculas.get(i).getVecesPuntuado();
                        unaPelicula.add(pelicula);*/
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, unaPelicula);
                    superListView.setAdapter(adapter);
                } else {
                    // handle unsuccessful response
                    Log.d("Error:", String.valueOf(response.code()));
                    Toast.makeText(getApplicationContext(), "An error has occured: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<cPeli>> call, Throwable t) {
                // handle network failure
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



}
