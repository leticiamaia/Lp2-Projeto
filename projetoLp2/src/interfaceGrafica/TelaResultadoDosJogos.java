package interfaceGrafica;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.docs.ControladorPartidas;

import javax.swing.JScrollPane;

public class TelaResultadoDosJogos extends JPanel {

	
	JPanel resultadosPanel;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public TelaResultadoDosJogos() throws Exception {
		setVisible(false);
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><center>Resultados dos Jogos</center><html>");
		lblNewLabel.setBounds(41, 11, 382, 74);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		add(lblNewLabel);

		
		JLabel label = new JLabel("");
		label.setBounds(-72, 71, 615, 14);
		label.setIcon(new ImageIcon(TelaResultadoDosJogos.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		add(label);
		
		resultadosPanel = new JPanel(new GridBagLayout());
		resultadosPanel.setBounds(0, 0, 822, 452);
		
		JScrollPane mainScroll = new JScrollPane(resultadosPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainScroll.setBounds(254, 172, 774, 390);
		add(mainScroll);
		mainScroll.setVisible(true);
	
		
		
		atualizaResultados();
	}


			/*if(partidas[i].testaJogoNaoRealizado()) {
				JLabel tLabel = new JLabel("<html>Nenhuma partida ocorreu ainda.</html>");
				tLabel.setBounds(61, 208, 751, 38);
				tLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
				resultadosPanel.add(tLabel);
			}*/

	public void atualizaResultados() throws Exception {
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;
		cons.gridwidth = 1;
		cons.gridx = 0;

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridx = 1;
		
		Partida[] partidas = ControladorPartidas.ler();
		for(int i=0;  i < partidas.length ; i++) {
			if(partidas[i] != null && !partidas[i].testaJogoNaoRealizado()){
				c.gridy = i;
				cons.gridy = i;
				JLabel labelResultado = new JLabel(partidas[i].getResultadoFormatado());
				labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
				resultadosPanel.add(labelResultado, cons);
				resultadosPanel.add(partidas[i].panelDaPartida(), c);
	}
		}
	}
}
	/*	private Object[][] partidasDisponiveis() throws Exception {
			Partida[] partidas = ControladorPartidas.ler();
			Object[][] data = (Object[][]) new Object();
			for(int i=0; i< partidas.length; i++) {
				if(!partidas[i].testaJogoNaoRealizado()){
					data[0][i] = partidas[i].panelDaPartida();
					data[1][i] = partidas[i].getResultadoFormatado();
				}
			}
			return data;
		}*/

		

	
