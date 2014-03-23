package projetoLp2.bolao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JMenuBar;

import java.awt.Label;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;

public class TelaDoUsuario extends JFrame {

	private JPanel contentPane;
	private TelaDeLogin telaLogin;
	private MeuBolao bolao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoUsuario frame = new TelaDoUsuario();
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
	public TelaDoUsuario() {
		setTitle("Tela do Usu\u00E1rio");
		setAlwaysOnTop(true);
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		getContentPane().setLayout(flow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(this.getClass().getResource("docs/program-icon.png")).getImage());
/*		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());*/  
		setBounds(0, 0, 1300, 700);	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInformaesPessoais = new JMenu("Usuário");
		menuBar.add(mnInformaesPessoais);
		
		JMenuItem mntmVisualizarInformaes = new JMenuItem("Alterar Informa\u00E7\u00F5es");
		mntmVisualizarInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnInformaesPessoais.add(mntmVisualizarInformaes);
		
		JMenuItem mntmAlterarSenha = new JMenuItem("Visualizar Ranking");
		mnInformaesPessoais.add(mntmAlterarSenha);
		
		JMenu menuApostas = new JMenu("Apostas");
		menuBar.add(menuApostas);
		
		JMenuItem fazerApostaMenuItem  = new JMenuItem("Fazer nova aposta");
		menuApostas.add(fazerApostaMenuItem);
		
		JMenuItem verApostaMenuItem  = new JMenuItem("Visualizar apostas");
		menuApostas.add(verApostaMenuItem);
		
		JMenuItem editarApostaMenuItem  = new JMenuItem("Editar uma aposta");
		menuApostas.add(editarApostaMenuItem);
		
		JMenu menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);
		
		JMenuItem sobreMenuItem  = new JMenuItem("Sobre o programa");
		 menuSobre.add(sobreMenuItem);
		
		 JMenu mnSair = new JMenu("Sair");
		 menuBar.add(mnSair);
		 JMenuItem mntmSair = new JMenuItem("Sair");
		 mnSair.add(mntmSair);
		
		menuBar.add(Box.createHorizontalGlue());
		
		bolao = new MeuBolao();
		JLabel bemVindoLabel = new JLabel();
		bemVindoLabel.setText("Você está logado como " + bolao.getUsuarioLogado().getUsername() + ".");
		menuBar.add(bemVindoLabel);
		bemVindoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		/*mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja sair?");
				if(resposta == 1) {
					
					dispose();

					
				}
			
			}
		});
*/		
		class exitaction implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				bolao = new MeuBolao();
				bolao.desloga();
				dispose();
				telaLogin = new TelaDeLogin();
				telaLogin.show();
			}
		}
		mntmSair.addActionListener(new exitaction());
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * 
		 * 	JLabel lblSelecioneAFase = new JLabel("Selecione a fase do jogo que voc\u00EA deseja apostar:");
		lblSelecioneAFase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelecioneAFase.setBounds(181, 149, 358, 23);
		contentPane.add(lblSelecioneAFase);

		 * 
		 * JComboBox<String> comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setToolTipText("\\ijrery");
		comboBox.setBounds(527, 149, 201, 27);
		comboBox.addItem("Primeira fase");
		comboBox.addItem("Oitavas de Final");
		comboBox.addItem("Quartas de Final");
		comboBox.addItem("Semi-final");
		comboBox.addItem("Final");
		contentPane.add(comboBox);
		*/
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1284, 640);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBoloCopaDo = new JLabel("Bol\u00E3o Copa do Mundo 2014");
		lblBoloCopaDo.setBackground(Color.WHITE);
		lblBoloCopaDo.setBounds(506, 60, 492, 61);
		panel.add(lblBoloCopaDo);
		lblBoloCopaDo.setFont(new Font("Segoe Print", Font.PLAIN, 34));
		
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(396, 11, 113, 161);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/FIFA-World-Cup-2014-Brazil_peq.png")));
		
		JLabel lblBemVindoEssa = new JLabel("Bem vindo! Essa \u00E9 sua p\u00E1gina principal. Voc\u00EA pode acessar as diversas a\u00E7\u00F5es do programa atrav\u00E9s da barra de menu fixada acima.");
		lblBemVindoEssa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBemVindoEssa.setBounds(333, 188, 754, 25);
		panel.add(lblBemVindoEssa);
		

	
	}
}
			
