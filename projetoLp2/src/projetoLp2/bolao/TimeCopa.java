package projetoLp2.bolao;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * Essa classe representa um time da copa
 * @author Marcela, Leticia, Orion, Lucas
 */
public class TimeCopa implements Serializable, Comparable<TimeCopa>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 553510963983020232L;
	private String nomeDoTime, abreviacaoNomeTime;
	private ImageIcon bandeiraDoTime;
	private List<Partida> partidasJogadas;
	private int numVitorias, numDerrotas, numEmpates;

	/**
	 * Construtor da classe
	 * @param caminhoBandeira - Caminho para a imagem da bandeira do time
	 * @param nomeDoTime - Nome do time
	 * @param abreviacaoNomeTime - Abreviacao do nome do time (com 3 caracteres)
	 * @throws Exception
	 *             se o caminho da bandeira, o nome do time ou a abreviacao
	 *             forem invalidos
	 */
	public TimeCopa(String caminhoBandeira, String nomeDoTime,
			String abreviacaoNomeTime) throws Exception {
		if (caminhoBandeira == null || caminhoBandeira.length() == 0)
			throw new Exception("Caminho da bandeira invalido!");
		if (nomeDoTime == null || nomeDoTime.length() == 0)
			throw new Exception("Nome do time invalido!");
		if (abreviacaoNomeTime == null || abreviacaoNomeTime.length() == 0)
			throw new Exception("Abreciacao do nome do time invalido!");
		if (abreviacaoNomeTime.length() != 3)
			throw new Exception("Abreviacao do nome do time deve ter 3 caracteres!");

		try {
			bandeiraDoTime = new ImageIcon(
					TimeCopa.class.getResource("/projetoLp2/bolao/docs/bandeiras/"+ caminhoBandeira));
		} catch (Exception e) {
			throw new FileNotFoundException("Imagem invalida!");
		}

		this.abreviacaoNomeTime = abreviacaoNomeTime.toUpperCase();
		this.nomeDoTime = nomeDoTime;
		partidasJogadas = new ArrayList<Partida>();
		numVitorias = 0;
		numDerrotas = 0;
		numEmpates = 0;
	}

	/**
	 * Retorna o nome do time
	 * @return nome do time
	 */
	public String getNomeDoTime() {
		return nomeDoTime;
	}

	/**
	 * Retorna a abreviacao do nome do time
	 * @return a abreviacao do nome do time
	 */
	public String getAbreviacaoNomeTime() {
		return abreviacaoNomeTime;
	}

	/**
	 * Retorna a imagem da bandeira do time
	 * @return imagem da bandeira do time
	 */
	public ImageIcon getBandeiraDoTime() {
		return bandeiraDoTime;
	}

	/**
	 * Adiciona a lista de partidas jogadas uma partida
	 * @param p - Partida a ser adicionada
	 * @throws Exception se a partida for invalida, se nenhum dos times
	 * 			   da partida for o time referente ou se a partida ainda
	 * 			   nao tiver sido realizada
	 */
	public void addPartidaJogada(Partida p) throws Exception {
		if (p == null)
			throw new Exception("Partida invalida!");
		if (!(p.getTime1().equals(this) || p.getTime2().equals(this)))
			throw new Exception("O time nao esta nesta partida!");
		if (p.testaJogoNaoRealizado())
			throw new Exception("Jogo ainda nao foi realizado!");

		partidasJogadas.add(p) ; 

		if (p.getTime1().equals(this)) {
			if (p.resultado() == 1)
				numVitorias++;
			else if (p.resultado() == 0)
				numEmpates++;
			else
				numDerrotas++;
		} else if (p.getTime2().equals(this)) {
			if (p.resultado() == -1)
				numVitorias++;
			else if (p.resultado() == 0)
				numEmpates++;
			else
				numDerrotas++;
		}
	}

	/**
	 * Retorna o numero de vitorias
	 * @return numero de vitorias
	 */
	public int getNumVitorias() {
		return numVitorias;
	}
	
	/**
	 * Retorna porcentagem de vitorias
	 * @return porcentagem de vitorias
	 */
	public int getPorcentagemVitorias(){
		if (numVitorias + numEmpates + numDerrotas == 0)
			return 0;
		return numVitorias * 100/(numVitorias + numEmpates + numDerrotas);
	}

	/**
	 * Retorna o numero de derrotas
	 * @return numero de derrotas
	 */
	public int getNumDerrotas() {
		return numDerrotas;
	}

	/**
	 * Retorna porcentagem de derrotas
	 * @return porcentagem de derrotas
	 */
	public int getPorcentagemDerrotas(){
		if (numVitorias + numEmpates + numDerrotas == 0)
			return 0;
		return numDerrotas * 100/(numVitorias + numEmpates + numDerrotas);
	}
	
	/**
	 * Retorna o numero de empates
	 * @return numero de empates
	 */
	public int getNumEmpates() {
		return numEmpates;
	}

	/**
	 * Retorna porcentagem de empates
	 * @return porcentagem de empates
	 */
	public int getPorcentagemEmpates(){
		if (numVitorias + numEmpates + numDerrotas == 0)
			return 0;
		return numEmpates * 100/(numVitorias + numEmpates + numDerrotas);
	}
	
	/**
	 * Esse metodo retorna as partidas jogadas pelo Time
	 * @return Lista de partidas jogadas pelo Time
	 */
	public List<Partida> getPartidasJogadas(){
		return partidasJogadas;  
	}
	
	/**
	 * Metodo Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeCopa other = (TimeCopa) obj;
		if (abreviacaoNomeTime == null) {
			if (other.abreviacaoNomeTime != null)
				return false;
		} else if (!abreviacaoNomeTime.equals(other.abreviacaoNomeTime))
			return false;
		if (nomeDoTime == null) {
			if (other.nomeDoTime != null)
				return false;
		} else if (!nomeDoTime.equals(other.nomeDoTime))
			return false;
		return true;
	}
	
	/**
	 * Metodo de comparar 2 times.
	 */
	@Override
	public int compareTo(TimeCopa time) {
		if (this.getNomeDoTime().compareTo(time.getNomeDoTime()) < 0)
			return -1;
		
		else if (this.getNomeDoTime().compareTo(time.getNomeDoTime()) > 0)
			return 1;
			
		return 0;
	}
	
	/**
	 * Metodo de retornar a String do Obejto TimeCopa
	 */
	@Override
	public String toString(){
		return nomeDoTime;
	}
}
