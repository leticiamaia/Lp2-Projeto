package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

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
	ObjectInputStream ois;
	ObjectOutputStream out;

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
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private void atualizaRanking() throws IOException {
		List<Jogador> jogadores = null;
		try {
			createIos("usuarios.bin");
			jogadores = (List<Jogador>) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
		try {
			createOut("usuarios.bin");
			Collections.sort(jogadores);
			out.writeObject(jogadores);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

	/**
	 * Esse metodo atuliza a pontucao dos jogadores do bolao quando o resultado
	 * de uma partida e atualizado.
	 * 
	 * @param indicePartida
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private void atualizaPontuacao(int indicePartida) throws IOException {

		List<Jogador> jogadores = null;
		try {
			createIos("usuarios.bin");
			jogadores = (List<Jogador>) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
		try {
			createOut("usuarios.bin");
			for (Jogador j : jogadores) {
				Aposta aposta = j.getAposta(indicePartida);
				j.adicionaPontos(aposta.resultadoAposta());
			}
			out.writeObject(jogadores);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}

	}

	/**
	 * Esse Metodo cria um Objeto de Input
	 * 
	 * @param fileName
	 *            Nome do arquivo
	 * @throws IOException
	 */
	private void createIos(String fileName) throws IOException {
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Esse Metodo cria um Objeto de Output
	 * 
	 * @param fileName
	 *            Nome do arquivo
	 * @throws IOException
	 */
	private void createOut(String fileName) throws IOException {
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
