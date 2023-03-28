package com.example.pruebasubibueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebasubibueno.RetrofitAPI.RetrofitClient;
import com.example.pruebasubibueno.entities.Peliculas;
import com.google.android.material.navigation.NavigationBarView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FUNCTION = "com.example.application.example.EXTRA_FUNCTION";
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";
    private Button findAll;
    private Button top10;
    private Button historico;
    private Button btnFiltrarTitulo;
    private Spinner comboDias;
    private ArrayList<String> comboDiasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comboDias = (Spinner) findViewById(R.id.idSpinnerDias);

        tematicas();
        comboDiasList = new ArrayList<String>();
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,comboDiasList);
        comboDias.setAdapter(adapter);


        btnFiltrarTitulo = (Button) findViewById(R.id.btnFiltrarTitulo);
        btnFiltrarTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFilterPeliculas("filtrarTitulo");
            }
        });

        findAll = (Button) findViewById(R.id.findAll);
        findAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLstPeliculas("findAll");
            }
        });

        top10 = (Button) findViewById(R.id.top10);
        top10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLstPeliculas("top10");
            }
        });

        historico = (Button) findViewById(R.id.historico);
        historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLstPeliculas("historico");
            }
        });

    }


    private void tematicas() {
        Call<List<String>> call = RetrofitClient.getInstance().getMyApi().tematicas();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> tematicas = response.body();
                String[] unaTematica = new String[tematicas.size()];
                for (int i = 0; i < tematicas.size(); i++) {
                    unaTematica[i] = tematicas.get(i);
                }
                comboDias.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, unaTematica));
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("Error:", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "An error has occured: " + t, Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tematicas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void openActivityLstPeliculas(String metodo) {
        //EditText function = (EditText) findViewById(R.id.filtrarTitulo);
        //String text = function.getText().toString();
        Intent intent = new Intent(this, Lst_Peliculas.class);
        intent.putExtra(EXTRA_FUNCTION, metodo);
        startActivity(intent);
    }

    public void openActivityFilterPeliculas(String metodo) {
        EditText function = (EditText) findViewById(R.id.filtrarTitulo);
        String text = function.getText().toString();
        Intent intent = new Intent(this, Lst_Peliculas.class);
        intent.putExtra(EXTRA_FUNCTION, metodo);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}