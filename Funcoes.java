package com.mycompany.lady.s_books;

import static com.mycompany.lady.s_books.Principal.livros;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Funcoes {
    
    public void exibirMenu(){  // aqui se inicializa o menu
        System.out.println("(^_^)Seja bem vinda(o) ao seu organizador de livros Ladys Books!\n");
        System.out.println("Menu:");
        System.out.println("1. Cadastre seu livro :)");
        System.out.println("2. Listar livros cadastrados ");
        System.out.println("3. Buscar livro pelo titulo");
        System.out.println("4. Ordenar os livros por algum dos atributos");
        System.out.println("5. Sair T_T");
        System.out.print("** Escolha apenas uma opcao: ");
    }

    public void logicaMenu(){ //Método com a lógica para o funcionamento do menu
        try (Scanner scanner = new Scanner(System.in) // esse scanner serve para ler a entrada de dados do usuario.
        ) {
            int opcao = 0;

            do{
                exibirMenu(); // exibe o menu de opções
                try{
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    if (opcao == 1){ // aqui vai ser o processamento da escolha do usuario
                        cadastrarLivro(scanner); // aqui chama o metodo para cadastrar um novo livro
                    } else if (opcao == 2){ // aqui chama o metodo para listar livros
                        listarLivros();
                    } else if (opcao == 3){ // aqui chama o metodo para buscar os livros
                        buscarLivro(scanner);
                    } else if (opcao == 4){ // aqui ordena os livros por algum dos atributos
                        listarLivrosOrdenados(scanner);
                    } else if (opcao == 5){ // aqui encerra o programa
                        System.out.println("** Ate mais! Volte sempre! S2");
                    } else {
                        System.out.println("** Essa opcao nao existe, tente de novo.\n");
                    }
                }catch (InputMismatchException e){ // para caso o usuario digite uma opção invalida.
                    System.out.println("** Entrada invalida, por favor, digite um numero.");
                    scanner.next();
                }
            } while (opcao != 4); // um loop que continua ate o usuario sair do programa
        }
    }


    public void cadastrarLivro(Scanner scanner) { // Metodo para cadastrar os livros
        System.out.println("** Cadastro de livro\n");

        String titulo = lerInputNaoVazio(scanner, "** Titulo (apenas letras): ");
        String autor = lerInputNaoVazio(scanner, "** Autor (apenas letras): ");
        String genero = lerInputNaoVazio(scanner, "** Genero (apenas letras): ");
        String isbn = lerInputNaoVazio(scanner, "** ISBN (apenas numeros): ");
        int anoPublicacao = lerInteiroNaoVazio(scanner, "** Ano de publicacao (apenas numeros): ");
        String tipo = lerInputNaoVazio(scanner, "** Ficcao ou Nao-Ficcao? (apenas letras): ");

        Livros novoLivro = new Livros(titulo, autor, anoPublicacao, genero,  tipo, isbn);
        livros.add(novoLivro);
        System.out.println("\n");
        System.out.println("Seu livro foi cadastrado com sucesso!S2");
    }

    public String lerInputNaoVazio(Scanner scanner, String mensagem) { //método para verificar se o input é string  vazio
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(mensagem);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Tipo incorreto, tente novamente.");
            }
        }
        return input;
    }

    public int lerInteiroNaoVazio(Scanner scanner, String mensagem) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensagem);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                try {
                    valor = Integer.parseInt(input);
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Tipo incorreto, tente novamente.");
                }
            } else {
                System.out.println("Tipo incorreto, tente novamente.");
            }
        }
        return valor;
    }

    public void listarLivros(){ // aqui inicializa a listagem dos livros cadastrados
        if (livros.isEmpty()){
            System.out.println("** Nenhum livro cadastrado.\n");
        } else {
            System.out.printf("%-30s%-20s%-15s%n", "Titulo", "Autor", "Ano de Publicacao"); // aqui se formata o output em formato tabular
            System.out.println("-----------------------------------------------------------");
            for (Livros livro : livros) {
                System.out.printf("%-30s%-20s%-15d%n", livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
            }
        }
    }

    public void listarLivrosOrdenados(Scanner scanner) {
        System.out.println("Escolha o atributo para ordenar os livros:");
        System.out.println("1. Titulo");
        System.out.println("2. Autor");
        System.out.println("3. Ano de Publicacao");
        System.out.println("4. Tipo");
        System.out.println("5. Genero");
        System.out.println("6. ISBN");
        System.out.print("Digite o número da sua escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        Comparator<Livros> comparator;
        comparator = null;

        switch (escolha) {
            case 1:
                comparator = Comparator.comparing(Livros::getTitulo);
                break;
            case 2:
                comparator = Comparator.comparing(Livros::getAutor);
                break;
            case 3:
                comparator = Comparator.comparingInt(Livros::getAnoPublicacao);
                break;
            case 4:
                comparator = Comparator.comparing(Livros::getTipo);
                break;
            case 5:
                comparator = Comparator.comparing(Livros::getGenero);
                break;
            case 6:
                comparator = Comparator.comparing(Livros::getIsbn);
                break;
            default:
                System.out.println("Escolha inválida. Listagem não ordenada.");
                return;
        }

        Collections.sort(livros, comparator);

        System.out.println("** Lista de livros ordenados:");
        for (Livros livro : livros) {
            System.out.println("** Titulo: " + livro.getTitulo());
            System.out.println("** Autor: " + livro.getAutor());
            System.out.println("** Ano de publicacao: " + livro.getAnoPublicacao());
            System.out.println("** Ficcao ou Não-Ficcao: " + livro.getTipo());
            System.out.println("** Genero: " + livro.getGenero());
            System.out.println("** ISBN: " + livro.getIsbn());
            System.out.println();
        }
    }

    public void buscarLivro(Scanner scanner) {
        System.out.print("Digite o titulo de apenas um livro (com apenas letras): ");
        String titulo = scanner.nextLine();

        boolean encontrado = false;

        for (Livros livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("** Livro encontrado:");
                System.out.println("** Titulo: " + livro.getTitulo());
                System.out.println("** Autor: " + livro.getAutor());
                System.out.println("** Ano de publicacao: " + livro.getAnoPublicacao());
                System.out.println("** Ficcao ou Nao-Ficcao: " + livro.getTipo());
                System.out.println("** Genero: " + livro.getGenero());
                System.out.println("** ISBN: " + livro.getIsbn());
                encontrado = true;

                System.out.print("Deseja alterar (a) ou remover (r) o cadastro deste livro? (a/r/n): ");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("a")) {
                    System.out.print("Novo titulo: ");
                    livro.setTitulo(scanner.nextLine());

                    System.out.print("Novo autor: ");
                    livro.setAutor(scanner.nextLine());

                    System.out.print("Novo ano de publicacao: ");
                    livro.setAnoPublicacao(scanner.nextInt());
                    scanner.nextLine(); // Limpa o buffer do scanner

                    System.out.print("Novo tipo (Ficcao ou Não-Ficcao): ");
                    livro.setTipo(scanner.nextLine());

                    System.out.print("Novo genero: ");
                    livro.setGenero(scanner.nextLine());

                    System.out.print("Novo ISBN: ");
                    livro.setIsbn(scanner.nextLine());

                    System.out.println("** Cadastro do livro atualizado com sucesso!");
                } else if (resposta.equalsIgnoreCase("r")) {
                    System.out.println("Deseja realmente remover? Responsa s/n");
                    String resposta2 = scanner.nextLine();
                    if (resposta2.equalsIgnoreCase("s")){
                        livros.remove(livro);
                        System.out.println("** Livro removido com sucesso!");
                    }
               
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("** Este livro nao foi encontrado. Tente novamente!\n");
        }
    }
}
