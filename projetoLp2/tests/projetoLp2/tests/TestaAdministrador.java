package projetoLp2.tests;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

import interfaceGrafica.*;

public class TestaAdministrador {
	
	Administrador admin;
	TimeCopa time1;
	TimeCopa time2;
	GregorianCalendar data;
	Partida[] partidas;
	
	@Before
	public void set() throws Exception {
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
			
			System.out.println(partidas[1].getTime1());
						
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
}
