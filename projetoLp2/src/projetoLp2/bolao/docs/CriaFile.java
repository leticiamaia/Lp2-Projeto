package projetoLp2.bolao.docs;

import java.util.ArrayList;
import java.util.List;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.Partida;

public class CriaFile {

	public static void main(String[] args) throws Exception {
		
		Administrador admin = new Administrador("admin", "1234");
		ControladorAdmin.escreve(admin);
		
		List<Jogador> jogadores = new ArrayList<Jogador>();
		ControladorJogador.escreve(jogadores);

		Partida[] partidas = new Partida[64];
		ControladorPartidas.escreve(partidas);
		
	}
}
