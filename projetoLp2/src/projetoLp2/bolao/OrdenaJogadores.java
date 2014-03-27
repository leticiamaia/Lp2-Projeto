package projetoLp2.bolao;

import java.util.Comparator;

public class OrdenaJogadores implements Comparator<Jogador> {

	@Override
	public int compare(Jogador arg0, Jogador arg1) {
		
		if (arg0.getPontos() == arg1.getPontos())
			return arg0.getUsername().compareTo(arg1.getUsername());
		
		return arg1.getPontos() - arg0.getPontos();
		
	}
	
	// CONFERIR SE T� CERTO xD
	//no arq usuarios.txt est� uma lista de usuarios ou de jogadores?
	//Preciso que esse m�todo retorne um Jogador, para poder dar um getPontos.
	//Usado em: TelaDoUsuario
	
	/*public Usuario getUsuarioPosicao(int posicaoUsuario) {
		Usuario[] user = null;
		Usuario posUser = null;
		try {
			FileInputStream fin = new FileInputStream("usuarios.bin");
			FileOutputStream fon = new FileOutputStream("usuarios.bin");
			ObjectInputStream ois = new ObjectInputStream(fin);
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			user = (Usuario[]) ois.readObject();

			posUser = user[posicaoUsuario];

			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return (Jogador) posUser;
	}
*/
}
