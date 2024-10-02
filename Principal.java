package com.mycompany.lady.s_books;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    static List<Livros> livros = new ArrayList<>(); // aqui vamos fazer uma lista de livros já cadastrados

    public static void main(String[] args) {
        // aqui deixamos armazenados os livros que já estão cadastrados
        livros.add(new Livros("Tudo eh rio", "Carla Madeira", 2021, "Romance", "Ficcao", "6555871784"));
        livros.add(new Livros("A cachorra", "Pilar Quintada", 2020, "Ficcao Feminina", "Ficcao", "8551006592"));
        livros.add(new Livros("A pediatra", "Andrea Del Fuego", 2021, "Ficcao Literaria", "Ficcao", "655921348"));
        livros.add(new Livros("Boy Erased", "Garrard Conley", 2019, "Biografia", "Ficcao", "8551004115"));
        livros.add(new Livros("A filha primitiva", "Vanessa Passos", 2022, "Literatura Afro", "Ficcao", "6558470991"));
        livros.add(new Livros("O Caibailon", "Os tres iniciados", 2021, "Misticismo", "Nao-Ficcao", "6587236987"));
        livros.add(new Livros("A Tabua de Esmeralda", "Fabio Araujo", 2020, "Religiao", "Nao-Ficcao", "1609425561"));

        Funcoes funcoes = new Funcoes(); // criando uma instância de Funcoes
        funcoes.logicaMenu(); // chamando o método logicaMenu através da instância criada
    }
}

