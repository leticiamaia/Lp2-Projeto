package projetoLp2.bolao.docs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import projetoLp2.bolao.Administrador;
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
		
		//TimeCopa[] times = new TimeCopa[32];
		TimeCopa Alemanha = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		times.put("ALE", Alemanha);
		//times[0] = Alemanha;
		TimeCopa Argelia = new TimeCopa("bandeiraArgelia.png", "Argelia", "ALG");
		times.put("ALG", Argelia);
		//times[1] = Argelia;
		TimeCopa Argentina = new TimeCopa("bandeiraArgentina.png", "Argentina", "ARG");
		times.put("ARG", Argentina);
		//times[2] = Argentina;
		TimeCopa Australia = new TimeCopa("bandeiraAustralia.png", "Australia", "AUS");
		times.put("AUS", Australia);
		//times[3] = Australia;
		TimeCopa Belgica = new TimeCopa("bandeiraBelgica.png", "Belgica", "BEL");
		times.put("BEL", Belgica);
		//times[4] = Belgica;
		TimeCopa Bosnia = new TimeCopa("bandeiraBosniaHerzegovina.png", "Bosnia-Herzegovina", "BOS");
		times.put("BOS", Bosnia);
		//times[5] = Bosnia;
		TimeCopa Brasil = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		times.put("BRA", Brasil);
		//times[6] = Brasil;
		TimeCopa Camaroes = new TimeCopa("bandeiraCamaroes.png", "Camaroes", "CAM");
		times.put("CAM", Camaroes);
		//times[7] = Camaroes;
		TimeCopa Chile = new TimeCopa("bandeiraChile.png", "Chile", "CHI");
		times.put("CHI", Chile);
		//times[8] = Chile;
		TimeCopa Colombia = new TimeCopa("bandeiraColombia.png", "Colombia", "COL");
		times.put("COL", Colombia);
		//times[9] = Colombia;
		TimeCopa Coreia = new TimeCopa("bandeiraCoreiaDoSul.png", "Coreia do Sul", "CDS");
		times.put("CDS", Coreia);
		//times[10] = Coreia;
		TimeCopa CostaDoMarfim = new TimeCopa("bandeiraCostaDoMarfim.png", "Costa do Marfim", "CMA");
		times.put("CMA", CostaDoMarfim);
		//times[11] = CostaDoMarfim;
		TimeCopa CostaRica = new TimeCopa("bandeiraCostaRica.png", "Costa Rica", "COS");
		times.put("COS", CostaRica);
		//times[12] = CostaRica;
		TimeCopa Croacia = new TimeCopa("bandeiraCroacia.png", "Croacia", "CRO");
		times.put("CRO", Croacia);
		//times[13] = Croacia;
		TimeCopa Equador = new TimeCopa("bandeiraEquador.png", "Equador", "EQU");
		times.put("EQU", Equador);
		//times[14] = Equador;
		TimeCopa Espanha = new TimeCopa("bandeiraEspanha.png", "Espanha", "ESP");
		times.put("ESP", Espanha);
		//times[15] = Espanha;
		TimeCopa Eua = new TimeCopa("bandeiraEUA.png", "Estados Unidos", "EUA");
		times.put("EUA", Eua);
		//times[16] = Eua;
		TimeCopa Franca = new TimeCopa("bandeiraFranca.png", "Franca", "FRA");
		times.put("FRA", Franca);
		//times[17] = Franca;
		TimeCopa Gana = new TimeCopa("bandeiraGana.png", "Gana", "GAN");
		times.put("GAN", Gana);
		//times[18] = Gana;
		TimeCopa Grecia = new TimeCopa("bandeiraGrecia.png", "Grecia", "GRE");
		times.put("GRE", Grecia);
		//times[19] = Grecia;
		TimeCopa Holanda = new TimeCopa("bandeiraHolanda.png", "Holanda", "HOL");
		times.put("HOL", Holanda);
		//times[20] = Holanda;
		TimeCopa Honduras = new TimeCopa("bandeiraHonduras.png", "Honduras", "HON");
		times.put("HON", Honduras);
		//times[21] = Honduras;
		TimeCopa Inglaterra = new TimeCopa("bandeiraInglaterra.png", "Inglaterra", "ING");
		times.put("ING",Inglaterra);
		//times[22] = Inglaterra;
		TimeCopa Ira = new TimeCopa("bandeiraIra.png", "Ira", "IRA");
		times.put("IRA",Ira);
		//times[23] = Ira;
		TimeCopa Italia = new TimeCopa("bandeiraItalia.png", "Italia", "ITA");
		times.put("ITA", Italia);
		//times[24] = Italia;
		TimeCopa Japao = new TimeCopa("bandeiraJapao.png", "Japao", "JAP");
		times.put("JAP", Japao);
		//times[25] = Japao;
		TimeCopa Mexico = new TimeCopa("bandeiraMexico.png", "Mexico", "MEX");
		times.put("MEX", Mexico);
		//times[26] = Mexico;
		TimeCopa Nigeria = new TimeCopa("bandeiraNigeria.png", "Nigeria", "NGR");
		times.put("NGR", Nigeria);
		//times[27] = Nigeria;
		TimeCopa Portugal = new TimeCopa("bandeiraPortugal.png", "Portugal", "POR");
		times.put("POR", Portugal);
		//times[28] = Portugal;
		TimeCopa Russia = new TimeCopa("bandeiraRussia.png", "Russia", "RUS");
		times.put("RUS", Russia);
		//times[29] = Russia;
		TimeCopa Suica = new TimeCopa("bandeiraSuica.png", "Suica", "SUI");
		times.put("SUI", Suica);
		//times[30] = Suica;
		TimeCopa Uruguai = new TimeCopa("bandeiraUruguai.png", "Uruguai", "URU");
		times.put("URU", Uruguai);
		//times[31] = Uruguai;
		ControladorTimes.escreve(times);
	
	}
}