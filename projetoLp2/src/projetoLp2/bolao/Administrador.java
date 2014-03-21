package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

//add exeptions?

public class Administrador extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2088632941739437245L;
	FileInputStream fin;
	FileOutputStream fon;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Partida[] partidas = new Partida[64];

	public Administrador(String username, String senha) {
		super(username, senha);
	}

	public void cadastraPartida(int indicePartida, String nomeTime1,
			String nomeTime2, GregorianCalendar data) throws Exception {

		Partida partida = new Partida(nomeTime1, nomeTime2, data);
		partidas[indicePartida] = partida;
	}

	public void atualizaPartida(int indicePartida, int resultadoTime1,
			int resultadoTime2) throws Exception {
		partidas[indicePartida].setGols(resultadoTime1, resultadoTime2);
		atualizaPontucao(indicePartida);
		atualizaRanking();
	}

	private void atualizaRanking() {
		List<Jogador> jogadores;
		try {
			getObjectFromFileText("usuarios.bin");
			jogadores = (List<Jogador>) ois.readObject();
			Collections.sort(jogadores, new OrdenaJogadores());
			oos.writeObject(jogadores);
			closeFileText();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void atualizaPontucao(int indicePartida) {

		List<Jogador> jogadores;
		try {
			getObjectFromFileText("usuarios.txt");
			// check cast?
			jogadores = (List<Jogador>) ois.readObject();
			for (Jogador j : jogadores) {
				Aposta aposta = j.getAposta(indicePartida);
				j.adicionaPontos(aposta.resultadoAposta());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// adicionar a Usuario?
	private void getObjectFromFileText(String fileText) {

		try {
			fin = new FileInputStream(fileText);
			ois.close();
			oos.close();
			fon = new FileOutputStream(fileText);
			ois = new ObjectInputStream(fin);
			oos = new ObjectOutputStream(fon);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void closeFileText() {

		try {
			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
