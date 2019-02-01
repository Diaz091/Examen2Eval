package com.example.examen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class ListadoLibros extends AppCompatActivity {

    private ListView libros;
    private SQLiteDatabase db;
    private RadioButton leido , noLeido , todoLibro;
    private Libro[] libs , libs2 , libs3;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_listado_libros );


        // La visualización de los libros segun si están leidos o no funcionan pero salen un poco mal :) 
        libros = findViewById( R.id.listaLib );

        LibrosSQLiteHelper ldb = new LibrosSQLiteHelper(this,"DBLibros",null,1);
        db = ldb.getWritableDatabase();

        leido = findViewById( R.id.leidos );
        leido.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
                libs= leidos();

                AdaptadorLibro adpL =  new AdaptadorLibro( ListadoLibros.this, libs );

                libros.setAdapter( adpL );
            }
        } );

        noLeido = findViewById( R.id.noLeido );
        noLeido.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
                libs2= noLeidos();

                AdaptadorLibro adpL =  new AdaptadorLibro( ListadoLibros.this, libs2 );

                libros.setAdapter( adpL );

            }
        } );

        todoLibro = findViewById( R.id.todoLib );
        todoLibro.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
                libs3 = todoLibros();
                AdaptadorLibro adpL =  new AdaptadorLibro( ListadoLibros.this, libs3 );
                libros.setAdapter( adpL );
            }
        } );


        libros.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick( AdapterView< ? > parent, View view, int position, long id ) {
               Intent detalles = new Intent( ListadoLibros.this , Detalles.class );

                //Libro lib = ( Libro ) libros.getSelectedItem();
                //detalles.putExtra( "isbn" , lib.getIsbn());
                startActivity( detalles );

                return false;
            }
        } );


    }

    private Libro[] todoLibros(){

        ArrayList<Libro> arrlibros = new ArrayList<Libro>(  );

        Cursor libros = db.rawQuery("SELECT titulo, autor FROM LIBROS ",null);

        while (libros.moveToNext()){
            Libro lib = new Libro( libros.getString( 0 ) , libros.getString( 1 ) );
            arrlibros.add( lib );

        }
        libros.close();

        Libro[] lib = new Libro[arrlibros.size()];
        Log.i("funciona?",arrlibros.size()+"");

        for(int i =0; i<arrlibros.size(); i++){
            lib[i]=arrlibros.get( i );

        }

        return lib;
    }

    private Libro[] noLeidos(){

        ArrayList<Libro> arrlibros = new ArrayList<Libro>(  );

        Cursor libros = db.rawQuery("SELECT titulo, autor FROM LIBROS WHERE leido= ?",new String[]{"no"});


        while (libros.moveToNext()){
            Libro lib = new Libro( libros.getString( 0 ) , libros.getString( 1 ) );
            lib.toString();
            arrlibros.add( lib );

        }
        libros.close();
        Libro[] lib = new Libro[arrlibros.size()];

        for(int i =0; i<arrlibros.size(); i++){
            lib[i]=arrlibros.get( i );

        }

        return lib;
    }
    private Libro[] leidos(){

        ArrayList<Libro> arrlibros = new ArrayList<Libro>(  );

        Cursor libros = db.rawQuery("SELECT titulo, autor FROM LIBROS WHERE leido= ?",new String[]{"si"});

        while (libros.moveToNext()){
            Libro lib = new Libro( libros.getString( 0 ) , libros.getString( 1 ) );
            arrlibros.add( lib );

        }
        libros.close();
        Libro[] lib = new Libro[arrlibros.size()];

        for(int i =0; i<arrlibros.size(); i++){
            lib[i]=arrlibros.get( i );

        }
        return lib;
    }

    public void atras2( View view ) {
        finish();
    }



}

