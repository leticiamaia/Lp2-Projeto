package projetoLp2.bolao.docs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import projetoLp2.bolao.Partida;

public class ControladorPartidas {
	
	private static ObjectInputStream ois;
	private static ObjectOutputStream out;
	
	public static Partida[] ler() {
		Partida[] partidas = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("partidas.bin"));
			partidas =  (Partida[])ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return partidas;
	}
	
	public static void escreve(Partida[] partidas) {
		try {
			out = new ObjectOutputStream(new FileOutputStream("partidas.bin"));
			out.writeObject(partidas);
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
