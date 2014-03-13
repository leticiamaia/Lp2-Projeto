package projetoLp2.bolao;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Partida {

	//Usei o GregorianCalendar, pois quase todos os metodos de Date estao obsoletos.
	GregorianCalendar data;
	String time1, time2;
	int golsTime1, golsTime2;
	
	public Partida(String time1, String time2, GregorianCalendar data) throws Exception{
		if (time1 == null || time2 == null | time1.length() == 0 || time2.length() == 0)
			throw new Exception("Nome do time invalido!");
		
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
		 
		 return true;
	}

	public String getData() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return dataFormatada.format(data.getTimeInMillis()); 
	}

	public String getTime1() {
		return time1;
	}

	public String getTime2() {
		return time2;
	}

	public int getGolsTime1() throws Exception{
		if (golsTime1 == -1)
			throw new Exception("Jogo ainda não foi realizado!");
		return golsTime1;
	}

	public int getGolsTime2() throws Exception{
		if (golsTime2 == -1)
			throw new Exception("Jogo ainda não foi realizado!");
		return golsTime2;
	}
	
}
