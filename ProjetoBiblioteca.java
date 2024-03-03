import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}

class Biblioteca {
    private ArrayList<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
    }

    public void mostrarLivros() {
        if (acervo.isEmpty()) {
            System.out.println("A biblioteca está vazia.");
        } else {
            System.out.println("Livros na biblioteca:");
            for (Livro livro : acervo) {
                System.out.println(livro.getTitulo() + " - " + livro.getAutor());
            }
        }
    }
}

public class ProjetoBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Mostrar livros");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.nextLine();
                    Livro novoLivro = new Livro(titulo, autor);
                    biblioteca.adicionarLivro(novoLivro); // Removed extra parenthesis
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    biblioteca.mostrarLivros();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}