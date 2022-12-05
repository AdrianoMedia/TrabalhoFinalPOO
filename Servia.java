package module_servia;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Servia implements NationalTeamInfos, NationalTeamStats {
	private ArrayList<Jogador> jogadores = new 	ArrayList<>();
	private ArrayList<Dirigente> dirigentes = new ArrayList<>();
	private ArrayList<ComissaoTecnica> comissao = new ArrayList<>();
	private int numberOfCalls;
	private int vezesChamada;
	
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
	
	public ArrayList<Dirigente> getDirigentes(){
		return this.dirigentes;
	}
	
	public ArrayList<ComissaoTecnica> getComissao() {
		return this.comissao;
	}

	public int getHowManyMembers() {
		Jogador j1 = new Jogador(1, "Marko Dmitrovic", "Marko", 180, 80, 30, LocalDate.of(1992 , 10 , 2), "goalkeeper", "Flamengo", 0);
		jogadores.add(j1);
		Jogador j2 = new Jogador(2, "Giorge Rossovsk", "Giorgo", 185, 76, 32, LocalDate.of(1990 , 12 , 1), "defender", "Corinthians", 0);
		jogadores.add(j2);
		Jogador j3 = new Jogador(3, "Flip Mladenvic", "Filip", 173, 70, 31, LocalDate.of(1991 , 12 , 31), "defender", "Juventus", 0);
		jogadores.add(j3);
		Jogador j4 = new Jogador(4, "Luka Jovic", "Luka", 164, 67, 24, LocalDate.of(1998 , 2 , 3), "defender", "Vasco", 0);
		jogadores.add(j4);
		Jogador j5 = new Jogador(5, "Sus Amongov", "Sus", 196, 82, 27, LocalDate.of(1995 , 2 , 20), "left-back", "Liverpool", 0);
		jogadores.add(j5);
		Jogador j6 = new Jogador(6, "Uros Racic", "Uros", 184, 78, 22, LocalDate.of(2000 , 06 , 24), "defensive-midfielder", "Legia Warszawa", 0);
		jogadores.add(j6);
		Jogador j7 = new Jogador(7, "Ivan Ilic", "Ivan", 171, 66, 21, LocalDate.of(2001 , 11 , 16), "defensive-midfielder", "Crvena Zvezda", 0);
		jogadores.add(j7);
		Jogador j8 = new Jogador(8, "Sasa Lukic", "Sasa", 172, 66, 21, LocalDate.of(2001 , 9 , 11), "midfield", "Porto", 0);
		jogadores.add(j8);
		Jogador j9 = new Jogador(9, "Darko Lazovic", "Darka", 169, 70, 25, LocalDate.of(1997 , 1 , 14), "midfield", "Fiorentina", 0);
		jogadores.add(j9);
		Jogador j10 = new Jogador(10, "Nemanja Rodonjic", "Ne", 170, 72, 18, LocalDate.of(2004 , 06 , 30), "center-forward", "Juventus", 0);
		jogadores.add(j10);
		Jogador j11 = new Jogador(11, "Filip Drugovic", "Drugo", 177, 78, 22, LocalDate.of(2000 , 5 , 23), "center-forward", "Vasco", 0);
		jogadores.add(j11);
		ComissaoTecnica ct1 = new ComissaoTecnica("Dragan Stojkovic", "Drogon", "Couch", 57);
		comissao.add(ct1);
		ComissaoTecnica ct2 = new ComissaoTecnica("Nikita Minaj", "Minaj", "Nutritionist", 34);
		comissao.add(ct2);
		ComissaoTecnica ct3 = new ComissaoTecnica("Joseph Sneg", "Jow", "Observer", 48);
		comissao.add(ct3);
		Dirigente d1 = new Dirigente("Henry Avery", "+381 40028922", "henry@fss.com.rs");
		dirigentes.add(d1);
		Dirigente d2 = new Dirigente("Srdan Babic", "+381 73556089", "srdan@fss.com.rs");
		dirigentes.add(d2);
		return jogadores.size() + dirigentes.size() + comissao.size();
	}
	
	public int getOldestPlayer() {
		numberOfCalls++;
		Jogador velho = null;
		for (Jogador j: jogadores) {
			if (velho == null 
					 || j.getIdade() > velho.getIdade()) {
				velho = j;
			}
		}
		return velho.getNumero();
		
	}
	
	public int getYoungestPlayer() {
		numberOfCalls++;
		Jogador novo = null;
		for (Jogador j: jogadores) {
			if (novo == null 
					|| j.getIdade() > novo.getIdade()) {
				novo = j;
			}
		}
		return novo.getNumero();
	}
	
	public double getAverageAge() {
		numberOfCalls++;
		double media = 0;
		for (Jogador j: jogadores) {
			media += j.getIdade();
		}
		return media / jogadores.size();
	}
	
	public String getCountryName() {
		numberOfCalls++;
		return "Sérvia";
	}
	
	public Image getFlagImage() {
		Image image = null;
		URL url = null;
		try {
			url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Flag_of_Serbia.svg/255px-Flag_of_Serbia.svg.png");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	public String getPlayer(int number) {
		numberOfCalls++;
		FileWriter writeFile = null;
		JSONObject objetoJson = new JSONObject();
			for (Jogador jor: jogadores) {
				if (number == jor.getNumero() || number == jor.getNumero() || number == jor.getNumero() || number == jor.getNumero() 
						|| number == jor.getNumero() || number == jor.getNumero() || number == jor.getNumero() || number == jor.getNumero() 
						|| number == jor.getNumero() || number == jor.getNumero() || number == jor.getNumero()) {
				objetoJson.put("number", jor.getNumero());
				objetoJson.put("name", jor.getNome());
				objetoJson.put("nickname", jor.getApelido());
				objetoJson.put("height", jor.getAltura());
				objetoJson.put("weigth", jor.getPeso());
				objetoJson.put("birthDate", jor.getDataAniver());
				objetoJson.put("position", jor.getPosicao());
				objetoJson.put("currentClub", jor.getClubAtual());
				jor.setContador(+1);
		}
		}
		try {
			writeFile = new FileWriter("Dados_Jogadores.json");
			writeFile.write(objetoJson.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objetoJson.toString();
	}
	
	public String getPressOfficerContacts() {
		numberOfCalls++;
		FileWriter escrever = null;
		JSONObject objJson = new JSONObject();
		
		for (Dirigente dir: dirigentes) {
		objJson.put("name", dir.getNome());
		objJson.put("tel1", dir.getTelefone());
		objJson.put("tel2", dir.getTelefone());
		objJson.put("emailAccount", dir.getEmail());
		}
		try {
			escrever = new FileWriter("Dados_Assessor_da_Imprensa.json");
			escrever.write(objJson.toJSONString());
			escrever.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objJson.toString();
		
	}
	
	public Path getTechnicalCommittee() {
		numberOfCalls++;
		FileWriter write = null;
		JSONObject objeJson = new JSONObject();
		
		for (ComissaoTecnica ct: comissao) {
		objeJson.put("name", ct.getNome());
		objeJson.put("nickname", ct.getApelido());
		objeJson.put("role", ct.getRole());
		objeJson.put("age", ct.getIdade());
		}
		try {
			write = new FileWriter("Dados_Comissao_Tecnica.json");
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
		int teste = 0;
		for (Jogador jor: jogadores) {
			teste = jor.getContador();
	}
		return teste;
	}
}
