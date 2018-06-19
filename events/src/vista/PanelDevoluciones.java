package vista;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ModelPanelB;
import controlador.ModelTableDevoluciones;
import controlador.ModelTableProductos;
import modelo.DevolucionDTO;
import modeloDAO.DevolucionDAO;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class PanelDevoluciones extends JPanel {
	
	private JTable table;
	private List<DevolucionDTO> listaDevoluciones;
	private JButton btnAPerdidas;
	private JButton btnAVentas;
	private JLabel lblFoto;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;

	/**
	 * Create the panel.
	 */
	public PanelDevoluciones() {
		
		JPanel panel = new JPanel();
		
		btnAPerdidas = new JButton("A PERDIDAS");
		
		btnAVentas = new JButton("A VENTAS");
		
		JLabel lblNewLabel = new JLabel("Devoluciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"INCIDENCIAS", "DEVOLUCIONES", ""}));
		
		scrollPane_1 = new JScrollPane();
		//lblFoto.setIcon(new ImageIcon("C:\\Users\\rosa\\Desktop\\pyton.PNG"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(383)
					.addComponent(btnAPerdidas, GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAVentas, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
					.addGap(291))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(194)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFoto, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(comboBox, 0, 31, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(258)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addGap(279))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAVentas)
								.addComponent(btnAPerdidas)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	
	/*	
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"DNI CLIENTE", "CODIGO PRODUCTO", "IMPORTE", "ESTADO", "FECHA"
			}
		));
		*/
	
		
		
		table=new JTable(new ModelTableDevoluciones());
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);	
		
		
		
		
		
		
		
                btnAPerdidas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	/*
                            if(!(table.getSelectionModel().isSelectionEmpty( ))) {

                                int filad = table.getSelectedRow();
                                String dni=table.getValueAt(filad, 0).toString();
                                String codigo_producto=table.getValueAt(filad, 1).toString();
                                DevolucionDAO d=new DevolucionDAO();

                                boolean borrar=d.deleteDevolucion(dni, codigo_producto);
                                if(borrar) {
                                        JOptionPane.showMessageDialog(null, "Se ha enviado a pérdidas");
                                } else {
                                        JOptionPane.showMessageDialog(null, "No ha sido posible enviar a pérdidas");
                                }
                                
                           }
                           
                           */
                    }
		 });
                
                btnAVentas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	/*
                            if(!(table.getSelectionModel().isSelectionEmpty( ))) {
                  
                                int filad = table.getSelectedRow();
                                String dnis=table.getValueAt(filad, 0).toString();
                                String codigo_productos=table.getValueAt(filad, 1).toString();
                                String importes=table.getValueAt(filad, 2).toString().toString();
                                String estados=table.getValueAt(filad, 3).toString().toString();
                                String fecha_devolucions=table.getValueAt(filad, 4).toString();
                                
                                int importe =Integer.parseInt(importes);
                                DevolucionDAO d=new DevolucionDAO();
                                DevolucionDTO dto=new DevolucionDTO(dnis, codigo_productos, importe, estados, fecha_devolucions);

                                boolean aVentas=d.updateEstadoDevolucion(dnis, codigo_productos);
                                
                            if(aVentas) {
                                    JOptionPane.showMessageDialog(null, "Se ha enviado a ventas");
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha enviado a ventas.Revise estado");
                            }
                            
                        }
                        */      
                    }
		 });
			
}
	


public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}



public JTextArea getTextArea() {
		return textArea;
	}



public JComboBox getComboBox() {
		return comboBox;
	}



public JLabel getLblFoto() {
		return lblFoto;
	}



/**
 * @return the table
 */
public JTable getTable() {
	return table;
}

/**
 * @return the listaDevoluciones
 */
public List<DevolucionDTO> getListaDevoluciones() {
	return listaDevoluciones;
}

/**
 * @return the btnAPerdidas
 */
public JButton getBtnAPerdidas() {
	return btnAPerdidas;
}

/**
 * @return the btnAVentas
 */
public JButton getBtnAVentas() {
	return btnAVentas;
}



public void setTextArea(JTextArea textArea) {
	this.textArea = textArea;
}


}
