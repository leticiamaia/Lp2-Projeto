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
		partidas[3] = new Partida(times.get("ARG"), times.get("AGL"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[4] = new Partida(times.get("JAP"), times.get("EUA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[5] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[6] = new Partida(times.get("ARG"), times.get("AGL"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[7] = new Partida(times.get("JAP"), times.get("EUA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[8] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[9] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[10] = new Partida(times.get("ARG"), times.get("AGL"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[11] = new Partida(times.get("JAP"), times.get("EUA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[12] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[13] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[14] = new Partida(times.get("ARG"), times.get("AGL"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[15] = new Partida(times.get("JAP"), times.get("EUA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[16] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[17] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[18] = new Partida(times.get("ARG"), times.get("AGL"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[19] = new Partida(times.get("JAP"), times.get("EUA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[20] = new Partida(times.get("RUS"), times.get("BRA"), new GregorianCalendar(2014, 8, 15, 15, 30));
		ControladorPartidas.escreve(partidas);
		partidas = ControladorPartidas.ler();
	}
}
