package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.Aposta;
import projetoLp2.bolao.ApostaFinal;
import projetoLp2.bolao.ApostaOitavasDeFinal;
import projetoLp2.bolao.ApostaPrimeiraFase;
import projetoLp2.bolao.ApostaQuartasDeFinal;
import projetoLp2.bolao.ApostaSemiFinal;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.ControladorPartidas;

public class TestaAposta {
	
	TimeCopa time1;
	TimeCopa time2;
	Partida partida;
	
	@Before
	public void inicializaTime() throws Exception {
		time1 = new TimeCopa("bandeiraHolanda.png", "Holanda", "HOL");
		time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
	}

	@Test
	public void testaConstrutor() throws Exception {

		try {
			new ApostaPrimeiraFase(-1, 1, 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Partida invalida!", e.getMessage());
		}

		try {
			new ApostaPrimeiraFase(0, -1, 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}

		try {
			new ApostaPrimeiraFase(0, 1, -2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Palpite de gols invalido!", e.getMessage());
		}
		
		Aposta aposta = new ApostaPrimeiraFase(0, 1, 2);
		Assert.assertTrue(aposta.getPalpiteGolsTime1() == 1);
		Assert.assertTrue(aposta.getPalpiteGolsTime2() == 2);
	}

	@Test
	public void testaSetPalpite() throws Exception {
		Aposta aposta = new ApostaPrimeiraFase(0, 1, 2);

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
		
		Partida[] partidas= ControladorPartidas.ler();
		partidas[0] = partida;
		ControladorPartidas.escreve(partidas);
		
		try {
			Aposta aposta = new ApostaOitavasDeFinal(0, 1, 1);
			aposta.resultadoAposta();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}

		partida.setGols(3, 3);
		partidas= ControladorPartidas.ler();
		partidas[0] = partida;
		ControladorPartidas.escreve(partidas);
		
		Aposta aposta = new ApostaPrimeiraFase(0, 5, 5);
		Assert.assertTrue(aposta.resultadoAposta() == 1);


		aposta = new ApostaPrimeiraFase(0, 3, 3);
		Assert.assertTrue(aposta.resultadoAposta() == 3);

	
		aposta = new ApostaPrimeiraFase(0, 4, 5);
		Assert.assertTrue(aposta.resultadoAposta() == 0);
	
		
		aposta = new ApostaPrimeiraFase(0, 3, 5);
		Assert.assertTrue(aposta.resultadoAposta() == 1);
		
		aposta = new ApostaPrimeiraFase(0, 5, 3);
		Assert.assertTrue(aposta.resultadoAposta() == 1);
		
		partida.setGols(4, 2);
		partidas= ControladorPartidas.ler();
		partidas[0] = partida;
		ControladorPartidas.escreve(partidas);
		
		aposta = new ApostaOitavasDeFinal(0, 4, 2);
		Assert.assertTrue(aposta.resultadoAposta() == 6);
		
		aposta = new ApostaOitavasDeFinal(0, 3, 2);
		Assert.assertTrue(aposta.resultadoAposta() == 4);
		
		aposta = new ApostaOitavasDeFinal(0, 3, 1);
		Assert.assertTrue(aposta.resultadoAposta() == 2);
		
		aposta = new ApostaOitavasDeFinal(0, 1, 1);
		Assert.assertTrue(aposta.resultadoAposta() == 0);
		
		partida.setGols(3, 4);
		partidas= ControladorPartidas.ler();
		partidas[0] = partida;
		ControladorPartidas.escreve(partidas);
		
		aposta = new ApostaQuartasDeFinal(0, 3, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 12);

		aposta = new ApostaQuartasDeFinal(0, 2, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 8);
		
		aposta = new ApostaQuartasDeFinal(0, 2, 3);
		Assert.assertTrue(aposta.resultadoAposta() == 4);
	
		aposta = new ApostaQuartasDeFinal(0, 2, 2);
		Assert.assertTrue(aposta.resultadoAposta() == 0);
	
		aposta = new ApostaSemiFinal(0, 3, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 24);
	
		aposta = new ApostaFinal(0, 3, 4);
		Assert.assertTrue(aposta.resultadoAposta() == 48);
	}

}
