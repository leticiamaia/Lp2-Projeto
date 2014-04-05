package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.CriaFile;

public class TestaAdministrador {

	Administrador admin;
	TimeCopa time1;
	TimeCopa time2;
	GregorianCalendar data;
	Partida[] partidas;

	@Before
	public void set() throws Exception {
		CriaFile.main(null);
		admin = new Administrador ("admin", "senha");
	    time1 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
	    time2 = new TimeCopa("bandeiraArgentina.png", "Argentina", "ARG");
	    data = new GregorianCalendar(2014, 07, 12, 23, 00);
	}

	@Test
	public void testaCadastrapartida() {
		try {
			partidas = admin.cadastraPartida(-1, time1, time2, data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Indice da partida invalido!", e.getMessage());
		}

		try {
			partidas = admin.cadastraPartida(1, null, time2, data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Time(s) invalido(s)!", e.getMessage());
		}

		try {
			partidas = admin.cadastraPartida(1, time1, null, data);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Time(s) invalido(s)!", e.getMessage());
		}

		try {
			partidas = admin.cadastraPartida(1, time1, time2, data);
			Assert.assertEquals(partidas[1].getTime1(), time1);
			Assert.assertEquals(partidas[1].getTime2(), time2);
			Assert.assertEquals(partidas[1].getData(), data);

			partidas = admin.cadastraPartida(2, time2, time1, data);
			Assert.assertEquals(partidas[2].getTime1(), time2);
			Assert.assertEquals(partidas[2].getTime2(), time1);
			Assert.assertEquals(partidas[2].getData(), data);
			
			Assert.assertEquals(partidas[1].getTime1(), time1);
			Assert.assertEquals(partidas[1].getTime2(), time2);
			Assert.assertEquals(partidas[1].getData(), data);
			

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaAtualizaPartida() throws Exception {
		try {
			partidas = admin.atualizaPartida(-1, 0, 0);
			Assert.fail();
		} catch (Exception e) {
		Assert.assertEquals("Indice da partida invalido!", e.getMessage());
		}
		
		try {
			partidas = admin.atualizaPartida(65, 0, 0);
			Assert.fail();
		} catch (Exception e) {
		Assert.assertEquals("Indice da partida invalido!", e.getMessage());
		}
		
		try {
			partidas = admin.atualizaPartida(1, 0, -1);
			Assert.fail();
		} catch (Exception e) {
		Assert.assertEquals("Resultado(s) invalido(s)!", e.getMessage());
		}
		
		try {
			partidas = admin.atualizaPartida(1, -10, -1);
			Assert.fail();
		} catch (Exception e) {
		Assert.assertEquals("Resultado(s) invalido(s)!", e.getMessage());
		}
		
		try {
			partidas = admin.atualizaPartida(1, 0, 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Essa Partida nao foi Cadastrada ainda.", e.getMessage());
		}
		
		partidas = admin.cadastraPartida(1, time1, time2, data);
		partidas = admin.atualizaPartida(1, 0, 0);
		Assert.assertEquals(partidas[1].getGolsTime1(),0);
		Assert.assertEquals(partidas[1].getGolsTime2(),0);
		partidas = admin.cadastraPartida(2, time2, time1, data);
	}
	
	/*//impossivel de testar
	@Test
	public void testaAtualizaPontucao() throws Exception {
		MeuBolao.cadastraJogador("nome", "username", "senha", "email", "perguntaSecreta", "resposta");
		GregorianCalendar data = new GregorianCalendar();
		data.add(Calendar.DATE, -2);
		admin.cadastraPartida(1, time1, time2, data);
		MeuBolao.login2("username", "senha");
		Assert.assertEquals(((Jogador) MeuBolao.getUsuarioLogado()).getPontos(), 0);
		MeuBolao.apostar(1, 1, 0);
		admin.atualizaPartida(1, 1, 1);	
		Assert.assertEquals(((Jogador) MeuBolao.getUsuarioLogado()).getPontos(), 2);		
	}*/
	
	/*@Test
	public void testaAtualizaRanking() {
		
	}*/
	@After
	public void clean() throws Exception {
		CriaFile.main(null);
	}
}