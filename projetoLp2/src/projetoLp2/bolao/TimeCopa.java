package projetoLp2.bolao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class TimeCopa {
	private String nomeDoTime;
	private ImageIcon bandeiraDoTime;
	private List<Partida> partidas;
	private int numVitorias, numDerrotas, numEmpates;
	
	public TimeCopa(String caminhoBandeira, String nomeDoTime) throws Exception{
		if (caminhoBandeira == null || caminhoBandeira.length() == 0)
			throw new Exception("Caminho da bandeira invalido!");
		if (nomeDoTime == null || nomeDoTime.length() == 0)
			throw new Exception("Nome do time invalido!");
		
		try {
			bandeiraDoTime = new ImageIcon(TimeCopa.class.getResource("/projetoLp2/bolao/docs/bandeiras/" + caminhoBandeira));
		} catch (Exception e) {
			throw new Exception("Imagem invalida!");
		}
		
		this.nomeDoTime = nomeDoTime;
		partidas = new ArrayList<Partida>();
		numVitorias = 0;
		numDerrotas = 0;
		numEmpates = 0;
	}

	public String getNomeDoTime() {
		return nomeDoTime;
	}

	public ImageIcon getBandeiraDoTime() {
		return bandeiraDoTime;
	}

	public void addPartidaJogada(Partida p) throws Exception{
		if (p == null)
			throw new Exception("Partida invalida!");
		if (!(p.getTime1().equals(nomeDoTime) || p.getTime2().equals(nomeDoTime)))
			throw new Exception("O time não esta nesta partida!");
		try {
			p.getGolsTime1();
		} catch (Exception e) {
			throw e;
		}
		
		partidas.add(p);
		
		if (p.getTime1().equals(nomeDoTime)){
			if (p.resultado() == 1)
				numVitorias++;
			else if (p.resultado() == 0)
				numEmpates++;
			else
				numDerrotas++;
		}
		else if (p.getTime2().equals(nomeDoTime)){
			if (p.resultado() == -1)
				numVitorias++;
			else if (p.resultado() == 0)
				numEmpates++;
			else
				numDerrotas++;
		}
	}

	public int getNumVitorias() {
		return numVitorias;
	}

	public int getNumDerrotas() {
		return numDerrotas;
	}

	public int getNumEmpates() {
		return numEmpates;
	}
	
	
}
