package projetoLp2.bolao.docs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.ControladorAdmin;
import projetoLp2.bolao.ControladorJogador;
import projetoLp2.bolao.ControladorPartidas;
import projetoLp2.bolao.ControladorTimes;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

public class CriaFile {

	public static void main(String[] args) throws Exception {
		
		Administrador admin = new Administrador("admin", "1234");
		ControladorAdmin.escreve(admin);
		
		List<Jogador> jogadores = new ArrayList<Jogador>();
		ControladorJogador.escreve(jogadores);

		Partida[] partidas = new Partida[64];
		ControladorPartidas.escreve(partidas);
		
		Map<String, TimeCopa> times = new TreeMap<String, TimeCopa>();
		
		TimeCopa Alemanha = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		times.put("ALE", Alemanha);
		TimeCopa Argelia = new TimeCopa("bandeiraArgelia.png", "Argelia", "ALG");
		times.put("ALG", Argelia);
		TimeCopa Argentina = new TimeCopa("bandeiraArgentina.png", "Argentina", "ARG");
		times.put("ARG", Argentina);
		TimeCopa Australia = new TimeCopa("bandeiraAustralia.png", "Australia", "AUS");
		times.put("AUS", Australia);
		TimeCopa Belgica = new TimeCopa("bandeiraBelgica.png", "Belgica", "BEL");
		times.put("BEL", Belgica);
		TimeCopa Bosnia = new TimeCopa("bandeiraBosniaHerzegovina.png", "Bosnia-Herzegovina", "BOS");
		times.put("BOS", Bosnia);
		TimeCopa Brasil = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		times.put("BRA", Brasil);
		TimeCopa Camaroes = new TimeCopa("bandeiraCamaroes.png", "Camaroes", "CAM");
		times.put("CAM", Camaroes);
		TimeCopa Chile = new TimeCopa("bandeiraChile.png", "Chile", "CHI");
		times.put("CHI", Chile);
		TimeCopa Colombia = new TimeCopa("bandeiraColombia.png", "Colombia", "COL");
		times.put("COL", Colombia);
		TimeCopa Coreia = new TimeCopa("bandeiraCoreiaDoSul.png", "Coreia do Sul", "CDS");
		times.put("CDS", Coreia);
		TimeCopa CostaDoMarfim = new TimeCopa("bandeiraCostaDoMarfim.png", "Costa do Marfim", "CMA");
		times.put("CMA", CostaDoMarfim);
		TimeCopa CostaRica = new TimeCopa("bandeiraCostaRica.png", "Costa Rica", "COS");
		times.put("COS", CostaRica);
		TimeCopa Croacia = new TimeCopa("bandeiraCroacia.png", "Croacia", "CRO");
		times.put("CRO", Croacia);
		TimeCopa Equador = new TimeCopa("bandeiraEquador.png", "Equador", "EQU");
		times.put("EQU", Equador);
		TimeCopa Espanha = new TimeCopa("bandeiraEspanha.png", "Espanha", "ESP");
		times.put("ESP", Espanha);
		TimeCopa Eua = new TimeCopa("bandeiraEUA.png", "Estados Unidos", "EUA");
		times.put("EUA", Eua);
		TimeCopa Franca = new TimeCopa("bandeiraFranca.png", "Franca", "FRA");
		times.put("FRA", Franca);
		TimeCopa Gana = new TimeCopa("bandeiraGana.png", "Gana", "GAN");
		times.put("GAN", Gana);
		TimeCopa Grecia = new TimeCopa("bandeiraGrecia.png", "Grecia", "GRE");
		times.put("GRE", Grecia);
		TimeCopa Holanda = new TimeCopa("bandeiraHolanda.png", "Holanda", "HOL");
		times.put("HOL", Holanda);
		TimeCopa Honduras = new TimeCopa("bandeiraHonduras.png", "Honduras", "HON");
		times.put("HON", Honduras);
		TimeCopa Inglaterra = new TimeCopa("bandeiraInglaterra.png", "Inglaterra", "ING");
		times.put("ING",Inglaterra);
		TimeCopa Ira = new TimeCopa("bandeiraIra.png", "Ira", "IRA");
		times.put("IRA",Ira);
		TimeCopa Italia = new TimeCopa("bandeiraItalia.png", "Italia", "ITA");
		times.put("ITA", Italia);
		TimeCopa Japao = new TimeCopa("bandeiraJapao.png", "Japao", "JAP");
		times.put("JAP", Japao);
		TimeCopa Mexico = new TimeCopa("bandeiraMexico.png", "Mexico", "MEX");
		times.put("MEX", Mexico);
		TimeCopa Nigeria = new TimeCopa("bandeiraNigeria.png", "Nigeria", "NGR");
		times.put("NGR", Nigeria);
		TimeCopa Portugal = new TimeCopa("bandeiraPortugal.png", "Portugal", "POR");
		times.put("POR", Portugal);
		TimeCopa Russia = new TimeCopa("bandeiraRussia.png", "Russia", "RUS");
		times.put("RUS", Russia);
		TimeCopa Suica = new TimeCopa("bandeiraSuica.png", "Suica", "SUI");
		times.put("SUI", Suica);
		TimeCopa Uruguai = new TimeCopa("bandeiraUruguai.png", "Uruguai", "URU");
		times.put("URU", Uruguai);
		ControladorTimes.escreve(times);
	
	}
}