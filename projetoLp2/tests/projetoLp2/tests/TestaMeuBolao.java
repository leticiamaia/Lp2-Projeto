package projetoLp2.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.docs.CriaFile;

public class TestaMeuBolao {
	private MeuBolao bolao;
	private final String NOME = "nome";
	private final String USERNAME = "user";
	private final String SENHA = "senha";
	private final String EMAIL = "email@.";
	private final String PERGUNTA = "pergunta?";
	private final String RESPOSTA = "resposta";
	private final String VAZIO = "";
	private final String NULO = null;

	@Before
	public void set() throws Exception {
		bolao = new MeuBolao();
		CriaFile.main(null);
	}

	@Test
	public void testaLoginAdmin() throws Exception {
		Assert.assertTrue(bolao.login2("admin", "1234"));
		try {
			bolao.login2("admin", "1234");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(
					"Nao e possivel logar com um usuario ja logado",
					e.getMessage());
		}
		bolao.desloga();
		try {
			bolao.login2("admin", "123");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Senha incorreta(s).", e.getMessage());
		}
	}

	@Test
	public void testaLoginUsuario() throws Exception {
		bolao.cadastraJogador("Leticia", "Leticia", "1234", "let@gmail.com",
				"Qual?", "patos");

		try {
			bolao.login2("Leticia", "123");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Senha incorreta(s).", e.getMessage());
		}

		Assert.assertTrue(bolao.login2("Leticia", "1234"));

		try {
			bolao.login2("Leticia", "1234");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Mensagem Errada",
					"Nao e possivel logar com um usuario ja logado",
					e.getMessage());
		}
		try {
			bolao.login2("Leti", "1234");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Mensagem Errada",
					"Nao e possivel logar com um usuario ja logado",
					e.getMessage());
		}
		bolao.desloga();
		Assert.assertTrue(bolao.login2("Leticia", "1234"));
		bolao.cadastraJogador("Leticia", "Let", "1234", "lmt@gmail.com",
				"Qual?", "patos");
		bolao.desloga();
		Assert.assertTrue(bolao.login2("Let", "1234"));
		bolao.desloga();

	}

	@Test
	public void testaCadastro() throws Exception {
		try {
			bolao.cadastraJogador(NOME, NULO, SENHA, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, VAZIO, SENHA, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, NULO, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, VAZIO, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, SENHA, NULO, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, SENHA, VAZIO, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, NULO, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, VAZIO, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA, NULO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA, VAZIO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, "admin", SENHA, EMAIL + "1", PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Usuario ja existente.",
					e.getMessage());
		}
		
		Assert.assertTrue(bolao.cadastraJogador(NOME, USERNAME, SENHA,EMAIL, PERGUNTA, RESPOSTA));
		
		try {
			bolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL + "1", PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Usuario ja existente.",
					e.getMessage());
		}
		
		try {
			bolao.cadastraJogador(NOME, USERNAME + "1", SENHA, EMAIL, PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Email ja cadastrado.",
					e.getMessage());
		}
		Assert.assertTrue(bolao.cadastraJogador(NOME, USERNAME + "1", SENHA,  EMAIL + "1", PERGUNTA, RESPOSTA));

	}

	@Test
	public void testaCheckUsuario() throws Exception {
		Assert.assertFalse(bolao.checkUsuario("Leticia", "Qual?", "patos",
				"lmt@gmail.com"));
		bolao.cadastraJogador("Leticia", "Leticia", "1234", "lmt@gmail.com",
				"Qual?", "patos");
		bolao.cadastraJogador("amor", "amor", "amor", "amor@gmail.com", "amor",
				"amor");
		Assert.assertTrue(bolao.checkUsuario("amor", "amor", "amor",
				"amor@gmail.com"));
		Assert.assertTrue(bolao.checkUsuario("Leticia", "Qual?", "patos",
				"lmt@gmail.com"));
		Assert.assertFalse(bolao.checkUsuario("Leticia", "Qual?",
				"campina grande", "lmt@gmail.com"));
		Assert.assertFalse(bolao.checkUsuario("Let", "Qual?", "patos",
				"lmt@gmail.com"));
		Assert.assertFalse(bolao.checkUsuario("Leticia", "Qual?", "Patos",
				"let@gmail.com"));
		bolao.cadastraJogador("Lucas", "casal20", "1234", "lucas@gmail.com",
				"namorada?", "Leticia");
		Assert.assertFalse(bolao.checkUsuario("Leticia", "namorada?",
				"Leticia", "lmt@gmail.com"));
		Assert.assertTrue(bolao.checkUsuario("casal20", "namorada?", "Leticia",
				"lucas@gmail.com"));
	}

	@Test
	public void testaMudarSenha() throws Exception {
		Assert.assertTrue(bolao.login2("admin", "1234"));
		bolao.mudarSenha("123");
		bolao.desloga();
		Assert.assertTrue(bolao.login2("admin", "123"));
		bolao.desloga();
		bolao.cadastraJogador("Leticia", "Let", "1234", "lmt@gmail.com",
				"Qual?", "patos");
		bolao.login2("Let", "1234");
		bolao.mudarSenha("123");
		bolao.desloga();
		try {
			bolao.login2("Let", "1234");
		} catch (Exception e) {
			Assert.assertEquals("Senha incorreta(s).", e.getMessage());
		}
		Assert.assertTrue(bolao.login2("Let", "123"));
		bolao.desloga();
	}
	
	@Test
	public void testaGetRankingJogador() throws Exception {
		bolao.cadastraJogador(NOME, USERNAME, SENHA,  EMAIL, PERGUNTA, RESPOSTA);
		bolao.login2(USERNAME, SENHA);
		String[][] ranking = bolao.getRankingUsuario();
		Assert.assertEquals("1", ranking[0][0]);
		Assert.assertEquals(USERNAME, ranking[0][1]);
		Assert.assertEquals("0", ranking[0][2]);
		
		bolao.desloga();
		bolao.login2("admin", "1234");
		try {
			bolao.getRankingUsuario();
		} catch (Exception e) {
			Assert.assertEquals("Admin nao possua ranking.", e.getMessage());
		}
	}
	
	@Test
	public void testaGetRanking() throws Exception {
		bolao.cadastraJogador(NOME, USERNAME, SENHA,  EMAIL, PERGUNTA, RESPOSTA);
		String[][] ranking = bolao.getRanking();
		Assert.assertEquals("1", ranking[0][0]);
		Assert.assertEquals(USERNAME, ranking[0][1]);
		Assert.assertEquals("0", ranking[0][2]);
		bolao.cadastraJogador(NOME, USERNAME + "1", SENHA,  EMAIL + "1", PERGUNTA, RESPOSTA);
		ranking = bolao.getRanking();
		Assert.assertEquals("2", ranking[1][0]);
		Assert.assertEquals(USERNAME + "1", ranking[1][1]);
		Assert.assertEquals("0", ranking[1][2]);
		Assert.assertEquals("3", ranking[2][0]);
		Assert.assertEquals(null, ranking[2][1]);
		Assert.assertEquals(null, ranking[2][2]);
	}
	@After
	public void clean() throws Exception {
		CriaFile.main(null);
		bolao.desloga();
	}

}
