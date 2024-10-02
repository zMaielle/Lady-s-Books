package com.mycompany.lady.s_books;

// Classe-pai Genero_Literario
public class Genero_Literario {
    private String tipo; // Ficção ou Não-Ficção
    private String genero; // Gênero específico

    public Genero_Literario(String tipo, String genero) {
        this.tipo = tipo;
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

