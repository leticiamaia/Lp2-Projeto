package projetoLp2.bolao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEsqueciDados extends JFrame {

	private JPanel contentPane;
	private JPanel mostraSenha;
	private String usuario, respostaSecreta, pergunta; 
	//Jogador jogador1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEsqueciDados frame = new TelaEsqueciDados();
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
	public TelaEsqueciDados() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 759, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		setIconImage(new ImageIcon(this.getClass().getResource("docs/program-icon.png")).getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel tituloEsqueceuDados = new JLabel("Esqueci meus dados");
		tituloEsqueceuDados.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		tituloEsqueceuDados.setBackground(Color.WHITE);
		tituloEsqueceuDados.setBounds(246, 11, 365, 54);
		contentPane.add(tituloEsqueceuDados);
		
		JLabel login = new JLabel(); 
		login.setFont(new Font("Tahoma", Font.PLAIN, 13));
		login.setBounds(157, 146, 77, 20);
		contentPane.add(login);
		login.setText("Seu usu\u00E1rio: "); 
		login.setBackground(new Color(240, 240, 240));
		
		final JTextField recebeLogin = new JTextField(); 
		recebeLogin.setBounds(245, 176, 336, 20);
		contentPane.add(recebeLogin);
		recebeLogin.setColumns(10);
		
		JLabel email = new JLabel("Seu e-mail:");
		email.setSize(67, 20);
		email.setLocation(164, 176);
		email.setBackground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(email);
		
		final JTextField recebeEmail = new JTextField(); 
		recebeEmail.setBounds(245, 145, 336, 20);
		contentPane.add(recebeEmail);
		recebeEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pergunta Secreta:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(127, 206, 104, 20);
		contentPane.add(lblNewLabel_3);
		
		final JComboBox<String> perguntaSecretaComboBox = new JComboBox();
		perguntaSecretaComboBox.setBounds(245, 206, 336, 20);
		perguntaSecretaComboBox.addItem("Qual o nome do seu primeiro animal de estimação?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu professor favarito(a)?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu melhor amigo(a)?");
		perguntaSecretaComboBox.addItem("Qual a primeira praia que você visitou?");
		perguntaSecretaComboBox.addItem("Qual era seu apelido de infância?");
		perguntaSecretaComboBox.addItem("Qual é o emprego dos seus sonhos?");
		perguntaSecretaComboBox.addItem("Qual era o modelo do seu primeiro veículo motorizado?");		
		contentPane.add(perguntaSecretaComboBox);
		
		JLabel lblResposta = new JLabel("Sua resposta:");
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResposta.setBounds(150, 237, 81, 21);
		contentPane.add(lblResposta);
		
		final JTextField respostaSecretaField = new JTextField();
		respostaSecretaField.setColumns(10);
		respostaSecretaField.setBounds(245, 237, 336, 20);
		contentPane.add(respostaSecretaField);
		
		JLabel informacaoEsqueciSenha = new JLabel("<html>Aqui voc\u00EA pode recuperar apenas sua senha atrav\u00E9s da sua resposta \u00E0 pergunta secreta escolhida no momento do seu cadastro. Caso voc\u00EA n\u00E3o se recorde do seu usu\u00E1rio ou da sua resposta/pergunta secreta, contate um administrador.</html>");
		informacaoEsqueciSenha.setVerticalAlignment(SwingConstants.TOP);
		informacaoEsqueciSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		informacaoEsqueciSenha.setBackground(Color.WHITE);
		informacaoEsqueciSenha.setBounds(139, 75, 563, 74);
		contentPane.add(informacaoEsqueciSenha);
		
		JButton confirma = new JButton("Confirma");
		confirma.setBounds(267, 274, 91, 23);
		confirma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usuario = recebeLogin.getText();
				pergunta = (String) perguntaSecretaComboBox.getSelectedItem();
				respostaSecreta = respostaSecretaField.getText();
				/*if(usuario)
				 * 
				 */
				
			}
		});
		contentPane.add(confirma);
		
		JButton cancela = new JButton("Cancela");
		cancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancela.setBounds(444, 274, 91, 23);
		contentPane.add(cancela);
		
		
		mostraSenha = new JPanel();
		mostraSenha.setBackground(new Color(240, 240, 240));
		getContentPane().add(mostraSenha);

		

	}
}
