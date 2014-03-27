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

public class AlterarInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -337804168890997381L;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField txtDigiteSuaResposta;

	/**
	 * Create the panel.
	 */
	public AlterarInfoPanel() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		JLabel lblAlterarInformaesDo = new JLabel("Alterar Informa\u00E7\u00F5es do Usu\u00E1rio");
		lblAlterarInformaesDo.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		lblAlterarInformaesDo.setBounds(10, 11, 658, 66);
		add(lblAlterarInformaesDo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		lblNewLabel.setBounds(-50, 55, 658, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(123, 155, 48, 21);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBounds(171, 155, 437, 20);
		textField.setText("Digite seu nome aqui");
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblEmail.setBounds(123, 187, 48, 21);
		add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
		});
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setBounds(171, 187, 437, 20);
		textField_1.setText("Digite seu novo email");
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblSenha.setBounds(118, 219, 53, 21);
		add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 219, 437, 20);
		add(passwordField);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox<String> perguntaSecretaComboBox = new JComboBox();
		perguntaSecretaComboBox.setBounds(171, 251, 437, 20);
		perguntaSecretaComboBox.addItem("Qual o nome do seu primeiro animal de estimação?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu professor favarito(a)?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu melhor amigo(a)?");
		perguntaSecretaComboBox.addItem("Qual a primeira praia que você visitou?");
		perguntaSecretaComboBox.addItem("Qual era seu apelido de infância?");
		perguntaSecretaComboBox.addItem("Qual é o emprego dos seus sonhos?");
		perguntaSecretaComboBox.addItem("Qual era o modelo do seu primeiro veiculo motorizado?");		
		add(perguntaSecretaComboBox);
		
		JLabel lblPerguntaSecreta = new JLabel("Pergunta Secreta: ");
		lblPerguntaSecreta.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblPerguntaSecreta.setBounds(57, 250, 114, 21);
		add(lblPerguntaSecreta);
		
		JLabel lblRespostaSecreta = new JLabel("Resposta Secreta: ");
		lblRespostaSecreta.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblRespostaSecreta.setBounds(57, 282, 124, 21);
		add(lblRespostaSecreta);
		
		txtDigiteSuaResposta = new JTextField();
		txtDigiteSuaResposta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDigiteSuaResposta.setText("");
			}
		});
		txtDigiteSuaResposta.setForeground(Color.LIGHT_GRAY);
		txtDigiteSuaResposta.setText("Digite sua nova resposta secreta aqui");
		txtDigiteSuaResposta.setBounds(171, 282, 437, 20);
		add(txtDigiteSuaResposta);
		txtDigiteSuaResposta.setColumns(10);
	}
}
