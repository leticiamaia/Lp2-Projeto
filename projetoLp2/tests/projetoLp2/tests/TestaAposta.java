package projetoLp2.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import projetoLp2.bolao.Aposta;
import projetoLp2.bolao.ApostaFinal;
import projetoLp2.bolao.ApostaOitavasDeFinal;
import projetoLp2.bolao.ApostaPrimeiraFase;
import projetoLp2.bolao.ApostaQuartasDeFinal;
import projetoLp2.bolao.ApostaSemiFinal;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

public class TestaAposta {

	@Test
	public void testaConstrutor() throws Exception {
		TimeCopa time1 = new TimeCopa("bandeiraHolanda.png", "Holanda", "HOL");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		Partida partida = new Partida(time1, time2, new GregorianCalendar(2014,
				8, 15, 15, 30));

		try {
			new ApostaPrimeiraFase(null, 1, 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Partida invalida!", e.getMessage());
		}

		try {
			new ApostaPrimeiraFase(partida, -1, 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}

		try {
			new ApostaPrimeiraFase(partida, 1, -2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}

		try {
			GregorianCalendar c = new GregorianCalendar();
			c.add(Calendar.MINUTE, 60);
			Partida partida1 = new Partida(time1, time2, c);
			new ApostaPrimeiraFase(partida1, 1, 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(
					"Nao e mais possivel fazer uma aposta nessa partida.",
					e.getMessage());
		}
		
		Aposta aposta = new ApostaPrimeiraFase(partida, 1, 2);
		Assert.assertTrue(aposta.getPalpiteGolsTime1() == 1);
		Assert.assertTrue(aposta.getPalpiteGolsTime2() == 2);
	}

	@Test
	public void testaSetPalpite() throws Exception {
		TimeCopa time1 = new TimeCopa("bandeiraHolanda.png", "Holanda", "HOL");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		Partida partida = new Partida(time1, time2, new GregorianCalendar(2014,
				8, 15, 15, 30));
		Aposta aposta = new ApostaPrimeiraFase(partida, 1, 2);

		try {
			aposta.setPalpiteGolsTime1(-1);
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}

		try {
			aposta.setPalpiteGolsTime2(-2);
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}

		aposta.setPalpiteGolsTime1(0);
		Assert.assertTrue(aposta.getPalpiteGolsTime1() == 0);
		aposta.setPalpiteGolsTime2(5);
		Assert.assertTrue(aposta.getPalpiteGolsTime2() == 5);
		
	}

	@Test
	public void testaResultadoAposta() throws Exception {
		TimeCopa time1 = new TimeCopa("bandeiraHolanda.png", "Holanda", "HOL");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		Partida partida = new Partida(time1, time2, new GregorianCalendar(2014,
				8, 15, 15, 30));

		try {
			Aposta aposta = new ApostaOitavasDeFinal(partida, 1, 1);
			aposta.resultadoAposta();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}

		partida.setGols(3, 3);
		Aposta aposta = new ApostaPrimeiraFase(partida, 5, 5);
		Assert.assertTrue(aposta.resultadoAposta() == 1);


		partida.setGols(3, 3);
		aposta = new ApostaPrimeiraFase(partida, 3, 3);
		Assert.assertTrue(aposta.resultadoAposta() == 3);

	
		partida.setGols(3, 3);
		aposta = new ApostaPrimeiraFase(partida, 4, 5);
		Assert.assertTrue(aposta.resultadoAposta() == 0);
	
		
		partida.setGols(3, 3);
		aposta = new ApostaPrimeiraFase(partida, 3, 5);
		Assert.assertTrue(aposta.resultadoAposta() == 1);
		
		partida.setGols(3, 3);
		aposta = new ApostaPrimeiraFase(partida, 5, 3);
		Assert.assertTrue(aposta.resultadoAposta() == 1);
		
		partida.setGols(4, 2);
		aposta = new ApostaOitavasDeFinal(partida, 4, 2);
		Assert.assertTrue(aposta.resultadoAposta() == 6);
		
		partida.setGols(4, 2);
		aposta = new ApostaOitavasDeFinal(partida, 3, 2);
		Assert.assertTrue(aposta.resultadoAposta() == 4);
		
		partida.setGols(4, 2);
		aposta = new ApostaOitavasDeFinal(partida, 3, 1);
		Assert.assertTrue(aposta.resultadoAposta() == 2);
		
		partida.setGols(4, 2);
		aposta = new ApostaOitavasDeFinal(partida, 1, 1);
		Assert.assertTrue(aposta.resultadoAposta() == 0);
		
		partida.setGols(3, 4);
		aposta = new ApostaQuartasDeFinal(partida, 3, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 12);

		partida.setGols(3, 4);
		aposta = new ApostaQuartasDeFinal(partida, 2, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 8);
		
		partida.setGols(3, 4);
		aposta = new ApostaQuartasDeFinal(partida, 2, 3);
		Assert.assertTrue(aposta.resultadoAposta() == 4);
	
		partida.setGols(3, 4);
		aposta = new ApostaQuartasDeFinal(partida, 2, 2);
		Assert.assertTrue(aposta.resultadoAposta() == 0);
	
		partida.setGols(3, 4);
		aposta = new ApostaSemiFinal(partida, 3, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 24);
	
		partida.setGols(3, 4);
		aposta = new ApostaFinal(partida, 3, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 48);
	}

}
