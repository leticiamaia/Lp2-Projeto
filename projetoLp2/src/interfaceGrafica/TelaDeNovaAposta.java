package interfaceGrafica;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.CardLayout;
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
	
	public TelaDeNovaAposta() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		final String[] comboItens = new String[]{"Selecione uma fase","Primeira fase","Oitavas de Final",
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
		
		final JPanel panelPrimeiraFase = new JPanel(new GridBagLayout());
		panelPrimeiraFase.setBounds(0, 0, 822, 452);
		
		final JPanel panelOitavaFinal = new JPanel(null);
		panelOitavaFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelOitavaFinal, comboItens[2]);
		
		final JPanel panelQuartaFinal = new JPanel(null);
		panelQuartaFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelQuartaFinal, comboItens[3]);
		
		final JPanel panelSemiFinal = new JPanel(null);
		panelSemiFinal.setBounds(0, 0, 822, 452);
		mainPanel.add(panelSemiFinal, comboItens[4]);
		
		final JPanel panelFinal = new JPanel(null);
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
		
	    JScrollPane area = new JScrollPane(panelPrimeiraFase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    mainPanel.add(area, comboItens[1]);
		
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
		
		int valor=0;
		for(int i=0; i < 48; i++){
			if(ControladorPartidas.ler()[i] != null){
/*				JLabel numLabel = new JLabel(i + 1 + ".");
				numLabel.setBounds(281, 103, 278, 16);
				panelPrimeiraFase.add(numLabel);*/
                JRadioButton time = new JRadioButton();
				grupo.add(time);
				c.gridy = i;
				cons.gridy = i;
			panelPrimeiraFase.add(ControladorPartidas.ler()[i].panelDaPartida(), c);
			//panelPrimeiraFase.add(numLabel, cons);
			panelPrimeiraFase.add(time, cons);
			radios.add(time);
			}
			valor = i;
		}
		co.gridy = valor + 1;
		
		final JComboBox<String> comboBox = new JComboBox<>(comboItens);
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
		
		JButton btnSubmeter = new JButton("Submeter");
		btnSubmeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		panelPrimeiraFase.add(btnSubmeter, co);
		
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
