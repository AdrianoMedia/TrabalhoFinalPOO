
public abstract class ComissaoTecnica extends Servia {
	private String nome;
	private String apelido;
	private String role;
	private int idade;
	
	public ComissaoTecnica(String nome, String apelido, String role, int idade) {
		super();
		this.setApelido(apelido);
		this.setIdade(idade);
		this.setNome(nome);
		this.setRole(role);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
		this.nome = nome;
		} else
			throw new IllegalArgumentException("Nome inválido");
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		if (apelido != null && !apelido.isBlank()) {
		this.apelido = apelido;
		} else
			throw new IllegalArgumentException("Apelido inválido");
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		if (role != null && !role.isBlank()) {
		this.role = role;
		} else
			throw new IllegalArgumentException("Role inválida, insira uma role existente");
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade > 0) {
		this.idade = idade;
		}
	}
	
	
	
}
