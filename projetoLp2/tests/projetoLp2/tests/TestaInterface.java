package projetoLp2.tests;

import java.util.GregorianCalendar;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.docs.ControladorPartidas;
import projetoLp2.bolao.docs.ControladorTimes;

public class TestaInterface {
	static Partida[] partidas;
	public static void main(String[] args) throws Exception {
		partidas = ControladorPartidas.ler();
		partidas[0] = new Partida(ControladorTimes.ler()[0], ControladorTimes.ler()[1], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[1] = new Partida(ControladorTimes.ler()[2], ControladorTimes.ler()[3], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[2] = new Partida(ControladorTimes.ler()[4], ControladorTimes.ler()[5], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[3] = new Partida(ControladorTimes.ler()[6], ControladorTimes.ler()[7], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[4] = new Partida(ControladorTimes.ler()[8], ControladorTimes.ler()[8], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[5] = new Partida(ControladorTimes.ler()[14], ControladorTimes.ler()[15], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[6] = new Partida(ControladorTimes.ler()[11], ControladorTimes.ler()[12], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[7] = new Partida(ControladorTimes.ler()[16], ControladorTimes.ler()[17], new GregorianCalendar(2014, 8, 15, 15, 30));		
		partidas[8] = new Partida(ControladorTimes.ler()[18], ControladorTimes.ler()[19], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[9] = new Partida(ControladorTimes.ler()[20], ControladorTimes.ler()[21], new GregorianCalendar(2014, 8, 15, 15, 30));
		partidas[10] = new Partida(ControladorTimes.ler()[22], ControladorTimes.ler()[23], new GregorianCalendar(2014, 8, 15, 15, 30));
		ControladorPartidas.escreve(partidas);
		partidas = ControladorPartidas.ler();
	}
}
