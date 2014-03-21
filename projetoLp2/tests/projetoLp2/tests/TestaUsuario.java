package projetoLp2.tests;

import org.junit.Assert;
import org.junit.Test;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Usuario;

public class TestaUsuario {
	@Test
	public void testaLogin() {
		Usuario usuario = new Administrador("Admin", "1234");
		Assert.assertTrue(usuario.login("Admin","1234"));
		Assert.assertFalse(usuario.login("Admin","123"));
	}

}
