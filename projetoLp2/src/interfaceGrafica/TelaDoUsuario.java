package interfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.MeuBolao;

public class TelaDoUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2567460421508989944L;
	private TelaDeLogin telaLogin;
	private AlterarInfoPanel infoPanel;
	private RankingPanel rankingPanel;
	private TelaUserBoasVindas telaBoasVindas;
	private TelaDeNovaAposta telaAposta;

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
	 * 
	 */
	public TelaDoUsuario() {
		infoPanel = new AlterarInfoPanel((Jogador) MeuBolao.getUsuarioLogado());
		telaBoasVindas = new TelaUserBoasVindas();
		telaAposta = new TelaDeNovaAposta();
		telaBoasVindas.setVisible(true);
		try {
			rankingPanel = new RankingPanel();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		setTitle("Bet2Beat - Tela do Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(this.getClass().getResource("/projetoLp2/bolao/docs/program-icon.png")).getImage());
		setBounds(0, 0, 1300, 700);
		setBackground(Color.WHITE);
		setResizable(false);
		add(telaBoasVindas);
		add(infoPanel);
		add(rankingPanel);
		add(telaAposta);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		criaIconeHome(menuBar);

		JMenu informaesPessoaisMenu = new JMenu(" Usu\u00E1rio");
		menuBar.add(informaesPessoaisMenu);

		JMenuItem visualizarInformacoesMenuItem = new JMenuItem(
				"Alterar Informa\u00E7\u00F5es");
		visualizarInformacoesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rankingPanel.setVisible(false);
				telaBoasVindas.setVisible(false);
				telaAposta.setVisible(false);
				infoPanel.setVisible(true);
			}
		});
		 informaesPessoaisMenu.add(visualizarInformacoesMenuItem);

		JMenuItem alterarSenhaMenuItem = new JMenuItem("Visualizar Ranking");
		alterarSenhaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoPanel.setVisible(false);
				telaBoasVindas.setVisible(false);
				telaAposta.setVisible(false);
				rankingPanel.setVisible(true);
			}
		});
		 informaesPessoaisMenu.add(alterarSenhaMenuItem);

		JMenu menuApostas = new JMenu("Apostas");
		menuBar.add(menuApostas);

		JMenuItem fazerApostaMenuItem = new JMenuItem("Fazer nova aposta");
		fazerApostaMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infoPanel.setVisible(false);
				telaBoasVindas.setVisible(false);
				rankingPanel.setVisible(false);
				telaAposta.setVisible(true);
			}
		});
		menuApostas.add(fazerApostaMenuItem);

		JMenuItem verApostaMenuItem = new JMenuItem("Visualizar apostas");
		menuApostas.add(verApostaMenuItem);

		JMenuItem editarApostaMenuItem = new JMenuItem("Editar uma aposta");
		menuApostas.add(editarApostaMenuItem);

		JMenu menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);

		JMenuItem regrasMenuItem = new JMenuItem("Regras do Jogo");
		menuSobre.add(regrasMenuItem);
		
		JMenuItem sobreMenuItem = new JMenuItem("Sobre o Bet2Beat");
		sobreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Program designed by:\n- Let\u00edcia Maia \n- Lucas de Matos \n- Marcela Tejo \n- \u00d2rion Winter \nVersion: 1.0 (2014) \u00A9",
								"Sobre o Bet2Beat",	0,new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/SoccerDukeSmall.png")));
			}
		});
		menuSobre.add(sobreMenuItem);

		JMenu sairMenu = new JMenu("Sair");
		sairMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MeuBolao.desloga();
				dispose();
				telaLogin = new TelaDeLogin();
				telaLogin.setVisible(true);
			}
		});
		menuBar.add(sairMenu);
		
		menuBar.add(Box.createHorizontalGlue());

		JLabel bemVindoLabel = new JLabel();
		bemVindoLabel.setText("Voc\u00ea est\u00e1 logado como " + MeuBolao.getUsuarioLogado().getUsername() + ".");
		menuBar.add(bemVindoLabel);
		bemVindoLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));	
	}

	private void criaIconeHome(JMenuBar menuBar) {
		JLabel espaco = new JLabel("");
		espaco.setText("  ");
		menuBar.add(espaco);

		JLabel casinha = new JLabel("");
		casinha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				infoPanel.setVisible(false);
				rankingPanel.setVisible(false);
				telaAposta.setVisible(false);
				telaBoasVindas.setVisible(true);	
			}
		});
		casinha.setForeground(new Color(0, 0, 0));
		casinha.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/casinha.png")));
		casinha.setBounds(64, 134, 103, 49);
		menuBar.add(casinha);
	}
}
