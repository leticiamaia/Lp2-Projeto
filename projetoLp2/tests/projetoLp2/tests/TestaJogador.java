package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.ApostaFinal;
import projetoLp2.bolao.ApostaOitavasDeFinal;
import projetoLp2.bolao.ApostaPrimeiraFase;
import projetoLp2.bolao.ApostaQuartasDeFinal;
import projetoLp2.bolao.ApostaSemiFinal;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.ControladorPartidas;
import projetoLp2.bolao.docs.CriaFile;

public class TestaJogador {
	private final String NOME = "nome";
	private final String USERNAME = "user";
	private final String SENHA = "senha";
	private final String EMAIL = "email@.";
	private final String PERGUNTA = "pergunta?";
	private final String RESPOSTA = "resposta";
	private final String VAZIO = "";
	private final String NULO = null;
	private Jogador jogador;
	private Partida partida;
	private TimeCopa time1, time2;
	
	@Before
	public void set() throws Exception{
		CriaFile.main(null);
		jogador = new Jogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA, RESPOSTA);
		time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
	}
	@Test
	public void testaConstrutor() throws Exception {
		try {
			new Jogador(NOME, NULO, SENHA, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, VAZIO, SENHA, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, NULO, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, VAZIO, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, SENHA, NULO, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, SENHA, VAZIO, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, SENHA, EMAIL, NULO, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, SENHA, EMAIL, VAZIO, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA, NULO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			new Jogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA, VAZIO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		Jogador jogador = new Jogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA, RESPOSTA);
		Assert.assertEquals(NOME, jogador.getNome());
		Assert.assertEquals(USERNAME, jogador.getUsername());
		Assert.assertEquals(EMAIL, jogador.getEmail());
		Assert.assertEquals(PERGUNTA, jogador.getPerguntaSecreta());
		Assert.assertEquals(RESPOSTA, jogador.getResposta());
	}
	
	@Test
	public void testaAdicionaPontos() {
		jogador.adicionaPontos(10);
		Assert.assertEquals(10, jogador.getPontos());
		jogador.adicionaPontos(5);
		Assert.assertEquals(15, jogador.getPontos());
		jogador.adicionaPontos(0);
		Assert.assertEquals(15, jogador.getPontos());
	}
	
	@Test
	public void testaNovaAposta() throws Exception {
		try {
			jogador.novaAposta(-1, 1, 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Indice invalido",
					e.getMessage());
		}
		try {
			jogador.novaAposta(1, 0, 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Partida Inexistente.",
					e.getMessage());
		}
		
		Partida[] partidas = ControladorPartidas.ler();
		partidas[1] = partida;
		partidas[48] = partida;
		partidas[56] = partida;
		partidas[60] = partida;
		partidas[63] = partida;
		ControladorPartidas.escreve(partidas);
		
		Assert.assertEquals(jogador.getApostas()[1], null);
		jogador.novaAposta(1, 1, 1);
		Assert.assertEquals(jogador.getApostas()[1], new ApostaPrimeiraFase(1, 1, 1));
		
		Assert.assertEquals(jogador.getApostas()[48], null);
		jogador.novaAposta(48, 1, 1);
		Assert.assertEquals(jogador.getApostas()[48], new ApostaOitavasDeFinal(48, 1, 1));
		
		Assert.assertEquals(jogador.getApostas()[56], null);
		jogador.novaAposta(56, 1, 1);
		Assert.assertEquals(jogador.getApostas()[56], new ApostaQuartasDeFinal(56, 1, 1));
		
		Assert.assertEquals(jogador.getApostas()[60], null);
		jogador.novaAposta(60, 1, 1);
		Assert.assertEquals(jogador.getApostas()[60], new ApostaSemiFinal(60, 1, 1));
		
		Assert.assertEquals(jogador.getApostas()[63], null);
		jogador.novaAposta(63, 1, 1);
		Assert.assertEquals(jogador.getApostas()[63], new ApostaFinal(63, 1, 1));
		
		jogador.novaAposta(1, 1, 2);
		Assert.assertEquals(jogador.getApostas()[1], new ApostaPrimeiraFase(1, 1, 2));
		
	}
	
	@Test
	public void testaCancelarAposta() throws Exception {
		try {
			jogador.cancelarAposta(-1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Indice invalido",
					e.getMessage());
		}
		
		try {
			jogador.cancelarAposta(1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Aposta Inexistente",
					e.getMessage());
		}
		
		Partida[] partidas = ControladorPartidas.ler();
		partidas[1] = partida;
		ControladorPartidas.escreve(partidas);
	
		jogador.novaAposta(1, 1, 1);
		Assert.assertEquals(jogador.getApostas()[1], new ApostaPrimeiraFase(1, 1, 1));
		jogador.cancelarAposta(1);
		Assert.assertEquals(jogador.getApostas()[1], null);
	}
}
