package projetoLp2.bolao;

public class ApostaOitavasDeFinal extends Aposta{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8363009324875929698L;

	public ApostaOitavasDeFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 2;
	}

}
