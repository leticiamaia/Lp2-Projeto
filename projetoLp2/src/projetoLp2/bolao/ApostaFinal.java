package projetoLp2.bolao;

public class ApostaFinal extends Aposta{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8493792389945159624L;

	public ApostaFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 16;
	}

}
