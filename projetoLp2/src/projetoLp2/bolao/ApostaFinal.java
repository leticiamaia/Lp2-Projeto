package projetoLp2.bolao;

public class ApostaFinal extends Aposta{

	public ApostaFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 16;
	}

}
