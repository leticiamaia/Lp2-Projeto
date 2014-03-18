package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

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
			getPartidasFromFileText();
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
			getPartidasFromFileText();
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
		//nem ideia de como se pega a lista de usuarios
		
	}

	private void atualizaPontucao(int indicePartida) {
		//para cada usuario em main
			//compara a pontuacao da partida
		// adiciona pos pontos
		
	} 
	
	private void getPartidasFromFileText() {
		
		try {
		    fin = new FileInputStream("partidas.txt");ois.close();
			oos.close();
			fon = new FileOutputStream("partidas.txt");
			ois = new ObjectInputStream(fin);
			oos = new ObjectOutputStream(fon);
			partidas = (Partida[]) ois.readObject();
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
