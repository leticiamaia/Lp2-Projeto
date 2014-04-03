package projetoLp2.bolao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import projetoLp2.bolao.docs.ControladorAdmin;
import projetoLp2.bolao.docs.ControladorJogador;

public class MeuBolao {
	private static Usuario usuarioLogado;
	private static int indexUsuarioLogado;
	ObjectInputStream ois;
	ObjectOutputStream out;

	public static boolean login2(String username, String senha) throws Exception {
		boolean retorno = false;
		if (usuarioLogado != null)
			throw new Exception("Nao e possivel logar com um usuario ja logado");
		if (username == null || username.equals("") || senha == null
				|| senha.equals(""))
			throw new Exception(
					"Username e Senha nao devem ser nulos ou vazios");
		
			Administrador admin = ControladorAdmin.ler();
			if (admin.login(username, senha)) {
				usuarioLogado = admin;
				indexUsuarioLogado = -1;
				retorno = true;
			} else if (admin.getUsername().equals(username)) {
				throw new Exception("Senha incorreta(s).");
			}
	
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador.ler();
			for (Jogador j : jogadores) {
				if (j.login(username, senha)) {
					indexUsuarioLogado = jogadores.indexOf(j);
					usuarioLogado = j;
					retorno = true;
				} else if (j.getUsername().equals(username)) {
					throw new Exception("Senha incorreta(s).");
				}
			}
		if (!retorno)
			throw new Exception("Usuario nao encontrado.");
		return retorno;
	}

	public static boolean cadastraJogador(String nome, String username, String senha,
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

		
		Administrador admin = ControladorAdmin.ler();
			if (username.equals(admin.getUsername())) {
				retorno = false;
				throw new Exception("Usuario ja existente.");
			}
			ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador.ler();
			
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
				jogadores.add(j);
			}

			ControladorJogador.escreve(jogadores);
			return retorno;
	}

	public static boolean checkUsuario(String usuario, String pergunta,
			String respostaSecreta, String email) throws Exception {
		if (usuario == null || usuario == "" || pergunta == null
				|| pergunta == "" || respostaSecreta == null
				|| respostaSecreta == "" || email == null || email.equals("")) {
			throw new Exception("Campos nao podem ser nulos ou vazios.");
		}
		boolean retorno = false;
		
		ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador.ler();
		for (Jogador j : jogadores) {
			if (j.getUsername().equals(usuario)
					&& j.getPerguntaSecreta().equals(pergunta)
					&& j.getResposta().equals(respostaSecreta)
					&& j.getEmail().equals(email)) {
					usuarioLogado = j;
					retorno = true;
				}
			}
		return retorno;
	}

	public static boolean mudarSenha(String novaSenha) throws Exception {
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

	public static boolean mudarSenhaAdmin() throws IOException {
		Administrador admin = null;
		boolean retorno = false;
		
		admin = (Administrador) ControladorAdmin.ler();
		
		if (admin.getUsername().equals(usuarioLogado.getUsername())) {
			ControladorAdmin.escreve((Administrador) usuarioLogado);
			retorno = true;
		}
		return retorno;
	}

	public static boolean mudarSenhaUsuario() throws IOException {	
		ArrayList <Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador.ler();
		boolean retorno = false;
		
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getUsername()
					.equals(usuarioLogado.getUsername())) {
				jogadores.set(i, (Jogador) usuarioLogado);
				ControladorJogador.escreve(jogadores);
				retorno = true;
			}
		}
		return retorno;
	}

	public static void desloga() {
		usuarioLogado = null;
	}

	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static String[][] getRanking() throws IOException, ClassNotFoundException {
		ArrayList<Jogador> jogadores = (ArrayList<Jogador>)ControladorJogador.ler();
		String[][] tabela = new String[10][3];
		
		for (int i = 0; i < 10; i++) {
			tabela[i][0] = "" + (i + 1);
			if (i < jogadores.size()) {
				tabela[i][1] = jogadores.get(i).getUsername();
				tabela[i][2] = "" + jogadores.get(i).getPontos();
			} else {
				tabela[i][1] = null;
				tabela[i][2] = null;
			}
		}
		return tabela;
	}
	

	public static String[][] getRankingUsuario() throws Exception {
		if (usuarioLogado instanceof Administrador) {
			throw new Exception("Admin nao possua ranking.");
		}
		String[][] tabela = new String[1][3];
		tabela[0][0] = "" + (indexUsuarioLogado + 1);
		tabela[0][1] = usuarioLogado.getUsername();
		tabela[0][2] = "" + ((Jogador) usuarioLogado).getPontos();
		return tabela;
	}

}
