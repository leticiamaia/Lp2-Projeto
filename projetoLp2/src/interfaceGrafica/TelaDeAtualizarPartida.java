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

public class TelaDeAtualizarPartida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 213413234132321L;
	private static JPanel contentPane;
	final static JComboBox partidas = new JComboBox();
	/**
	 * Create the panel.
	 */
	public TelaDeAtualizarPartida() {
		
		this.contentPane = contentPane;
		setBounds(0, 0, 816, 361);	
		setBackground(Color.WHITE);
		setVisible(false);
		setLayout(null);

		JLabel TelaDoAdministradorLabel = new JLabel("Tela de Atualizar Cadastro");
		TelaDoAdministradorLabel.setBounds(153, 11, 500, 52);
		TelaDoAdministradorLabel.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		add(TelaDoAdministradorLabel);
		
		
		partidas.setBounds(81, 112, 637, 42);
		inicializaComboPartidas();
		add(partidas);
		
		final JComboBox gols1 = new JComboBox();
		gols1.setBounds(213, 245, 67, 20);
		inicializaCombo(gols1);
		add(gols1);
		
		final JComboBox gols2 = new JComboBox();
		gols2.setBounds(548, 245, 67, 20);
		inicializaCombo(gols2);
		add(gols2);
		
		JLabel lblNewLabel = new JLabel("Gols 1");
		lblNewLabel.setBounds(225, 209, 52, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("Gols 2");
		label.setBounds(562, 213, 67, 20);
		add(label);
		
		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.setIcon(new ImageIcon(TelaDeAtualizarPartida.class.getResource("/projetoLp2/bolao/docs/refresh.png")));
		btnCadastrar.setBounds(271, 316, 127, 34);
		btnCadastrar.addActionListener(new ActionListener() {
			private Integer nGols1;
			private Integer nGols2;
			private String partida;

			public void actionPerformed(ActionEvent arg0) {
				nGols1 = (Integer) gols1.getSelectedItem();
				nGols2 = (Integer) gols2.getSelectedItem();
				partida = (String) partidas.getSelectedItem();
				int idx =  (partida.charAt(0));
				idx -= '0';
				Partida[] partidasDisponiveis;
				partidasDisponiveis = ControladorPartidas.ler();
				try {
					((Administrador)MeuBolao.getUsuarioLogado()).atualizaPartida(idx, nGols1, nGols2);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				ControladorPartidas.escreve(partidasDisponiveis);
				//JOptionPane.showMessageDialog(null, "Gols1:" + nGols1 + "\n" + "Gols2:" + nGols2);
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaDeAtualizarPartida.class.getResource("/projetoLp2/bolao/docs/cancel.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				contentPane.setVisible(true);
			}
		});
		btnVoltar.setBounds(429, 316, 127, 34);
		add(btnVoltar);
		add(btnCadastrar);
		
	}

	public void inicializaComboPartidas() {
		partidas.removeAllItems();
		Partida[] partidasDisponiveis;
		partidasDisponiveis = ControladorPartidas.ler();
		for(Integer i = 0; i < partidasDisponiveis.length && partidasDisponiveis[i] != null; i++) {
			partidas.addItem(i.toString() + ". " + partidasDisponiveis[i].toString());
		}
		
	}
	
	private void inicializaCombo(JComboBox gols) {
		for(Integer i = 0; i<=15; i++) {
			gols.addItem(i);
		}
	}
}
