package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MeuBolao {
	private Usuario usuarioLogado = null;

	ObjectInputStream ois;
	ObjectOutputStream out;

	public int login2(String username, String senha) throws Exception {
		int retorno = 3;
		if (usuarioLogado != null)
			throw new Exception("Nao e possivel logar com um usuario ja logado");
		if (username == null || username.equals("") || senha == null
				|| senha.equals("")) throw new Exception("Username e Senha nao devem ser nulos ou vazios");

			try {
				createIos("admin.bin");
				Administrador admin = (Administrador) ois.readObject();
				if (admin.login(username, senha)) {
					usuarioLogado = admin;
					retorno = 1;
				} else if (admin.getUsername().equals(username)) {
					retorno = 2;
				}
			} catch (Exception e) {
				System.out.println("aqui");
				e.printStackTrace();
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
					retorno = 1;
				} else if (j.getUsername().equals(username)) {
					retorno = 2;
				}
			}
		} catch (Exception e) {
			System.out.println("aqui2");
			e.printStackTrace();
		} finally {
			ois.close();
		}
		return retorno;
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			ois.close();
		}
		return false;
	}

	public boolean mudarSenha(String novaSenha) throws Exception {
		if (usuarioLogado == null)
			throw new Exception(
					"Usuario precisa estar logado para realizar esta operacao");
		if (novaSenha == null || novaSenha == "" || novaSenha.contains(" "))
			throw new Exception("Senha nao pode ser nula, vazia e nem conter espaços");
		boolean retorno = false;
		usuarioLogado.mudaSenha(novaSenha);
		if(usuarioLogado instanceof Administrador) {
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
	
	public boolean mudarSenhaUsuario() throws IOException {
		ArrayList<Jogador> jogadores = null;
		boolean retorno = false;
		try {
			createIos("usuarios.bin");
			jogadores = (ArrayList<Jogador>) ois
					.readObject();
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
}
