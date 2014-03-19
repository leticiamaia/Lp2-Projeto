package projetoLp2.bolao;

import java.util.Comparator;

public class OrdenaJogadores implements Comparator<Jogador> {

	@Override
	public int compare(Jogador arg0, Jogador arg1) {
		if (arg0.getPontos() == arg1.getPontos())
			return arg0.getUsername().compareTo(arg1.getUsername());
		else
			return (new Integer(arg0.getPontos())).compareTo(new Integer(arg1
					.getPontos()));
	}

}
