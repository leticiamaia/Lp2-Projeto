package projetoLp2.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.docs.CriaFile;

public class TestaMeuBolao {
	private MeuBolao bolao;

	@Before
	public void set() {
		bolao = new MeuBolao();
		CriaFile c = new CriaFile();
		c.main(null);
	}

	@Test
	public void testaLoginAdmin() throws Exception {
		Assert.assertTrue(bolao.login2("admin", "1234"));
		try {
			bolao.login2("Admin", "1234");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Mensagem Errada",
					"Nao e possivel logar com um usuario ja logado",
					e.getMessage());
		}
		bolao.desloga();
		Assert.assertFalse(bolao.login2("Admin", "123"));
	}

	@Test
	public void testaLoginUsuario() throws Exception {
		bolao.cadastraJogador("Leticia", "Leticia", "1234", "let@gmail.com",
				"Qual?", "patos");
		Assert.assertFalse(bolao.login2("Leticia", "123"));
		Assert.assertTrue(bolao.login2("Leticia", "1234"));
		try {
			bolao.login2("Leticia", "1234");
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
	}

	@Test
	public void testaCadastro() throws Exception {
		Assert.assertEquals(bolao.cadastraJogador("Leticia", "Leticia", "1234",
				"let@gmail.com", "Qual?", "patos"), 1);
		Assert.assertEquals(bolao.cadastraJogador("Leticia", "Leticia", "1234",
				"lmt@gmail.com", "Qual?", "patos"), 2);
		Assert.assertEquals(bolao.cadastraJogador("Leticica", "Let", "1234",
				"lmt@gmail.com", "Qual?", "patos"), 1);
		Assert.assertEquals(bolao.cadastraJogador("Leticia", "admin", "1234",
				"leti@gmail.com", "Qual?", "patos"), 2);
		Assert.assertEquals(bolao.cadastraJogador("Leticia", "Outro", "1234",
				"lmt@gmail.com", "Qual?", "patos"), 3);

	}


	@Test
	public void testaCheckUsuario() throws Exception {
		Assert.assertFalse(bolao.checkUsuario("Leticia", "Qual?", "patos",
				"lmt@gmail.com"));
		bolao.cadastraJogador("Leticia", "Leticia", "1234", "lmt@gmail.com",
				"Qual?", "patos");
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

	@After
	public void clean() {
		CriaFile c = new CriaFile();
		c.main(null);
		bolao.desloga();
	}

}
