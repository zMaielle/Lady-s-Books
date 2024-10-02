package com.mycompany.lady.s_books;

// Classe Livros herdando de Genero_Literario
public class Livros extends Genero_Literario { // Esta classe vai representar um livro, nela iremos ter todos os atributos de um livro.
    private String titulo;  // Esse é o atributo "titulo" do livro, e assim segue abaixo. 
    private String autor;
    private int anoPublicacao;
    private String isbn; 

    public Livros(String titulo, String autor, int anoPublicacao, String genero, String tipo, String isbn) { 
        super(tipo, genero); // Chama o construtor da classe-pai
        this.titulo = titulo; // Aqui, vamos usar o this para diferenciar os parâmetros do construtor.
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
    }

    public String getTitulo() { // Aqui, são os métodos get, e iremos usar para acessar os valores dos atributos que declaramos lá em cima.
        return titulo; // aqui, vamos retornar o titulo do livro que foi armazanado. 
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao; 
    }
    
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
        
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    void add(Livros novoLivro) { // aqui é o método add, e iremos usar ele para adicionar novos livros.
        Principal.livros.add(novoLivro); 
    }
}