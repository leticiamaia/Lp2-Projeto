package projetoLp2.bolao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

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

public class TelaDoUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setToolTipText("\\ijrery");
		comboBox.setBounds(385, 238, 150, 27);
		comboBox.addItem("1ª fase");
		comboBox.addItem("2ª fase");
		comboBox.addItem("3ª fase");
		contentPane.add(comboBox);
		
		JLabel lblBoloCopaDo = new JLabel("Bol\u00E3o Copa do Mundo 2014");
		lblBoloCopaDo.setFont(new Font("Segoe Print", Font.PLAIN, 34));
		lblBoloCopaDo.setBounds(363, 64, 499, 91);
		contentPane.add(lblBoloCopaDo);
		
		JLabel lblSelecioneAFase = new JLabel("Selecione a fase:");
		lblSelecioneAFase.setBounds(281, 244, 112, 14);
		contentPane.add(lblSelecioneAFase);
		
		table = new JTable();
		table.setBounds(316, 297, 359, 169);
		contentPane.add(table);
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
