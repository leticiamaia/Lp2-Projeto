package projetoLp2.bolao;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class TestaPartida {

	@Test
	public void testaConstrutor(){
		try {
			Partida partida = new Partida(null, "Brasil", new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", null, new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("", "Brasil", new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "", new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2000, 2, 13, 15, 30));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel adicionar jogo com data anterior a atual!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Assert.assertEquals("Brasil", partida.getTime1());
			Assert.assertEquals("Holanda", partida.getTime2());
			Assert.assertEquals("15/09/2014", partida.getData());
		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void testaSetGols(){
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(-1, 3);
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(1, -3);
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(1, 3);
			Assert.assertTrue(partida.getGolsTime1() == 1);
			Assert.assertTrue(partida.getGolsTime2() == 3);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaGetGols(){
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.getGolsTime1();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda não foi realizado!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.getGolsTime2();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda não foi realizado!", e.getMessage());
		}
	}
}
