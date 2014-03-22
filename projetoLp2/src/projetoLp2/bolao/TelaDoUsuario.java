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

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDoUsuario extends JFrame {

	private JPanel contentPane;

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
		
		JMenu mnInformaesPessoais = new JMenu("Informa\u00E7\u00F5es Pessoais");
		menuBar.add(mnInformaesPessoais);
		
		JMenuItem mntmVisualizarInformaes = new JMenuItem("Visualizar Informa\u00E7\u00F5es");
		mnInformaesPessoais.add(mntmVisualizarInformaes);
		
		JMenuItem mntmAlterarSenha = new JMenuItem("Alterar senha");
		mnInformaesPessoais.add(mntmAlterarSenha);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnSair.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setToolTipText("\\ijrery");
		comboBox.setBounds(527, 149, 201, 27);
		comboBox.addItem("Primeira fase");
		comboBox.addItem("Oitavas de Final");
		comboBox.addItem("Quartas de Final");
		comboBox.addItem("Semi-final");
		comboBox.addItem("Final");
		contentPane.add(comboBox);
		
		JLabel lblBoloCopaDo = new JLabel("Bol\u00E3o Copa do Mundo 2014");
		lblBoloCopaDo.setFont(new Font("Segoe Print", Font.PLAIN, 34));
		lblBoloCopaDo.setBounds(507, 11, 499, 91);
		contentPane.add(lblBoloCopaDo);
		
		JLabel lblSelecioneAFase = new JLabel("Selecione a fase do jogo que voc\u00EA deseja apostar:");
		lblSelecioneAFase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelecioneAFase.setBounds(181, 149, 358, 23);
		contentPane.add(lblSelecioneAFase);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/flag_brazil.png")));
		lblNewLabel.setBounds(378, 11, 103, 99);
		contentPane.add(lblNewLabel);
		
		JButton btnVisualizaRanking = new JButton("Visualizar Ranking");
		btnVisualizaRanking.setBounds(1021, 219, 163, 47);
		contentPane.add(btnVisualizaRanking);
		
		JPanel panel = new JPanel();
		panel.setBounds(85, 195, 861, 422);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Visualizar suas Apostas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(1021, 293, 163, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(1021, 363, 163, 47);
		contentPane.add(btnNewButton_1);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
