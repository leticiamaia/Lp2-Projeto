package projetoLp2.bolao;

/**
 * Essa classe representa uma aposta do jogador sobre uma partida da quarta de final
 * @author Marcela, Leticia, Orion, Lucas
 */
public class ApostaQuartasDeFinal extends Aposta{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4535290507875759039L;

	/**
	 * Construtor da classe
	 * @param partida - Partida a ser apostada 
	 * @param numGolsTime1 - Palpite do numero de gols do time 1
	 * @param numGolsTime2 - Palpite do numero de gols do time 0
	 * @throws Exception se a partida for nula ou numero de gols for menor que 0
	 */
	public ApostaQuartasDeFinal(int indicePartida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(indicePartida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 4;
	}
}
