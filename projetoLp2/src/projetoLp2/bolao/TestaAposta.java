package projetoLp2.bolao;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class TestaAposta {

	@Test
	public void testaConstrutor(){
		try {
			Aposta aposta = new ApostaPrimeiraFase(null, 1, 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Partida invalida!", e.getMessage());
		}
	
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, -1, 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 1, -2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 1, 2);
			Assert.assertTrue(aposta.getPalpiteGolsTime1() == 1);
			Assert.assertTrue(aposta.getPalpiteGolsTime2() == 2);
			Assert.assertTrue(aposta.palpiteGanhador() == -1);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaSetPalpite(){
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 1, 2);
			aposta.setPalpiteGolsTime1(-1);
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 1, 2);
			aposta.setPalpiteGolsTime2(-2);
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}

		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 1, 2);
			
			aposta.setPalpiteGolsTime1(0);
			Assert.assertTrue(aposta.getPalpiteGolsTime1() == 0);
			
			aposta.setPalpiteGolsTime2(5);
			Assert.assertTrue(aposta.getPalpiteGolsTime2() == 5);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaMudaPlacarDaPatrida(){
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 5, 5);
			aposta.mudaPlacarDaPartida(-4, 5);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 5, 5);
			aposta.mudaPlacarDaPartida(4, -5);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 5, 5);
			aposta.mudaPlacarDaPartida(4, 5);
			Assert.assertTrue(partida.getGolsTime1() == 4);
			Assert.assertTrue(partida.getGolsTime2() == 5);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaResultadoAposta(){
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaOitavasDeFinal(partida, 1, 1);
			aposta.resultadoAposta();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda n�o foi realizado!", e.getMessage());
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 3);
			Aposta aposta = new ApostaPrimeiraFase(partida, 5, 5);
			Assert.assertTrue(aposta.resultadoAposta() == 1);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 3);
			Aposta aposta = new ApostaPrimeiraFase(partida, 3, 3);
			Assert.assertTrue(aposta.resultadoAposta() == 3);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			Aposta aposta = new ApostaPrimeiraFase(partida, 4, 5);
			aposta.mudaPlacarDaPartida(3, 3);
			Assert.assertTrue(aposta.resultadoAposta() == 0);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 3);
			Aposta aposta = new ApostaPrimeiraFase(partida, 3, 5);
			Assert.assertTrue(aposta.resultadoAposta() == 1);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 3);
			Aposta aposta = new ApostaPrimeiraFase(partida, 5, 3);
			Assert.assertTrue(aposta.resultadoAposta() == 1);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(4, 2);
			Aposta aposta = new ApostaOitavasDeFinal(partida, 4, 2);
			Assert.assertTrue(aposta.resultadoAposta() == 6);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(4, 2);
			Aposta aposta = new ApostaOitavasDeFinal(partida, 3, 2);
			Assert.assertTrue(aposta.resultadoAposta() == 4);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(4, 2);
			Aposta aposta = new ApostaOitavasDeFinal(partida, 3, 1);
			Assert.assertTrue(aposta.resultadoAposta() == 2);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(4, 2);
			Aposta aposta = new ApostaOitavasDeFinal(partida, 1, 1);
			Assert.assertTrue(aposta.resultadoAposta() == 0);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 4);
			Aposta aposta = new ApostaQuartasDeFinal(partida, 3, 4);
			Assert.assertTrue(aposta.resultadoAposta() == 12);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 4);
			Aposta aposta = new ApostaQuartasDeFinal(partida, 2, 4);
			Assert.assertTrue(aposta.resultadoAposta() == 8);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 4);
			Aposta aposta = new ApostaQuartasDeFinal(partida, 2, 3);
			Assert.assertTrue(aposta.resultadoAposta() == 4);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 4);
			Aposta aposta = new ApostaQuartasDeFinal(partida, 2, 2);
			Assert.assertTrue(aposta.resultadoAposta() == 0);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 4);
			Aposta aposta = new ApostaSemiFinal(partida, 3, 4);
			Assert.assertTrue(aposta.resultadoAposta() == 24);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Partida partida = new Partida("Brasil", "Holanda", new GregorianCalendar(2014, 8, 15, 15, 30));
			partida.setGols(3, 4);
			Aposta aposta = new ApostaFinal(partida, 3, 4);
			Assert.assertTrue(aposta.resultadoAposta() == 48);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
}
