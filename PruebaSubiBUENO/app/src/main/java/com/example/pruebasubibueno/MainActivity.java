package com.example.pruebasubibueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button findAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAll = (Button) findViewById(R.id.findAll);
        findAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLstPeliculas();
            }
        });

    }

    public void openActivityLstPeliculas() {
        Intent intent = new Intent(this, Lst_Peliculas.class);
        startActivity(intent);
    }
}