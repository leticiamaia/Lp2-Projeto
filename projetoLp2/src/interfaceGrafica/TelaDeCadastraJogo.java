package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaDeCadastraJogo extends JPanel {

	private JTextField abrevTime1;
	private JTextField abrevTime2;
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

		abrevTime1 = new JTextField();
		abrevTime1.setBounds(319, 302, 137, 36);
		abrevTime1.setColumns(10);
		add(abrevTime1);

		abrevTime2 = new JTextField();
		abrevTime2.setColumns(10);
		abrevTime2.setBounds(839, 302, 137, 36);
		add(abrevTime2);

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
		btnCadastrar.addActionListener(new ActionListener() {
			private String time1;
			private String time2;
			private String data;

			public void actionPerformed(ActionEvent arg0) {
				time1 = abrevTime1.getText();
				time2 = abrevTime2.getText();
				data = textField.getText();
				JOptionPane.showMessageDialog(null, "Nada foi feito com sucesso!");
			}
		});
	}

}
