package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projetoLp2.bolao.Partida;
import projetoLp2.bolao.TimeCopa;
import projetoLp2.bolao.docs.ControladorPartidas;
import projetoLp2.bolao.docs.ControladorTimes;

public class TelaDeCadastraJogo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 834875740282875192L;


	private JTextField textField;
	
	/**
	 * Create the panel.
	 */
	public TelaDeCadastraJogo() {
		
		
		setBounds(0, 0, 1300, 700);	
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

		JLabel lblNewLabel_1 = new JLabel("DD/MM/AAAA");
		lblNewLabel_1.setBounds(577, 263, 187, 15);
		add(lblNewLabel_1);

		JButton btnCadastrar = new JButton("CADASTRAR!");
		btnCadastrar.setBounds(522, 411, 246, 52);
		add(btnCadastrar);
		
		JButton button = new JButton("voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
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
			private String time1;
			private String time2;
			private String data;

			public void actionPerformed(ActionEvent arg0) {
				Partida[] partidas = ControladorPartidas.ler();
				
				time1 = (String) comboTime1.getSelectedItem();
				time2 = (String) comboTime2.getSelectedItem();
				data = textField.getText();
				for(int i = 0; i < 64; i++) {
					if(partidas[i] == null) {
						try {
							//partidas[i] = new Partida(time1, time2, new GregorianCalendar());
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
				JOptionPane.showMessageDialog(null, "Jogo cadastrado!");
			}
		});
	}

	private void adicionaTimesCombo(JComboBox comboTime) {
		TimeCopa[] times = ControladorTimes.ler();
		
		for(int i = 0; i < times.length; i++) {
			comboTime.addItem(times[i].getAbreviacaoNomeTime());
		}
	}
}
