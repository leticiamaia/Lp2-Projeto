package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

public class TestaPartida {

	@Test
	public void testaConstrutor() throws Exception{
		TimeCopa time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil");
		
		try {
			Partida partida = new Partida(null, time2, new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Time invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida(time2, null, new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Time invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2000, 2, 13, 15, 30));
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel adicionar jogo com data anterior a atual!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			Assert.assertEquals("Alemanha", partida.getTime1());
			Assert.assertEquals("Brasil", partida.getTime2());
			Assert.assertEquals("15/09/2014", partida.getData());
		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void testaSetGols() throws Exception{
		TimeCopa time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil");
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(-1, 3);
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(1, -3);
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(1, 3);
			Assert.assertTrue(partida.getGolsTime1() == 1);
			Assert.assertTrue(partida.getGolsTime2() == 3);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaGetGols() throws Exception{
		TimeCopa time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil");
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.getGolsTime1();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.getGolsTime2();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}
	}
	
	@Test
	public void testaCompareTo() throws Exception{
		TimeCopa time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil");
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.resultado();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(1, 1);
			Assert.assertTrue(partida.resultado() == 0);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(2, 1);
			Assert.assertTrue(partida.resultado() == 1);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(1, 2);
			Assert.assertTrue(partida.resultado() == -1);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
