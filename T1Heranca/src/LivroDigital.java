public class LivroDigital extends Livro {
    private double tamanhoArquivo;

    public LivroDigital(String titulo, String autor, String isbn, String status, double tamanhoArquivo) {
        super(titulo, autor, isbn, status);
        this.tamanhoArquivo = tamanhoArquivo;
    }

    

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Tamanho do Arquivo (MB): " + tamanhoArquivo);
    }
}