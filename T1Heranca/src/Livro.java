public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private String status;

    public Livro(String titulo, String autor, String isbn, String status) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.status = status;
    }

    
    public String getTitulo() {
        return titulo;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para imprimir informações do livro
    public void imprimirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Status: " + status);
    }
}