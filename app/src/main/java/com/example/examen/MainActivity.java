package com.example.examen;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        LibrosSQLiteHelper ldb = new LibrosSQLiteHelper(this,"DBLibros",null,1);
        db = ldb.getWritableDatabase();
    }


    public void ventanaBBDD( View view ) {
        Intent bbdd = new Intent( this ,BaseDatos.class );
        startActivity( bbdd );
    }



    public void salir( View view ) {
        finish();
    }

    public void multi( View view ) {
        Intent multi = new Intent( this , Multimedia.class );
        startActivity( multi );
    }
}
