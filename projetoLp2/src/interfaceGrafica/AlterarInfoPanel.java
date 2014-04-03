package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -337804168890997381L;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private Jogador user;

	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public AlterarInfoPanel(Jogador usuario) {
		user = usuario;
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(627, 11, 647, 606);
		panel_1.setVisible(true);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/verticalDivider.png")));
		label.setBounds(579, -32, 48, 715);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		label_1.setBounds(-73, 85, 658, 21);
		add(label_1);
		
		JLabel lblSeusDadosAtuais = new JLabel("Seus dados atuais");
		lblSeusDadosAtuais.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		lblSeusDadosAtuais.setBounds(120, 40, 304, 66);
		add(lblSeusDadosAtuais);
		
		JLabel label_2 = new JLabel("Nome: ");
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_2.setBounds(102, 192, 41, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("Email: ");
		label_3.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_3.setBounds(107, 224, 48, 21);
		add(label_3);
		
		JLabel label_5 = new JLabel("Pergunta Secreta: ");
		label_5.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_5.setBounds(41, 256, 114, 21);
		add(label_5);
		
		JLabel label_6 = new JLabel("Resposta Secreta: ");
		label_6.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_6.setBounds(41, 288, 124, 21);
		add(label_6);
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(626, 11, 648, 606);
		panel.setVisible(false);
		add(panel);
		panel.setLayout(null);
		
		JLabel label_7 = new JLabel("Alterar Informa\u00E7\u00F5es do Usu\u00E1rio");
		label_7.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		label_7.setBounds(36, 24, 658, 66);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		label_8.setBounds(-20, 75, 658, 21);
		panel.add(label_8);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(null);
			}
		});
		textField.setText("Digite seu nome aqui");
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setColumns(10);
		textField.setBounds(131, 176, 437, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_1.setText(null);
			}
		});
		textField_1.setText("Digite seu novo email");
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(131, 207, 437, 20);
		panel.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 238, 437, 20);
		panel.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 266, 437, 20);
		panel.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_2.setText(null);
			}
		});
		textField_2.setText("Digite sua nova resposta secreta aqui");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(131, 297, 437, 20);
		panel.add(textField_2);
		
		JLabel label_9 = new JLabel("Nome: ");
		label_9.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_9.setBounds(82, 176, 41, 21);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Email: ");
		label_10.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_10.setBounds(82, 207, 48, 21);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Senha: ");
		label_11.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_11.setBounds(82, 238, 41, 21);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Pergunta Secreta: ");
		label_12.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_12.setBounds(21, 269, 114, 21);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("Resposta Secreta: ");
		label_13.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		label_13.setBounds(21, 297, 124, 21);
		panel.add(label_13);
		
		JButton button = new JButton(" Confirmar");
		button.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/tick.png")));
		button.setBounds(189, 369, 121, 34);
		panel.add(button);
		
		JButton button_1 = new JButton(" Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/cancel.png")));
		button_1.setBounds(367, 369, 121, 34);
		panel.add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("Os campos das informações que permanecerão iguais não devem ser preenchidos.");
		lblNewLabel_1.setBounds(92, 89, 476, 86);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Editar Dados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/segura-trofeu.jpg")));
		label_16.setBounds(55, 0, 554, 598);
		panel_1.add(label_16);
		btnNewButton.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/register_icon.gif")));
		btnNewButton.setBounds(240, 382, 132, 36);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(user.getUsername());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(153, 195, 388, 14);
		add(lblNewLabel);
		
		JLabel label_14 = new JLabel(user.getEmail());
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_14.setBounds(153, 227, 388, 14);
		add(label_14);
		
		JLabel label_4 = new JLabel(user.getPerguntaSecreta());
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(153, 259, 388, 14);
		add(label_4);
		
		JLabel label_15 = new JLabel(user.getResposta());
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_15.setBounds(153, 291, 388, 14);
		add(label_15);
	}
}
