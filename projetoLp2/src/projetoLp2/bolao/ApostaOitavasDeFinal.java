package projetoLp2.bolao;

public class ApostaOitavasDeFinal extends Aposta{
	
	public ApostaOitavasDeFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 2;
	}

}
