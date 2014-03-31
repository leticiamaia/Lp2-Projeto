package interfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import projetoLp2.bolao.MeuBolao;

public class TelaEsqueciDados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3106983905403077506L;
	private JPanel contentPane;
	private JPanel mostraSenha;
	private String usuario, respostaSecreta, pergunta, eMail, novaSenha; 
	private TelaDoUsuario telaUser;
	private TelaDeLogin telaLogin;
	MeuBolao bolao;


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
		setTitle("Bet2Beat - Esqueci minha senha");
		setContentPane(contentPane);
		setIconImage(new ImageIcon(this.getClass().getResource("/projetoLp2/bolao/docs/program-icon.png")).getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		final JOptionPane pane = new JOptionPane("");
		JDialog dialog = pane.createDialog("");
		dialog.setContentPane(pane);
		dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.pack();
		dialog.setVisible(false);		
		
		JLabel tituloEsqueceuDados = new JLabel("Esqueci meus dados");
		tituloEsqueceuDados.setFont(new Font("Calibri Light", Font.PLAIN, 36));
		tituloEsqueceuDados.setBackground(Color.WHITE);
		tituloEsqueceuDados.setBounds(252, 11, 365, 54);
		contentPane.add(tituloEsqueceuDados);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaEsqueciDados.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		label.setBounds(121, 49, 496, 9);
		contentPane.add(label);
		
		JLabel dory = new JLabel("");
		dory.setIcon(new ImageIcon(this.getClass().getResource("/projetoLp2/bolao/docs/dory-small.png")));
		dory.setBounds(31, 11, 138, 272);
		contentPane.add(dory);
		
		JLabel login = new JLabel(); 
		login.setFont(new Font("Tahoma", Font.PLAIN, 13));
		login.setBounds(182, 145, 77, 20);
		contentPane.add(login);
		login.setText("Seu usu\u00E1rio: "); 
		login.setBackground(new Color(240, 240, 240));
		
		final JTextField recebeEmail = new JTextField(); 
		recebeEmail.setBounds(270, 176, 336, 20);
		contentPane.add(recebeEmail);
		recebeEmail.setColumns(10);
		
		JLabel email = new JLabel("Seu e-mail:");
		email.setSize(67, 20);
		email.setLocation(189, 175);
		email.setBackground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(email);
		
		final JTextField recebeLogin = new JTextField(); 
		recebeLogin.setBounds(270, 144, 336, 20);
		contentPane.add(recebeLogin);
		recebeLogin.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pergunta Secreta:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(152, 205, 104, 20);
		contentPane.add(lblNewLabel_3);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox<String> perguntaSecretaComboBox = new JComboBox();
		perguntaSecretaComboBox.setBounds(270, 205, 336, 20);
		perguntaSecretaComboBox.addItem("Qual o nome do seu primeiro animal de estimação?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu professor favarito(a)?");
		perguntaSecretaComboBox.addItem("Qual o nome do seu melhor amigo(a)?");
		perguntaSecretaComboBox.addItem("Qual a primeira praia que você visitou?");
		perguntaSecretaComboBox.addItem("Qual era seu apelido de infância?");
		perguntaSecretaComboBox.addItem("Qual é o emprego dos seus sonhos?");
		perguntaSecretaComboBox.addItem("Qual era o modelo do seu primeiro veiculo motorizado?");		
		contentPane.add(perguntaSecretaComboBox);
		
		JLabel lblResposta = new JLabel("Sua resposta:");
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResposta.setBounds(175, 236, 81, 21);
		contentPane.add(lblResposta);
		
		final JTextField respostaSecretaField = new JTextField();
		respostaSecretaField.setColumns(10);
		respostaSecretaField.setBounds(270, 236, 336, 20);
		contentPane.add(respostaSecretaField);
		
		JLabel informacaoEsqueciSenha = new JLabel("<html>Aqui voc\u00EA pode recuperar apenas sua senha atrav\u00E9s da sua resposta \u00E0 pergunta secreta escolhida no momento do seu cadastro. Caso voc\u00EA n\u00E3o se recorde do seu usu\u00E1rio ou da sua resposta/pergunta secreta, contate um administrador.</html>");
		informacaoEsqueciSenha.setVerticalAlignment(SwingConstants.TOP);
		informacaoEsqueciSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		informacaoEsqueciSenha.setBackground(Color.WHITE);
		informacaoEsqueciSenha.setBounds(177, 76, 482, 74);
		contentPane.add(informacaoEsqueciSenha);		
		
		JButton confirma = new JButton(" Confirma");
		confirma.setIcon(new ImageIcon(TelaEsqueciDados.class.getResource("/projetoLp2/bolao/docs/tick.png")));
		confirma.setBounds(292, 273, 121, 34);	
		confirma.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "static-access" })
			@Override
			public void actionPerformed(ActionEvent e) {
				usuario = recebeLogin.getText().trim();
				pergunta = (String) perguntaSecretaComboBox.getSelectedItem();
				respostaSecreta = respostaSecretaField.getText().trim();
				eMail = recebeEmail.getText().trim();			
				bolao = new MeuBolao();
				try {
					if(bolao.checkUsuario(usuario, pergunta, respostaSecreta, eMail)) {
						JOptionPane.showMessageDialog(null, "Usuario(a) encontrado(a)! \nSeja bem vindo " + usuario + " !"); 					
						String[] options = {"OK"};
						JPanel panel = new JPanel();
						JLabel lbl = new JLabel("Voce precisa redefinir sua senha para continuar: ");
						JPasswordField txt = new JPasswordField(10);
						panel.add(lbl);
						panel.add(txt);
						pane.setVisible(true);
						telaLogin = new TelaDeLogin();
						telaLogin.setVisible(false);
						telaLogin.dispose();
						do {
							pane.showOptionDialog(null, panel, "Redefinir Senha", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
							novaSenha = txt.getText().trim();
							bolao.mudarSenha(novaSenha);
						}while(novaSenha.compareTo("") == 0);
							telaUser = new TelaDoUsuario(usuario);
							telaUser.setVisible(true);	
							dispose(); 
					}
					else {
						JOptionPane.showMessageDialog(null, "Algum dado incorreto ou usuario não cadastrado!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
	
		contentPane.add(confirma);
		
		JButton cancela = new JButton(" Cancela");
		cancela.setIcon(new ImageIcon(TelaEsqueciDados.class.getResource("/projetoLp2/bolao/docs/cancel.png")));
		cancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancela.setBounds(469, 273, 121, 34);
		contentPane.add(cancela);
		
		
		mostraSenha = new JPanel();
		mostraSenha.setBackground(new Color(240, 240, 240));
		getContentPane().add(mostraSenha);
		
		JLabel interrogacaoLabel = new JLabel("?");
		interrogacaoLabel.setForeground(Color.RED);
		interrogacaoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		interrogacaoLabel.setBounds(68, 27, 77, 54);
		contentPane.add(interrogacaoLabel);

		

	}


}
