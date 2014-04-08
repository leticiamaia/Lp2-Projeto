package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaUserBoasVindas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaUserBoasVindas() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1284, 640);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		JLabel bolaoCopaLabel = new JLabel("Bol\u00E3o Copa do Mundo 2014");
		bolaoCopaLabel.setBackground(Color.WHITE);
		bolaoCopaLabel.setBounds(458, 62, 492, 61);
		panel.add(bolaoCopaLabel);
		bolaoCopaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));

		JLabel divisorHorizontalLabel = new JLabel("");
		divisorHorizontalLabel.setIcon(new ImageIcon(TelaDoUsuario.class
				.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		divisorHorizontalLabel.setBounds(420, 106, 530, 28);
		panel.add(divisorHorizontalLabel);

		JLabel logoCopa2014 = new JLabel("");
		logoCopa2014.setBackground(Color.WHITE);
		logoCopa2014.setBounds(335, 11, 113, 161);
		panel.add(logoCopa2014);
		logoCopa2014
				.setIcon(new ImageIcon(
						TelaDoUsuario.class
								.getResource("/projetoLp2/bolao/docs/FIFA-World-Cup-2014-Brazil_peq.png")));

		JLabel boasVindasLabel = new JLabel(
				"Bem vindo! Essa \u00E9 sua p\u00E1gina principal. Voc\u00EA pode acessar as diversas funcionalidades do programa atrav\u00E9s da barra de menu fixada acima.");
		boasVindasLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		boasVindasLabel.setBounds(263, 169, 817, 25);
		panel.add(boasVindasLabel);

		JLabel lblBetbeat = new JLabel("Bet2Beat");
		lblBetbeat.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblBetbeat.setBounds(656, 134, 124, 14);
		panel.add(lblBetbeat);

		NewJPanel tablePanel = new NewJPanel();
		tablePanel.setBounds(341, 205, 640, 388);
		panel.add(tablePanel);
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBorder(null);
		tablePanel.setVisible(true);
	}

}
