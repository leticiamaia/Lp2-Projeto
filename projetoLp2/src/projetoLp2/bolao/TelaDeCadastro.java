package projetoLp2.bolao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField recebeNomeField;
	private JTextField recebeEmailField;
	private JTextField recebeUserField;
	private JPasswordField recebeSenhaField;
	private JPasswordField recebeConfirmaSenhaField;
	private String senha, senhaConfirmada, email, usuario;
	private JTextField respostaSecretaField;

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
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 150, 759, 448);
		setTitle("Cadastro de Novo Usuário");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon(this.getClass().getResource("docs/program-icon.png")).getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cadastroDeNovo = new JLabel("Cadastro de novo usu\u00E1rio");
		cadastroDeNovo.setBounds(186, 0, 386, 54);
		cadastroDeNovo.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(cadastroDeNovo);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeCompleto.setBounds(132, 122, 101, 21);
		contentPane.add(lblNomeCompleto);
		
		recebeNomeField = new JTextField();
		recebeNomeField.setBounds(241, 122, 336, 20);
		contentPane.add(recebeNomeField);
		recebeNomeField.setColumns(10);
		
		JLabel informacaoLabel = new JLabel("Preencha os campos a seguir com suas informa\u00E7\u00F5es. \r\n\n");
		informacaoLabel.setLabelFor(this);
		informacaoLabel.setToolTipText("");
		informacaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		informacaoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		informacaoLabel.setBounds(214, 65, 327, 21);
		contentPane.add(informacaoLabel);
		
		JLabel informacao2Label = new JLabel("Os campos marcados com um asterisco (*) s\u00E3o obrigat\u00F3rios.");
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
		
		JComboBox perguntaSecretaComboBox = new JComboBox();
		perguntaSecretaComboBox.setBounds(241, 275, 336, 20);
		contentPane.add(perguntaSecretaComboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Pergunta Secreta:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(124, 271, 109, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblResposta = new JLabel("Resposta:");
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResposta.setBounds(168, 301, 57, 21);
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
		
		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senha =	recebeSenhaField.getText();
				senhaConfirmada = recebeConfirmaSenhaField.getText();
				email = recebeEmailField.getText();
				usuario = recebeUserField.getText();
				if(usuario.equals("")) {
					JOptionPane.showMessageDialog(null, "O campo 'usuário' é obrigatório!");
				}
				if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "O campo 'email' é obrigatório!");
				}
				if(senha.equals("") || senhaConfirmada.equals("")) {
					JOptionPane.showMessageDialog(null, "Os campos de senha são obrigatórios!");
				}
				
				else if(senha.equals(senhaConfirmada) && senha.isEmpty() == false && senhaConfirmada.isEmpty() == false) {					
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
					dispose(); 
				}
				else {
					JOptionPane.showMessageDialog(null, "As senhas não conferem!");
				}

			}
		});
		botaoConfirma.setBounds(260, 352, 121, 34);
		contentPane.add(botaoConfirma);
		
		JButton botaoCancela = new JButton("Cancelar");
		botaoCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		botaoCancela.setBounds(413, 352, 121, 34);
		contentPane.add(botaoCancela);
		
		respostaSecretaField = new JTextField();
		respostaSecretaField.setColumns(10);
		respostaSecretaField.setBounds(241, 306, 336, 20);
		contentPane.add(respostaSecretaField);
	}
}
