package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.ControladorAdmin;
import projetoLp2.bolao.docs.CriaFile;

public class TestaMeuBolao {
	private static final GregorianCalendar DATA = new GregorianCalendar(2014,
			8, 15, 15, 30);
	private TimeCopa TIME2;
	private TimeCopa TIME1;
	private final String NOME = "nome";
	private final String USERNAME = "user";
	private final String SENHA = "senha";
	private final String EMAIL = "email@as.as";
	private final String PERGUNTA = "pergunta?";
	private final String RESPOSTA = "resposta";
	private final String VAZIO = "";
	private final String NULO = null;

	@Before
	public void set() throws Exception {
		TIME2 = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		TIME1 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		CriaFile.main(null);
	}

	@Test
	public void testaLoginAdmin() throws Exception {
		Assert.assertTrue(MeuBolao.login2("admin", "1234"));
		try {
			MeuBolao.login2("admin", "1234");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(
					"Nao e possivel logar com um usuario ja logado",
					e.getMessage());
		}
		MeuBolao.desloga();
		try {
			MeuBolao.login2("admin", "123");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Senha incorreta(s).", e.getMessage());
		}
	}

	@Test
	public void testaLoginUsuario() throws Exception {
		MeuBolao.cadastraJogador("Leticia", "Leticia", "1234", "let@gmail.com",
				"Qual?", "patos");

		try {
			MeuBolao.login2("Leticia", "123");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Senha incorreta(s).", e.getMessage());
		}

		Assert.assertTrue(MeuBolao.login2("Leticia", "1234"));

		try {
			MeuBolao.login2("Leticia", "1234");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Mensagem Errada",
					"Nao e possivel logar com um usuario ja logado",
					e.getMessage());
		}
		try {
			MeuBolao.login2("Leti", "1234");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Mensagem Errada",
					"Nao e possivel logar com um usuario ja logado",
					e.getMessage());
		}
		MeuBolao.desloga();
		Assert.assertTrue(MeuBolao.login2("Leticia", "1234"));
		MeuBolao.cadastraJogador("Leticia", "Let", "1234", "lmt@gmail.com",
				"Qual?", "patos");
		MeuBolao.desloga();
		Assert.assertTrue(MeuBolao.login2("Let", "1234"));
		MeuBolao.desloga();

	}

	@Test
	public void testaCadastro() throws Exception {
		try {
			MeuBolao.cadastraJogador(NOME, NULO, SENHA, EMAIL, PERGUNTA,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, VAZIO, SENHA, EMAIL, PERGUNTA,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, NULO, EMAIL, PERGUNTA,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, VAZIO, EMAIL, PERGUNTA,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, NULO, PERGUNTA,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, VAZIO, PERGUNTA,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, NULO,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, VAZIO,
					RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA,
					NULO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA,
					VAZIO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Campos nao podem ser nulos ou vazios.",
					e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, "admin", SENHA, EMAIL + "1",
					PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Usuario ja existente.", e.getMessage());
		}

		Assert.assertTrue(MeuBolao.cadastraJogador(NOME, USERNAME, SENHA,
				EMAIL, PERGUNTA, RESPOSTA));

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL + "1",
					PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Usuario ja existente.", e.getMessage());
		}

		try {
			MeuBolao.cadastraJogador(NOME, USERNAME + "1", SENHA, EMAIL,
					PERGUNTA, RESPOSTA);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Email ja cadastrado.", e.getMessage());
		}
		Assert.assertTrue(MeuBolao.cadastraJogador(NOME, USERNAME + "1", SENHA,
				EMAIL + "1", PERGUNTA, RESPOSTA));

	}

	@Test
	public void testaCheckUsuario() throws Exception {
		Assert.assertFalse(MeuBolao.checkUsuario("Leticia", "Qual?", "patos",
				"lmt@gmail.com"));
		MeuBolao.cadastraJogador("Leticia", "Leticia", "1234", "lmt@gmail.com",
				"Qual?", "patos");
		MeuBolao.cadastraJogador("amor", "amor", "amor", "amor@gmail.com",
				"amor", "amor");
		Assert.assertTrue(MeuBolao.checkUsuario("amor", "amor", "amor",
				"amor@gmail.com"));
		Assert.assertTrue(MeuBolao.checkUsuario("Leticia", "Qual?", "patos",
				"lmt@gmail.com"));
		Assert.assertFalse(MeuBolao.checkUsuario("Leticia", "Qual?",
				"campina grande", "lmt@gmail.com"));
		Assert.assertFalse(MeuBolao.checkUsuario("Let", "Qual?", "patos",
				"lmt@gmail.com"));
		Assert.assertFalse(MeuBolao.checkUsuario("Leticia", "Qual?", "Patos",
				"let@gmail.com"));
		MeuBolao.cadastraJogador("Lucas", "casal20", "1234", "lucas@gmail.com",
				"namorada?", "Leticia");
		Assert.assertFalse(MeuBolao.checkUsuario("Leticia", "namorada?",
				"Leticia", "lmt@gmail.com"));
		Assert.assertTrue(MeuBolao.checkUsuario("casal20", "namorada?",
				"Leticia", "lucas@gmail.com"));
	}

	@Test
	public void testaMudarSenha() throws Exception {
		Assert.assertTrue(MeuBolao.login2("admin", "1234"));
		MeuBolao.mudarSenha("123");
		MeuBolao.desloga();
		Assert.assertTrue(MeuBolao.login2("admin", "123"));
		MeuBolao.desloga();
		MeuBolao.cadastraJogador("Leticia", "Let", "1234", "lmt@gmail.com",
				"Qual?", "patos");
		MeuBolao.login2("Let", "1234");
		MeuBolao.mudarSenha("123");
		MeuBolao.desloga();
		try {
			MeuBolao.login2("Let", "1234");
		} catch (Exception e) {
			Assert.assertEquals("Senha incorreta(s).", e.getMessage());
		}
		Assert.assertTrue(MeuBolao.login2("Let", "123"));
		MeuBolao.desloga();
	}

	@Test
	public void testaGetRankingJogador() throws Exception {
		MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA,
				RESPOSTA);
		MeuBolao.login2(USERNAME, SENHA);
		String[][] ranking = MeuBolao.getRankingUsuario();
		Assert.assertEquals("1", ranking[0][0]);
		Assert.assertEquals(USERNAME, ranking[0][1]);
		Assert.assertEquals("0", ranking[0][2]);

		MeuBolao.desloga();
		MeuBolao.login2("admin", "1234");
	}

	@Test
	public void testaGetRanking() throws Exception {
		MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA,
				RESPOSTA);
		String[][] ranking = MeuBolao.getRanking();
		Assert.assertEquals("1", ranking[0][0]);
		Assert.assertEquals(USERNAME, ranking[0][1]);
		Assert.assertEquals("0", ranking[0][2]);
		MeuBolao.cadastraJogador(NOME, USERNAME + "1", SENHA, EMAIL + "1",
				PERGUNTA, RESPOSTA);
		ranking = MeuBolao.getRanking();
		Assert.assertEquals("2", ranking[1][0]);
		Assert.assertEquals(USERNAME + "1", ranking[1][1]);
		Assert.assertEquals("0", ranking[1][2]);
		Assert.assertEquals("3", ranking[2][0]);
		Assert.assertEquals(null, ranking[2][1]);
		Assert.assertEquals(null, ranking[2][2]);
	}

	@Test
	public void testaAlterarInfo() throws Exception {
		MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA,
				RESPOSTA);
		MeuBolao.login2(USERNAME, SENHA);
		MeuBolao.alterarInfo(NOME + "1", EMAIL + "1", SENHA + "1", PERGUNTA
				+ "1", RESPOSTA + "1");
		Assert.assertEquals(((Jogador) MeuBolao.getUsuarioLogado()).getNome(),
				NOME + "1");
		Assert.assertEquals(((Jogador) MeuBolao.getUsuarioLogado()).getEmail(),
				EMAIL + "1");
		Assert.assertEquals(
				((Jogador) MeuBolao.getUsuarioLogado()).getPerguntaSecreta(),
				PERGUNTA + "1");
		Assert.assertEquals(
				((Jogador) MeuBolao.getUsuarioLogado()).getResposta(), RESPOSTA
						+ "1");
		MeuBolao.desloga();
		Assert.assertTrue(MeuBolao.login2(USERNAME, SENHA + "1"));
		MeuBolao.desloga();

	}

	@Test
	public void testaBolaoApostas() throws Exception {
		MeuBolao.cadastraJogador(NOME, USERNAME, SENHA, EMAIL, PERGUNTA,
				RESPOSTA);
		MeuBolao.login2(USERNAME, SENHA);
		Administrador admin = ControladorAdmin.ler();
		admin.cadastraPartida(1, TIME1, TIME2, DATA);
		Assert.assertTrue(MeuBolao.apostar(1, 1, 2));
		Assert.assertEquals(((Jogador) MeuBolao.getUsuarioLogado())
				.getAposta(1).getPalpiteGolsTime1(), 1);
		Assert.assertEquals(((Jogador) MeuBolao.getUsuarioLogado())
				.getAposta(1).getPalpiteGolsTime2(),2);
		MeuBolao.CancelarAposta(1);
		Assert.assertEquals(((Jogador) MeuBolao.getUsuarioLogado())
				.getAposta(1), null);
	}

	@After
	public void clean() throws Exception {
		CriaFile.main(null);
		MeuBolao.desloga();
	}

}
