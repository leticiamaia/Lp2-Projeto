package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
	List<Jogador> jogadores;
	Usuario usuarioLogado = null;

	FileInputStream fin;
	FileOutputStream fon;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public boolean login2(String username, String senha)
			throws ClassNotFoundException, IOException {
		 if (usuarioLogado!= null) return false; // throw Exception?
		try {
			createIos("admin.bin");
			Administrador admin = (Administrador) ois.readObject();
			System.out.println(admin.getUsername());
			if (admin.login(username, senha)) {
				usuarioLogado = admin;
				System.out.println("Admin Logadoo!!");
				ois.close();
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}

		try {
			createIos("usuarios.bin");
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ois
					.readObject();
			for (Jogador j : jogadores) {
				if (j.login(username, senha)) {
					usuarioLogado = j;
					ois.close();
					return true;
				}
			}
			ois.close();
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
		return false;
	}
	
	private void createIos(String fileName) throws IOException {
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao Existe");
		}	
	}
}
