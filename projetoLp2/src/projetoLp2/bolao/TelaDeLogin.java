package projetoLp2.bolao;


import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class TelaDeLogin extends JFrame {

	private JPanel contentPane;
	private JTextField recebeLogin;
	private JPasswordField recebeSenhaEncriptada;
	private TelaDeCadastro telaDeCadastro;
	private MeuBolao bolao;
	private TelaDoUsuario telaUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} //09
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDeLogin() {
		final MeuBolao bolao = new MeuBolao();
		setResizable(false);
		setTitle("Bol\u00E3o Copa do Mundo 2014 - Bem Vindo!"); 
		setBackground(Color.WHITE); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 150, 759, 448); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255)); 
		setContentPane(contentPane);
		setIconImage(new ImageIcon(this.getClass().getResource("docs/program-icon.png")).getImage());
		contentPane.setLayout(null); 
		
		JPanel quadroDeLogin = new JPanel();
		quadroDeLogin.setBounds(230, 195, 450, 164); 
		contentPane.add(quadroDeLogin); 
		quadroDeLogin.setBorder(new TitledBorder(null, "Fazer Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		quadroDeLogin.setLayout(null);
		
		recebeLogin = new JTextField(); 
		recebeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
		recebeLogin.setBounds(156, 36, 174, 20);
		quadroDeLogin.add(recebeLogin);
		recebeLogin.setColumns(10);
		
		JLabel login = new JLabel(); 
		login.setBounds(104, 36, 49, 20);
		quadroDeLogin.add(login);
		login.setText("Login:"); 
		login.setBackground(new Color(240, 240, 240));
		
		JLabel senha = new JLabel();
		senha.setBounds(104, 67, 43, 20);
		quadroDeLogin.add(senha);
		senha.setText("Senha: ");
		senha.setBackground(new Color(240, 240, 240));
		
		JButton botaoEntrar = new JButton("Entrar"); 
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String getSenha;
				String getLogin;
						getLogin = recebeLogin.getText();
						getSenha = recebeSenhaEncriptada.getText(); 
						
						if(getLogin.equals("")) {
							JOptionPane.showMessageDialog(null, "Campo 'usuário' não deve ser vazio!");
						}
						if(getSenha.equals("")) {
							JOptionPane.showMessageDialog(null, "Campo 'senha' não deve ser vazio!");
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Login feito com sucesso!");
							dispose(); 
							telaUser = new TelaDoUsuario();
							telaUser.show();
							JOptionPane.showMessageDialog(null, "Seja bem vindo " + getLogin + "!");
						}
						
				
							try {
								bolao.login2(getLogin,getSenha);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
		});
		botaoEntrar.setBounds(138, 97, 91, 23);
		quadroDeLogin.add(botaoEntrar); 
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				telaDeCadastro = new TelaDeCadastro();
				telaDeCadastro.show();

			}
		});
		botaoCadastrar.setBounds(239, 97, 91, 23);
		quadroDeLogin.add(botaoCadastrar);
		
		JButton botaoEsqueciDados = new JButton("Esqueci dados");
		botaoEsqueciDados.setBounds(178, 130, 119, 23);
		quadroDeLogin.add(botaoEsqueciDados);
		
		recebeSenhaEncriptada = new JPasswordField(); 
		recebeSenhaEncriptada.setBounds(156, 67, 174, 20);
		quadroDeLogin.add(recebeSenhaEncriptada);
		
		JLabel boasVindas = new JLabel("Seja bem vindo!");
		boasVindas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boasVindas.setBounds(409, 135, 133, 19);
		contentPane.add(boasVindas);
		
		JLabel bolaoCopa2014 = new JLabel("Bol\u00E3o Copa do Mundo 2014");
		bolaoCopa2014.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		bolaoCopa2014.setBounds(241, 66, 525, 58);
		contentPane.add(bolaoCopa2014);

		JLabel fuleco = new JLabel("");
		fuleco.setIcon(new ImageIcon(this.getClass().getResource("docs/tatu-bola.png")));
		fuleco.setBounds(-44, 11, 361, 272);
		contentPane.add(fuleco);
		
		
		

		
		
	}
}
