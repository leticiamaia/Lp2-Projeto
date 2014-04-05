package interfaceGrafica;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TelaDeNovaAposta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	String itemSelecionado;
	
	public TelaDeNovaAposta() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		String[] comboItens = new String[]{"Selecione uma fase","Primeira fase","Oitavas de Final",
				"Quartas de Final","Semi-final","Final"};
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(234, 165, 822, 452);
		add(panel, comboItens[0]);
		
		final JPanel panelPrimeiraFase = new JPanel(new CardLayout());
		panelPrimeiraFase.setBounds(0, 0, 822, 452);
		panel.add(panelPrimeiraFase, comboItens[1]);
		
		JLabel testLabel = new JLabel("Selecione a fase do jogo que voc\u00EA quer apostar:");
		testLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		testLabel.setBounds(281, 103, 278, 16);
		panelPrimeiraFase.add(testLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaDeNovaAposta.class.getResource("/projetoLp2/bolao/docs/SoccerDukeSmall.png")));
		label.setBounds(154, 103, 291, 251);
		panelPrimeiraFase.add(label);
		
		JLabel tLabel = new JLabel("Isso mesmo, ai sim");
		tLabel.setBounds(0, 0, 822, 452);
		panel.add(tLabel);
		tLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JComboBox<String> comboBox = new JComboBox<>(comboItens);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				((CardLayout) panel.getLayout()).show(panel, (String)arg0.getItem());
			}
		});
		comboBox.setBounds(600, 110, 360, 26);
		add(comboBox);
		
		JLabel lblSelecioneAFase = new JLabel("Selecione a fase do jogo que voc\u00EA quer apostar:");
		lblSelecioneAFase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelecioneAFase.setBounds(320, 112, 385, 20);
		add(lblSelecioneAFase);

		JLabel fazerApostaLabel = new JLabel("Fazer uma Nova Aposta");
		fazerApostaLabel.setBackground(Color.WHITE);
		fazerApostaLabel.setBounds(10, 11, 492, 61);
		 add(fazerApostaLabel);
		fazerApostaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		
		JLabel divisorHorizontalLabel = new JLabel("");
		add(divisorHorizontalLabel);
		divisorHorizontalLabel.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		divisorHorizontalLabel.setBounds(-88, 59, 700, 21);
		
	/*	itemSelecionado = (String) comboBox.getSelectedItem();
		if(!itemSelecionado.equals("Selecione uma fase") && itemSelecionado.equals("Primeira Fase"))
			panelPrimeiraFase.setVisible(true);*/
		
	}
}
