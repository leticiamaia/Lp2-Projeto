package projetoLp2.bolao;

public class ApostaSemiFinal extends Aposta{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3170143978393655028L;

	public ApostaSemiFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 8;
	}

}
