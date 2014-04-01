package interfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import projetoLp2.bolao.MeuBolao;

public class TelaDeCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1278752757107632458L;
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
		setIconImage(new ImageIcon(this.getClass().getResource(
				"/projetoLp2/bolao/docs/program-icon.png")).getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel cadastroUserLabel = new JLabel("Cadastro de novo Usu\u00E1rio");
		cadastroUserLabel.setBounds(207, 0, 391, 54);
		cadastroUserLabel.setFont(new Font("Calibri", Font.PLAIN, 33));
		contentPane.add(cadastroUserLabel);

		JLabel nomeLabel = new JLabel("Nome Completo: ");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nomeLabel.setBounds(131, 122, 102, 21);
		contentPane.add(nomeLabel);

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

		JLabel emailLabel = new JLabel("*E-mail:");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailLabel.setBounds(180, 154, 53, 18);
		contentPane.add(emailLabel);

		recebeEmailField = new JTextField();
		recebeEmailField.setColumns(10);
		recebeEmailField.setBounds(241, 153, 336, 20);
		contentPane.add(recebeEmailField);

		JLabel userLabel = new JLabel("*Usu\u00E1rio:");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userLabel.setBounds(169, 183, 64, 21);
		contentPane.add(userLabel);

		recebeUserField = new JTextField();
		recebeUserField.setColumns(10);
		recebeUserField.setBounds(241, 183, 336, 20);
		contentPane.add(recebeUserField);

		JLabel senhaLabel = new JLabel("*Senha:");
		senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		senhaLabel.setBounds(179, 217, 54, 18);
		contentPane.add(senhaLabel);
		
		recebeSenhaField = new JPasswordField();
		recebeSenhaField.setBounds(241, 214, 336, 20);
		contentPane.add(recebeSenhaField);

		JLabel confirmaSenhaLabel = new JLabel("*Confirmar Senha:");
		confirmaSenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmaSenhaLabel.setBounds(117, 246, 116, 14);
		contentPane.add(confirmaSenhaLabel);

		recebeConfirmaSenhaField = new JPasswordField();
		recebeConfirmaSenhaField.setBounds(241, 244, 336, 20);
		contentPane.add(recebeConfirmaSenhaField);


		final JComboBox<String> perguntaSecretaComboBox = new JComboBox<String>();
		perguntaSecretaComboBox.setBounds(241, 275, 336, 20);
		perguntaSecretaComboBox
				.addItem("Qual o nome do seu primeiro animal de estima��o?");
		perguntaSecretaComboBox
				.addItem("Qual o nome do seu professor favarito(a)?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu melhor amigo(a)?");
		perguntaSecretaComboBox
				.addItem("Qual a primeira praia que voc� visitou?");
		perguntaSecretaComboBox.addItem("Qual era seu apelido de inf�ncia?");
		perguntaSecretaComboBox.addItem("Qual � o emprego dos seus sonhos?");
		perguntaSecretaComboBox
				.addItem("Qual era o modelo do seu primeiro veiculo motorizado?");
		contentPane.add(perguntaSecretaComboBox);

		JLabel perguntaSecretaLabel = new JLabel("*Pergunta Secreta:");
		perguntaSecretaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		perguntaSecretaLabel.setBounds(117, 271, 116, 20);
		contentPane.add(perguntaSecretaLabel);

		JLabel respostaLabel = new JLabel("*Resposta:");
		respostaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		respostaLabel.setBounds(168, 305, 65, 21);
		contentPane.add(respostaLabel);

		JButton botaoConfirma = new JButton(" Confirmar");
		botaoConfirma.setIcon(new ImageIcon(TelaDeCadastro.class
				.getResource("/projetoLp2/bolao/docs/tick.png")));
		botaoConfirma.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				nome = recebeNomeField.getText().trim();
				senha = recebeSenhaField.getText().trim();
				senhaConfirmada = recebeConfirmaSenhaField.getText().trim();
				email = recebeEmailField.getText().trim();
				usuario = recebeUserField.getText().trim();
				respostaSecreta = respostaSecretaField.getText().trim();
				pergunta = (String) perguntaSecretaComboBox.getSelectedItem();
				verificaCampos();
			}
		});
		botaoConfirma.setBounds(264, 351, 121, 34);
		contentPane.add(botaoConfirma);

		JButton botaoCancela = new JButton(" Cancelar");
		botaoCancela.setIcon(new ImageIcon(TelaDeCadastro.class
				.getResource("/projetoLp2/bolao/docs/cancel.png")));
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

		JLabel anotaMemorizeSenhaLabel = new JLabel(
				"<html>Memorize sua pergunta e resposta secreta. Elas servir\u00E3o para recuperar sua senha, caso voc\u00EA a esque\u00E7a.</html>");
		anotaMemorizeSenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		anotaMemorizeSenhaLabel.setBounds(145, 326, 432, 14);
		contentPane.add(anotaMemorizeSenhaLabel);

		JLabel divisorLabel = new JLabel("");
		divisorLabel.setIcon(new ImageIcon(TelaDeCadastro.class
				.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		divisorLabel.setBounds(94, 39, 504, 14);
		contentPane.add(divisorLabel);
	}
	
	public boolean verificaCampos() {
		boolean sucesso = true;
		if (usuario.equals("")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'usuario' � obrigatorio!");
			sucesso = false;
		}
		if (email.equals("")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'email' � obrigatorio!");
			sucesso = false;
		}
		sucesso = verificaEmail();
		if (senha.equals("") || senhaConfirmada.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Os campos de senha s�o obrigatorios!");
			sucesso = false;
		}
		if (!senha.equals(senhaConfirmada) || senha.isEmpty()
				|| senhaConfirmada.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"As senhas nao conferem!");
			sucesso = false;
		}
		if (sucesso) {
			try {
				sucesso = bolao.cadastraJogador(nome, usuario, senha, email, pergunta, respostaSecreta);
				JOptionPane.showMessageDialog(null,
						"Cadastro feito com sucesso!");
				dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		return sucesso;
	}
	
	public boolean verificaEmail() { 
	int idx = email.lastIndexOf("@");
	if (idx == 0) {
		JOptionPane.showMessageDialog(null, "E-mail Invalido.");
		return false;
	}

	else {
		int last = idx;
		for (idx = idx+1; idx < email.length(); idx++) {
			if (email.charAt(idx) == '.') {
				if (idx - last == 1 || idx == email.length()-1) {
					JOptionPane.showMessageDialog(null,
							"E-mail Invalido.");
					return false;
				}
				last = idx;
			}
		}
		return true;
	}
	}
	}




