package projetoLp2.tests;

import java.util.GregorianCalendar;
import java.util.Map;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.ControladorPartidas;
import projetoLp2.bolao.docs.ControladorTimes;

public class TestaInterface {
	static Partida[] partidas;
	public static void main(String[] args) throws Exception {
		partidas = ControladorPartidas.ler();
		Map<String, TimeCopa> times= ControladorTimes.ler();
		
		partidas[0] = new Partida(times.get("ARG"), times.get("AGL"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[1] = new Partida(times.get("JAP"), times.get("EUA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[2] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		ControladorPartidas.escreve(partidas);
		partidas = ControladorPartidas.ler();
	}
}
