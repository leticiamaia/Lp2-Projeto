package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

import projetoLp2.bolao.MeuBolao;

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
					TelaDoUsuario frame = new TelaDoUsuario(new TelaDeLogin().getLogin);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public TelaDoUsuario(String user) {
		setTitle("Tela do Usu\u00E1rio");
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		getContentPane().setLayout(flow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(this.getClass().getResource("/projetoLp2/bolao/docs/program-icon.png")).getImage());
/*		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());*/  
		setBounds(0, 0, 1300, 700);	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInformaesPessoais = new JMenu("Usu\u00E1rio");
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
		sobreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Program designed by:\n- Letícia Maia \n- Lucas de Matos \n- Marcela Tejo \n- Órion Winter \nVersion: 1.0 - 2014", "Sobre nós", 0, new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/selo-RA-200.jpg")));
			}
		});
		 menuSobre.add(sobreMenuItem);
		
		 JMenu mnSair = new JMenu("Sair");
		 menuBar.add(mnSair);
		 JMenuItem mntmSair = new JMenuItem("Sair");
		 mnSair.add(mntmSair);
		
		menuBar.add(Box.createHorizontalGlue());
		
			
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
		
		bolao = new MeuBolao();
		JLabel bemVindoLabel = new JLabel();
		bemVindoLabel.setText("Você está logado como " + user + ".");
		menuBar.add(bemVindoLabel);
		bemVindoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13)); 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1284, 191);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblBoloCopaDo = new JLabel("Bol\u00E3o Copa do Mundo 2014");
		lblBoloCopaDo.setBackground(Color.WHITE);
		lblBoloCopaDo.setBounds(458, 62, 492, 61);
		panel.add(lblBoloCopaDo);
		lblBoloCopaDo.setFont(new Font("Segoe Print", Font.PLAIN, 34));
		
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(335, 0, 113, 161);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/FIFA-World-Cup-2014-Brazil_peq.png")));
		
		JLabel lblBemVindoEssa = new JLabel("Bem vindo! Essa \u00E9 sua p\u00E1gina principal. Voc\u00EA pode acessar as diversas a\u00E7\u00F5es do programa atrav\u00E9s da barra de menu fixada acima.");
		lblBemVindoEssa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBemVindoEssa.setBounds(261, 160, 754, 25);
		panel.add(lblBemVindoEssa);
		
		JLabel rankingLabel = new JLabel("Ranking");
		rankingLabel.setBounds(323, 234, 317, 61);
		panel.add(rankingLabel);
		rankingLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		NewJPanel tablePanel = new NewJPanel();
	    tablePanel.setBounds(327, 202, 665, 386);
	    tablePanel.setVisible(true);
	    contentPane.add(tablePanel);
		
	 /*  JButton btnNewButton = new JButton("Atualizar Tabela");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/refresh.png")));
		btnNewButton.setBounds(583, 578, 152, 35);
		contentPane.add(btnNewButton);
		contentPane.add(tablePanel);*/
	
	}
}
			
