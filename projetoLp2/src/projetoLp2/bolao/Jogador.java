package projetoLp2.bolao;

/**
 * Essa classe representa um jogador do bolao.
 * 
 * @author Leticia
 * 
 */
@SuppressWarnings("rawtypes")
public class Jogador extends Usuario implements Comparable {
	private static final long serialVersionUID = 776610356730575144L;
	private Aposta[] apostas = new Aposta[64];
	private int totalPontos = 0;
	private String email;
	private String perguntaSecreta;
	private String resposta;
	private String nome;

	/**
	 * Construtor da classe
	 * 
	 * @param nome
	 *            nome do Jogador
	 * @param username
	 *            Username do Jogador
	 * @param senha
	 *            Senha definida pelo Jogador
	 * @param email
	 *            Email do Jogador
	 * @param perguntaSecreta
	 *            Pergunta Secreta escohida pelo jogador
	 * @param resposta
	 *            Resposta da pergunta secreta escolhida.
	 * @throws Exception
	 *             caso os parametros sejam invalidos.
	 */
	public Jogador(String nome, String username, String senha, String email,
			String perguntaSecreta, String resposta) throws Exception {
		super(username, senha);
		if (email == null || email.equals("") || senha == null
				|| senha.equals("") || perguntaSecreta == null
				|| perguntaSecreta.equals("") || resposta == null
				|| resposta.equals(""))
			throw new Exception("Campos nao podem ser nulos ou vazios.");
		this.email = email;
		this.perguntaSecreta = perguntaSecreta;
		this.resposta = resposta;
		this.nome = nome; 
	}

	/**
	 * Retorna as apostas do Jogador
	 * 
	 * @return as apostas do Jogador
	 */
	public Aposta[] getApostas() {
		return apostas;
	}
	/**
	 * Cria/edita uma nova Aposta
	 * 
	 * @param indiceAposta
	 *            indice da Aposta
	 * @param partida
	 *            Partida em que o jogador vai apostar
	 * @param palpiteGolsTime1
	 *            Palpite do Jogador quanto ao numero de gols do time1
	 * @param palpiteGolsTime2
	 *            Palpite do Jogador quanto ao numero de gols do time2
	 * @return Verdadeiro se a operacao foi realizada com sucesso
	 * @throws Exception
	 *             Caso os parametros sejam invalidos
	 */
	public boolean novaAposta(int indiceAposta,
			int palpiteGolsTime1, int palpiteGolsTime2) throws Exception {
		if (indiceAposta < 0 || indiceAposta > 64)
			throw new Exception("Indice invalido");

		if (apostas[indiceAposta] != null) {
			apostas[indiceAposta].setPalpiteGolsTime1(palpiteGolsTime1);
			apostas[indiceAposta].setPalpiteGolsTime2(palpiteGolsTime2);
			return true;
		}

		if (indiceAposta >= 0 && indiceAposta < 48) {
			apostas[indiceAposta] = new ApostaPrimeiraFase(indiceAposta,
					palpiteGolsTime1, palpiteGolsTime2);
			return true;
		}

		if (indiceAposta >= 48 && indiceAposta < 56) {
			apostas[indiceAposta] = new ApostaOitavasDeFinal(indiceAposta,
					palpiteGolsTime1, palpiteGolsTime2);
			return true;
		}

		if (indiceAposta >= 56 && indiceAposta < 60) {
			apostas[indiceAposta] = new ApostaQuartasDeFinal(indiceAposta,
					palpiteGolsTime1, palpiteGolsTime2);
			return true;
		}

		if (indiceAposta >= 60 && indiceAposta < 63) { 
			apostas[indiceAposta] = new ApostaSemiFinal(indiceAposta,
					palpiteGolsTime1, palpiteGolsTime2);
			return true;
		}

		if (indiceAposta == 63) {
			apostas[indiceAposta] = new ApostaFinal(indiceAposta, palpiteGolsTime1,
					palpiteGolsTime2);
			return true;
		}

		return false;

	}

	/**
	 * Cancela uma aposta ja feita
	 * 
	 * @param indiceAposta
	 * @throws Exception
	 */
	public void cancelarAposta(int indiceAposta) throws Exception {
		if (indiceAposta < 0)
			throw new Exception("Indice invalido");
		if (apostas[indiceAposta] == null)
			throw new Exception("Aposta Inexistente");
		apostas[indiceAposta] = null;
	}

	/**
	 * Retorna a pergunta secreta escolhida pelo Jogador
	 * 
	 * @returna A pergunta secreta escolhida pelo Jogador
	 */
	public String getPerguntaSecreta() {
		return perguntaSecreta;
	}

	/**
	 * Muda a pergunta Secreta do jogador
	 * 
	 * @param perguntaSecreta
	 *            A nova pergunta secreta escolhida pelo Jogador
	 */
	public void setPerguntaSecreta(String perguntaSecreta) {
		this.perguntaSecreta = perguntaSecreta;
	}

	/**
	 * Retorna a resposta da pergunta secreta escolhida pelo Jogador
	 * @return  A resposta da pergunta secreta escolhida pelo Jogador
	 */
	public String getResposta() {
		return resposta;
	}

	/**
	 * Muda a resposta da pergunta secreta escolhida pelo Jogador
	 * @param resposta A nova resposta da pergunta secreta escolhida pelo Jogador
	 */
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	/**
	 * Retorna o Nome do jogador
	 * @return Nome do Jogador
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Muda o nome do Jogador
	 * @param nome Novo Nome escolhido
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Adiciona pontos de uma aposta ao total de pontos
	 * @param resultadoAposta Pontos ganhos com uma aposta.
	 */
	public void adicionaPontos(int resultadoAposta) {
		totalPontos += resultadoAposta;
	}

	/**
	 * Reorna uma aposta.
	 * @param indiceAposta indice da Aposta a ser retornada.
	 * @return A aposta
	 */
	public Aposta getAposta(int indiceAposta) {
		return apostas[indiceAposta];
	}

	/**
	 * Retorna o numero de pontos atual do Jogador no bolao
	 * @return Numero de pontos Atual
	 */
	public int getPontos() {
		return totalPontos;
	}

	/**
	 * Muda o total de pontos do jogador
	 * @param pontos
	 */
	public void setPontos(int pontos) {
		totalPontos = pontos;
	}

	/**
	 * Retorna o e-mail do Jogador
	 * @return E-mail do Jogador
	 */
	public String getEmail() {
		return this.email;
	}

	@Override
	public int compareTo(Object arg0) {
		Jogador outroJogador = (Jogador)arg0;
		if (this.getPontos() == outroJogador.getPontos())
			return this.getUsername().compareTo(outroJogador.getUsername());

		return outroJogador.getPontos() - this.getPontos();
	}

	/**
	 * Muda o e-mail do Jogador
	 * @param email Nomo e-mail do Jogador
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}