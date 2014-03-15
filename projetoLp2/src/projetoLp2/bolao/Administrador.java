package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

public class Administrador extends Usuario {

	Partida[] partidas = new Partida[64];

	public Administrador(String username, String senha) {
		super(username, senha);
	}

	public void cadastraPartida(int indicePartida, String nomeTime1,
			String nomeTime2, GregorianCalendar data) throws Exception {
		
		Partida partida = new Partida(nomeTime1, nomeTime2, data);
		try {
			FileInputStream fin = new FileInputStream("partidas.txt");
			FileOutputStream fon = new FileOutputStream("partidas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			partidas = (Partida[]) ois.readObject();
			
			partidas[indicePartida] = partida;
			
			oos.writeObject(partidas);
			
			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}


	} 

	public void atualizaPartida (int indicePartida, int resultadoTime1,
			int resultadoTime2) throws Exception {
		
		try {
			FileInputStream fin = new FileInputStream("partidas.txt");
			FileOutputStream fon = new FileOutputStream("partidas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			partidas = (Partida[]) ois.readObject();
			
			partidas[indicePartida].setGols(resultadoTime1, resultadoTime2);
			
			oos.writeObject(partidas);
			
			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		atualizaPontucao(indicePartida);
		atualizaRanking();
	}

	private void atualizaRanking() {
		// TODO Auto-generated method stub
		
	}

	private void atualizaPontucao(int indicePartida) {
		//para cada usuario em main
			//compara a pontuacao da partida
		// adiciona pos pontos
		
	} 
}
