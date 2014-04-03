package projetoLp2.bolao;

/**
 * Essa classe representa uma aposta do jogador sobre uma partida da oitava de final
 * @author Marcela, Leticia, Orion, Lucas
 */
public class ApostaOitavasDeFinal extends Aposta{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8363009324875929698L;

	/**
	 * Construtor da classe
	 * @param partida - Partida a ser apostada 
	 * @param numGolsTime1 - Palpite do numero de gols do time 1
	 * @param numGolsTime2 - Palpite do numero de gols do time 0
	 * @throws Exception se a partida for nula ou numero de gols for menor que 0
	 */
	public ApostaOitavasDeFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 2;
	}

}
