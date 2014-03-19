package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {
	List<Jogador> jogadores; 
	Usuario usuarioLogado = null;
	
	FileInputStream fin;
	FileOutputStream fon;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public boolean login(String username, String senha) throws ClassNotFoundException, IOException {
		getObjectFromFileText("admin.bin");
		Administrador admin = (Administrador)ois.readObject();
		if (admin.login(username,senha)) {
			usuarioLogado = admin;
			closeFileText();
			return true;
		} else {
			closeFileText();
			getObjectFromFileText("admin.bin");
			jogadores = (List<Jogador>)ois.readObject();
			for (Jogador j: jogadores) {
				if (j.login(username, senha)) {
					usuarioLogado = j;
					closeFileText();
					return true;
				}
			}
		}
		System.out.println("chegou");
		return false;
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

	private void closeFileText() {

		try {
			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
