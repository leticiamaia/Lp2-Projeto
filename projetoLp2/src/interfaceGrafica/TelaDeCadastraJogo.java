package interfaceGrafica;

import java.awt.Color;

import projetoLp2.bolao.Administrador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projetoLp2.bolao.ControladorPartidas;
import projetoLp2.bolao.ControladorTimes;
import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class TelaDeCadastraJogo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 834875740282875192L;

	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TelaDeCadastraJogo(
			final TelaDeAtualizarPartida telaDeAtualizarPartida) {
		setBorder(new LineBorder(new Color(0, 0, 0)));

		setBounds(0, 0, 816, 361);
		setBackground(Color.WHITE);
		setVisible(false);
		setLayout(null);

		JLabel TelaDoAdministradorLabel = new JLabel("Fazer novo cadastro");
		TelaDoAdministradorLabel.setBounds(267, 11, 240, 52);
		TelaDoAdministradorLabel.setFont(new Font("Calibri Light", Font.PLAIN,
				28));
		add(TelaDoAdministradorLabel);

		JLabel lblNewLabel = new JLabel("Time 1");
		lblNewLabel.setBounds(141, 136, 40, 21);
		add(lblNewLabel);

		JLabel lblTime = new JLabel("Time 2");
		lblTime.setBounds(569, 139, 40, 21);
		add(lblTime);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(310, 165, 137, 36);
		add(textField);

		JLabel lblNewLabel_1 = new JLabel("DD/MM/AAAA hh:mm");
		lblNewLabel_1.setBounds(322, 142, 123, 15);
		add(lblNewLabel_1);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaDeCadastraJogo.class
				.getResource("/projetoLp2/bolao/docs/add_small.png")));
		btnCadastrar.setBounds(321, 247, 112, 40);
		add(btnCadastrar);

		final JComboBox<String> comboTime1 = new JComboBox<>();
		comboTime1.setBounds(107, 162, 123, 35);
		adicionaTimesCombo(comboTime1);
		add(comboTime1);

		final JComboBox<String> comboTime2 = new JComboBox<>();
		comboTime2.setBounds(525, 165, 123, 32);
		adicionaTimesCombo(comboTime2);
		add(comboTime2);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaDeCadastraJogo.class
				.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		label_1.setBounds(92, 48, 493, 14);
		add(label_1);

		JLabel lblNotaAdicioneOs = new JLabel(
				"Nota: adicione os jogos na ordem em que eles ir\u00E3o acontecer.");
		lblNotaAdicioneOs.setBounds(222, 67, 371, 14);
		add(lblNotaAdicioneOs);

		btnCadastrar.addActionListener(new ActionListener() {
			private TimeCopa time1;
			private TimeCopa time2;
			private String data;

			public void actionPerformed(ActionEvent arg0) {
				Partida[] partidas = ControladorPartidas.ler();
				Map<String, TimeCopa> times = ControladorTimes.ler();
				time1 = times.get(comboTime1.getSelectedItem());
				time2 = times.get(comboTime2.getSelectedItem());
				data = textField.getText();
				for (int i = 0; i < 64; i++) {
					if (partidas[i] == null) {
						try {
							DateFormat df = new SimpleDateFormat(
									"dd/MM/yyyy hh:mm");
							Date date = df.parse(data);
							GregorianCalendar cal = new GregorianCalendar();
							cal.setTime(date);
							((Administrador) MeuBolao.getUsuarioLogado())
									.cadastraPartida(i, time1, time2, cal);
							telaDeAtualizarPartida.inicializaComboPartidas();
							JOptionPane.showMessageDialog(null,
									"Jogo cadastrado!");
						} catch (ParseException e1) {
							JOptionPane
									.showMessageDialog(null,
											"Data inválida! Por favor siga o formato dd/MM/yyyy hh:mm");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					}
				}
			}
		});
	}

	private void adicionaTimesCombo(JComboBox<String> comboTime) {
		Map<String, TimeCopa> times = ControladorTimes.ler();
		Set<String> times1 = times.keySet();
		Object[] times2 = times1.toArray();
		for (int i = 0; i < times2.length; i++) {
			comboTime.addItem(times2[i].toString());
		}
	}
}
