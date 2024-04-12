import java.util.ArrayList;
import java.time.LocalDate;

public class Biblioteca {
    private ArrayList<Livro> listaLivros;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Emprestimo> listaEmprestimos;
   private ArrayList<Devolucao> listaDevolucao;

   	public Biblioteca() {
        listaLivros = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        listaEmprestimos = new ArrayList<>();
        listaDevolucao = new ArrayList<>();
    }

    // Métodos para adicionar livro, adicionar usuário, emprestar livro, retornar livro
    
    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void emprestarLivro(Livro livro, Usuario usuario) {
        // Verificar se o livro está disponível para empréstimo
        if (livro.getStatus().equalsIgnoreCase("Emprestado")) {
            System.out.println("Este livro já está emprestado e não pode ser emprestado novamente.");
            return; 
        }
        
 
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataPrevistaDevolucao = dataAtual.plusDays(7);
        Emprestimo emprestimo = new Emprestimo(livro, usuario, dataAtual, dataPrevistaDevolucao);
        listaEmprestimos.add(emprestimo);
        livro.setStatus("Emprestado");
    }

    public void retornarLivro(Emprestimo emprestimo, LocalDate dataDevolucao) {
        Devolucao.processarDevolucao(emprestimo, dataDevolucao);
    }

    // Métodos para imprimir informações de todos os livros e usuários
    
    public void imprimirInformacoesTodosLivros() {
        System.out.println("Lista de Livros:");
        for (Livro livro : listaLivros) {
            livro.imprimirInformacoes();
        }
    }

    public void imprimirInformacoesTodosUsuarios() {
        System.out.println("Lista de Usuários:");
        for (Usuario usuario : listaUsuarios) {
            usuario.imprimirInformacoes();
        }
    }

    public Livro encontrarLivroPorISBN(String isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null; // Retornar null se o livro não for encontrado
    }

    public Usuario encontrarUsuarioPorID(int idUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == idUsuario) {
                return usuario;
            }
        }
        return null; // Retornar null se o usuário não for encontrado
    }

    public Emprestimo encontrarEmprestimoPorLivro(Livro livro) {
        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.getLivro().equals(livro)) {
                return emprestimo;
            }
        }
        return null; // Retornar null se o empréstimo não for encontrado
    }
}
