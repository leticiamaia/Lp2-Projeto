package projetoLp2.bolao;

public class ApostaQuartasDeFinal extends Aposta{
	
	public ApostaQuartasDeFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		valorPontuacao = 4;
	}

}
