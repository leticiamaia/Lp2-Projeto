package projetoLp2.bolao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastro frame = new TelaDeCadastro();
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
	public TelaDeCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 759, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon(this.getClass().getResource("docs/program-icon.png")).getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeNovo = new JLabel("Cadastro de novo usu\u00E1rio");
		lblCadastroDeNovo.setBounds(186, 0, 386, 54);
		lblCadastroDeNovo.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(lblCadastroDeNovo);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeCompleto.setBounds(132, 122, 101, 21);
		contentPane.add(lblNomeCompleto);
		
		textField = new JTextField();
		textField.setBounds(241, 122, 336, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPreenchaOsCampos = new JLabel("Preencha os campos a seguir com suas informa\u00E7\u00F5es. \r\n\n");
		lblPreenchaOsCampos.setLabelFor(this);
		lblPreenchaOsCampos.setToolTipText("");
		lblPreenchaOsCampos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreenchaOsCampos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPreenchaOsCampos.setBounds(214, 65, 327, 21);
		contentPane.add(lblPreenchaOsCampos);
		
		JLabel lblOsCamposMarcados = new JLabel("Os campos marcados com um asterisco (*) s\u00E3o obrigat\u00F3rios.");
		lblOsCamposMarcados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOsCamposMarcados.setBounds(196, 82, 386, 21);
		contentPane.add(lblOsCamposMarcados);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(580, 153, 53, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(188, 154, 45, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 153, 336, 20);
		contentPane.add(textField_1);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsurio.setBounds(180, 183, 53, 21);
		contentPane.add(lblUsurio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(241, 183, 336, 20);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(580, 182, 53, 18);
		contentPane.add(label);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(188, 217, 45, 18);
		contentPane.add(lblSenha);
		
		JLabel lblNewLabel_2 = new JLabel("Confirmar Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(124, 246, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(241, 214, 336, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(241, 244, 336, 20);
		contentPane.add(passwordField_1);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(580, 214, 53, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(580, 246, 53, 18);
		contentPane.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(241, 275, 336, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Pergunta Secreta:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(124, 271, 109, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblResposta = new JLabel("Resposta:");
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResposta.setBounds(168, 301, 57, 21);
		contentPane.add(lblResposta);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(241, 306, 336, 20);
		contentPane.add(passwordField_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(580, 275, 53, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(580, 305, 53, 18);
		contentPane.add(label_4);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
				
			}
		});
		btnNewButton.setBounds(260, 352, 121, 34);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnCancelar.setBounds(413, 352, 121, 34);
		contentPane.add(btnCancelar);
	}
}
