package interfaceGrafica;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.ControladorPartidas;
import projetoLp2.bolao.docs.ControladorTimes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.GregorianCalendar;
import javax.swing.JScrollBar;
import java.awt.Insets;

public class TelaDeNovaAposta extends JPanel implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	private  final JPanel mainPanel;
	
	public TelaDeNovaAposta() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		String[] comboItens = new String[]{"Selecione uma fase","Primeira fase","Oitavas de Final",
				"Quartas de Final","Semi-final","Final"};		
		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(234, 165, 822, 452);
		mainPanel.setVisible(true);
		add(mainPanel);
		
		final JPanel panelTeste = new JPanel();
		panelTeste.setBounds(0, 0, 822, 452);
		mainPanel.add( panelTeste, comboItens[0]);
		panelTeste.setLayout(null);
		
		JLabel tLabel = new JLabel("<html>Para come\u00E7ar, selecione a fase na qual o jogo que voc\u00EA deseja apostar se encontra.</html>");
		tLabel.setBounds(61, 208, 751, 38);
		tLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelTeste.add(tLabel);
		
		final JPanel panelPrimeiraFase = new JPanel();
		panelPrimeiraFase.setBounds(0, 0, 822, 452);
		mainPanel.add(panelPrimeiraFase, comboItens[1]);
		
		final JPanel panelOitavaFinal = new JPanel(null);
		panelOitavaFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelOitavaFinal, comboItens[2]);
		
		JLabel testeLabel = new JLabel("Painel Oitava de final");
		testeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		testeLabel.setBounds(281, 103, 278, 16);
		panelOitavaFinal.add(testeLabel);
		
		ButtonGroup grupo = new ButtonGroup();		
		
		GridBagConstraints cons = new GridBagConstraints();
		cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.LINE_START;
		cons.gridwidth = 1;
		cons.gridx = 0;
		
		GridBagConstraints c = new GridBagConstraints();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridx = 1;
		
		for(int i=0; i < 48; i++){
			if(ControladorPartidas.ler()[i] != null){
				JLabel numLabel = new JLabel(i + 1 + ".");
				numLabel.setBounds(281, 103, 278, 16);
				panelPrimeiraFase.add(numLabel);
              /*JRadioButton time = new JRadioButton();
				grupo.add(time);*/
				c.gridy = i;
				cons.gridy = i;
			panelPrimeiraFase.add(ControladorPartidas.ler()[i].panelDaPartida(), c);
			panelPrimeiraFase.add(numLabel, cons);
			}
		}

		final JComboBox comboBox = new JComboBox(comboItens);
		comboBox.addItemListener(this);
		comboBox.setBounds(600, 110, 360, 26);
		add(comboBox);

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
	
	@Override
	public void itemStateChanged(ItemEvent e){
		CardLayout cl = (CardLayout)(mainPanel.getLayout());
		cl.show(mainPanel, (String)e.getItem());
	}
}
