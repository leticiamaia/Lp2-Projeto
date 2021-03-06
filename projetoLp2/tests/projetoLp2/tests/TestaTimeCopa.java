package projetoLp2.tests;

import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.CriaFile;

public class TestaTimeCopa {
	
	private TimeCopa time1;
	private TimeCopa time2;
	private TimeCopa time3;
	
	@Before
	public void inicializaVariaveis() throws Exception {
		CriaFile.main(null);
		time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ALE");
		time2 = new TimeCopa("bandeiraBrasil.png", "Brasil", "BRA");
		time3 = new TimeCopa("bandeiraAustralia.png", "Australia",
				"AUS");
	}
	@Test
	public void testaConstrutor() throws Exception {
		try {
			new TimeCopa(null, "Alemanha", "ALE");
		} catch (Exception e) {
			Assert.assertEquals("Caminho da bandeira invalido!", e.getMessage());
		}

		try {
			new TimeCopa("", "Alemanha", "ALE");
		} catch (Exception e) {
			Assert.assertEquals("Caminho da bandeira invalido!", e.getMessage());
		}

		try {
			new TimeCopa("bandeiraAlemanha.png", null, "ALE");
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}

		try {
			new TimeCopa("bandeiraAlemanha.png", "", "ALE");
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}

		try {
			new TimeCopa("bandeiraAlemanha.png", "Alemanha", null);
		} catch (Exception e) {
			Assert.assertEquals("Abreciacao do nome do time invalido!",
					e.getMessage());
		}

		try {
			new TimeCopa("bandeiraAlemanha.png", "Alemanha", "");
		} catch (Exception e) {
			Assert.assertEquals("Abreciacao do nome do time invalido!",
					e.getMessage());
		}

		try {
			new TimeCopa("bandeiraAlemanha.png", "Alemanha", "alemanha");
		} catch (Exception e) {
			Assert.assertEquals(
					"Abreviacao do nome do time deve ter 3 caracteres!",
					e.getMessage());
		}

		try {
			new TimeCopa("bandeiraQueNaoExiste.png", "Time que nao existe",
					"ABV");
		} catch (Exception e) {
			Assert.assertEquals("Imagem invalida!", e.getMessage());
		}

		TimeCopa time = new TimeCopa("bandeiraAlemanha.png", "Alemanha", "ale");
		Assert.assertEquals(time.getNomeDoTime(), "Alemanha");
		Assert.assertEquals(time.getAbreviacaoNomeTime(), "ALE");
		Assert.assertTrue(time.getNumDerrotas() == 0);
		Assert.assertTrue(time.getNumVitorias() == 0);
		Assert.assertTrue(time.getNumEmpates() == 0);

		JFrame janela = new JFrame("Bandeira");
		janela.setVisible(true);

		JLabel label = new JLabel();
		label.setIcon(time.getBandeiraDoTime());

		janela.add(label);
		janela.pack();
	}

	@Test
	public void testaAddPartidaJogada() throws Exception {
		Partida partida = new Partida(time1, time2, new GregorianCalendar(2014,
				8, 15, 15, 30));

		try {
			time1.addPartidaJogada(null);
		} catch (Exception e) {
			Assert.assertEquals("Partida invalida!", e.getMessage());
		}

		try {
			time3.addPartidaJogada(partida);
		} catch (Exception e) {
			Assert.assertEquals("O time nao esta nesta partida!",
					e.getMessage());
		}

		try {
			time1.addPartidaJogada(partida);
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}
		
		partida.setGols(1, 2);
		time1.addPartidaJogada(partida);
		time2.addPartidaJogada(partida);
		Assert.assertEquals(time1.getNumDerrotas(), 1);
		Assert.assertEquals(time1.getPorcentagemDerrotas(), 100);
		Assert.assertEquals(time1.getNumVitorias(), 0);
		Assert.assertEquals(time1.getNumEmpates(), 0);
		Assert.assertEquals(time2.getNumVitorias(), 1);
		Assert.assertEquals(time2.getPorcentagemVitorias(), 100);
		Assert.assertEquals(time2.getPorcentagemEmpates(), 0);
	}
	
	@Test
	public void testaCompareTo() throws Exception{		
		Assert.assertEquals(time1.compareTo(time2), -1);
		Assert.assertEquals(time2.compareTo(time2), 0);
		Assert.assertEquals(time2.compareTo(time3), 1);
		Assert.assertEquals(time1.compareTo(time3), -1); 
	}

}
