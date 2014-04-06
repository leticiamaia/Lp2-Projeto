package interfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.MeuBolao;

public class TelaDeLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1351227738501426505L;
	private JPanel contentPane;
	private JTextField recebeLogin;
	private JPasswordField recebeSenhaEncriptada;
	private TelaDeCadastro telaDeCadastro = new TelaDeCadastro();
	private TelaDoUsuario telaUser;
	private TelaDoAdmin telaAdmin;
	private TelaEsqueciDados telaEsqueceu = new TelaEsqueciDados(this);
	String getSenha;
	String getLogin;
	
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
		setResizable(false);
		setTitle("Bet2Beat - Seja bem Vindo!"); 
		setBackground(Color.WHITE); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 150, 759, 448); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255)); 
		setContentPane(contentPane);
		setIconImage(new ImageIcon(this.getClass().getResource("/projetoLp2/bolao/docs/program-icon.png")).getImage());
		contentPane.setLayout(null); 

		criaTelaBoasVindas();

		JPanel quadroDeLogin = new JPanel();
		quadroDeLogin.setBounds(230, 195, 450, 164); 
		contentPane.add(quadroDeLogin); 
		quadroDeLogin.setBorder(new TitledBorder(null, "Fazer Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		quadroDeLogin.setLayout(null);

		criaQuadroDeLogin(quadroDeLogin);
		
		JButton botaoEntrar = new JButton(" Entrar"); 
		botaoEntrar.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/projetoLp2/bolao/docs/bullet_key.png")));
		botaoEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				getLogin = recebeLogin.getText().trim();
				getSenha = recebeSenhaEncriptada.getText().trim(); 
				try {
					boolean sucesso = MeuBolao.login2(getLogin, getSenha);
					if (sucesso) {
						JOptionPane.showMessageDialog(null, "Login feito com sucesso! \n Seja bem vindo " + getLogin + " !"); 
						dispose(); 
						if(MeuBolao.getUsuarioLogado() instanceof Administrador)
						{
							telaAdmin = new TelaDoAdmin();
							telaAdmin.setVisible(true);									
						}
						else {
							telaUser = new TelaDoUsuario();
							telaUser.setVisible(true);
							telaDeCadastro.setVisible(false);
						}
					}
				} catch (Exception e1) {
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				} 
			}
		});
		botaoEntrar.setBounds(104, 98, 99, 23);
		quadroDeLogin.add(botaoEntrar); 

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/projetoLp2/bolao/docs/add_small.png")));
		botaoCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				telaDeCadastro.setVisible(true);
			}
		});
		botaoCadastrar.setBounds(219, 98, 111, 23);
		quadroDeLogin.add(botaoCadastrar);

		JButton botaoEsqueciDados = new JButton("Esqueci senha");
		botaoEsqueciDados.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/projetoLp2/bolao/docs/icon_forgotPassword.png")));
		botaoEsqueciDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaEsqueceu.setVisible(true);
			}
		});
		botaoEsqueciDados.setBounds(145, 130, 140, 23);
		quadroDeLogin.add(botaoEsqueciDados);	
	}

	private void criaTelaBoasVindas() {
		JLabel bolaoCopa2014 = new JLabel("Bol\u00E3o Copa do Mundo 2014");
		bolaoCopa2014.setFont(new Font("Calibri Light", Font.PLAIN, 38));
		bolaoCopa2014.setBounds(241, 77, 525, 58);
		contentPane.add(bolaoCopa2014);

		JLabel fuleco = new JLabel("");
		fuleco.setIcon(new ImageIcon(this.getClass().getResource("/projetoLp2/bolao/docs/tatu-bola.png")));
		fuleco.setBounds(-44, 11, 255, 272);
		contentPane.add(fuleco);		

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		label.setBounds(171, 109, 510, 31);
		contentPane.add(label);
		JLabel boasVindas = new JLabel("Seja bem vindo!");
		boasVindas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boasVindas.setBounds(409, 135, 133, 19);
		contentPane.add(boasVindas);
	}

	private void criaQuadroDeLogin(JPanel quadroDeLogin) {
		JLabel login = new JLabel(); 
		login.setBounds(104, 36, 49, 20);
		quadroDeLogin.add(login);
		login.setText("Login:"); 
		login.setBackground(new Color(240, 240, 240));

		recebeLogin = new JTextField(); 
		recebeLogin.setBounds(156, 36, 174, 20);
		quadroDeLogin.add(recebeLogin);
		recebeLogin.setColumns(10);

		JLabel senha = new JLabel();
		senha.setBounds(104, 67, 43, 20);
		quadroDeLogin.add(senha);
		senha.setText("Senha: ");
		senha.setBackground(new Color(240, 240, 240));

		recebeSenhaEncriptada = new JPasswordField(); 
		recebeSenhaEncriptada.setBounds(156, 67, 174, 20);
		quadroDeLogin.add(recebeSenhaEncriptada);
	}
}