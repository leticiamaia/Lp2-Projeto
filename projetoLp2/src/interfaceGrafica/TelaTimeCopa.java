package interfaceGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projetoLp2.bolao.docs.ControladorTimes;
import projetoLp2.bolao.TimeCopa;

public class TelaTimeCopa extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel mainPanel;
	//private static TimeCopa[] times = (TimeCopa[]) ControladorTimes.ler().values().toArray();
	//private static Map<String, TimeCopa> mapTimes = (Map<String, TimeCopa>) ControladorTimes.ler();
	//private static Collection<TimeCopa> listaDeTimes = (Collection<TimeCopa>) mapTimes.values();
	private static Collection<TimeCopa> listaDeTimes = (Collection<TimeCopa>) ControladorTimes.ler().values();
	private final static String[] comboItens = arrayComboItens();
	
	/**
	 * Create the panel.
	 */
	public TelaTimeCopa() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(234, 165, 822, 452);
		mainPanel.setVisible(true);
		add(mainPanel);
		
		JLabel fazerApostaLabel = new JLabel("Times da Copa 2014");
		fazerApostaLabel.setBackground(Color.WHITE);
		fazerApostaLabel.setBounds(10, 11, 492, 61);
		fazerApostaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		add(fazerApostaLabel);
		
		JLabel divisorHorizontalLabel = new JLabel("");
		add(divisorHorizontalLabel);
		divisorHorizontalLabel.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		divisorHorizontalLabel.setBounds(-88, 59, 700, 21);
		
		final JPanel panelTeste = new JPanel();
		panelTeste.setBounds(0, 0, 822, 452);
		mainPanel.add( panelTeste, comboItens[0]);
		panelTeste.setLayout(null);

		JLabel tLabel = new JLabel("<html>Para come\u00E7ar, selecione time que deseja ver!</html>");
		tLabel.setBounds(218, 21, 385, 38);
		tLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelTeste.add(tLabel);
		
		
	}
	
	private static String[] arrayComboItens(){
		String[] arrayComboItens = new String[33];
		
		arrayComboItens[0] = "Selecione um time";
		
		int i = 1;
		//ordenaTimes();
		for (TimeCopa time : listaDeTimes) {
			arrayComboItens[i] = time.getNomeDoTime();
			i++;
		}
		return arrayComboItens;
	}
	
	/*private static void ordenaTimes(){
		Arrays.sort(arrayTimes);
	}*/
	
	
	public static void main(String[] args) {
		for (int i = 0; i < comboItens.length; i++) {
			System.out.println(comboItens[i]);
		}
	}
}
