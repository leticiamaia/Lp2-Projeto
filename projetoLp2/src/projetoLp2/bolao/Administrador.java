package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

//add exeptions?

public class Administrador extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2088632941739437245L;
	ObjectInputStream ois;
	ObjectOutputStream out;
	Partida[] partidas = new Partida[64];

	public Administrador(String username, String senha) {
		super(username, senha);
	}

	public void cadastraPartida(int indicePartida, TimeCopa time1,
			TimeCopa time2, GregorianCalendar data) throws Exception {

		Partida partida = new Partida(time1, time2, data);
		partidas[indicePartida] = partida;
	}

	public void atualizaPartida(int indicePartida, int resultadoTime1,
			int resultadoTime2) throws Exception {
		partidas[indicePartida].setGols(resultadoTime1, resultadoTime2);
		atualizaPontucao(indicePartida);
		atualizaRanking();
	}

	private void atualizaRanking() throws IOException {
		List<Jogador> jogadores = null;
		try {
			createIos("jogadores.bin");
			jogadores = (List<Jogador>) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
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

	private void atualizaPontucao(int indicePartida) throws IOException {

		List<Jogador> jogadores = null;
		try {
			createIos("usuarios.bin");
			jogadores = (List<Jogador>) ois.readObject();
		}  catch (Exception ex) {
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
			System.out.println("Arquivo nao Existe");
		}
	}

	private void createOut(String fileName) throws IOException {
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao Existe");
		}
	}
	
}
