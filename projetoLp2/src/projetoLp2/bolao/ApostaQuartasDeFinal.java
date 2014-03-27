package projetoLp2.bolao;

public class ApostaQuartasDeFinal extends Aposta{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4535290507875759039L;

	public ApostaQuartasDeFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 4;
	}

}
