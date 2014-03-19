package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Jogador extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 776610356730575144L;
	private Aposta[] apostas = new Aposta[64];
	private int totalPontos = 0;
	
	public Jogador(String username, String senha) {
		super(username, senha);
		// TODO Auto-generated constructor stub
	}
	
	public void adicionaPontos(int resultadoAposta) {
		totalPontos += resultadoAposta;
	}
	
	//nao precisa tirar do arquvo.
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

	public int getPontos() {
		return totalPontos;
	}
}
