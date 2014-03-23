package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MeuBolao {
	private Usuario usuarioLogado = null;

	ObjectInputStream ois;
	ObjectOutputStream out;

	public boolean login2(String username, String senha) throws Exception {
		if (usuarioLogado != null)
			throw new Exception("Nao e possivel logar com um usuario ja logado"); // throw
		try {
			createIos("admin.bin");
			Administrador admin = (Administrador) ois.readObject();
			if (admin.login(username, senha)) {
				usuarioLogado = admin;
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ois.close();
		}
		try {
			createIos("usuarios.bin");
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ois
					.readObject();
			for (Jogador j : jogadores) {
				if (j.login(username, senha)) {
					usuarioLogado = j;
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ois.close();
		}
		return false;
	}

	public int cadastraJogador(String nome, String username, String senha,
			String email, String perguntaSecreta, String resposta)
			throws Exception {
		if (nome == null || username == null || username.equals("")
				|| senha == null || senha.equals("") || email == null
				|| email.equals("") || perguntaSecreta == null
				|| resposta == null)
			throw new Exception(
					"Campos nao podem ser nulos, alguns não devem estar vazios.");

		int retorno = 1;

		try {
			createIos("admin.bin");
			Administrador admin = (Administrador) ois.readObject();
			if (username.equals(admin.getUsername())) {
				retorno = 2;
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ois.close();
		}

		try {
			createIos("usuarios.bin");
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ois
					.readObject();
			for (Jogador j : jogadores) {
				if (j.getUsername().equals(username)) {
					retorno = 2;
				}
				if (j.getEmail().equals(email)) {
					retorno = 3;
				}
			}
			if (retorno == 1) {
				Jogador j = new Jogador(nome, username, senha, email,
						perguntaSecreta, resposta);
				jogadores.add(j);
			}

			createOut("usuarios.bin");
			out.writeObject(jogadores);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ois.close();
			out.close();
		}

		return retorno;
	}

	public boolean checkUsuario(String usuario, String pergunta,
			String respostaSecreta, String email) throws Exception {
		if (usuario == null || usuario == "" || pergunta == null
				|| pergunta == "" || respostaSecreta == null
				|| respostaSecreta == "" || email == null || email.equals("")) {
			throw new Exception("Campos nao podem ser nulos ou vazios.");
		}

		try {
			createIos("usuarios.bin");
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ois
					.readObject();
			for (Jogador j : jogadores) {
				if (j.getUsername().equals(usuario)
						&& j.getPerguntaSecreta().equals(pergunta)
						&& j.getResposta().equals(respostaSecreta)
						&& j.getEmail().equals(email)) {
					usuarioLogado = j;
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ois.close();
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

	private void createOut(String fileName) throws IOException {
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao Existe");
		}
	}

	public void desloga() {
		usuarioLogado = null;
	}
	
	public Usuario getUsuarioLogado(){
		return this.usuarioLogado;
	}
}
