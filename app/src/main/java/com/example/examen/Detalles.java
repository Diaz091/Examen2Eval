package com.example.examen;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    private TextView txt1 ;
    private String isbn;
    private SQLiteDatabase db;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detalles );

        LibrosSQLiteHelper ldb = new LibrosSQLiteHelper(this,"DBLibros",null,1);
        db = ldb.getWritableDatabase();

      //  Intent intento = getIntent();
       // isbn = intento.getStringExtra( "isbn" );


    }


    public void borrar( View view ) {

        db.execSQL("DELETE FROM LIBROS where isbn = '"+123456+"'");
        finish();

    }

    public void atras( View view ) {
        finish();
    }
}
