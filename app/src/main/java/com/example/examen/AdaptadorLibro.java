package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptadorLibro extends ArrayAdapter<Libro> {

    private Libro[] libros;

    public AdaptadorLibro( Context context, Libro[] libros){
        super(context,R.layout.list_item,libros);
        this.libros = libros;
    }


    public View getView( int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from( getContext() );
        View vista = inflater.inflate( R.layout.list_item, null);

        TextView titulo = vista.findViewById( R.id.titu );
        titulo.setText( libros[ position ].getTitulo() );

        TextView autor = vista.findViewById( R.id.auto );
        autor.setText( libros[ position ].getAutor());

        return vista;
    }
}
