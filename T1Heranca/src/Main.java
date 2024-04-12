import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n======= Sistema de Biblioteca =======");
			System.out.println("1. Adicionar livro");
			System.out.println("2. Adicionar usuário");
			System.out.println("3. Emprestar livro");
			System.out.println("4. Retornar livro");
			System.out.println("5. Imprimir informações de todos os livros");
			System.out.println("6. Imprimir informações de todos os usuários");
			System.out.println("7. Sair");
			System.out.print("Escolha uma opção: ");

			
			int escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
			case 1:
				adicionarLivro(biblioteca, scanner);
				break;
			case 2:
				adicionarUsuario(biblioteca, scanner);
				break;
			case 3:
				emprestarLivro(biblioteca, scanner);
				break;
			case 4:
				retornarLivro(biblioteca, scanner);
				break;
			case 5:
				biblioteca.imprimirInformacoesTodosLivros();
				break;
			case 6:
				biblioteca.imprimirInformacoesTodosUsuarios();
				break;
			case 7:
				System.out.println("Saindo...");
				return;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}

	private static void adicionarLivro(Biblioteca biblioteca, Scanner scanner) {
		System.out.print("Título do livro: ");
		String titulo = scanner.nextLine();
		System.out.print("Autor do livro: ");
		String autor = scanner.nextLine();
		System.out.print("ISBN do livro: ");
		String isbn = scanner.nextLine();
		System.out.print("Status do livro (Disponível/Emprestado): ");
		String status = scanner.nextLine();
		System.out.print("Tipo de livro (Físico/Digital): ");
		String tipoLivro = scanner.nextLine();

		if (tipoLivro.equalsIgnoreCase("Físico")) {
			System.out.print("Número de páginas: ");
			int numeroPaginas = scanner.nextInt();
			biblioteca.adicionarLivro(new LivroFisico(titulo, autor, isbn, status, numeroPaginas));
		} else if (tipoLivro.equalsIgnoreCase("Digital")) {
			System.out.print("Tamanho do arquivo (MB): ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Por favor, insira um número válido.");
				scanner.next();
			}
			double tamanhoArquivo = scanner.nextDouble();
			biblioteca.adicionarLivro(new LivroDigital(titulo, autor, isbn, status, tamanhoArquivo));
		} else {
			System.out.println("Tipo de livro inválido!");
		}
	}

	private static void adicionarUsuario(Biblioteca biblioteca, Scanner scanner) {
		System.out.print("Nome do usuário: ");
		String nome = scanner.nextLine();
		System.out.print("ID do usuário: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		biblioteca.adicionarUsuario(new Usuario(nome, id));
	}

	private static void emprestarLivro(Biblioteca biblioteca, Scanner scanner) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate localDate = LocalDate.now();
		//System.out.println("Data atual: " + dtf.format(localDate));
		//System.out.println("data com mais 5 dias :" + dtf.format(localDate.plusDays(5)));


		// System.out.println(dtf.format(localDate)); // 2021/03/22

		System.out.print("ISBN do livro a ser emprestado: ");
		String isbn = scanner.nextLine();
		System.out.print("ID do usuário: ");
		int idUsuario = scanner.nextInt();
		scanner.nextLine();

		Livro livro = biblioteca.encontrarLivroPorISBN(isbn);
		Usuario usuario = biblioteca.encontrarUsuarioPorID(idUsuario);

		if (livro != null && usuario != null) {
			if (livro.getStatus().equalsIgnoreCase("Disponível")) {
				biblioteca.emprestarLivro(livro, usuario);
				System.out.println("Livro emprestado com sucesso!");
				System.out.println("Devolva o livro no dia: " + dtf.format(localDate.plusDays(5)));
			} else {
				System.out.println("Este livro já está emprestado e não pode ser emprestado novamente.");
			}
		} else {
			System.out.println("Livro ou usuário não encontrado!");
		}
	}
	
	

	

	private static void retornarLivro(Biblioteca biblioteca, Scanner scanner) {
		System.out.print("ISBN do livro a ser retornado: ");
		String isbn = scanner.nextLine();

		Livro livro = biblioteca.encontrarLivroPorISBN(isbn);

		if (livro != null && livro.getStatus().equals("Emprestado")) {
			Emprestimo emprestimo = biblioteca.encontrarEmprestimoPorLivro(livro);
			LocalDate dataDevolucao = LocalDate.now();
			biblioteca.retornarLivro(emprestimo, dataDevolucao);
			System.out.println("Livro retornado com sucesso!");
		} else {
			System.out.println("Livro não encontrado ou não está emprestado!");
		}
	}
}



















