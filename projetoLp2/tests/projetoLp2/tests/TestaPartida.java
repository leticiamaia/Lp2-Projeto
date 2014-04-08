package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

public class TestaPartida {

	private TimeCopa time1;
	private TimeCopa time2;
	private Partida partida;

	@Before
	public void inicializaTimes() throws Exception {
		time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15,
				15, 30));
	}

	@Test
	public void testaConstrutor() throws Exception {
		try {
			new Partida(null, time2, new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Time invalido!", e.getMessage());
		}

		try {
			new Partida(time2, null, new GregorianCalendar());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Time invalido!", e.getMessage());
		}

		/*
		 * try { new Partida(time1, time2, new GregorianCalendar(2000, 2, 13,
		 * 15, 30)); Assert.fail(); } catch (Exception e) { Assert.assertEquals(
		 * "Nao e possivel adicionar jogo com data anterior a atual!",
		 * e.getMessage()); }
		 */

		Assert.assertEquals("Alemanha", partida.getTime1().getNomeDoTime());
		Assert.assertEquals("Brasil", partida.getTime2().getNomeDoTime());
		Assert.assertEquals("15/09/2014 03:30", partida.getDataFormatada());
	}

	@Test
	public void testaSetGols() throws Exception {
		try {
			partida.setGols(-1, 3);
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}

		try {
			Partida partida = new Partida(time1, time2, new GregorianCalendar(
					2014, 8, 15, 15, 30));
			partida.setGols(1, -3);
		} catch (Exception e) {
			Assert.assertEquals("Numero de gols invalido!", e.getMessage());
		}

		partida.setGols(1, 3);
		time1.addPartidaJogada(partida);
		time2.addPartidaJogada(partida);
		Assert.assertEquals(partida.getGolsTime1(), 1);
		Assert.assertEquals(partida.getGolsTime2(), 3);
		Assert.assertEquals(time1.getNumDerrotas(), 1);
		Assert.assertEquals(time2.getNumVitorias(), 1);

	}

	@Test
	public void testaCompareTo() throws Exception {
		try {
			partida.resultado();
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}

		partida.setGols(1, 1);
		Assert.assertEquals(partida.resultado(), 0);

		partida.setGols(2, 1);
		Assert.assertEquals(partida.resultado(), 1);

		partida.setGols(1, 2);
		Assert.assertEquals(partida.resultado(), -1);
	}

	@Test
	public void testaJogoNaoRealizado() throws Exception {
		Assert.assertTrue(partida.testaJogoNaoRealizado());
		partida.setGols(2, 0);
		Assert.assertFalse(partida.testaJogoNaoRealizado());
	}

	@Test
	public void testaResultadoFormatado() throws Exception {
		Assert.assertEquals(partida.getResultadoFormatado(), "-1 X -1");
		partida.setGols(2, 2);
		Assert.assertEquals(partida.getResultadoFormatado(), "2 X 2");
	}

}
