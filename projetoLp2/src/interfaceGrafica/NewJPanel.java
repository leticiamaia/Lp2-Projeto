/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceGrafica;
import java.awt.Color;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;


import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import projetoLp2.bolao.MeuBolao;

/**
 *
 * @author M
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form NewJPanel
     */
    public NewJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    private void initComponents() {
    	MeuBolao bolao = new MeuBolao();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setBorder(new LineBorder(new Color(0, 0, 0)));
        jTable1.setFillsViewportHeight(true);
        setVisible(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        try {
	        jTable1.setModel(new DefaultTableModel( bolao.getRanking(),
	        	/*new String[][] {
	        		{"1�", null, null},
	        		{"2�", null, null},
	        		{"3�", null, null},
	        		{"4�", null, null},
	        		{"5�", null, null},
	        		{"6�", null, null},
	        		{"7�", null, null},
	        		{"8�", null, null},
	        		{"9�", null, null},
	        		{"10�", null, null},
	        	},*/
	        	new String[] {
	        		"Posi\u00E7\u00E3o", "Usu\u00E1rio", "Pontua\u00E7\u00E3o"
	        	}
	        ) {
	        	/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
	        		false, false, false
	        	};
	        	public boolean isCellEditable(int row, int column) {
	        		return columnEditables[column];
	        	}
	        });
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }

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
        
        JLabel lblRaking = new JLabel("Jogadores com as melhores pontua\u00E7\u00F5es");
        lblRaking.setFont(new Font("Calibri Light", Font.PLAIN, 30));
        
        label = new JLabel("");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(16)
        					.addComponent(label))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(70, Short.MAX_VALUE)
        			.addComponent(lblRaking)
        			.addGap(72))
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
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JLabel label;
    // End of variables declaration//GEN-END:variables
}
