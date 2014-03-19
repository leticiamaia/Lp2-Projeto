package projetoLp2.bolao;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Window.Type;

public class TelaDeLogin extends JFrame {

	private JPanel contentPane;
	private JTextField recebeSenha;
	private JPasswordField recebeSenhaEncriptada;

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
		setResizable(false);
		setTitle("Bol\u00E3o Copa do Mundo 2014 - Bem Vindo!"); // título da janela
		setBackground(Color.WHITE); //cor do fundo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 448); // localização e tamanho da janela
		contentPane = new JPanel();
		contentPane.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.setAlignmentY(CENTER_ALIGNMENT);
		contentPane.setBackground(new Color(255, 255, 255)); //cor do fundo do painel em RGB code
		setContentPane(contentPane);
		contentPane.setLayout(null); // sem layout = é possivel posicionar botões em qualquer área do painel
		
		JPanel quadroDeLogin = new JPanel();
		quadroDeLogin.setBounds(230, 195, 450, 164); //setta tamanhos (posição x, posição y, comprimento, altura)
		contentPane.add(quadroDeLogin); // adiciona o quadro de login a janela criada lá em cima
		quadroDeLogin.setBorder(new TitledBorder(null, "Fazer Login", TitledBorder.LEADING, TitledBorder.TOP, null, null)); // faz a bordinha com "Fazer Login" em cima
		quadroDeLogin.setLayout(null);
		
		recebeSenha = new JTextField(); // cria caixa pra receber texto
		recebeSenha.setBounds(156, 36, 174, 20);
		quadroDeLogin.add(recebeSenha);
		recebeSenha.setColumns(10);
		
		JLabel login = new JLabel(); // cria uma 'área de texto'
		login.setBounds(104, 36, 49, 20);
		quadroDeLogin.add(login);
		login.setText("Login:"); // texto 'impresso'
		login.setBackground(new Color(240, 240, 240));
		
		JLabel senha = new JLabel();
		senha.setBounds(104, 67, 43, 20);
		quadroDeLogin.add(senha);
		senha.setText("Senha: ");
		senha.setBackground(new Color(240, 240, 240));
		
		JButton botaoEntrar = new JButton("Entrar"); // cria botão de entrar
		botaoEntrar.setBounds(138, 97, 91, 23);
		quadroDeLogin.add(botaoEntrar); //adiciona botão ao quadro de login
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(239, 97, 91, 23);
		quadroDeLogin.add(botaoCadastrar);
		
		JButton botaoEsqueciDados = new JButton("Esqueci dados");
		botaoEsqueciDados.setBounds(178, 130, 119, 23);
		quadroDeLogin.add(botaoEsqueciDados);
		
		recebeSenhaEncriptada = new JPasswordField(); // cria um campo de texto para senha 
		recebeSenhaEncriptada.setBounds(156, 67, 174, 20);
		quadroDeLogin.add(recebeSenhaEncriptada);
		 botaoEntrar.addActionListener(new ActionListener() { // não faço ideia do q isso faz xD mas provavelmente transforma os caracteres em bolinhas
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	/*	File imagemFuleco = new File("C:\\Users\\M\\Desktop\\Projeto LP2\\tatu-bola.png");
		try {
			   BufferedImage fuleco = ImageIO.read(imagemFuleco);
			} catch (IOException e) {
			}*/
		
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
