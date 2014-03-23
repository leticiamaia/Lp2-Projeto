package projetoLp2.bolao;

import javax.swing.ImageIcon;

public class TimeCopa {
	String nomeDoTime;
	ImageIcon bandeiraDoTime;
	
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
	}

	public String getNomeDoTime() {
		return nomeDoTime;
	}

	public ImageIcon getBandeiraDoTime() {
		return bandeiraDoTime;
	}

}
