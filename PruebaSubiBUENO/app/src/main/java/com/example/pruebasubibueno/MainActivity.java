package com.example.pruebasubibueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FUNCTION = "com.example.application.example.EXTRA_FUNCTION";
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";
    private Button findAll;
    private Button top10;
    private Button historico;
    private Button btnFiltrarTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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