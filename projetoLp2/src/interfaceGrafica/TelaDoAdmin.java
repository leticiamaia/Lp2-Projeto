package interfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projetoLp2.bolao.MeuBolao;

import java.awt.SystemColor;

public class TelaDoAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -494761158154562268L;
	private static JPanel contentPane;
	private JPanel mainPane;
	private TelaDeCadastraJogo telaDeCadastro;
	private TelaDeAtualizarPartida telaDeAtualizarPartida;
	private TelaDeLogin telaDeLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoAdmin frame = new TelaDoAdmin();
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
	public TelaDoAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 700);	
		mainPane = new JPanel();
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		contentPane = new JPanel(null);
		contentPane.setVisible(true);
		telaDeAtualizarPartida = new TelaDeAtualizarPartida();
		telaDeAtualizarPartida.setBackground(SystemColor.menu);
		telaDeCadastro = new TelaDeCadastraJogo(mainPane, telaDeAtualizarPartida);
		contentPane.setBounds(70, 216, 816, 361);	
		contentPane.setBackground(SystemColor.menu);
	
		contentPane.add(telaDeCadastro);
		contentPane.add(telaDeAtualizarPartida);
		mainPane.add(contentPane);
		
		JLabel TelaDoAdministradorLabel = new JLabel("Tela do Administrador");
		TelaDoAdministradorLabel.setBounds(329, 25, 447, 52);
		mainPane.add(TelaDoAdministradorLabel);
		TelaDoAdministradorLabel.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		
		JLabel lblNewLabel = new JLabel("<html> Seja muito bem vindo administrador! Voc\u00EA possui um papel muito importante no funcionamento desse sistema. Voc\u00EA ser\u00E1 respons\u00E1vel por cadastrar e atualizar o resultado dos jogos. </html>");
		lblNewLabel.setBounds(55, 132, 1047, 32);
		mainPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnAtualizarPartida = new JButton("Atualizar Partida");
		btnAtualizarPartida.setBounds(994, 422, 164, 49);
		mainPane.add(btnAtualizarPartida);
		
		JButton btnCadastrarJogo = new JButton("Cadastrar Jogo");
		btnCadastrarJogo.setBounds(991, 308, 164, 49);
		mainPane.add(btnCadastrarJogo);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(1050, 237, 46, 14);
		mainPane.add(lblMenu);
		btnCadastrarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaDeAtualizarPartida.setVisible(false);
				telaDeCadastro.setVisible(true);
			}
		});
		btnAtualizarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaDeCadastro.setVisible(false);
				telaDeAtualizarPartida.setVisible(true);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu sairMenu = new JMenu("Sair");
		sairMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MeuBolao.desloga();
				dispose();
				telaDeLogin = new TelaDeLogin();
				telaDeLogin.setVisible(true);
			}
		});
		menuBar.add(sairMenu);
		
		menuBar.add(Box.createHorizontalGlue());

		JLabel bemVindoLabel = new JLabel();
		//bemVindoLabel.setText("Voc\u00ea est\u00e1 logado como " + MeuBolao.getUsuarioLogado().getUsername() + ".");
		menuBar.add(bemVindoLabel);
		bemVindoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));	
		
	}
	
	public static void setContentPanel(boolean cond) {
		contentPane.setVisible(cond);
	}
}
