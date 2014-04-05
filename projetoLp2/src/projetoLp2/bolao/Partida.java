package projetoLp2.bolao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Essa classe que representa uma partida da copa
 * @author Marcela, Leticia, Orion, Lucas
 */
public class Partida implements Serializable {

	private static final long serialVersionUID = -2980340733258351497L;
	private GregorianCalendar data;
	private TimeCopa time1;
	private TimeCopa time2;
	private int golsTime1, golsTime2;

	/**
	 * Construtor da classe
	 * @param time1 - Time 1 da partida
	 * @param time2 - Time 2 da partida
	 * @param data - Data do jogo
	 * @throws Exception
	 *             Lança excessao caso o time 1 ou 2 sejam invalidos ou a data
	 *             da partida é anterior ao dia atual
	 */
	public Partida(TimeCopa time1, TimeCopa time2, GregorianCalendar data) throws Exception {
		if (time1 == null || time2 == null)
			throw new Exception("Time invalido!");

		GregorianCalendar dataDeHoje = new GregorianCalendar();

		if (data.before(dataDeHoje))
			throw new Exception("Nao e possivel adicionar jogo com data anterior a atual!");

		this.data = data;
		this.time1 = time1;
		this.time2 = time2;
		golsTime1 = -1;
		golsTime2 = -1;
	}

	/**
	 * Define os gols do time 1 e 2
	 * @param golsTime1 - Numero de gols do time 1
	 * @param golsTime2 - Numero de gols do time 2
	 * @return um boolean se a operacao foi concluida
	 * @throws Exception caso os gols do time 1 ou 2 sejam menor do que 0
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
	 * @return string da data formatada
	 */
	public String getDataFormatada() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return dataFormatada.format(data.getTimeInMillis());
	}

	/**
	 * Retorna a data do jogo sendo a data um gregorian calendar
	 * @return a data do jogo
	 */
	public GregorianCalendar getData() {
		return data;
	}

	/**
	 * Retorna o time 1
	 * @return o time 1
	 */
	public TimeCopa getTime1() {
		return time1;
	}

	/**
	 * Retorna o time 2
	 * @return o time 2
	 */
	public TimeCopa getTime2() {
		return time2;
	}

	/**
	 * Retorna o numero de gols que o time 1 fez durante a partida
	 * @return o numero de gols do time 1
	 * @throws Exception caso o jogo ainda nao tenha sido realizado
	 */
	public int getGolsTime1() throws Exception {
		testaJogoNaoRealizado();
		return golsTime1;
	}

	/**
	 * Retorna o numero de gols que o time 2 fez durante a partida
	 * @return o numero de gols do time 2
	 * @throws Exception caso o jogo ainda nao tenha sido realizado
	 */
	public int getGolsTime2() throws Exception {
		testaJogoNaoRealizado();
		return golsTime2;
	}

	/**
	 * Retorna o ganhador da partida: -1, 0, 1, caso o time 1 ganhe, seja
	 * empate, ou que o time 2 ganhe, respectivamente.
	 * @return o ganhador da partida: -1, 0, 1, caso o time 1 ganhe, seja
	 *         empate, ou que o time 2 ganhe, respectivamente.
	 * @throws Exception Caso a partida ainda não tenha acontecido
	 */
	public int resultado() throws Exception {
		Integer g1 = getGolsTime1();
		Integer g2 = getGolsTime2();
		return g1.compareTo(g2);
	}
	
	/**
	 * Testa se uma partida ja foi realizada
	 * @throws Exception se a partida ainda não foi realizada.
	 */
	protected void testaJogoNaoRealizado() throws Exception{
		if (golsTime1 == -1 || golsTime2 == -1)
			throw new Exception("Jogo ainda nao foi realizado!");
	}
	
	/**
	 * Retorna a string contendo a abreviacao do time 1 X abreviacao do time 2
	 */
	@Override
	public String toString(){
		return getTime1().getAbreviacaoNomeTime() + " X " + getTime2().getAbreviacaoNomeTime();
	}
	
	/**
	 * Cria um JPanel que tem as bandeiras dos times da partida com suas respectivas abreviacoes
	 * @return um JPanel que tem as bandeiras dos times da partida com suas respectivas abreviacoes
	 */
	public JPanel panelDaPartida(){
		JPanel container = new JPanel();
		container.setVisible(true);
		
		container.add(new JLabel(getTime1().getBandeiraDoTime()));
		container.add(new JLabel(getTime1().getAbreviacaoNomeTime() + " X"));
		container.add(new JLabel(getTime2().getAbreviacaoNomeTime()));
		container.add(new JLabel(getTime2().getBandeiraDoTime()));
		
		return container;
	}
	
/*	public static void main(String[] args) throws Exception {
		TimeCopa time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
	}*/
	
}
