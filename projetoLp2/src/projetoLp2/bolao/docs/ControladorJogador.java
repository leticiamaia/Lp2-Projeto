package projetoLp2.bolao.docs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import projetoLp2.bolao.Jogador;

public class ControladorJogador {
	
	private static ObjectInputStream ois;
	private static ObjectOutputStream out;
	
	
	@SuppressWarnings("unchecked")
	public static List<Jogador> ler() {
		List<Jogador> jogadores = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("usuarios.bin"));
			jogadores =  (List<Jogador>)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jogadores;
	}
	
	public static void escreve(List<Jogador> jogadores) {
		try {
			out = new ObjectOutputStream(new FileOutputStream("usuarios.bin"));
			out.writeObject(jogadores);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
