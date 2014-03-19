package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.omg.CORBA.portable.IndirectionException;

public class Administrador extends Usuario {

	Partida[] partidas = new Partida[64];
	
	FileInputStream fin;
	FileOutputStream fon;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public Administrador(String username, String senha) {
		super(username, senha);
	}

	public void cadastraPartida(int indicePartida, String nomeTime1,
			String nomeTime2, GregorianCalendar data) throws Exception {
		
		Partida partida = new Partida(nomeTime1, nomeTime2, data);
		try {
			getObjectFromFileText("partidas.txt");
			partidas[indicePartida] = partida;		
			oos.writeObject(partidas);	
			closeFileText();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}


	} 

	public void atualizaPartida (int indicePartida, int resultadoTime1,
			int resultadoTime2) throws Exception {
		
		try {
			getObjectFromFileText("partidas.txt");
			partidas = (Partida[]) ois.readObject();
			partidas[indicePartida].setGols(resultadoTime1, resultadoTime2);	
			oos.writeObject(partidas);
			closeFileText();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		atualizaPontucao(indicePartida);
		atualizaRanking();
	}

	private void atualizaRanking() {
		List <Jogador> jogadores;
		try {
			getObjectFromFileText("usuarios.txt");
			jogadores = (List<Jogador>)ois.readObject();
			Collections.sort(jogadores, new OrdenaJogadores());
			closeFileText();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void atualizaPontucao(int indicePartida) {
		
			List <Jogador> jogadores;
			try {
				getObjectFromFileText("usuarios.txt");
				jogadores = (List<Jogador>)ois.readObject();
				for (Jogador j: jogadores) {
					Aposta aposta = j.getAposta(indicePartida);
					//discutir, melhor passar a partida do que abrir o arquivo novamente
				}
				closeFileText();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
	} 
	
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
	
	private void closeFileText(){

		try {
			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
