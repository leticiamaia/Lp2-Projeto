package projetoLp2.bolao;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import projetoLp2.bolao.docs.ControladorJogador;
import projetoLp2.bolao.docs.ControladorPartidas;

/**
 * Essa classe representa o administrador do Nosso Bolao
 * 
 * @author Marcela, Leticia, Orion, Lucas
 * 
 */
public class Administrador extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2088632941739437245L;

	/**
	 * Construtor da classe
	 * 
	 * @param username
	 *            Username do admin
	 * @param senha
	 *            Senha do Admin
	 * @throws Exception
	 *             Caso os paramentros sejam Invalidos.
	 */
	public Administrador(String username, String senha) throws Exception {
		super(username, senha);
	}

	/**
	 * Esse Metodo e usado para cadastrar uma partida da Copa no sistema
	 * 
	 * @param indicePartida
	 *            Indice da partida
	 * @param time1
	 *            Time que Jogara a partida.
	 * @param time2
	 *            Outro Time que Jogara a partida.
	 * @param data
	 *            Data de realzacao da partida.
	 * @return Um array de Pertidas da Copa
	 * @throws Exception
	 *             caso os Parametros sejam Invalidos.
	 */
	public Partida[] cadastraPartida(int indicePartida, TimeCopa time1,
			TimeCopa time2, GregorianCalendar data) throws Exception {
		if (indicePartida < 0)
			throw new Exception("Indice da partida invalido!");
		if (time1 == null || time2 == null)
			throw new Exception("Time(s) invalido(s)!");

		Partida partida = new Partida(time1, time2, data);
		Partida[] partidas = (Partida[]) ControladorPartidas.ler();
		partidas[indicePartida] = partida;
		ControladorPartidas.escreve(partidas);
		
		return partidas;
	}

	/**
	 * Esse Metodo Coloca o resultado de uma partida no bolao.
	 * 
	 * @param indicePartida
	 *            Indice da Partida
	 * @param resultadoTime1
	 *            Numero de gols feitos pelo time1
	 * @param resultadoTime2
	 *            Numero de gols feitos pelo time2
	 * @return O array de partidas da copa
	 * @throws Exception
	 *             Caso os parametros sejam invalidos e/ou a partida nao foi
	 *             cadastrada ainda.
	 */
	public Partida[] atualizaPartida(int indicePartida, int resultadoTime1,
			int resultadoTime2) throws Exception {
		if (indicePartida < 0 || indicePartida > 63)
			throw new Exception("Indice da partida invalido!");
		if (resultadoTime1 < 0 || resultadoTime2 < 0)
			throw new Exception("Resultado(s) invalido(s)!");

		Partida[] partidas = (Partida[])ControladorPartidas.ler();
		
		if (partidas[indicePartida] == null) {
			throw new Exception("Essa Partida nao foi Cadastrada ainda.");
		}
		partidas[indicePartida].setGols(resultadoTime1, resultadoTime2);
		ControladorPartidas.escreve(partidas);
		atualizaPontuacao(indicePartida);
		atualizaRanking();
		return partidas;
	}

	/**
	 * Esse metodo atuliza o ranking dos jogadores quando um resultado de uma
	 * partida e adicionado.
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void atualizaRanking() {
		List<Jogador> jogadores = ControladorJogador.ler();
		Collections.sort(jogadores);
		ControladorJogador.escreve(jogadores);
	}

	/**
	 * Esse metodo atuliza a pontucao dos jogadores do bolao quando o resultado
	 * de uma partida e atualizado.
	 * 
	 * @param indicePartida
	 * @throws Exception 
	 */
	private void atualizaPontuacao(int indicePartida) throws Exception {

		List<Jogador> jogadores = ControladorJogador.ler();
		System.out.println("Log6");
		for (Jogador j : jogadores) {
			Aposta aposta = j.getAposta(indicePartida);
			if (aposta!= null) {
				j.adicionaPontos(aposta.resultadoAposta());
				System.out.println("Log7");
			}
		}
		ControladorJogador.escreve(jogadores);

	}

}
