package projetoLp2.bolao;

import java.util.ArrayList;
import java.util.List;

import projetoLp2.bolao.docs.ControladorAdmin;
import projetoLp2.bolao.docs.ControladorJogador;

/**
 * Essafaz a ligacao da interface com as classes internas do sistema
 * 
 * @author Leticia, Marcela, Orion, Lucas
 * 
 */
public class MeuBolao {
	private static Usuario usuarioLogado;
	private static int indexUsuarioLogado;

	/**
	 * 
	 * @param username
	 *            Username(Login) do usuario.
	 * @param senha
	 *            Senha do Usuario.
	 * @return Verdadeiro se o jogador conseguiu se Logar
	 * @throws Exception
	 *             Caso o usuario nao exista ou a senha seja incorreta.
	 */
	public static boolean login2(String username, String senha)
			throws Exception {
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

		ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador
				.ler();
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

	/**
	 * Esse metodo cadastra um Jogador no sistema
	 * 
	 * @param nome
	 *            Nome do Jogador, campo nao obrigatorio.
	 * @param username
	 *            Username(login) do usuario.
	 * @param senha
	 *            Senha do usuario
	 * @param email
	 *            Email do usuario
	 * @param perguntaSecreta
	 *            Pergunta Secreta escolhida pelo usuario.
	 * @param resposta
	 *            Resposta da pergunta Secreta escolhida pelo usuario
	 * @return Verdadiro se o usuario conseguiu se cadastrar
	 * @throws Exception
	 *             se o Usuario ou email ja existem, ou se os campos foram
	 *             preenchidos de forma invalida.
	 */
	public static boolean cadastraJogador(String nome, String username,
			String senha, String email, String perguntaSecreta, String resposta)
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
		ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador
				.ler();

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

	/**
	 * Esse metodo loga o usuario caso ele esqueça sua senha.
	 * 
	 * @param usuario
	 *            Username(Login) do usuario.
	 * @param pergunta
	 *            Pegunta que o usuario escolheu.
	 * @param respostaSecreta
	 *            Resposta da pergunta que o susuario escolheu.
	 * @param email
	 *            Email do usario.
	 * @return Verdadeiro se a operacao foi realizada com sucesso.
	 * @throws Exception
	 *             Caso os campos sejam preechidos invalidamente ou os dados nao
	 *             sejam corretos.
	 */
	public static boolean checkUsuario(String usuario, String pergunta,
			String respostaSecreta, String email) throws Exception {
		if (usuario == null || usuario == "" || pergunta == null
				|| pergunta == "" || respostaSecreta == null
				|| respostaSecreta == "" || email == null || email.equals("")) {
			throw new Exception("Campos nao podem ser nulos ou vazios.");
		}
		boolean retorno = false;

		ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador
				.ler();
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
	
	/**
	 * Esse metodo altera a senha do usuario
	 * @param novaSenha A nova senha do usuario
	 * @return Cerdadeiro se a operacao foi realizada com sucesso.
	 * @throws Exception Caso os campos sejam preenchidos incorretamente.
	 */
	public static boolean mudarSenha(String novaSenha) throws Exception {
		if (usuarioLogado == null)
			throw new Exception(
					"Usuario precisa estar logado para realizar esta operacao");
		if (novaSenha == null || novaSenha == "" || novaSenha.contains(" "))
			throw new Exception(
					"Senha nao pode ser nula, vazia e nem conter espaï¿½os");
		boolean retorno = false;
		usuarioLogado.mudaSenha(novaSenha);
		if (usuarioLogado instanceof Administrador) {
			retorno = mudarSenhaAdmin();
		} else {
			retorno = mudarSenhaUsuario();
		}
		return retorno;

	}
	
	/**
	 * Muda a senha Caso o usuario seja um administrador
	 * @return verdadeiro se a operacao foi realizada com sucesso.
	 */
	private static boolean mudarSenhaAdmin() {
		Administrador admin = null;
		boolean retorno = false;

		admin = (Administrador) ControladorAdmin.ler();

		if (admin.getUsername().equals(usuarioLogado.getUsername())) {
			ControladorAdmin.escreve((Administrador) usuarioLogado);
			retorno = true;
		}
		return retorno;
	}
	
	/**
	 * Muda a senha caso o Usuario Logado seja um Jogador.
	 * @return verdadeiro se a operacao foi realizada com sucesso.
	 */
	private static boolean mudarSenhaUsuario() {
		ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador
				.ler();
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
	
	/**
	 * Esse metodo desloga o Usuario.
	 */
	public static void desloga() {
		usuarioLogado = null;
	}

	/**
	 * Esse metodo retorna o usuarioLogador
	 * @return O usuarioLogado.
	 */
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	/**
	 * Esse metodo retorna o ranking de Jogadores.
	 * @return A tabela de ranking dos Jogadores.
	 */
	public static String[][] getRanking() {
		ArrayList<Jogador> jogadores = (ArrayList<Jogador>) ControladorJogador
				.ler();
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
	
	/**
	 * Esse metodo retorna o ranaking do Jogador Logado
	 * @return Uma tabela com o ranking, posicao e valor do ranking do jogador
	 */
	public static String[][] getRankingUsuario() throws Exception {
		String[][] tabela = new String[1][3];
		tabela[0][0] = "" + (indexUsuarioLogado + 1);
		tabela[0][1] = usuarioLogado.getUsername();
		tabela[0][2] = "" + ((Jogador) usuarioLogado).getPontos();
		return tabela;
	}

	/**
	 * Esse Metodo altera as informacoes do Jogador Logado.
	 * @param Nome Novo nome do jogador
	 * @param Email Novo e-mail do Jogador
	 * @param Senha Nova senha do Jogador
	 * @param Pergunta Nova pergunta secreta do Jogador
	 * @param Resposta Nova respota da pergunta secreta do jogador
	 * @return Verdadeiro se a operacao foi reaizada com sucesso.
	 * @throws Exception Execao de Mudar Senha.
	 */
	public static boolean alterarInfo(String nome, String email, String senha,
			String pergunta, String resposta) throws Exception {
		if (!senha.equals(""))
			mudarSenha(senha);
		if (!nome.equals(""))
			((Jogador) usuarioLogado).setNome(nome);
		if (!email.equals(""))
			((Jogador) usuarioLogado).setEmail(email);
		if (!pergunta.equals(""))
			((Jogador) usuarioLogado).setPerguntaSecreta(pergunta);
		if (!resposta.equals(""))
			((Jogador) usuarioLogado).setResposta(resposta);
		List<Jogador> jogadores = ControladorJogador.ler();
		jogadores.set(indexUsuarioLogado, (Jogador) usuarioLogado);
		ControladorJogador.escreve(jogadores);
		return true;
	}
	
	/**
	 *Esse metodo faz uma aposta para o Jogador logado. 
	 * @param indicePartida indice da Partida em que o jogador quer apostar
	 * @param palpiteGolsTime1 Palpite do numero de gols do time 1
	 * @param palpiteGolsTime2 Palpite do numero de gols do time 2
	 * @return Verdadeiro se a operacao foi realiada com sucesso
	 * @throws Exception Se houver Execoes da classe Jogador
	 */
	public static boolean apostar(int indicePartida, int palpiteGolsTime1,
			int palpiteGolsTime2) throws Exception {
		boolean retorno = false;
		List<Jogador> jogadores = ControladorJogador.ler();
		if (((Jogador) usuarioLogado).novaAposta(indicePartida,
				palpiteGolsTime1, palpiteGolsTime2))
			retorno = true;
		jogadores.set(indexUsuarioLogado, (Jogador) usuarioLogado);
		ControladorJogador.escreve(jogadores);
		return retorno;
	}
	
	/**
	 * Cancela uma aposta feira pelo jogador
	 * @param indiceAposta Indice da aposta que o jogador deseja cancelar
	 * @throws Exception Da classe Jogador.
	 */
	public static void CancelarAposta(int indiceAposta) throws Exception {
		List<Jogador> jogadores = ControladorJogador.ler();
		((Jogador) usuarioLogado).cancelarAposta(indiceAposta);
		jogadores.set(indexUsuarioLogado, (Jogador) usuarioLogado);
		ControladorJogador.escreve(jogadores);
	}
}
