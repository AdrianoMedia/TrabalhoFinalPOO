package module_servia;
import java.time.LocalDate;
import java.util.HashMap;

public class Jogador extends Servia {
	private int number;
	private String name;
	private String nickname;
	private int age;
	private float height;
	private float weight;
	private LocalDate birthDate;
	private String posicion;
	private String currentClub;
	
	public Jogador(String nome, String apelido, int idade, float altura,
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
	
	public int getNumero() {
		return number;
	}

	public void setNumero(int numero) {
		if (numero > 0) {
		this.number = numero;
		}
	}

	public String getNome() {
		return name;
	}
	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
		this.name = nome;
		} else
			throw new IllegalArgumentException("Nome inexistente");
	}
	public String getApelido() {
		return nickname;
	}
	public void setApelido(String apelido) {
		if (apelido != null && !apelido.isBlank()) {
		this.nickname = apelido;
		}
	}
	public int getIdade() {
		return age;
	}
	public void setIdade(int idade) {
		if (idade >= 18) {
		this.age = idade;
		}
	}
	public float getAltura() {
		return height;
	}
	public void setAltura(float altura) {
		if (altura > 0) {
		this.height = altura;
		}
	}
	public float getPeso() {
		return weight;
	}
	public void setPeso(float peso) {
		if (peso > 0) {
		this.weight = peso;
		}
	}
	public LocalDate getDataAniver() {
		return birthDate;
	}
	public void setDataAniver(LocalDate dataAniver) {
		if (dataAniver != null) {
		this.birthDate = dataAniver;
		}
	}
	public String getPosicao() {
		return posicion;
	}
	public void setPosicao(String posicao) {
		if (posicao != null && !posicao.isBlank()) {
		this.posicion = posicao;
		} else
			throw new IllegalArgumentException("Posição inválida, não tente novamente");
	}
	public String getClubAtual() {
		return currentClub;
	}
	public void setClubAtual(String clubAtual) {
		if (clubAtual != null && !clubAtual.isBlank()) {
		this.currentClub = clubAtual;
		} else
			throw new IllegalArgumentException("Insira um Clube válido");
	}
	
	
}