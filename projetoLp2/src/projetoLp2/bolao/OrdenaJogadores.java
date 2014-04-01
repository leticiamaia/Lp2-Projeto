package projetoLp2.bolao;

import java.util.Comparator;

public class OrdenaJogadores implements Comparator<Jogador> {

	@Override
	public int compare(Jogador arg0, Jogador arg1) {
		
		if (arg0.getPontos() == arg1.getPontos())
			return arg0.getUsername().compareTo(arg1.getUsername());
		
		return arg1.getPontos() - arg0.getPontos();
	}
}
