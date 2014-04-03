package projetoLp2.bolao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Partida implements Serializable {

	private static final long serialVersionUID = -2980340733258351497L;
	GregorianCalendar data;
	TimeCopa time1, time2;
	int golsTime1, golsTime2;

	/**
	 * Construtor da Partida
	 * 
	 * @param time1
	 *            - Time 1 da partida
	 * @param time2
	 *            - Time 2 da partida
	 * @param data
	 *            - Data do jogo
	 * @throws Exception
	 *             Lan�a excessao caso o time 1 ou 2 sejam invalidos ou a data
	 *             da partida � anterior ao dia atual
	 */
	public Partida(TimeCopa time1, TimeCopa time2, GregorianCalendar data)
			throws Exception {
		if (time1 == null || time2 == null)
			throw new Exception("Time invalido!");

		GregorianCalendar dataDeHoje = new GregorianCalendar();

		if (data.before(dataDeHoje))
			throw new Exception(
					"Nao e possivel adicionar jogo com data anterior a atual!");

		this.data = data;
		this.time1 = time1;
		this.time2 = time2;
		golsTime1 = -1;
		golsTime2 = -1;
	}

	/**
	 * Define os gols do time 1 e 2
	 * 
	 * @param golsTime1
	 *            - Numero de gols do time 1
	 * @param golsTime2
	 *            - Numero de gols do time 2
	 * @return um boolean se a operacao foi concluida
	 * @throws Exception
	 *             caso os gols do time 1 ou 2 sejam menor do que 0
	 */
	public boolean setGols(int golsTime1, int golsTime2) throws Exception {
		if (golsTime1 < 0 || golsTime2 < 0)
			throw new Exception("Numero de gols invalido!");
		this.golsTime1 = golsTime1;
		this.golsTime2 = golsTime2;

		time1.addPartidaJogada(this);
		time2.addPartidaJogada(this);

		return true;
	}

	/**
	 * Retorna uma string da data da partida formatada no modelo dia, mes,
	 * ano(dd/mm/aaaa)
	 * 
	 * @return string da data formatada
	 */
	public String getDataFormatada() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return dataFormatada.format(data.getTimeInMillis());
	}

	/**
	 * Retorna a data do jogo sendo a data um gregorian calendar
	 * 
	 * @return a data do jogo
	 */
	public GregorianCalendar getData() {
		return data;
	}

	/**
	 * Retorna o time 1
	 * 
	 * @return o time 1
	 */
	public TimeCopa getTime1() {
		return time1;
	}

	/**
	 * Retorna o time 2
	 * 
	 * @return o time 2
	 */
	public TimeCopa getTime2() {
		return time2;
	}

	/**
	 * Retorna o numero de gols que o time 1 fez durante a partida
	 * 
	 * @return o numero de gols do time 1
	 * @throws Exception
	 *             caso o jogo ainda nao tenha sido realizado
	 */
	public int getGolsTime1() throws Exception {
		if (golsTime1 == -1)
			throw new Exception("Jogo ainda nao foi realizado!");
		return golsTime1;
	}

	/**
	 * Retorna o numero de gols que o time 2 fez durante a partida
	 * 
	 * @return o numero de gols do time 2
	 * @throws Exception
	 *             caso o jogo ainda nao tenha sido realizado
	 */
	public int getGolsTime2() throws Exception {
		if (golsTime2 == -1)
			throw new Exception("Jogo ainda nao foi realizado!");
		return golsTime2;
	}

	/**
	 * Retorna o ganhador da partida: -1, 0, 1, caso o time 1 ganhe, seja
	 * empate, ou que o time 2 ganhe, respectivamente.
	 * 
	 * @return o ganhador da partida: -1, 0, 1, caso o time 1 ganhe, seja
	 *         empate, ou que o time 2 ganhe, respectivamente.
	 * @throws Exception
	 *             Caso a partida ainda n�o tenha acontecido
	 */
	public int resultado() throws Exception {
		Integer g1 = getGolsTime1();
		Integer g2 = getGolsTime2();
		return g1.compareTo(g2);
	}
}
