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

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.docs.ControladorPartidas;

public class TelaDeAtualizarPartida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4071085146304599749L;
	private JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public TelaDeAtualizarPartida(final JPanel contentPane) {
		
		this.contentPane = contentPane;
		
		setBounds(0, 0, 1300, 700);	
		setBackground(Color.WHITE);
		setVisible(false);
		setLayout(null);

		JLabel TelaDoAdministradorLabel = new JLabel("Tela de Atualizar Cadastro");
		TelaDoAdministradorLabel.setBounds(502, 23, 378, 52);
		TelaDoAdministradorLabel.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		add(TelaDoAdministradorLabel);
		
		JComboBox partidas = new JComboBox();
		partidas.setBounds(383, 187, 645, 82);
		inicializaComboPartidas(partidas);
		add(partidas);
		
		final JComboBox gols1 = new JComboBox();
		gols1.setBounds(383, 323, 67, 43);
		inicializaCombo(gols1);
		add(gols1);
		
		final JComboBox gols2 = new JComboBox();
		gols2.setBounds(960, 323, 67, 43);
		inicializaCombo(gols2);
		add(gols2);
		
		JLabel lblNewLabel = new JLabel("Gols 1");
		lblNewLabel.setBounds(380, 283, 70, 28);
		add(lblNewLabel);
		
		JLabel label = new JLabel("Gols 2");
		label.setBounds(958, 281, 70, 28);
		add(label);
		
		JButton btnCadastrar = new JButton("ATUALIZAR!");
		btnCadastrar.setBounds(522, 411, 246, 52);
		btnCadastrar.addActionListener(new ActionListener() {
			private Integer nGols1;
			private Integer nGols2;
			private String data;

			public void actionPerformed(ActionEvent arg0) {
				nGols1 = (Integer) gols1.getSelectedItem();
				nGols2 = (Integer) gols2.getSelectedItem();
				JOptionPane.showMessageDialog(null, "Gols1:" + nGols1 + "\n" + "Gols2:" + nGols2);
			}
		});
		add(btnCadastrar);
		
		JButton button = new JButton("voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				contentPane.setVisible(true);
			}
		});
		button.setBounds(518, 521, 246, 52);
		add(button);
		
	}

	private void inicializaComboPartidas(JComboBox partidas) {
		Partida[] partidasDisponiveis;
		ControladorPartidas controlador = new ControladorPartidas();
		partidasDisponiveis = controlador.ler();
		for(int i = 0; i < partidasDisponiveis.length; i++) {
			partidas.addItem(partidasDisponiveis[i]);
		}
		
	}

	private void inicializaCombo(JComboBox gols) {
		for(Integer i = 0; i<=15; i++) {
			gols.addItem(i);
		}
	}
}
