import java.awt.Image;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public abstract class Servia implements NationalTeamInfos {
	private HashMap<Integer, Jogador> jogadores = new HashMap<>();
	private ArrayList<Dirigente> dirigentes = new ArrayList<>();
	private ArrayList<ComissaoTecnica> comissao = new ArrayList<>();
	private Jogador jor;
	private Dirigente dir;
	private ComissaoTecnica ct;
	
	public Servia() {
		super();
	}
	
	public HashMap<Integer, Jogador> getJogadores() {
		return this.jogadores;
	}
	 
	public void addJogador(Jogador j) {
		if(!jogadores.containsKey(j.getNumero())) {
			jogadores.put(j.getNumero(), j);
		}
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
	
	public int getHowManyMembers() {
		return jogadores.size();
	}
	
	public int getOldestPlayer() {
		Jogador velho = null;
		for (Jogador j: jogadores.values()) {
			if (velho == null || j.getIdade() > velho.getIdade()) {
				velho = j;
			}
		}
		return velho;
		
	}
	
	public int getYoungestPlayer() {
		Jogador novo = null;
		for (Jogador j: jogadores.values()) {
			if (novo == null || j.getIdade() > novo.getIdade()) {
				novo = j;
			}
		}
		return novo;
	}
	
	public double getAverageAge() {
		double media = 0;
		for (Jogador j: jogadores.values()) {
			media += j.getIdade();
		}
		return media / jogadores.size();
	}
	
	public String getCountryName() {
		return "Sérvia";
	}
	
	public Image getFlagImage() {
		return null;
	}
	
	public String getPlayer(int number) {
		JSONObject objetoJson = new JSONObject();
		
		objetoJson.put("number", jor.getNumero());
		objetoJson.put("name", jor.getNome());
		objetoJson.put("nickname", jor.getApelido());
		objetoJson.put("height", jor.getAltura());
		objetoJson.put("weigth", jor.getPeso());
		objetoJson.put("birthDate", jor.getDataAniver());
		objetoJson.put("position", jor.getPosicao());
		objetoJson.put("currentClub", jor.getClubAtual());
		try {
			FileWriter writeFile = new FileWriter("Dados_Jogadores.json");
			writeFile.write(objetoJson.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPressOfficerContacts() {
		JSONObject objJson = new JSONObject();
		
		objJson.put("name", dir.getNome());
		objJson.put("tel1", dir.getTelefone());
		objJson.put("tel2", dir.getTelefone());
		objJson.put("emailAccount", dir.getEmail());
		
		try {
			FileWriter escrever = new FileWriter("Dados_Assessor_da_Imprensa.json");
			escrever.write(objJson.toJSONString());
			escrever.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Path getTechnicalCommittee() {
		
		JSONObject objeJson = new JSONObject();
		
		objeJson.put("name", ct.getNome());
		objeJson.put("nickname", ct.getApelido());
		objeJson.put("role", ct.getRole());
		objeJson.put("age", ct.getIdade());
		
		try {
			FileWriter write = new FileWriter("Dados_Comissao_Tecnica.json");
			write.write(objeJson.toJSONString());
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Paths.get("Dados_Comissao_Tecnica.json");
	}
	
	public abstract NationalTeamStats getStatsResponsible();
}
