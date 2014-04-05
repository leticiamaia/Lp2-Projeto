package interfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import projetoLp2.bolao.MeuBolao;

public class TelaDoAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -494761158154562268L;
	private JPanel contentPane, mainPane;
	private TelaDeCadastraJogo telaDeCadastro;

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
		telaDeCadastro = new TelaDeCadastraJogo();
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		contentPane = new JPanel(null);
		contentPane.setVisible(true);
		contentPane.setBounds(0, 0, 1284, 660);	
		contentPane.setBackground(Color.WHITE);
		 
		JLabel TelaDoAdministradorLabel = new JLabel("Tela do Administrador");
		TelaDoAdministradorLabel.setBounds(436, 22, 378, 52);
		TelaDoAdministradorLabel.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		contentPane.add(TelaDoAdministradorLabel);
		
		JLabel lblNewLabel = new JLabel("<html> Seja muito bem vindo administrador! Voc\u00EA possui um papel muito importante no funcionamento desse sistema. Voc\u00EA ser\u00E1 respons\u00E1vel por cadastrar e atualizar o resultado dos jogos. </html>");
		lblNewLabel.setBounds(104, 85, 1047, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel);
		
		JButton btnAtualizarRanking = new JButton("Atualizar Ranking");
		btnAtualizarRanking.setBounds(1033, 368, 164, 49);
		contentPane.add(btnAtualizarRanking);
		
		JButton btnAtualizarPartida = new JButton("Atualizar Partida");
		btnAtualizarPartida.setBounds(1033, 291, 164, 49);
		btnAtualizarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnAtualizarPartida);
		
		JButton btnCadastrarJogo = new JButton("Cadastrar Jogo");
		btnCadastrarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				telaDeCadastro.setVisible(true);
			}
		});
		btnCadastrarJogo.setBounds(1033, 213, 164, 49);
		contentPane.add(btnCadastrarJogo);
		
		mainPane.add(contentPane);
		mainPane.add(telaDeCadastro);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnSair.add(mntmSair);
		
		menuBar.add(Box.createHorizontalGlue());

		JLabel bemVindoLabel = new JLabel();
		//bemVindoLabel.setText("Voc\u00ea est\u00e1 logado como " + MeuBolao.getUsuarioLogado().getUsername() + ".");
		menuBar.add(bemVindoLabel);
		bemVindoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));	
		
	}
}
