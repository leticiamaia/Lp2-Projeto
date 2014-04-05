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
		ControladorPartidas.escreve(partidas);
		partidas = ControladorPartidas.ler();
	}
}
