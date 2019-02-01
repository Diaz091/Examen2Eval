package com.example.examen;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class NuevoLibro extends AppCompatActivity {
    private SQLiteDatabase db;
    private EditText titu , aut, isbn, edit, numP;
    private CheckBox tick;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_nuevo_libro );

        LibrosSQLiteHelper ldb = new LibrosSQLiteHelper(this,"DBLibros",null,1);
        db = ldb.getWritableDatabase();

        titu = findViewById( R.id.titulo );
        aut  = findViewById( R.id.autor );
        isbn = findViewById( R.id.isbn );
        edit = findViewById( R.id.editorial );
        numP = findViewById( R.id.numP );
        tick = findViewById( R.id.check );

    }

    public void insertartLib( View view ) {
        // CREATE TABLE LIBROS(isbn NUMBER(13)  PRIMARY KEY,titulo TEXT, autor TEXT, editorial TEXT, numPag NUMBER, leido TEXT)");

        String tit = titu.getText().toString();
        String autor= aut.getText().toString();
        String isb= isbn.getText().toString() ;
        String edi= edit.getText().toString();
        String numPag= numP.getText().toString();
        String leido = "no";
        if(tick.isChecked()){
            leido = "si";
        }

        db.execSQL("INSERT INTO LIBROS VALUES('"+isb+"', '"+tit+"', '"+autor+"', '"+edi+"', '"+numPag+"','"+leido+"' )");

        titu.setText( null );
        aut.setText( null );
        isbn.setText( null );
        edit.setText( null );
        numP.setText( null );
        tick.setChecked( false );
    }



    public void limpiar( View view ) {
        titu.setText( null );
        aut.setText( null );
        isbn.setText( null );
        edit.setText( null );
        numP.setText( null );
        tick.setChecked( false );
    }

    public void atras( View view ) {
        finish();
    }
}
