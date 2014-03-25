package projetoLp2.tests;

import java.util.GregorianCalendar;

import org.junit.Before;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

public class TestaAdministrador {
	
	Administrador admin;
	TimeCopa time1;
	TimeCopa time2;
	GregorianCalendar data;
	@Before
	public void set() throws Exception {
		admin = new Administrador ("admin", "senha");
	    time1 = new TimeCopa("//", "Brasil", "BRA");
	    time1 = new TimeCopa("//", "Brasil", "BRA");
	    data = new GregorianCalendar(2014, 07, 12, 23, 00);
	}/*
	public Partida[] cadastraPartida(int indicePartida, TimeCopa time1,
			TimeCopa time2, GregorianCalendar data) throws Exception {*/
	public void testaCadastrapartida() throws Exception {
		admin.cadastraPartida(1, time1, time2, data);
		data = new GregorianCalendar(2014, 07, 12, 23, 01);
		admin.cadastraPartida(2, time1, time2, data);
	}
	
}
