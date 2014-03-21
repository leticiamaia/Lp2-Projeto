package projetoLp2.tests;

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
	public void testaLogin() throws Exception {
		Assert.assertTrue(bolao.login2("Admin", "1234"));
		bolao.desloga();
		Assert.assertFalse(bolao.login2("Admin", "123"));
	}
	
	@Test
	public void testaCadastro() throws Exception {
		Assert.assertEquals(bolao.cadastraJogador("Leticia", "1234","let@gmail.com","Qual?","patos"), 1);
		Assert.assertEquals(bolao.cadastraJogador("Leticia", "1234","lmt@gmail.com","Qual?","patos"), 2);
		Assert.assertEquals(bolao.cadastraJogador("Admin", "1234","leti@gmail.com","Qual?","patos"), 2);
		Assert.assertEquals(bolao.cadastraJogador("Outro", "1234","lmt@gmail.com","Qual?","patos"), 1);

	}
	
}
