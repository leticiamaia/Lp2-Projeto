package projetoLp2.bolao;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDeLogin() {
		setTitle("Bol\u00E3o Copa do Mundo 2014 - Bem Vindo!"); // título da janela
		setBackground(Color.WHITE); //cor do fundo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 448); // localização e tamanho da janela
		contentPane = new JPanel();
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
		
		JTextPane login = new JTextPane(); // cria uma 'área de texto'
		login.setBounds(104, 36, 49, 20);
		quadroDeLogin.add(login);
		login.setText("Login:"); // texto 'impresso'
		login.setBackground(new Color(240, 240, 240));
		
		JTextPane senha = new JTextPane();
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
		
		JTextPane textoPrincipal = new JTextPane(); // cria o texto principal ("Bolão Copa do Mundo 2014)
		textoPrincipal.setFont(new Font("BlackJack", Font.PLAIN, 45)); // define a fonte e o tamanho do texto
		//aqui eu acho que teremos que mudar a fonte, pq se o pc não tiver a fonte BlackJack, o texto não fica daquele jeito.
		textoPrincipal.setText("Bol\u00E3o Copa do Mundo 2014");
		textoPrincipal.setBounds(230, 63, 513, 73);
		contentPane.add(textoPrincipal);
		
		JTextPane textoBoasVindas = new JTextPane(); 
		textoBoasVindas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textoBoasVindas.setText("Seja bem vindo!");
		textoBoasVindas.setBounds(412, 136, 134, 48);
		contentPane.add(textoBoasVindas);
		
		JLabel fuleco = new JLabel("");
		fuleco.setIcon(new ImageIcon("C:\\Users\\M\\Desktop\\Projeto LP2\\tatu-bola.png")); // essa parte vocês terão que salvar a imagem 
		// no pc de vcs, e trocar o link (vou 
		//passar pra voces, ainda nao sei como faz pra tornar a imagem 'universal' :\
		fuleco.setBounds(-44, 11, 361, 272);
		contentPane.add(fuleco);
		

		
		
	}
}
