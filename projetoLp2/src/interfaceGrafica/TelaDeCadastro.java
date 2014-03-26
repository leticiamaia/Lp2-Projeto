package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ItemSelectable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;

import projetoLp2.bolao.MeuBolao;

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField recebeNomeField;
	private JTextField recebeEmailField;
	private JTextField recebeUserField;
	private JPasswordField recebeSenhaField;
	private JPasswordField recebeConfirmaSenhaField;
	private String senha, senhaConfirmada, email, usuario, respostaSecreta,
			pergunta, nome;
	private JTextField respostaSecretaField;
	private static MeuBolao bolao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastro frame = new TelaDeCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDeCadastro() {
		bolao = new MeuBolao();

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 759, 448);
		setTitle("Bet2Beat - Cadastro de Novo  Usu\u00E1rio");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon(this.getClass().getResource("/projetoLp2/bolao/docs/program-icon.png")).getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel cadastroDeNovo = new JLabel("Cadastro de novo Usu\u00E1rio");
		cadastroDeNovo.setBounds(207, 0, 391, 54);
		cadastroDeNovo.setFont(new Font("Calibri", Font.PLAIN, 33));
		contentPane.add(cadastroDeNovo);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeCompleto.setBounds(132, 122, 101, 21);
		contentPane.add(lblNomeCompleto);

		recebeNomeField = new JTextField();
		recebeNomeField.setBounds(241, 122, 336, 20);
		contentPane.add(recebeNomeField);
		recebeNomeField.setColumns(10);

		JLabel informacaoLabel = new JLabel(
				"Preencha os campos a seguir com suas informa\u00E7\u00F5es. \r\n\n");
		informacaoLabel.setLabelFor(this);
		informacaoLabel.setToolTipText("");
		informacaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		informacaoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		informacaoLabel.setBounds(214, 65, 327, 21);
		contentPane.add(informacaoLabel);

		JLabel informacao2Label = new JLabel(
				"Os campos marcados com um asterisco (*) s\u00E3o obrigat\u00F3rios.");
		informacao2Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		informacao2Label.setBounds(196, 82, 386, 21);
		contentPane.add(informacao2Label);

		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(580, 153, 53, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("E-mail: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(188, 154, 45, 18);
		contentPane.add(lblNewLabel_1);

		recebeEmailField = new JTextField();
		recebeEmailField.setColumns(10);
		recebeEmailField.setBounds(241, 153, 336, 20);
		contentPane.add(recebeEmailField);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsurio.setBounds(180, 183, 53, 21);
		contentPane.add(lblUsurio);

		recebeUserField = new JTextField();
		recebeUserField.setColumns(10);
		recebeUserField.setBounds(241, 183, 336, 20);
		contentPane.add(recebeUserField);

		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(580, 182, 53, 18);
		contentPane.add(label);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(188, 217, 45, 18);
		contentPane.add(lblSenha);

		JLabel lblNewLabel_2 = new JLabel("Confirmar Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(124, 246, 102, 14);
		contentPane.add(lblNewLabel_2);

		recebeSenhaField = new JPasswordField();
		recebeSenhaField.setBounds(241, 214, 336, 20);
		contentPane.add(recebeSenhaField);

		recebeConfirmaSenhaField = new JPasswordField();
		recebeConfirmaSenhaField.setBounds(241, 244, 336, 20);
		contentPane.add(recebeConfirmaSenhaField);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(580, 214, 53, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(580, 246, 53, 18);
		contentPane.add(label_2);

		final JComboBox<String> perguntaSecretaComboBox = new JComboBox();
		perguntaSecretaComboBox.setBounds(241, 275, 336, 20);
		perguntaSecretaComboBox.addItem("Qual o nome do seu primeiro animal de estima��o?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu professor favarito(a)?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu melhor amigo(a)?");
		perguntaSecretaComboBox.addItem("Qual a primeira praia que voc� visitou?");
		perguntaSecretaComboBox.addItem("Qual era seu apelido de inf�ncia?");
		perguntaSecretaComboBox.addItem("Qual � o emprego dos seus sonhos?");
		perguntaSecretaComboBox.addItem("Qual era o modelo do seu primeiro veiculo motorizado?");		
		contentPane.add(perguntaSecretaComboBox);

		JLabel lblNewLabel_3 = new JLabel("Pergunta Secreta:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(124, 271, 109, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblResposta = new JLabel("Resposta:");
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResposta.setBounds(168, 304, 57, 21);
		contentPane.add(lblResposta);

		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(580, 275, 53, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(580, 305, 53, 18);
		contentPane.add(label_4);

		JButton botaoConfirma = new JButton(" Confirmar");
		botaoConfirma.setIcon(new ImageIcon(TelaDeCadastro.class.getResource("/projetoLp2/bolao/docs/tick.png")));
		botaoConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome = recebeNomeField.getText().trim();
				senha = recebeSenhaField.getText().trim();
				senhaConfirmada = recebeConfirmaSenhaField.getText().trim();
				email = recebeEmailField.getText().trim();
				usuario = recebeUserField.getText().trim();
				respostaSecreta = respostaSecretaField.getText().trim();
				pergunta = (String) perguntaSecretaComboBox.getSelectedItem();
				int sucesso = 0;
				if (usuario.equals("")) {
					JOptionPane.showMessageDialog(null,
							"O campo 'usuario' � obrigatorio!");
					sucesso = -1;
				}
				if (email.equals("")) {
					JOptionPane.showMessageDialog(null,
							"O campo 'email' � obrigatorio!");
					sucesso = -1;
				}
				if (senha.equals("") || senhaConfirmada.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Os campos de senha s�o obrigatorios!");
					sucesso = -1;
				}
				if (!email.contains("@") || !email.contains(".") || email.contains(" ")) {
					JOptionPane.showMessageDialog(null,
							"E-mail Invalido.");
					sucesso = -1;
				}
				
				if (!senha.equals(senhaConfirmada) || senha.isEmpty()
						|| senhaConfirmada.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"As senhas nao conferem!");
					sucesso = -1;
					
				}
				if (sucesso == 0) {
					
					try {
						sucesso = bolao.cadastraJogador(nome, usuario, senha, email,
								pergunta, respostaSecreta);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					if (sucesso == 1) {
						JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
						dispose();
					}
					else if (sucesso == 2)
						JOptionPane.showMessageDialog(null,
								"Usuario ja existente, escolha outro."); 
					else if (sucesso == 3)
						JOptionPane.showMessageDialog(null,
								"E-mail ja existente, escolha outro.");
				} 
			}
		});
		botaoConfirma.setBounds(264, 351, 121, 34);
		contentPane.add(botaoConfirma);

		JButton botaoCancela = new JButton(" Cancelar");
		botaoCancela.setIcon(new ImageIcon(TelaDeCadastro.class.getResource("/projetoLp2/bolao/docs/cancel.png")));
		botaoCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoCancela.setBounds(410, 351, 121, 34);
		contentPane.add(botaoCancela);

		respostaSecretaField = new JTextField();
		respostaSecretaField.setColumns(10);
		respostaSecretaField.setBounds(241, 306, 336, 20);
		contentPane.add(respostaSecretaField);
		
		JLabel lblMemorizeSuaPergunta = new JLabel("<html>Memorize sua pergunta e resposta secreta. Elas servir\u00E3o para recuperar sua senha, caso voc\u00EA a esque\u00E7a.</html>");
		lblMemorizeSuaPergunta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMemorizeSuaPergunta.setBounds(145, 326, 432, 14);
		contentPane.add(lblMemorizeSuaPergunta);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(TelaDeCadastro.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		label_5.setBounds(94, 39, 504, 14);
		contentPane.add(label_5);

	}
}
