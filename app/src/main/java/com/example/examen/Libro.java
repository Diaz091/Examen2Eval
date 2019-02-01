package com.example.examen;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private int isbn;
    private int numPag;


    public Libro( String titulo, String autor ) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro( String titulo, String autor, String editorial, int isbn, int numPag ) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.numPag = numPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo( String titulo ) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor( String autor ) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial( String editorial ) {
        this.editorial = editorial;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn( int isbn ) {
        this.isbn = isbn;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag( int numPag ) {
        this.numPag = numPag;
    }
}
