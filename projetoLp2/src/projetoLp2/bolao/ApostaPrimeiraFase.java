package projetoLp2.bolao;

public class ApostaPrimeiraFase extends Aposta{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2863466470604813070L;

	public ApostaPrimeiraFase(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
		super.valorPontuacao = 1;
	}

}
