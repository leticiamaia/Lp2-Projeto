package interfaceGrafica;

import java.awt.Color;
import projetoLp2.bolao.Administrador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import projetoLp2.bolao.MeuBolao;
import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.ControladorPartidas;
import projetoLp2.bolao.docs.ControladorTimes;

public class TelaDeCadastraJogo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 834875740282875192L;

	private JPanel contentPane;
	private JPanel telaDeAtulizarPartida;
	private JTextField textField;
	
	/**
	 * Create the panel.
	 */
	public TelaDeCadastraJogo(final JPanel contentPane, final TelaDeAtualizarPartida telaDeAtualizarPartida) {
		
		this.contentPane = contentPane;
		setBounds(0, 0, 816, 361);
		this.telaDeAtulizarPartida = telaDeAtualizarPartida;
		setBackground(Color.WHITE);
		setVisible(false);
		setLayout(null);

		JLabel TelaDoAdministradorLabel = new JLabel("Tela de Cadastro");
		TelaDoAdministradorLabel.setBounds(502, 23, 378, 52);
		TelaDoAdministradorLabel.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		add(TelaDoAdministradorLabel);

		JLabel lblNewLabel = new JLabel("Time1");
		lblNewLabel.setBounds(286+33, 250, 223, 40);
		add(lblNewLabel);

		JLabel label = new JLabel("Time2");
		label.setBounds(791+45, 250, 223, 40);
		add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(577, 302, 137, 36);
		add(textField);

		JLabel lblNewLabel_1 = new JLabel("DD/MM/AAAA hh:mm");
		lblNewLabel_1.setBounds(577, 263, 187, 15);
		add(lblNewLabel_1);

		JButton btnCadastrar = new JButton("CADASTRAR!");
		btnCadastrar.setBounds(522, 411, 246, 52);
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
		
		final JComboBox comboTime1 = new JComboBox();
		comboTime1.setBounds(319, 302, 143, 36);
		adicionaTimesCombo(comboTime1);
		add(comboTime1);
		
		final JComboBox comboTime2 = new JComboBox();
		comboTime2.setBounds(836, 302, 143, 36);
		adicionaTimesCombo(comboTime2);
		add(comboTime2);
		
		
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
				for(int i = 0; i < 64; i++) {
					if(partidas[i] == null) {
						try {
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
							Date date = df.parse(data);
							GregorianCalendar cal = new GregorianCalendar();
							cal.setTime(date);
							((Administrador) MeuBolao.getUsuarioLogado()).cadastraPartida(i, time1, time2, cal);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					}
					telaDeAtualizarPartida.inicializaComboPartidas();
				}
				JOptionPane.showMessageDialog(null, "Jogo cadastrado!");
			}
		});
	}

	private void adicionaTimesCombo(JComboBox comboTime) {
		Map<String,TimeCopa> times = ControladorTimes.ler();
		Set<String> times1 = times.keySet();
		Object[] times2 = times1.toArray();
		for(int i = 0; i < times2.length; i++) {
			comboTime.addItem(times2[i].toString());
		}
	}
}
