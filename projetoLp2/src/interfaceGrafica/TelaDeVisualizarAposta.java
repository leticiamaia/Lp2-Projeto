package interfaceGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import projetoLp2.bolao.Aposta;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.docs.ControladorPartidas;

public class TelaDeVisualizarAposta extends JPanel implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private final JPanel mainPanel;
	final String[] comboItens = new String[] { "Selecione uma fase",
			"Primeira fase", "Oitavas de Final", "Quartas de Final",
			"Semi-final", "Final" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	final JComboBox comboBox = new JComboBox(comboItens);
	final JPanel panelPrimeiraFase, panelOitavaFinal, panelQuartaFinal,
			panelSemiFinal, panelFinal;
	final int JOGOS_PRIMEIRA_FASE = 48;
	final int JOGOS_OITAVAS = 56;
	final int JOGOS_QUARTAS = 60;
	final int JOGOS_SEMI = 63;

	public TelaDeVisualizarAposta() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		setVisible(false);

		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(234, 147, 822, 452);
		mainPanel.setVisible(true);
		add(mainPanel);

		final JPanel panelTeste = new JPanel();
		panelTeste.setBounds(0, 0, 822, 452);
		mainPanel.add(panelTeste, comboItens[0]);
		panelTeste.setLayout(null);

		JLabel tLabel = new JLabel(
				"<html>Para come\u00E7ar, selecione a fase na qual o jogo que voc\u00EA deseja visualizar se encontra.</html>");
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

		panelFinal = new JPanel(new GridBagLayout());
		panelFinal.setBounds(0, 0, 822, 452);

		ButtonGroup grupo = new ButtonGroup();

		JScrollPane scrollPrimeiraFase = new JScrollPane(panelPrimeiraFase,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollPrimeiraFase, comboItens[1]);

		JScrollPane scrollOitavas = new JScrollPane(panelOitavaFinal,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollOitavas, comboItens[2]);

		JScrollPane scrollQuartas = new JScrollPane(panelQuartaFinal,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollQuartas, comboItens[3]);

		JScrollPane scrollSemi = new JScrollPane(panelSemiFinal,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollSemi, comboItens[4]);

		JScrollPane scrollFinal = new JScrollPane(panelFinal,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollFinal, comboItens[5]);

		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;
		cons.gridwidth = 1;
		cons.gridx = 0;

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridx = 1;

		final ArrayList<JRadioButton> radios = new ArrayList<JRadioButton>();

		JButton btnSubmeter = new JButton("Cancelar");
		btnSubmeter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Jogador jogador = (Jogador) MeuBolao.getUsuarioLogado();
				for (int i = 0; i < radios.size(); i++) {
					if (radios.get(i).isSelected()) {
						int cont = 0;
						int j = 0;
						for (j = 0; cont < i + 1; j++) {
							if (jogador.getAposta(j) != null)
								cont++;
						}
						try {
							radios.remove(i);
							MeuBolao.CancelarAposta(j - 1);
							JOptionPane.showMessageDialog(null,
									"Sua aposta foi cancelada com sucesso.");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
				}

			}
		});
		add(btnSubmeter);
		btnSubmeter.setBounds(506, 606, 303, 32);
		btnSubmeter.setIcon(new ImageIcon(TelaDeVisualizarAposta.class
				.getResource("/projetoLp2/bolao/docs/cancel.png")));

		JLabel vazioLabel = new JLabel(
				"Nenhum jogo cadastrado para essa fase. Por favor, tente outra!");
		vazioLabel.setBounds(281, 103, 278, 16);
		vazioLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));

		JLabel vazioLabel3 = new JLabel(
				"Nenhum jogo cadastrado para essa fase. Por favor, tente outra!");
		vazioLabel3.setBounds(281, 103, 278, 16);
		vazioLabel3.setFont(new Font("Tahoma", Font.PLAIN, 19));

		JLabel vazioLabel1 = new JLabel(
				"Nenhum jogo cadastrado para essa fase. Por favor, tente outra!");
		vazioLabel1.setBounds(281, 103, 278, 16);
		vazioLabel1.setFont(new Font("Tahoma", Font.PLAIN, 19));

		JLabel vazioLabel2 = new JLabel(
				"Nenhum jogo cadastrado para essa fase. Por favor, tente outra!");
		vazioLabel2.setBounds(281, 103, 278, 16);
		vazioLabel2.setFont(new Font("Tahoma", Font.PLAIN, 19));

		JLabel vazioLabel4 = new JLabel(
				"Nenhum jogo cadastrado para essa fase. Por favor, tente outra!");
		vazioLabel4.setBounds(281, 103, 278, 16);
		vazioLabel4.setFont(new Font("Tahoma", Font.PLAIN, 19));

		Jogador jogador = (Jogador) MeuBolao.getUsuarioLogado();
		for (int i = 0; i < 64; i++) {
			Aposta aposta = jogador.getAposta(i);
			if (aposta != null) {
				JRadioButton time = new JRadioButton();
				grupo.add(time);
				c.gridy = i;
				cons.gridy = i;
				decidePanel(i).add(panelDaPartida(aposta), c);
				decidePanel(i).add(time, cons);
				radios.add(time);
			}
		}

		JLabel selecioneFase = new JLabel(
				"Selecione a fase do jogo que voc\u00EA quer visualizar:");
		selecioneFase.setBackground(Color.WHITE);
		selecioneFase.setBounds(315, 83, 303, 61);
		add(selecioneFase);
		selecioneFase.setFont(new Font("Tahoma", Font.PLAIN, 13));

		comboBox.addItemListener(this);
		comboBox.setBounds(610, 101, 360, 26);
		add(comboBox);

		JLabel fazerApostaLabel = new JLabel("Visualizar/Deletar  Apostas");
		fazerApostaLabel.setBackground(Color.WHITE);
		fazerApostaLabel.setBounds(10, 11, 492, 61);
		add(fazerApostaLabel);
		fazerApostaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));

		JLabel divisorHorizontalLabel = new JLabel("");
		add(divisorHorizontalLabel);
		divisorHorizontalLabel.setIcon(new ImageIcon(TelaDoUsuario.class
				.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		divisorHorizontalLabel.setBounds(-88, 59, 700, 21);

	}

	private JPanel panelDaPartida(Aposta aposta) {
		JPanel mainPanel = new JPanel();
		mainPanel.setVisible(true);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		JPanel container = new JPanel();
		container.setVisible(true);

		JPanel containerData = new JPanel();
		containerData.setVisible(true);

		Partida partida = ControladorPartidas.ler()[aposta.getIndice()];

		container.add(new JLabel(partida.getTime1().getBandeiraDoTime()));
		container.add(new JLabel(partida.getTime1().getAbreviacaoNomeTime()
				+ " X"));
		container.add(new JLabel(partida.getTime2().getAbreviacaoNomeTime()));
		container.add(new JLabel(partida.getTime2().getBandeiraDoTime()));
		container.add(new JLabel(aposta.getPalpiteGolsTime1() + ""));
		container.add(new JLabel(aposta.getPalpiteGolsTime2() + ""));

		JLabel data = new JLabel(partida.getDataFormatada());
		data.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mainPanel.add(container);
		containerData.add(data);
		mainPanel.add(containerData);

		return mainPanel;
	}

	private Container decidePanel(int num) {

		if (num < JOGOS_PRIMEIRA_FASE)
			return panelPrimeiraFase;
		else if (num < JOGOS_OITAVAS)
			return panelOitavaFinal;
		else if (num < JOGOS_QUARTAS)
			return panelQuartaFinal;
		else if (num < JOGOS_SEMI)
			return panelSemiFinal;
		else
			return panelFinal;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl = (CardLayout) (mainPanel.getLayout());
		cl.show(mainPanel, (String) e.getItem());
	}
}
