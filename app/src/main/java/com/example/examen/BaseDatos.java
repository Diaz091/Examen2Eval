package com.example.examen;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BaseDatos extends AppCompatActivity {



    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_base_datos );
    }

    public void newLib( View view ) {
        Intent nuevoLibro = new Intent(this, NuevoLibro.class);
        startActivity( nuevoLibro );
    }

    public void listaLib( View view ) {
        Intent listaLibros = new Intent(this, ListadoLibros.class);
        startActivity( listaLibros );
    }

    public void back( View view ) {
        finish();
    }


}
