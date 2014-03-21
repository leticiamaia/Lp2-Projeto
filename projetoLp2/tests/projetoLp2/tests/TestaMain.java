package projetoLp2.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import projetoLp2.bolao.MeuBolao;

public class TestaMain {
	
	@Test
	public void testaLogin() throws ClassNotFoundException, IOException {
		MeuBolao main = new MeuBolao();
		Assert.assertTrue(main.login2("Admin", "1234"));
		Assert.assertFalse(main.login2("Admin", "123"));
	}

}
