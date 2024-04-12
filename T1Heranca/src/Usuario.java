public class Usuario {
    private String nome;
    private int id;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método para imprimir informações do usuário
    public void imprimirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
    }

	public void registrarMulta(double multa) {
		// TODO Auto-generated method stub
		
	}
}