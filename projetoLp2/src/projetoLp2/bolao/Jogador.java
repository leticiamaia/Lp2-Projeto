package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Jogador extends Usuario {

	private Aposta[] apostas = new Aposta[64];
	private int totalPontos = 0;
	
	public Jogador(String username, String senha) {
		super(username, senha);
		// TODO Auto-generated constructor stub
	}
	
	public void adicionaPontos(int resultadoAposta) {
		totalPontos += resultadoAposta;
	}
	
	public Aposta getAposta(int indiceAposta){
		Aposta aposta = null;
		try {
			FileInputStream fin = new FileInputStream("partidas.txt");
			FileOutputStream fon = new FileOutputStream("partidas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			apostas = (Aposta[]) ois.readObject();
			
			aposta = apostas[indiceAposta];
			
			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return aposta;
	}
}
