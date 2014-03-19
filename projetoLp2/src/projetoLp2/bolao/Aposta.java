package projetoLp2.bolao;

public abstract class Aposta {

	protected Partida partida;
	protected int palpiteGolsTime1, palpiteGolsTime2, valorPontuacao;
	
	public Aposta(Partida partida, int numGolsTime1, int numGolsTime2) throws Exception{
		if (partida == null)
			throw new Exception("Partida invalida!");
		
		setPalpiteGolsTime1(numGolsTime1);
		setPalpiteGolsTime2(numGolsTime2);		
		this.partida = partida;
	}
	
	public int getPalpiteGolsTime1() {
		return palpiteGolsTime1;
	}
	
	public void setPalpiteGolsTime1(int palpiteGolsTime1) throws Exception {
		if (palpiteGolsTime1 < 0)
			throw new Exception("Palpite de gols invalido!");
		this.palpiteGolsTime1 = palpiteGolsTime1;
	}
	
	public int getPalpiteGolsTime2() {
		return palpiteGolsTime2;
	}
	
	public void setPalpiteGolsTime2(int palpiteGolsTime2) throws Exception {
		if (palpiteGolsTime2 < 0)
			throw new Exception("Palpite de gols invalido!");
		this.palpiteGolsTime2 = palpiteGolsTime2;
	}
	
	protected int palpiteGanhador(){
		Integer p1 = palpiteGolsTime1;
		Integer p2 = palpiteGolsTime2;
		
		return p1.compareTo(p2);
	}
	
	public int resultadoAposta() throws Exception{
		int resultado = 0;
		if (partida.getGolsTime1() == palpiteGolsTime1)
			resultado += valorPontuacao;
		if (partida.getGolsTime2() == palpiteGolsTime2)
			resultado += valorPontuacao;
		if (partida.resultado() == palpiteGanhador())
			resultado += valorPontuacao;
		return resultado;
	}
	
}
