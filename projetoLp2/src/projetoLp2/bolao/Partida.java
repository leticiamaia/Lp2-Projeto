package projetoLp2.bolao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Partida implements Serializable{

	private static final long serialVersionUID = -2980340733258351497L;
	//Usei o GregorianCalendar, pois quase todos os metodos de Date estao obsoletos.
	GregorianCalendar data;
	TimeCopa time1, time2;
	int golsTime1, golsTime2;
	
	public Partida(TimeCopa time1, TimeCopa time2, GregorianCalendar data) throws Exception{
		if (time1 == null || time2 == null)
			throw new Exception("Time invalido!");
		
		GregorianCalendar dataDeHoje = new GregorianCalendar();
		
		if (data.before(dataDeHoje))
			throw new Exception("Nao e possivel adicionar jogo com data anterior a atual!");
		
		this.data = data;
		this.time1 = time1;
		this.time2 = time2;
		golsTime1 = -1;
		golsTime2 = -1;
	}

	public boolean setGols(int golsTime1, int golsTime2) throws Exception{
		if (golsTime1 < 0 || golsTime2 < 0)
			throw new Exception("Numero de gols invalido!");
		 this.golsTime1 = golsTime1;
		 this.golsTime2 = golsTime2;
		 
		 time1.addPartidaJogada(this);
		 time2.addPartidaJogada(this);
		 
		 return true;
	}

	public String getDataFormatada() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return dataFormatada.format(data.getTimeInMillis()); 
	}

	public GregorianCalendar getData() {
		return data; 
	}
	
	public TimeCopa getTime1() {
		return time1;
	}

	public TimeCopa getTime2() {
		return time2;
	}

	public int getGolsTime1() throws Exception{
		if (golsTime1 == -1)
			throw new Exception("Jogo ainda nao foi realizado!");
		return golsTime1;
	}

	public int getGolsTime2() throws Exception{
		if (golsTime2 == -1)
			throw new Exception("Jogo ainda nao foi realizado!");
		return golsTime2;
	}

	//Metodo para facilitar na avaliacao da aposta
	public int resultado() throws Exception{
		Integer g1 = getGolsTime1();
		Integer g2 = getGolsTime2();
		
		return g1.compareTo(g2);
	}
}
