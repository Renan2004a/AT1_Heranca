public class LivroFisico extends Livro {
    private int numeroPaginas;

    public LivroFisico(String titulo, String autor, String isbn, String status, int numeroPaginas) {
        super(titulo, autor, isbn, status);
        this.numeroPaginas = numeroPaginas;
    }



    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Número de Páginas: " + numeroPaginas);
    }
}