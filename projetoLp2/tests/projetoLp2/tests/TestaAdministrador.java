package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

public class TestaAdministrador {
	
	Administrador admin;
	TimeCopa time1;
	TimeCopa time2;
	GregorianCalendar data;
	Partida[] partidas;
	
	@Before
	public void set() throws Exception {
		admin = new Administrador ("admin", "senha");
	    time1 = new TimeCopa("//", "Brasil", "BRA");
	    time2 = new TimeCopa("//", "Brasil", "BRA");
	    data = new GregorianCalendar(2014, 07, 12, 23, 00);
	}/*
	public Partida[] cadastraPartida(int indicePartida, TimeCopa time1,
			TimeCopa time2, GregorianCalendar data) throws Exception {*/
	@Test
	public void testaCadastrapartida() throws Exception {
		partidas = admin.cadastraPartida(1, time1, time2, data);
		Assert.assertEquals(partidas[1].getTime1(), time1);
		Assert.assertEquals(partidas[1].getTime2(), time2);
		Assert.assertEquals(partidas[1].getData(), data);
	}
	
}
