package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.docs.ControladorPartidas;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class TelaDeAtualizarPartida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 213413234132321L;
	final static JComboBox<String> partidas = new JComboBox<>();

	/**
	 * Create the panel.
	 */
	public TelaDeAtualizarPartida() {
		setBorder(new LineBorder(new Color(0, 0, 0)));

		setBounds(0, 0, 816, 361);
		setBackground(Color.WHITE);
		setVisible(false);
		setLayout(null);

		JLabel TelaDoAdministradorLabel = new JLabel("Atualizar Cadastro");
		TelaDoAdministradorLabel.setBounds(312, 11, 247, 52);
		TelaDoAdministradorLabel.setFont(new Font("Calibri Light", Font.PLAIN,
				28));
		add(TelaDoAdministradorLabel);

		partidas.setBounds(96, 139, 622, 25);
		inicializaComboPartidas();
		add(partidas);

		final JComboBox<Integer> gols1 = new JComboBox<>();
		gols1.setBounds(185, 223, 83, 20);
		inicializaCombo(gols1);
		add(gols1);

		final JComboBox<Integer> gols2 = new JComboBox<>();
		gols2.setBounds(526, 223, 83, 20);
		inicializaCombo(gols2);
		add(gols2);

		JLabel lblNewLabel = new JLabel("Gols 1");
		lblNewLabel.setBounds(214, 201, 35, 25);
		add(lblNewLabel);

		JLabel label = new JLabel("Gols 2");
		label.setBounds(551, 203, 42, 20);
		add(label);

		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.setIcon(new ImageIcon(TelaDeAtualizarPartida.class
				.getResource("/projetoLp2/bolao/docs/refresh.png")));
		btnCadastrar.setBounds(332, 291, 159, 42);
		btnCadastrar.addActionListener(new ActionListener() {
			private Integer nGols1;
			private Integer nGols2;
			private String partida;

			public void actionPerformed(ActionEvent arg0) {
				nGols1 = (Integer) gols1.getSelectedItem();
				nGols2 = (Integer) gols2.getSelectedItem();
				partida = (String) partidas.getSelectedItem();
				int idx = (partida.charAt(0));
				idx -= '0';
				Partida[] partidasDisponiveis;
				partidasDisponiveis = ControladorPartidas.ler();
				try {
					if (partidasDisponiveis[idx - 1].testaJogoNaoRealizado()) {
						((Administrador) MeuBolao.getUsuarioLogado())
								.atualizaPartida(idx - 1, nGols1, nGols2);
						JOptionPane.showMessageDialog(null,
								"Jogo Atualizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null,
								"Jogo ja atualizado!");
					}
				} catch (Exception e) {
					// e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		add(btnCadastrar);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaDeAtualizarPartida.class
				.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		label_1.setBounds(157, 49, 500, 14);
		add(label_1);

		JLabel lblSelecioneOJogo = new JLabel(
				"Selecione o jogo que deseja atualizar:");
		lblSelecioneOJogo.setBounds(312, 122, 261, 14);
		add(lblSelecioneOJogo);

		JLabel lblNotaAtualizeOs = new JLabel(
				"Nota: atualize os jogos na ordem em que eles ocorreram.");
		lblNotaAtualizeOs.setBounds(275, 62, 282, 14);
		add(lblNotaAtualizeOs);

	}

	public void inicializaComboPartidas() {
		partidas.removeAllItems();
		Partida[] partidasDisponiveis;
		partidasDisponiveis = ControladorPartidas.ler();
		for (Integer i = 0; i < partidasDisponiveis.length
				&& partidasDisponiveis[i] != null; i++) {
			partidas.addItem(i + 1 + ". " + partidasDisponiveis[i].toString()
					+ " - " + partidasDisponiveis[i].getDataFormatada());
		}

	}

	private void inicializaCombo(JComboBox<Integer> gols) {
		for (Integer i = 0; i <= 15; i++) {
			gols.addItem(i);
		}
	}
}
