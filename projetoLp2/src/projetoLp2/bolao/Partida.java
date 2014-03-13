package projetoLp2.bolao;

import java.util.Date;

public class Partida {

	Date data;
	String time1, time2;
	
	public Partida(String time1, String time2, Date data ) throws Exception{
		if (time1.length() == 0 || time2.length() == 0)
			throw new Exception("Nome do time invalido!");
		this.data = data;
		this.time1 = time1;
		this.time2 = time2;
	}

}
