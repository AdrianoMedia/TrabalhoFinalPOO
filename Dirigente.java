
public class Dirigente extends Servia {
	private String nome;
	private String telefone;
	private String email;
	
	public Dirigente(int qtdJogadores, int qtdComTec, int qtdDirigente, String nome, String telefone, String email) {
		super();
		this.setEmail(email);
		this.setNome(nome);
		this.setTelefone(telefone);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
		this.nome = nome;
		} else
			throw new IllegalArgumentException("Nome inválido ou em branco");
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone != null && !telefone.isBlank()) {
		this.telefone = telefone;
		} else
			throw new IllegalArgumentException("Número de telefone inválido");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && !email.isBlank()) {
		this.email = email;
		} else
			throw new IllegalArgumentException("Email inválido");
	}
	
	
	
	
}
