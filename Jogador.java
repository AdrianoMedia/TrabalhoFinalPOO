import java.time.LocalDate;

public class Jogador extends Servia {
	private String nome;
	private String apelido;
	private int idade;
	private float altura;
	private float peso;
	private LocalDate dataAniver;
	private String posicao;
	private String clubAtual;
	
	public Jogador(int qtdJogadores, int qtdComTec, int qtdDirigente, String nome, String apelido, int idade, float altura,
			float peso, LocalDate dataAniver, String posicao, String clubAtual) {
		super();
		this.setAltura(altura);
		this.setApelido(apelido);
		this.setClubAtual(clubAtual);
		this.setDataAniver(dataAniver);
		this.setIdade(idade);
		this.setPeso(peso);
		this.setNome(nome);
		this.setPosicao(posicao);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
		this.nome = nome;
		} else
			throw new IllegalArgumentException("Nome inexistente");
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		if (apelido != null && !apelido.isBlank()) {
		this.apelido = apelido;
		}
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		if (idade >= 18) {
		this.idade = idade;
		}
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		if (altura > 0) {
		this.altura = altura;
		}
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		if (peso > 0) {
		this.peso = peso;
		}
	}
	public LocalDate getDataAniver() {
		return dataAniver;
	}
	public void setDataAniver(LocalDate dataAniver) {
		if (dataAniver != null) {
		this.dataAniver = dataAniver;
		}
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		if (posicao != null && !posicao.isBlank()) {
		this.posicao = posicao;
		} else
			throw new IllegalArgumentException("Posição inválida, não tente novamente");
	}
	public String getClubAtual() {
		return clubAtual;
	}
	public void setClubAtual(String clubAtual) {
		if (clubAtual != null && !clubAtual.isBlank()) {
		this.clubAtual = clubAtual;
		} else
			throw new IllegalArgumentException("Insira um Clube válido");
	}
	
	
}
