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

	public void setEmail(String email) {
		this.email = email;
	}


	public void adicionaPontos(int resultadoAposta) {
		totalPontos += resultadoAposta;
	}

	public Aposta getAposta(int indiceAposta) {
		Aposta aposta = null;
		try {
			FileInputStream fin = new FileInputStream("partidas.txt");
			FileOutputStream fon = new FileOutputStream("partidas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			apostas = (Aposta[]) ois.readObject();

			aposta = apostas[indiceAposta];

			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return aposta;
	}

	public int getPontos() {
		return totalPontos;
	}

	public String getEmail() {
		return this.email;
	}
}
