package module_servia;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

import org.json.simple.JSONObject;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Servia implements NationalTeamInfos, NationalTeamStats {
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private ArrayList<Dirigente> dirigentes = new ArrayList<>();
	private ArrayList<ComissaoTecnica> comissao = new ArrayList<>();
	private int numberOfCalls;
	
	public Servia() {
		super();
	}	
	
	public int getNumberOfCalls() {
		return numberOfCalls;
	}

	public void setNumberOfCalls(int numberOfCalls) {
		this.numberOfCalls = numberOfCalls;
	}


	public ArrayList<Jogador> getJogadores() {
		return this.jogadores;
	}
	 
	public void addJogador() {
		Jogador j1 = new Jogador(1, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(1992 , 10 , 2), "goalkeeper", "Flamengo");
		jogadores.add(j1);
		Jogador j2 = new Jogador(2, "Giorge Rossovsk", "Giorgo", 185, 76, 20, LocalDate.of(1990 , 12 , 1), "defender", "Corinthians");
		jogadores.add(j2);
		Jogador j3 = new Jogador(3, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(1991 , 12 , 31), "defender", "Juventus");
		jogadores.add(j3);
		Jogador j4 = new Jogador(4, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(1998 , 2 , 3), "defender", "Vasco");
		jogadores.add(j4);
		Jogador j5 = new Jogador(5, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(1995 , 2 , 29), "left-back", "Liverpool");
		jogadores.add(j5);
		Jogador j6 = new Jogador(6, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(2000 , 06 , 24), "defensive-midfielder", "Legia Warszawa");
		jogadores.add(j6);
		Jogador j7 = new Jogador(7, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(2001 , 11 , 16), "defensive-midfielder", "Crvena Zvezda");
		jogadores.add(j7);
		Jogador j8 = new Jogador(8, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(2001 , 9 , 11), "midfield", "Porto");
		jogadores.add(j8);
		Jogador j9 = new Jogador(9, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(1997 , 1 , 14), "midfield", "Fiorentina");
		jogadores.add(j9);
		Jogador j10 = new Jogador(10, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(2004 , 06 , 30), "center-forward", "Juventus");
		jogadores.add(j10);
		Jogador j11 = new Jogador(11, "Marko Dmitrovic", "Marko", 180, 80, 22, LocalDate.of(2000 , 5 , 23), "center-forward", "Vasco");
		jogadores.add(j11);
		
	}
	
	public ArrayList<Dirigente> getDirigentes(){
		return this.dirigentes;
	}
	
	public void addDirigente() {
		Dirigente d1 = new Dirigente("Henry Avery", "+381 40028922", "henry@fss.com.rs");
		dirigentes.add(d1);
		Dirigente d2 = new Dirigente("Srdan Babic", "+381 73556089", "srdan@fss.com.rs");
		dirigentes.add(d2);
	}
	
	public ArrayList<ComissaoTecnica> getComissao() {
		return this.comissao;
	}
	
	public void addComissaoTecnica() {
		ComissaoTecnica ct1 = new ComissaoTecnica("Dragan Stojkovic", "Drogon", "Couch", 57);
		comissao.add(ct1);
		ComissaoTecnica ct2 = new ComissaoTecnica("Nikita Minaj", "Minaj", "Nutritionist", 34);
		comissao.add(ct2);
		ComissaoTecnica ct3 = new ComissaoTecnica("Joseph Sneg", "Jow", "Observer", 48);
		comissao.add(ct3);
	}
	
	public int getHowManyMembers() {
		return jogadores.size();
	}
	
	public int getOldestPlayer() {
		Jogador velho = null;
		for (Jogador j: jogadores) {
			if (velho == null || j.getIdade() > velho.getIdade()) {
				velho = j;
				numberOfCalls++;
			}
		}
		return velho.getNumero();
		
	}
	
	public int getYoungestPlayer() {
		Jogador novo = null;
		for (Jogador j: jogadores) {
			if (novo == null || j.getIdade() > novo.getIdade()) {
				novo = j;
				numberOfCalls++;
			}
		}
		return novo.getNumero();
	}
	
	public double getAverageAge() {
		double media = 0;
		for (Jogador j: jogadores) {
			media += j.getIdade();
			numberOfCalls++;
		}
		return media / jogadores.size();
	}
	
	public String getCountryName() {
		numberOfCalls++;
		return "Sérvia";
	}
	
	public Image getFlagImage() {
		BufferedImage img = null;
		numberOfCalls++;
		try {
		    img = ImageIO.read(new File("Servia.png"));
		} catch (IOException e) {
		}
		return img;
	}
	
	public String getPlayer(int number) {
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
		numberOfCalls++;
		}
		try {
			FileWriter writeFile = new FileWriter("Dados_Jogadores.json");
			writeFile.write(objetoJson.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objetoJson.toString();
	}
	
	public String getPressOfficerContacts() {
		JSONObject objJson = new JSONObject();
		
		for (Dirigente dir: dirigentes) {
		objJson.put("name", dir.getNome());
		objJson.put("tel1", dir.getTelefone());
		objJson.put("tel2", dir.getTelefone());
		objJson.put("emailAccount", dir.getEmail());
		numberOfCalls++;
		}
		try {
			FileWriter escrever = new FileWriter("Dados_Assessor_da_Imprensa.json");
			escrever.write(objJson.toJSONString());
			escrever.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objJson.toString();
		
	}
	
	public Path getTechnicalCommittee() {
		
		JSONObject objeJson = new JSONObject();
		
		for (ComissaoTecnica ct: comissao) {
		objeJson.put("name", ct.getNome());
		objeJson.put("nickname", ct.getApelido());
		objeJson.put("role", ct.getRole());
		objeJson.put("age", ct.getIdade());
		numberOfCalls++;
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
		numberOfCalls++;
		return national;
	}
	
	public int getHowManyQuestions() {
		return numberOfCalls;
	}
	
	public int getHowManyCallsToPlayer(int number) {
		return 0;
	}
}