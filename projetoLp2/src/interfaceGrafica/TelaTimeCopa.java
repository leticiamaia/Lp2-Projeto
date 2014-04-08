package interfaceGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.Collection;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import projetoLp2.bolao.ControladorTimes;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import java.awt.GridBagLayout;

public class TelaTimeCopa extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel mainPanel = new JPanel(new CardLayout());
	private Collection<TimeCopa> listaDeTimes = (Collection<TimeCopa>) ControladorTimes
			.ler().values();
	private final String[] comboItens = arrayComboItens();
	private JComboBox<String> comboBox = new JComboBox<String>(comboItens);
	private TimeCopa timeSelecionadoAtual;
	private JPanel panelDasPartidas = new JPanel();
	private final JPanel panelTeste = new JPanel();
	private final JProgressBar barraEmpate = new JProgressBar(),
			barraVitoria = new JProgressBar(),
			barraDerrota = new JProgressBar();

	/**
	 * Create the panel.
	 */
	public TelaTimeCopa() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		setVisible(false);

		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(234, 165, 822, 452);
		mainPanel.setVisible(true);
		add(mainPanel);

		JLabel timesCopa2014 = new JLabel("Times da Copa 2014");
		timesCopa2014.setBackground(Color.WHITE);
		timesCopa2014.setBounds(10, 11, 492, 61);
		timesCopa2014.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		add(timesCopa2014);

		JLabel divisorHorizontalLabel = new JLabel("");
		add(divisorHorizontalLabel);
		divisorHorizontalLabel.setIcon(new ImageIcon(TelaDoUsuario.class
				.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		divisorHorizontalLabel.setBounds(-88, 59, 700, 21);

		panelTeste.setBounds(0, 0, 822, 452);
		mainPanel.add(panelTeste, comboItens[0]);
		panelTeste.setLayout(null);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTime.setBounds(10, 11, 58, 30);
		panelTeste.add(lblTime);

		final JLabel labelNomeDoTime = new JLabel("");
		labelNomeDoTime.setBounds(130, 11, 192, 30);
		labelNomeDoTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTeste.add(labelNomeDoTime);

		JLabel lblBandeira = new JLabel("Bandeira:");
		lblBandeira.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBandeira.setBounds(10, 51, 90, 30);
		panelTeste.add(lblBandeira);

		final JLabel lblIconeBandeira = new JLabel("");
		lblIconeBandeira.setBounds(130, 46, 90, 45);
		panelTeste.add(lblIconeBandeira);

		JLabel lblNumeroDeVitorias = new JLabel("N\u00B0 Vit\u00F3rias:");
		lblNumeroDeVitorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroDeVitorias.setBounds(10, 92, 90, 30);
		panelTeste.add(lblNumeroDeVitorias);

		final JLabel labelNumeroDeVitorias = new JLabel("");
		labelNumeroDeVitorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumeroDeVitorias.setBounds(130, 92, 58, 33);
		panelTeste.add(labelNumeroDeVitorias);

		JLabel lblNmeroDeDerrotas = new JLabel("N\u00BA de Derrotas:");
		lblNmeroDeDerrotas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroDeDerrotas.setBounds(10, 133, 150, 30);
		panelTeste.add(lblNmeroDeDerrotas);

		final JLabel labelNumeroDeDerrotas = new JLabel("");
		labelNumeroDeDerrotas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumeroDeDerrotas.setBounds(130, 136, 58, 27);
		panelTeste.add(labelNumeroDeDerrotas);

		JLabel lblNDeEmpates = new JLabel("N\u00BA de Empates:");
		lblNDeEmpates.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNDeEmpates.setBounds(10, 174, 118, 30);
		panelTeste.add(lblNDeEmpates);

		final JLabel labelNumeroDeEmpates = new JLabel("");
		labelNumeroDeEmpates.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumeroDeEmpates.setBounds(130, 174, 58, 27);
		panelTeste.add(labelNumeroDeEmpates);

		JLabel lblPartidasJogadas = new JLabel("Partidas Jogadas:");
		lblPartidasJogadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartidasJogadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPartidasJogadas.setBounds(332, 50, 460, 33);
		panelTeste.add(lblPartidasJogadas);

		barraDerrota.setStringPainted(true);
		barraDerrota.setBounds(170, 138, 131, 27);
		panelTeste.add(barraDerrota);

		barraVitoria.setStringPainted(true);
		barraVitoria.setBounds(170, 97, 131, 27);
		panelTeste.add(barraVitoria);
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(332, 94, 428, 347);
				panelTeste.add(scrollPane);
				
						panelDasPartidas = new JPanel(new GridBagLayout());
						scrollPane.setViewportView(panelDasPartidas);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(410, 230, 412, 219);
		panelTeste.add(label_1);
		label_1.setIcon(new ImageIcon(TelaTimeCopa.class.getResource("/projetoLp2/bolao/docs/torcida-vector.png")));

		barraEmpate.setStringPainted(true);
		barraEmpate.setBounds(170, 179, 131, 27);
		panelTeste.add(barraEmpate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaTimeCopa.class.getResource("/projetoLp2/bolao/docs/torcida-vector.png")));
		label.setBounds(0, 215, 452, 234);
		panelTeste.add(label);

		JLabel selecioneFase = new JLabel(
				"Selecione o time que deseja visualizar:");
		selecioneFase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selecioneFase.setBackground(Color.WHITE);
		selecioneFase.setBounds(314, 93, 232, 61);
		add(selecioneFase);

		comboBox.setBounds(552, 111, 366, 26);
		add(comboBox);

		JButton btnOK = new JButton("OK");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timeSelecionadoAtual = (TimeCopa) opcaoComboBox();
				labelNomeDoTime
						.setText(nomeDoTime() + " (" + abrDoTime() + ")");
				lblIconeBandeira.setIcon(iconeDoTime());
				labelNumeroDeVitorias.setText(numeroDeVitorias());
				labelNumeroDeDerrotas.setText(numeroDeDerrotas());
				labelNumeroDeEmpates.setText(numeroDeEmpates());
				barrasDePorcentagem();
				try {
					atualizaResultados();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOK.setBounds(932, 111, 64, 26);
		add(btnOK);
	}

	public void atualizaResultados() throws Exception {
		List<Partida> partidasJogadas = timeSelecionadoAtual
				.getPartidasJogadas();
		panelDasPartidas.repaint();
		panelDasPartidas.removeAll();
		if (partidasJogadas.size() == 0) {
			JLabel label = new JLabel("Nenhum jogo do(a) "
					+ timeSelecionadoAtual.getNomeDoTime() + " foi realizado!");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.setBounds(10, 5, 440, 44);
			panelDasPartidas.add(label);
		} else {
			GridBagConstraints cons = new GridBagConstraints();
			cons.fill = GridBagConstraints.CENTER;
			cons.gridwidth = 1;
			cons.gridx = 1;

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.CENTER;
			c.gridwidth = 2;
			c.gridx = 0;
			for (int i = 0; i < partidasJogadas.size(); i++) {
				if (partidasJogadas.get(i) != null
						&& !partidasJogadas.get(i).testaJogoNaoRealizado()) {
					c.gridy = i;
					cons.gridy = i;
					JLabel labelResultado = new JLabel(partidasJogadas.get(i)
							.getResultadoFormatado());
					labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panelDasPartidas.add(labelResultado, cons);
					panelDasPartidas.add(partidasJogadas.get(i)
							.panelDaPartida(), c);
				}
			}
		}
	}

	private TimeCopa opcaoComboBox() {
		String opcao = (String) comboBox.getSelectedItem();

		for (TimeCopa time : listaDeTimes) {
			if (opcao.equals(time.toString())) {
				return time;
			}
		}
		return null;
	}

	private void barrasDePorcentagem() {
		aumentaBarra(timeSelecionadoAtual.getPorcentagemVitorias(),
				barraVitoria);
		aumentaBarra(timeSelecionadoAtual.getPorcentagemDerrotas(),
				barraDerrota);
		aumentaBarra(timeSelecionadoAtual.getPorcentagemEmpates(), barraEmpate);
	}

	private void aumentaBarra(final int porcentagem, final JProgressBar barra) {
		if (barra.equals(barraVitoria)) {
			if (porcentagem < 50)
				barra.setForeground(Color.RED);
			else
				barra.setForeground(Color.GREEN);
		} else if (barra.equals(barraDerrota)) {
			if (porcentagem < 50)
				barra.setForeground(Color.GREEN);
			else
				barra.setForeground(Color.RED);
		}

		new Thread() {
			public void run() {
				for (int i = 0; i <= porcentagem; i++) {
					try {
						sleep(20);
						barra.setValue(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private String nomeDoTime() {
		if (timeSelecionadoAtual == null)
			return "";
		return timeSelecionadoAtual.getNomeDoTime();
	}

	private String abrDoTime() {
		if (timeSelecionadoAtual == null)
			return "";
		return timeSelecionadoAtual.getAbreviacaoNomeTime();
	}

	private String numeroDeVitorias() {
		if (timeSelecionadoAtual == null)
			return "";
		return timeSelecionadoAtual.getNumVitorias() + "";
	}

	private String numeroDeDerrotas() {
		if (timeSelecionadoAtual == null)
			return "";
		return timeSelecionadoAtual.getNumDerrotas() + "";
	}

	private String numeroDeEmpates() {
		if (timeSelecionadoAtual == null)
			return "";
		return timeSelecionadoAtual.getNumEmpates() + "";
	}

	private String[] arrayComboItens() {
		String[] arrayComboItens = new String[32];

		int i = 0;
		for (TimeCopa time : listaDeTimes) {
			arrayComboItens[i] = time.toString();
			i++;
		}
		return arrayComboItens;
	}

	private Icon iconeDoTime() {
		if (timeSelecionadoAtual == null)
			return null;
		return timeSelecionadoAtual.getBandeiraDoTime();
	}
}