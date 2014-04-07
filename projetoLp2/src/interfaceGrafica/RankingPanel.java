package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import projetoLp2.bolao.MeuBolao;

public class RankingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7796197211046315244L;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public RankingPanel() throws Exception {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		setVisible(false);

		JLabel lblNewLabel = new JLabel("Ranking");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		lblNewLabel.setBounds(10, -44, 378, 145);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RankingPanel.class
				.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		lblNewLabel_1.setBounds(-183, 38, 618, 21);
		add(lblNewLabel_1);

		NewJPanel tablePanel = new NewJPanel();
		tablePanel.setBounds(339, 70, 640, 388);
		add(tablePanel);
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBorder(null);
		tablePanel.setVisible(true);

		initComponents();
	}

	private void initComponents() throws Exception {
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jTable1.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTable1.setFillsViewportHeight(true);
		setVisible(true);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jTable1.setDefaultRenderer(String.class, centerRenderer);
		jTable1.setModel(new DefaultTableModel(MeuBolao.getRankingUsuario(),
				new String[] { "Sua Posi\u00E7\u00E3o", "Seu Usu\u00E1rio",
						"Sua Pontua\u00E7\u00E3o" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		jTable1.getColumnModel().getColumn(0).setResizable(false);
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(1).setResizable(false);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(302);
		jTable1.getColumnModel().getColumn(2).setResizable(false);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(68);
		jTable1.getTableHeader().setReorderingAllowed(false);
		jTable1.setRowHeight(30);
		jTable1.setEditingColumn(0);
		jTable1.setEditingRow(0);
		jScrollPane1.setViewportView(jTable1);
		setBackground(Color.WHITE);

		JLabel lblRaking = new JLabel("");
		lblRaking.setFont(new Font("Calibri Light", Font.PLAIN, 30));

		label = new JLabel("");
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(16)
					.addComponent(label)
					.addContainerGap(1268, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(1212, Short.MAX_VALUE)
					.addComponent(lblRaking)
					.addGap(72))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(337, Short.MAX_VALUE)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE)
					.addGap(304))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(52)
							.addComponent(label))
						.addGroup(layout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblRaking, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
					.addGap(430)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private JLabel label;
	// End of variables declaration//GEN-END:variables
}
