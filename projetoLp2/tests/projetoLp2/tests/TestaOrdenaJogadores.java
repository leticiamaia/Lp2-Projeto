package projetoLp2.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.OrdenaJogadores;

public class TestaOrdenaJogadores {

	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void test() throws Exception {
		List<Jogador> listaDeJogadores = new ArrayList<Jogador>();
		listaDeJogadores.add(new Jogador("Marcela", "MarcelaDosLeites", "a", "a", "a", "a"));
		listaDeJogadores.add(new Jogador("Leticia", "Leticia", "a", "a", "a", "a"));
		listaDeJogadores.add(new Jogador("Lucas", "Lucas", "a", "a", "a", "a"));
		listaDeJogadores.add(new Jogador("Orion", "Orion", "a", "a", "a", "a"));
		
		listaDeJogadores.get(0).setPontos(10);
		listaDeJogadores.get(1).setPontos(9);
		listaDeJogadores.get(2).setPontos(9);
		listaDeJogadores.get(3).setPontos(17);
		
		OrdenaJogadores comparator = new OrdenaJogadores();
		Collections.sort(listaDeJogadores);
		
		Assert.assertEquals("Orion", listaDeJogadores.get(0).getUsername());
		Assert.assertEquals("MarcelaDosLeites", listaDeJogadores.get(1).getUsername());
		Assert.assertEquals("Leticia", listaDeJogadores.get(2).getUsername());
		Assert.assertEquals("Lucas", listaDeJogadores.get(3).getUsername());
		
	}

}
