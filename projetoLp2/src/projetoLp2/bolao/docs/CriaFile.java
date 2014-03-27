package projetoLp2.bolao.docs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.Partida;

public class CriaFile {

	public static void main(String[] args) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("admin.bin"));
			Administrador admin = new Administrador("admin", "1234");
			out.writeObject(admin);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		// criar file com lista de usuarios
		try {

			out = new ObjectOutputStream(new FileOutputStream("usuarios.bin"));
			List<Jogador> jogadores = new ArrayList<Jogador>();
			out.writeObject(jogadores);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

		try {
			out = new ObjectOutputStream(new FileOutputStream("partidas.bin"));
			Partida[] partidas = new Partida[64];
			for (int i = 0; i < 64; i++) {
				partidas[i] = null;
			}
			out.writeObject(partidas);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
