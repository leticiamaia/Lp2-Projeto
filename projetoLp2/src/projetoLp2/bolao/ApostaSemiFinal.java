package projetoLp2.bolao;

public class ApostaSemiFinal extends Aposta{
	
	public ApostaSemiFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		valorPontuacao = 8;
	}

}
