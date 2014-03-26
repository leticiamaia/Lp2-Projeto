package projetoLp2.bolao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class TimeCopa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 553510963983020232L;
	private String nomeDoTime, abreviacaoNomeTime;
	private ImageIcon bandeiraDoTime;
	private List<Partida> partidas;
	private int numVitorias, numDerrotas, numEmpates;
	
	public TimeCopa(String caminhoBandeira, String nomeDoTime, String abreviacaoNomeTime) throws Exception{
		if (caminhoBandeira == null || caminhoBandeira.length() == 0)
			throw new Exception("Caminho da bandeira invalido!");
		if (nomeDoTime == null || nomeDoTime.length() == 0)
			throw new Exception("Nome do time invalido!");
		if (abreviacaoNomeTime == null || abreviacaoNomeTime.length() == 0)
			throw new Exception("Abreciacao do nome do time invalido!");
		if (abreviacaoNomeTime.length() != 3)
			throw new Exception("Abreviacao do nome do time deve ter 3 caracteres!");
		
		try {
			bandeiraDoTime = new ImageIcon(TimeCopa.class.getResource("/projetoLp2/bolao/docs/bandeiras/" + caminhoBandeira));
		} catch (Exception e) {
			throw new Exception("Imagem invalida!");
		}
		
		this.abreviacaoNomeTime = abreviacaoNomeTime.toUpperCase();
		this.nomeDoTime = nomeDoTime;
		partidas = new ArrayList<Partida>();
		numVitorias = 0;
		numDerrotas = 0;
		numEmpates = 0;
	}

	public String getNomeDoTime() {
		return nomeDoTime;
	}
	
	public String getAbreviacaoNomeTime() {
		return abreviacaoNomeTime;
	}

	public ImageIcon getBandeiraDoTime() {
		return bandeiraDoTime;
	}

	public void addPartidaJogada(Partida p) throws Exception{
		if (p == null)
			throw new Exception("Partida invalida!");
		if (!(p.getTime1().equals(this) || p.getTime2().equals(this)))
			throw new Exception("O time nao esta nesta partida!");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((abreviacaoNomeTime == null) ? 0 : abreviacaoNomeTime
						.hashCode());
		result = prime * result
				+ ((nomeDoTime == null) ? 0 : nomeDoTime.hashCode());
		result = prime * result + numDerrotas;
		result = prime * result + numEmpates;
		result = prime * result + numVitorias;
		result = prime * result
				+ ((partidas == null) ? 0 : partidas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeCopa other = (TimeCopa) obj;
		if (abreviacaoNomeTime == null) {
			if (other.abreviacaoNomeTime != null)
				return false;
		} else if (!abreviacaoNomeTime.equals(other.abreviacaoNomeTime))
			return false;
		if (nomeDoTime == null) {
			if (other.nomeDoTime != null)
				return false;
		} else if (!nomeDoTime.equals(other.nomeDoTime))
			return false;
		if (numDerrotas != other.numDerrotas)
			return false;
		if (numEmpates != other.numEmpates)
			return false;
		if (numVitorias != other.numVitorias)
			return false;
		if (partidas == null) {
			if (other.partidas != null)
				return false;
		} else if (!partidas.equals(other.partidas))
			return false;
		return true;
	}
	
	
}
