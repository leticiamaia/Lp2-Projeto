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

public class Administrador extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2088632941739437245L;
	ObjectInputStream ois;
	ObjectOutputStream out;

	public Administrador(String username, String senha) {
		super(username, senha);
	}

	public Partida[] cadastraPartida(int indicePartida, TimeCopa time1,
			TimeCopa time2, GregorianCalendar data) throws Exception {
		if (indicePartida < 0)
			throw new Exception("Indice da partida invalido!");
		if (time1 == null || time2 == null)
			throw new Exception("Time(s) invalido(s)!");

		Partida[] partidas = null;
		Partida partida = new Partida(time1, time2, data);
		try {
			createIos("partidas.bin");
			partidas = (Partida[]) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
		partidas[indicePartida] = partida;
		try {
			createOut("partidas.bin");
			out.writeObject(partidas);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
		return partidas;
	}

	public Partida[] atualizaPartida(int indicePartida, int resultadoTime1,
			int resultadoTime2) throws Exception {
		if (indicePartida < 0 || indicePartida > 63)
			throw new Exception("Indice da partida invalido!");
		if (resultadoTime1 < 0 || resultadoTime2 < 0)
			throw new Exception("Resultado(s) invalido(s)!");
		Partida[] partidas = null;

		try {
			createIos("partidas.bin");
			partidas = (Partida[]) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
		if (partidas[indicePartida] == null) {
			throw new Exception("Essa Partida nao foi Cadastrada ainda.");
		}
		partidas[indicePartida].setGols(resultadoTime1, resultadoTime2);
		try {
			createOut("partidas.bin");
			out.writeObject(partidas);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
		atualizaPontuacao(indicePartida);
		atualizaRanking();
		return partidas;
	}

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
			Collections.sort(jogadores, new OrdenaJogadores());
			out.writeObject(jogadores);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

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

	private void createIos(String fileName) throws IOException {
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void createOut(String fileName) throws IOException {
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
