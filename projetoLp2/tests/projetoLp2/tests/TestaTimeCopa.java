package projetoLp2.tests;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Assert;
import org.junit.Test;

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

}
