package projetoLp2.bolao.docs;

import java.util.ArrayList;
import java.util.List;

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
		
		TimeCopa[] times = new TimeCopa[32];
		TimeCopa Alemanha = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		times[0] = Alemanha;
		TimeCopa Argelia = new TimeCopa("bandeiraArgelia.png", "Argelia", "ARG");
		times[1] = Argelia;
		TimeCopa Argentina = new TimeCopa("bandeiraArgentina.png", "Argentina", "ARG");
		times[2] = Argentina;
		TimeCopa Australia = new TimeCopa("bandeiraAustralia.png", "Australia", "AUS");
		times[3] = Australia;
		TimeCopa Belgica = new TimeCopa("bandeiraBelgica.png", "Belgica", "BEL");
		times[4] = Belgica;
		TimeCopa Bosnia = new TimeCopa("bandeiraBosniaHerzegovina.png", "Bosnia-Herzegovina", "BOS");
		times[5] = Bosnia;
		TimeCopa Brasil = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		times[6] = Brasil;
		TimeCopa Camaroes = new TimeCopa("bandeiraCamaroes.png", "Camaroes", "CAM");
		times[7] = Camaroes;
		TimeCopa Chile = new TimeCopa("bandeiraChile.png", "Chile", "CHI");
		times[8] = Chile;
		TimeCopa Colombia = new TimeCopa("bandeiraColombia.png", "Colombia", "COL");
		times[9] = Colombia;
		TimeCopa Coreia = new TimeCopa("bandeiraCoreiaDoSul.png", "Coreia do Sul", "CRS");
		times[10] = Coreia;
		TimeCopa CostaDoMarfim = new TimeCopa("bandeiraCostaDoMarfim.png", "Costa do Marfim", "COM");
		times[11] = CostaDoMarfim;
		TimeCopa CostaRica = new TimeCopa("bandeiraCostaRica.png", "Costa Rica", "COR");
		times[12] = CostaRica;
		TimeCopa Croacia = new TimeCopa("bandeiraCroacia.png", "Croacia", "CRO");
		times[13] = Croacia;
		TimeCopa Equador = new TimeCopa("bandeiraEquador.png", "Equador", "EQU");
		times[14] = Equador;
		TimeCopa Espanha = new TimeCopa("bandeiraEspanha.png", "Espanha", "ESP");
		times[15] = Espanha;
		TimeCopa Eua = new TimeCopa("bandeiraEUA.png", "Estados Unidos", "EUA");
		times[16] = Eua;
		TimeCopa Franca = new TimeCopa("bandeiraFranca.png", "Franca", "FRA");
		times[17] = Franca;
		TimeCopa Gana = new TimeCopa("bandeiraGana.png", "Gana", "GAN");
		times[18] = Gana;
		TimeCopa Grecia = new TimeCopa("bandeiraGrecia.png", "Grecia", "GRE");
		times[19] = Grecia;
		TimeCopa Holanda = new TimeCopa("bandeiraHolanda.png", "Holanda", "HOL");
		times[20] = Holanda;
		TimeCopa Honduras = new TimeCopa("bandeiraHonduras.png", "Honduras", "HON");
		times[21] = Honduras;
		TimeCopa Inglaterra = new TimeCopa("bandeiraInglaterra.png", "Inglaterra", "ING");
		times[22] = Inglaterra;
		TimeCopa Ira = new TimeCopa("bandeiraIra.png", "Ira", "IRA");
		times[23] = Ira;
		TimeCopa Italia = new TimeCopa("bandeiraItalia.png", "Italia", "ITA");
		times[24] = Italia;
		TimeCopa Japao = new TimeCopa("bandeiraJapao.png", "Japao", "JAP");
		times[25] = Japao;
		TimeCopa Mexico = new TimeCopa("bandeiraMexico.png", "Mexico", "MEX");
		times[26] = Mexico;
		TimeCopa Nigeria = new TimeCopa("bandeiraNigeria.png", "Nigeria", "NIG");
		times[27] = Nigeria;
		TimeCopa Portugal = new TimeCopa("bandeiraPortugal.png", "Portugal", "POR");
		times[28] = Portugal;
		TimeCopa Russia = new TimeCopa("bandeiraRussia.png", "Russia", "RUS");
		times[29] = Russia;
		TimeCopa Suica = new TimeCopa("bandeiraSuica.png", "Suica", "SUI");
		times[30] = Suica;
		TimeCopa Uruguai = new TimeCopa("bandeiraUruguai.png", "Uruguai", "URU");
		times[31] = Uruguai;
		ControladorTimes.escreve(times);
	
	}
}
