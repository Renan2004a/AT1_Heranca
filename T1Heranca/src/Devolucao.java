import java.time.LocalDate;


public class Devolucao {
    private static final double MultaPorDiadeAtraso = 0.50;

    public static double calcularMulta(LocalDate dataPrevistaDevolucao, LocalDate dataEfetivaDevolucao) {
        long diasAtraso = dataEfetivaDevolucao.compareTo(dataPrevistaDevolucao);
        if (diasAtraso > 0) {
            return diasAtraso * MultaPorDiadeAtraso;
        } else {
            return 0.0;
        }
    }

    public static void processarDevolucao(Emprestimo emprestimo, LocalDate dataDevolucao) {
        emprestimo.setDataDevolucao(dataDevolucao);
        emprestimo.setStatus("Concluído");
        Livro livro = emprestimo.getLivro();
        livro.setStatus("Disponível");
        Usuario usuario = emprestimo.getUsuario();
        double multa = calcularMulta(emprestimo.getDataPrevistaDevolucao(), dataDevolucao);
        if (multa > 0) {
            usuario.registrarMulta(multa);
            System.out.println("Multa de R$" + multa + " registrada para o usuário " + usuario.getNome());
        } else {
            System.out.println("Devolução efetuada com sucesso. Sem multa.");
        }
    }
}
