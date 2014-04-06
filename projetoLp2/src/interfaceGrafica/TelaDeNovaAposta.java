package interfaceGrafica;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.docs.ControladorPartidas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;

public class TelaDeNovaAposta extends JPanel implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private  final JPanel mainPanel;
	final String[] comboItens =  new String[]{"Selecione uma fase","Primeira fase","Oitavas de Final",
			"Quartas de Final","Semi-final","Final"};	
	final JComboBox comboBox = new JComboBox(comboItens);
	final JPanel panelPrimeiraFase, panelOitavaFinal, panelQuartaFinal, panelSemiFinal, panelFinal;

	public TelaDeNovaAposta() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);

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

		panelOitavaFinal = new JPanel(null);
		panelOitavaFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelOitavaFinal, comboItens[2]);

		panelQuartaFinal = new JPanel(null);
		panelQuartaFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelQuartaFinal, comboItens[3]);

		panelSemiFinal = new JPanel(null);
		panelSemiFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelSemiFinal, comboItens[4]);

		panelFinal = new JPanel(null);
		panelFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelFinal, comboItens[4]);

		JLabel testeLabel = new JLabel("Painel Oitava de final");
		testeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		testeLabel.setBounds(281, 103, 278, 16);
		panelOitavaFinal.add(testeLabel);

		JLabel quartaFinal = new JLabel("Painel Quarta de final");
		quartaFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		quartaFinal.setBounds(281, 103, 278, 16);
		panelQuartaFinal.add(quartaFinal);

		ButtonGroup grupo = new ButtonGroup();		

		JScrollPane scrollPrimeiraFase = new JScrollPane(panelPrimeiraFase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollPrimeiraFase, comboItens[1]);

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

		final ArrayList<JRadioButton> radios = new ArrayList<JRadioButton>();

		JButton btnSubmeter = new JButton("Submeter");
		btnSubmeter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < radios.size();i++) {
					if (radios.get(i).isEnabled()) {
						try {
							MeuBolao.apostar(i, 0, 0);
							JOptionPane.showMessageDialog(null, "Aposta feita com sucesso!");
							comboBox.setSelectedItem(comboItens[0]);
							break;
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}

					}
				}

			}
		});
		btnSubmeter.setBounds(523, 617, 89, 23);
		btnSubmeter.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/projetoLp2/bolao/docs/add_small.png")));


		int valor=0;
		for(int i=0; i>= 0/*decideValor()*/ && i < 6/*decideMaiorValor()*/; i++){
			if(ControladorPartidas.ler()[i] != null){
				/*JLabel numLabel = new JLabel(i + 1 + ".");
				numLabel.setBounds(281, 103, 278, 16);
				panelPrimeiraFase.add(numLabel);*/
				JRadioButton time = new JRadioButton();
				grupo.add(time);
				c.gridy = i;
				cons.gridy = i;
				/*decidePanel()*/panelPrimeiraFase.add(ControladorPartidas.ler()[i].panelDaPartida(), c);
				//panelPrimeiraFase.add(numLabel, cons);
				/*decidePanel()*/panelPrimeiraFase.add(time, cons);
				radios.add(time);
				panelPrimeiraFase.add(btnSubmeter, co);
			}
			else {
				JLabel vazioLabel = new JLabel("Nenhum jogo cadastrado para essa fase. Por favor, tente outra!");
				vazioLabel.setBounds(281, 103, 278, 16);
				vazioLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
				panelPrimeiraFase.add(vazioLabel);
			}
			valor = i;
		}
		co.gridy = valor + 1;

		JLabel selecioneFase = new JLabel("Selecione a fase do jogo que voc\u00EA quer apostar:");
		selecioneFase.setBackground(Color.WHITE);
		selecioneFase.setBounds(314, 93, 303, 61);
		add(selecioneFase);
		selecioneFase.setFont(new Font("Tahoma", Font.PLAIN, 13));

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

	private int decideMaiorValor() {
		if(comboBox.getSelectedItem().equals(comboItens[1]))
			return 48;
		else if(comboBox.getSelectedItem().equals(comboItens[2]))
			return 56;
		else if(comboBox.getSelectedItem().equals(comboItens[3]))
			return 60;
		else if(comboBox.getSelectedItem().equals(comboItens[4]))
			return 63;
		else {
			return 64;
		}
	}

	private Container decidePanel() {
		int num = decideMaiorValor();
		if(num == 48) 
			return panelPrimeiraFase;
		else if(num == 56) 
			return panelOitavaFinal;
		else if(num == 60) 
			return panelQuartaFinal;
		else if(num ==63) 
			return panelSemiFinal;
		else
			return panelFinal;
	}

	private int decideValor() {
		if(comboBox.getSelectedItem().equals(comboItens[1]))
			return 0;
		else if(comboBox.getSelectedItem().equals(comboItens[2]))
			return 48;
		else if(comboBox.getSelectedItem().equals(comboItens[3]))
			return 56;
		else if(comboBox.getSelectedItem().equals(comboItens[4]))
			return 60;
		else {
			return 63;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e){
		CardLayout cl = (CardLayout)(mainPanel.getLayout());
		cl.show(mainPanel, (String)e.getItem());
	}
}
