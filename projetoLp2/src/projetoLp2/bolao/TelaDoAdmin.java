package projetoLp2.bolao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class TelaDoAdmin extends JFrame {

	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TelaDoAdministradorLabel = new JLabel("Tela do Administrador");
		TelaDoAdministradorLabel.setBounds(436, 22, 378, 52);
		TelaDoAdministradorLabel.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		contentPane.add(TelaDoAdministradorLabel);
		
		JLabel lblNewLabel = new JLabel("<html> Seja muito bem vindo administrador! Voc\u00EA possui um papel muito importante no funcionamento desse sistema. Voc\u00EA ser\u00E1 respons\u00E1vel por cadastrar e atualizar o resultado dos jogos. </html>");
		lblNewLabel.setBounds(104, 85, 1047, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(70, 152, 866, 453);
		scrollPane.setLayout(null);
		contentPane.add(scrollPane);
		
		JButton btnCadastrarJogo = new JButton("Cadastrar Jogo");
		btnCadastrarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarJogo.setBounds(1033, 213, 164, 49);
		contentPane.add(btnCadastrarJogo);
		
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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnSair.add(mntmSair);
		
	}
}
