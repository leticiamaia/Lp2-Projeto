package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Jogador extends Usuario {


	
	private static final long serialVersionUID = 776610356730575144L;
	private Aposta[] apostas = new Aposta[64];
	private int totalPontos = 0;
	private String email;
	private String perguntaSecreta;
	private String resposta;
	private String nome;
	
	public Jogador(String nome, String username, String senha, String email,
			String perguntaSecreta, String resposta) throws Exception {
		super(username, senha);
		if (email == null || email.equals("") || senha == null
				|| senha.equals("") || perguntaSecreta == null
				|| perguntaSecreta.equals("")) throw new Exception("Campos nao podem ser nulos ou vazios.");
		this.email = email;
		this.perguntaSecreta = perguntaSecreta;
		this.resposta = resposta;
		this.nome = nome;
	}
	
	
	public Aposta[] getApostas() {
		return apostas;
	}

	public boolean novaAposta(int idx, Partida partida, int palpiteGolsTime1, int palpiteGolsTime2) throws Exception {
		if(apostas[idx] != null) {
			apostas[idx].setPalpiteGolsTime1(palpiteGolsTime1);
			apostas[idx].setPalpiteGolsTime2(palpiteGolsTime2);
			return true;
		}
		
		if(idx >= 0 && idx < 48) {
			apostas[idx] = new ApostaOitavasDeFinal(partida, palpiteGolsTime2, palpiteGolsTime2);
			return true;
		}
		
		if(idx >= 48 && idx < 56) {
			apostas[idx] = new ApostaQuartasDeFinal(partida, palpiteGolsTime2, palpiteGolsTime2);
			return true;
		}
		
		if(idx >= 56 && idx < 60) {
			apostas[idx] = new ApostaSemiFinal(partida, palpiteGolsTime2, palpiteGolsTime2);
			return true;
		}
		
		if(idx >= 60 && idx < 63) { // terceiro lugar tera mesmo peso que semifinal
			apostas[idx] = new ApostaFinal(partida, palpiteGolsTime2, palpiteGolsTime2);
			return true;
		}

		if(idx == 63) {
			apostas[idx] = new ApostaOitavasDeFinal(partida, palpiteGolsTime2, palpiteGolsTime2);
			return true;
		}
		
		return false;
		
	}
	
	public int getTotalPontos() {
		return totalPontos;
	}

	public String getPerguntaSecreta() {
		return perguntaSecreta;
	}

	public void setPerguntaSecreta(String perguntaSecreta) {
		this.perguntaSecreta = perguntaSecreta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void adicionaPontos(int resultadoAposta) {
		totalPontos += resultadoAposta;
	}

	public Aposta getAposta(int indiceAposta) {
		return apostas[indiceAposta];
	}

	public int getPontos() {
		return totalPontos;
	}

	public String getEmail() {
		return this.email;
	}
}
