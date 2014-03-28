package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MeuBolao {
	private Usuario usuarioLogado;

	ObjectInputStream ois;
	ObjectOutputStream out;

	public boolean login2(String username, String senha) throws Exception {
		boolean retorno = false;
		if (usuarioLogado != null)
			throw new Exception("Nao e possivel logar com um usuario ja logado");
		if (username == null || username.equals("") || senha == null
				|| senha.equals(""))
			throw new Exception(
					"Username e Senha nao devem ser nulos ou vazios");

		try {
			createIos("admin.bin");
			Administrador admin = (Administrador) ois.readObject();
			if (admin.login(username, senha)) {
				usuarioLogado = admin;
				retorno = true;
			} else if (admin.getUsername().equals(username)) {
				throw new Exception("Senha incorreta(s).");
			}
		} finally {
			closeOis();
		}
		try {
			createIos("usuarios.bin");
			@SuppressWarnings("unchecked")
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ois
					.readObject();
			for (Jogador j : jogadores) {
				if (j.login(username, senha)) {
					usuarioLogado = j;
					retorno = true;
				} else if (j.getUsername().equals(username)) {
					throw new Exception("Senha incorreta(s).");
				}
			}
		} finally {
			closeOis();
		}
		if (!retorno)
			throw new Exception("Usuario nao encontrado.");
		return retorno;
	}

	public boolean cadastraJogador(String nome, String username, String senha,
			String email, String perguntaSecreta, String resposta)
			throws Exception {
		boolean retorno = true;

		if (username == null || username == "" || senha == null || senha == ""
				|| email == null || email.equals("") || senha == null
				|| senha.equals("") || perguntaSecreta == null
				|| perguntaSecreta.equals("") || resposta == null
				|| resposta.equals("")) {
			retorno = false;
			throw new Exception("Campos nao podem ser nulos ou vazios.");
		}

		
		try {	
			createIos("admin.bin");
			Administrador admin = (Administrador) ois.readObject();
			if (username.equals(admin.getUsername())) {
				retorno = false;
				throw new Exception("Usuario ja existente.");
			} 
		} finally {
			closeOis();
		}

		try {
			createIos("usuarios.bin");
			@SuppressWarnings("unchecked")
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ois
					.readObject();
			for (Jogador j : jogadores) {
				if (j.getUsername().equals(username)) {
					retorno = false;
					throw new Exception("Usuario ja existente.");
				}
				if (j.getEmail().equals(email)) {
					retorno = false;
					throw new Exception("Email ja cadastrado.");
				}
			}
			if (retorno) {
				Jogador j = new Jogador(nome, username, senha, email,
						perguntaSecreta, resposta);
				System.out.println(j.getUsername());
				jogadores.add(j);
			}

			createOut("usuarios.bin");
			out.writeObject(jogadores);
		} finally {
			closeOis();
			closeOut();
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
		boolean retorno = false;
		try {
			createIos("usuarios.bin");
			@SuppressWarnings("unchecked")
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ois
					.readObject();
			for (Jogador j : jogadores) {
				if (j.getUsername().equals(usuario)
						&& j.getPerguntaSecreta().equals(pergunta)
						&& j.getResposta().equals(respostaSecreta)
						&& j.getEmail().equals(email)) {

					usuarioLogado = j;
					retorno = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ois.close();
		}
		return retorno;
	}

	public boolean mudarSenha(String novaSenha) throws Exception {
		if (usuarioLogado == null)
			throw new Exception(
					"Usuario precisa estar logado para realizar esta operacao");
		if (novaSenha == null || novaSenha == "" || novaSenha.contains(" "))
			throw new Exception(
					"Senha nao pode ser nula, vazia e nem conter espa�os");
		boolean retorno = false;
		usuarioLogado.mudaSenha(novaSenha);
		if (usuarioLogado instanceof Administrador) {
			retorno = mudarSenhaAdmin();
		} else {
			retorno = mudarSenhaUsuario();
		}
		return retorno;

	}

	public boolean mudarSenhaAdmin() throws IOException {
		Administrador admin = null;
		boolean retorno = false;
		try {
			createIos("admin.bin");
			admin = (Administrador) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ois.close();
		}
		try {
			createOut("admin.bin");
			if (admin.getUsername().equals(usuarioLogado.getUsername())) {
				out.writeObject((Administrador) usuarioLogado);
				retorno = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public boolean mudarSenhaUsuario() throws IOException {
		ArrayList<Jogador> jogadores = null;
		boolean retorno = false;
		try {
			createIos("usuarios.bin");
			jogadores = (ArrayList<Jogador>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ois.close();
		}
		try {
			createOut("usuarios.bin");
			for (int i = 0; i < jogadores.size(); i++) {
				if (jogadores.get(i).getUsername()
						.equals(usuarioLogado.getUsername())) {
					jogadores.set(i, (Jogador) usuarioLogado);
					out.writeObject(jogadores);
					retorno = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return retorno;
	}

	public void desloga() {
		usuarioLogado = null;
	}

	public Usuario getUsuarioLogado() {
		return this.usuarioLogado;
	}

	private void createIos(String fileName) throws IOException {
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void createOut(String fileName) throws IOException {
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void closeOis() {
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeOut() {
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
