package projetoLp2.bolao;

public class ApostaOitavasDeFinal extends Aposta{
	private final int PONTUACAO = 2;
	
	public ApostaOitavasDeFinal(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception {
		super(partida, numGolsTime1, numGolsTime2);
	}

	@Override
	public int resultadoAposta() throws Exception{
		int resultado = 0;
		if (partida.getGolsTime1() == palpiteGolsTime1)
			resultado += PONTUACAO;
		if (partida.getGolsTime2() == palpiteGolsTime2)
			resultado += PONTUACAO;
		if (partida.resultado() == palpiteGanhador())
			resultado += PONTUACAO;
		return resultado;
	}

}
