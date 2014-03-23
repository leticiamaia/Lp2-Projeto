package projetoLp2.tests;

import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Assert;
import org.junit.Test;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

public class TestaTimeCopa {
	@Test
	public void testaConstrutor(){
		try {
			TimeCopa time = new TimeCopa(null, "Alemanha");
		} catch (Exception e) {
			Assert.assertEquals("Caminho da bandeira invalido!", e.getMessage());
		}
		
		try {
			TimeCopa time = new TimeCopa("", "Alemanha");
		} catch (Exception e) {
			Assert.assertEquals("Caminho da bandeira invalido!", e.getMessage());
		}
		
		try {
			TimeCopa time = new TimeCopa("bandeiraAlemanha.png", null);
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}
		
		try {
			TimeCopa time = new TimeCopa("bandeiraAlemanha.png", "");
		} catch (Exception e) {
			Assert.assertEquals("Nome do time invalido!", e.getMessage());
		}
		
		try {
			TimeCopa time = new TimeCopa("bandeiraQueNaoExiste.png", "Time que nao existe");
		} catch (Exception e) {
			Assert.assertEquals("Imagem invalida!", e.getMessage());
		}
		
		try {
			TimeCopa time = new TimeCopa("bandeiraAlemanha.png", "Alemanha");
			Assert.assertEquals(time.getNomeDoTime(), "Alemanha");
			Assert.assertTrue(time.getNumDerrotas() == 0);
			Assert.assertTrue(time.getNumVitorias() == 0);
			Assert.assertTrue(time.getNumEmpates() == 0);
			
			JFrame janela = new JFrame("Bandeira");
			janela.setVisible(true);
			
			JLabel label = new JLabel();
			label.setIcon(time.getBandeiraDoTime());
			
			janela.add(label);
			janela.pack();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testaAddPartidaJogada() throws Exception{
		TimeCopa time1 = new TimeCopa("bandeiraAlemanha.png", "Alemanha");
		TimeCopa time2 = new TimeCopa("bandeiraBrasil.png", "Brasil");
		TimeCopa time3 = new TimeCopa("bandeiraAustralia.png", "Australia");
		Partida partida = new Partida(time1, time2, new GregorianCalendar(2014, 8, 15, 15, 30));
		
		try {
			time1.addPartidaJogada(null);
		} catch (Exception e) {
			Assert.assertEquals("Partida invalida!", e.getMessage());
		}
		
		try {
			time3.addPartidaJogada(partida);
		} catch (Exception e) {
			Assert.assertEquals("O time não esta nesta partida!", e.getMessage());
		}
		
		try {
			time1.addPartidaJogada(partida);
		} catch (Exception e) {
			Assert.assertEquals("Jogo ainda nao foi realizado!", e.getMessage());
		}
		
		try {
			partida.setGols(1, 2);
			Assert.assertTrue(time1.getNumDerrotas() == 1);
			Assert.assertTrue(time2.getNumVitorias() == 1);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
}
