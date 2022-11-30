package module_servia;
import java.awt.Image;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Servia implements NationalTeamInfos, NationalTeamStats {
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private ArrayList<Dirigente> dirigentes = new ArrayList<>();
	private ArrayList<ComissaoTecnica> comissao = new ArrayList<>();
	private int NumberOfCalls;
	
	public Servia() {
		super();
	}

	public ArrayList<Jogador> getJogadores() {
		return this.jogadores;
	}
	
    public void addJogador(Jogador j) {
		Jogador j1 = new Jogador("b", "c", 1, 2, 3, LocalDate.of(1995, 11, 02), "aa", "lk");
		jogadores.add(j1);
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
	
	public void addComissao(ComissaoTecnica ct) {
		comissao.add(ct);
	}
	
	public int getHowManyMembers() {
		return jogadores.size();
	}
	
	public int getOldestPlayer() {
		NumberOfCalls++;
		Jogador velho = null;
		for (Jogador j: jogadores) {
			if (velho == null || j.getIdade() > velho.getIdade()) {
				velho = j;
			}
		}
		return velho.getNumero();
		
	}
	
	public int getYoungestPlayer() {
		NumberOfCalls++;
		Jogador novo = null;
		for (Jogador j: jogadores) {
			if (novo == null || j.getIdade() > novo.getIdade()) {
				novo = j;
			}
		}
		return novo.getNumero();
	}
	
	public double getAverageAge() {
		NumberOfCalls++;
		double media = 0;
		for (Jogador j: jogadores) {
			media += j.getIdade();
		}
		return media / jogadores.size();
	}
	
	public String getCountryName() {
		NumberOfCalls++;
		return "Sérvia";
	}
	
	public Image getFlagImage() {
		NumberOfCalls++;
		return null;
	}
	
	public String getPlayer(int number) {
		NumberOfCalls++;
		JSONObject objetoJson = new JSONObject();
		
		for (Jogador jor: jogadores) {
		objetoJson.put("number", jor.getNumero());
		objetoJson.put("name", jor.getNome());
		objetoJson.put("nickname", jor.getApelido());
		objetoJson.put("height", jor.getAltura());
		objetoJson.put("weigth", jor.getPeso());
		objetoJson.put("birthDate", jor.getDataAniver());
		objetoJson.put("position", jor.getPosicao());
		objetoJson.put("currentClub", jor.getClubAtual());
		}
		try {
			FileWriter writeFile = new FileWriter("Dados_Jogadores.json");
			writeFile.write(objetoJson.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objetoJson.toJSONString();
	}
	
	public String getPressOfficerContacts() {
		NumberOfCalls++;
		JSONObject objJson = new JSONObject();
		
		for (Dirigente dir: dirigentes) {
		objJson.put("name", dir.getNome());
		objJson.put("tel1", dir.getTelefone());
		objJson.put("tel2", dir.getTelefone());
		objJson.put("emailAccount", dir.getEmail());
		}
		try {
			FileWriter escrever = new FileWriter("Dados_Assessor_da_Imprensa.json");
			escrever.write(objJson.toJSONString());
			escrever.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objJson.toJSONString();
		
	}
	
	public Path getTechnicalCommittee() {
		NumberOfCalls++;
		JSONObject objeJson = new JSONObject();
		
		for (ComissaoTecnica ct: comissao) {
		objeJson.put("name", ct.getNome());
		objeJson.put("nickname", ct.getApelido());
		objeJson.put("role", ct.getRole());
		objeJson.put("age", ct.getIdade());
		}
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
	
	public NationalTeamStats getStatsResponsible() {
		NationalTeamStats national = new Servia();
		return national;
	}
	
	public int getHowManyQuestions() {
		return NumberOfCalls;
	}
	
	public int getHowManyCallsToPlayer(int number) {
		return 0;
	}
}