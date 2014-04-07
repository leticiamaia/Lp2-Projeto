package interfaceGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import projetoLp2.bolao.Aposta;
import projetoLp2.bolao.MeuBolao;

public class TelaDeVisualizarAposta extends JPanel implements ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel mainPanel;
	final String[] comboItens =  new String[]{ "Selecione uma fase","Primeira fase","Oitavas de Final",
			"Quartas de Final","Semi-final","Final"};	
	final JComboBox<String> comboBox = new JComboBox<>(comboItens);
	final JPanel panelPrimeiraFase, panelOitavaFinal, panelQuartaFinal, panelSemiFinal, panelFinal;
	
	public TelaDeVisualizarAposta () {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null) ;

		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(234, 165, 822, 452);
		mainPanel.setVisible(true);
		add(mainPanel);
		
		final JPanel panelTeste = new JPanel();
		panelTeste.setBounds(0, 0, 822, 452);
		mainPanel.add(panelTeste, comboItens[0]);
		panelTeste.setLayout(null);

		JLabel tLabel = new JLabel("<html>Para come\u00E7ar, selecione a fase na qual o jogo que voc\u00EA deseja apostar se encontra.</html>");
		tLabel.setBounds(61, 208, 751, 38);
		tLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelTeste.add(tLabel);

		panelPrimeiraFase = new JPanel(new GridBagLayout());
		panelPrimeiraFase.setBounds(0, 0, 822, 452);

		panelOitavaFinal = new JPanel(new GridBagLayout());
		panelOitavaFinal.setBounds(0, 0, 822, 452);

		panelQuartaFinal = new JPanel(new GridBagLayout());
		panelQuartaFinal.setBounds(0, 0, 822, 452);

		panelSemiFinal = new JPanel(new GridBagLayout());
		panelSemiFinal.setBounds(0, 0, 822, 452);

		panelFinal = new JPanel(null);
		panelFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelFinal, comboItens[4]);
		
		ButtonGroup grupo = new ButtonGroup();		

		JScrollPane scrollPrimeiraFase = new JScrollPane(panelPrimeiraFase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollPrimeiraFase, comboItens[1]);

		JScrollPane scrollOitavas = new JScrollPane(panelPrimeiraFase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollOitavas, comboItens[2]);

		JScrollPane scrollQuartas = new JScrollPane(panelPrimeiraFase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollQuartas, comboItens[3]);

		JScrollPane scrollSemi = new JScrollPane(panelPrimeiraFase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add( scrollSemi , comboItens[4]);

		JScrollPane scrollFinal = new JScrollPane(panelPrimeiraFase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollFinal , comboItens[5]);		

		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;
		cons.gridwidth = 1;
		cons.gridx = 0;

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridx = 1;

		GridBagConstraints co = new GridBagConstraints();
		co.fill = GridBagConstraints.CENTER;
		co.gridwidth = 3;
		co.gridx = 1;
		
		JLabel vazioLabel = new JLabel("Nenhum jogo cadastrado para essa fase. Por favor, tente outra!");
		vazioLabel.setBounds(281, 103, 278, 16);
		vazioLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		int valor=0;
		Aposta[] apostas = MeuBolao.getApostas();
		
		for(int i=0;  i < 64; i++) {
			if(apostas[i] != null){
				c.gridy = i;
				cons.gridy = i;
				//decidePanel(i).add(apostas[i].getPanelDaAposta(), c);
				//decidePanel(i).add(time, cons);
			}
		}
	}
	
	private Container decidePanel(int num) {
		if(num < 4) 
			return panelPrimeiraFase;
		else if(num < 10) 
			return panelOitavaFinal;
		else if(num < 60) 
			return panelQuartaFinal;
		else if(num < 63) 
			return panelSemiFinal;
		else
			return panelFinal;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl = (CardLayout)(mainPanel.getLayout());
		cl.show(mainPanel, (String)e.getItem());
	}
}
