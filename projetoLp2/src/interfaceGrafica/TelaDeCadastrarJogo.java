package interfaceGrafica;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;


public class TelaDeCadastrarJogo extends JFrame {
	
	private static final long serialVersionUID = -239342797923874L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField abrevTime1;
	private JTextField abrevTime2;
	private String time1, time2, data;
	
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
	public TelaDeCadastrarJogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 700);	
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TelaDoAdministradorLabel = new JLabel("Tela de Cadastro");
		TelaDoAdministradorLabel.setBounds(502, 23, 378, 52);
		TelaDoAdministradorLabel.setFont(new Font("Segoe Print", Font.PLAIN, 32));
		contentPane.add(TelaDoAdministradorLabel);
		
		abrevTime1 = new JTextField();
		abrevTime1.setBounds(319, 302, 137, 36);
		contentPane.add(abrevTime1);
		abrevTime1.setColumns(10);
		
		abrevTime2 = new JTextField();
		abrevTime2.setColumns(10);
		abrevTime2.setBounds(839, 302, 137, 36);
		contentPane.add(abrevTime2);
		
		JLabel lblNewLabel = new JLabel("Time1");
		lblNewLabel.setBounds(286+33, 250, 223, 40);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Time2");
		label.setBounds(791+45, 250, 223, 40);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(577, 302, 137, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("DD/MM/AAAA");
		lblNewLabel_1.setBounds(577, 263, 187, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("CADASTRAR!");
		btnCadastrar.setBounds(522, 411, 246, 52);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				time1 = abrevTime1.getText();
				time2 = abrevTime2.getText();
				data = textField.getText();
				JOptionPane.showMessageDialog(null,
						"Nada foi feito com sucesso!");
			}
		});
		
		
	}
}

