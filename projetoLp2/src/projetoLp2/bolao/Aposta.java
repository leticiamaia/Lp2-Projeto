package projetoLp2.bolao;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Essa classe representa uma aposta do jogador
 * 
 * @author Marcela, Leticia, Orion, Lucas
 */
public abstract class Aposta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1431163718698165587L;
	protected int  indicePartida;
	protected int palpiteGolsTime1, palpiteGolsTime2, valorPontuacao;

	/**
	 * Construtor da classe
	 * 
	 * @param partida - Partida a ser apostada.
	 * @param numGolsTime1 - Palpite do numero de gols do time 1.
	 * @param numGolsTime2 - Palpite do numero de gols do time 2.
	 * @throws Exception se a partida for nula ou numero de gols for menor que 0.
	 */
	public Aposta(int indicePartida, int numGolsTime1, int numGolsTime2)
			throws Exception {
		if (indicePartida < 0 || indicePartida > 64) {
			throw new Exception("Partida invalida!");
		}

		Partida partida = ControladorPartidas.ler()[indicePartida];

		if (partida == null) throw new Exception ("Partida Inexistente.");
		GregorianCalendar dataAceita = partida.getData();
		//dataAceita.add(Calendar.DATE, -1);
		if (dataAceita.before(new GregorianCalendar())) {
			throw new Exception("Nao e mais possivel fazer uma aposta nessa partida (observe a data da mesma)");
		}
		setPalpiteGolsTime1(numGolsTime1);
		setPalpiteGolsTime2(numGolsTime2);
		this.indicePartida = indicePartida;
	}

	/**
	 * Retorna o valor do palpite do numero de gols do time 1.
	 * @return valor do palpite do numero de gols do time 1.
	 */
	public int getPalpiteGolsTime1() {
		return palpiteGolsTime1;
	}

	/**
	 * Redefine o valor do palpite de gols do time 1.
	 * @param palpiteGolsTime1 - valor do palpite de gols do time 1.
	 * @throws Exception se o numero de gols for menor que 0.
	 */
	public void setPalpiteGolsTime1(int palpiteGolsTime1) throws Exception {
		if (palpiteGolsTime1 < 0)
			throw new Exception("Palpite de gols invalido!");
		this.palpiteGolsTime1 = palpiteGolsTime1;
	}

	/**
	 * Retorna o valor do palpite do numero de gols do time 2.
	 * @return valor do palpite do numero de gols do time 2.
	 */
	public int getPalpiteGolsTime2() {
		return palpiteGolsTime2;
	}

	/**
	 * Redefine o valor do palpite de gols do time 2.
	 * @param palpiteGolsTime2 - valor do palpite de gols do time 2.
	 * @throws Exception se o numero de gols for menor que 0.
	 */
	public void setPalpiteGolsTime2(int palpiteGolsTime2) throws Exception {
		if (palpiteGolsTime2 < 0)
			throw new Exception("Palpite de gols invalido!");
		this.palpiteGolsTime2 = palpiteGolsTime2;
	}

	/**
	 * Retorna o palpite do ganhador da partida: -1, 0, 1, caso o palpite seja
	 * que o time 1 ganhe, seja empate, ou que o time 2 ganhe, respectivamente.
	 * @return o palpite ganhador da partida: -1, 0, 1, caso o palpite seja que
	 *         o time 1 ganhe, seja empate, ou que o time 2 ganhe,
	 *         respectivamente.
	 */
	private int palpiteGanhador() {
		Integer p1 = palpiteGolsTime1;
		Integer p2 = palpiteGolsTime2;

		return p1.compareTo(p2);
	}

	/**
	 * Calcula a pontuacao obtida na aposta.
	 * 
	 * @return a pontuacao da aposta.
	 * @throws Exception se a partida ainda nao foi realizada.
	 */
	public int resultadoAposta() throws Exception {
		Partida partida = ControladorPartidas.ler()[indicePartida];
		int resultado = 0;
		if (partida.getGolsTime1() == palpiteGolsTime1)
			resultado += valorPontuacao;
		if (partida.getGolsTime2() == palpiteGolsTime2)
			resultado += valorPontuacao;
		if (partida.resultado() == palpiteGanhador())
			resultado += valorPontuacao;
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		if (palpiteGolsTime1 != other.palpiteGolsTime1)
			return false;
		if (palpiteGolsTime2 != other.palpiteGolsTime2)
			return false;
		if (indicePartida != other.indicePartida) {
				return false;
		}
		return true;
	}

	public int getIndice() {
		return indicePartida;
	}
}