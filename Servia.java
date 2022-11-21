import java.util.ArrayList;

public class Servia {
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private ArrayList<Dirigente> dirigentes = new ArrayList<>();
	private ArrayList<ComissaoTecnica> comissao = new ArrayList<>();
	
	public Servia() {
		super();
	}
	
	public ArrayList<Jogador> getJogadores() {
		return this.jogadores;
	}
	 
	public void addJogador(Jogador j) {
		jogadores.add(j);
	}
	
	public ArrayList<Dirigente> getDirigentes(){
		return this.dirigentes;
	}
	
	public void addDirigente(Dirigente d) {
		dirigentes.add(d);
	}
	
	public ArrayList<ComissaoTecnica> getComissao() {
		return this.comissao;
	}
}
