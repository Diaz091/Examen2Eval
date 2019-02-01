package com.example.examen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Multimedia extends AppCompatActivity {

    private Spinner spinner;
    MediaPlayer mp;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_multimedia );

        spinner = findViewById(R.id.spinner);

        ArrayList<String> lista = new ArrayList<String>();
        try {
        InputStream is = getResources().openRawResource(R.raw.recurso);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String linea = null;

        linea = br.readLine();
    lista.add( " " );
        while (linea!= null){

            lista.add(linea);
            linea = br.readLine();
        }
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,lista);
        spinner.setAdapter(adaptador);

        } catch ( IOException e ) {
            e.printStackTrace();
        }


        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected( AdapterView< ? > parent, View view, int position, long id ) {

                String selectedItem = spinner.getSelectedItem().toString();

                if ( selectedItem.equals( "burro".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.burro );
                    mp.start();
                } else if ( selectedItem.equals( "caballos".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.caballos );
                    mp.start();
                } else if ( selectedItem.equals( "cabra".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.caballos );
                    mp.start();
                } else if ( selectedItem.equals( "gallina".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.gallina );
                    mp.start();
                } else if ( selectedItem.equals( "gallo".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.gallo );
                    mp.start();
                } else if ( selectedItem.equals( "gato".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.gato );
                    mp.start();
                } else if ( selectedItem.equals( "ovejas".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.ovejas );
                    mp.start();
                } else if ( selectedItem.equals( "vaca".trim() ) ) {

                    mp = MediaPlayer.create( Multimedia.this, R.raw.vaca );
                    mp.start();


                }
            }

            @Override
            public void onNothingSelected( AdapterView< ? > parent ) {

            }
        } );
    }
    public void back( View view ) {
        finish();
    }
}
