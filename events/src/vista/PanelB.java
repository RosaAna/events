package vista;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ModelPanelB;
import controlador.ModelPanelBP;
import controlador.ModelTableVentasParticipantes;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PanelB extends JPanel {
	private JTable tableV;
	private JTable tableP;
	private JTextField textFdni_v;
	private JTextField textFproducto_v;
    private JTextField textFImporte_v;
    private JTextField textFecha_v;
    private JButton btnInsertarVenta;
    private JButton btnAnular_v;
    private JLabel lblNewLabel;
    private JLabel lblimporte;
    private JTextField textFieldFecha;
    private JPanel panel_cli;
    private JTable tableParty;
     /**
	 * Create the panel.
	 */
	public PanelB(){
	
	
		btnAnular_v = new JButton("ANULAR VENTA");
		
		JLabel lblDniv = new JLabel("DNI");
		lblDniv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDniv.setForeground(Color.WHITE);
		
		JLabel lblProducto_v = new JLabel("Cod_Producto");
		lblProducto_v.setForeground(Color.WHITE);
		lblProducto_v.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFdni_v = new JTextField();
		textFdni_v.setColumns(5);
		
		textFproducto_v = new JTextField();
		textFproducto_v.setColumns(5);
		
		textFecha_v = new JTextField();
		textFecha_v.setColumns(5);
		
		JLabel lblVenta = new JLabel("Venta");
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setForeground(Color.WHITE);
		lblVenta.setFont(new Font("Verdana", Font.BOLD, 20));
		
		
		btnInsertarVenta = new JButton("INSERTAR VENTA");
		btnInsertarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                        }
		});
		
		JPanel panel = new JPanel();
		
		JLabel lblProductos = new JLabel("Participantes                   Productos");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblimporte = new JLabel("Importe");
		lblimporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblimporte.setForeground(Color.WHITE);
		
		textFImporte_v = new JTextField();
		textFImporte_v.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		
		lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.WHITE);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		panel_cli = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnInsertarVenta, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblProducto_v, GroupLayout.PREFERRED_SIZE, 136, Short.MAX_VALUE)
											.addGap(11))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblFecha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
												.addComponent(lblimporte, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
											.addGap(34))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblDniv, GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
											.addGap(38)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFdni_v, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(textFproducto_v, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(textFImporte_v, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(textFieldFecha, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
							.addGap(45))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(lblVenta, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_cli, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
							.addGap(7))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(206)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(198))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(396, Short.MAX_VALUE)
					.addComponent(lblProductos, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(621)
					.addComponent(btnAnular_v, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addGap(219))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblProductos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_cli, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblVenta)
							.addGap(28)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFdni_v, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDniv, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addComponent(lblNewLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblProducto_v)
								.addComponent(textFproducto_v, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFImporte_v, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblimporte))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFecha))
							.addGap(36)
							.addComponent(btnInsertarVenta))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAnular_v)
					.addGap(31))
		);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_cli = new GroupLayout(panel_cli);
		gl_panel_cli.setHorizontalGroup(
			gl_panel_cli.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cli.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(11))
		);
		gl_panel_cli.setVerticalGroup(
			gl_panel_cli.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cli.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addContainerGap())
		);
	/*	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"DNI CLIENTE", "NOMBRE"
			}
		));
		scrollPane_2.setViewportView(table);
		panel_cli.setLayout(gl_panel_cli);
		
		*/
		tableParty= new JTable(new ModelTableVentasParticipantes());
		scrollPane_2.setViewportView(tableParty);
		panel_cli.setLayout(gl_panel_cli);
		tableParty.setAutoCreateRowSorter(true);
		tableParty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addContainerGap())
		);
	
		tableP = new JTable(new ModelPanelBP());
		scrollPane.setViewportView(tableP);
		panel_1.setLayout(gl_panel_1);//yo
		tableP.setAutoCreateRowSorter(true);
		tableP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);
		
		
		//---------------------------------------

		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addContainerGap())
		);
		
	
		tableV = new JTable(new ModelPanelB());
		scrollPane_1.setViewportView(tableV);
		panel.setLayout(gl_panel);//yo
		tableV.setAutoCreateRowSorter(true);
		tableV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);
		
		
	
		
		btnAnular_v.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
			
	}
    



	public JTable getTableParty() {
		return tableParty;
	}




	/**
	 * @return the lblimporte
	 */
	public JLabel getLblimporte() {
		return lblimporte;
	}



	/**
	 * @param textFdni_v the textFdni_v to set
	 */
	public void setTextFdni_v(JTextField textFdni_v) {
		this.textFdni_v = textFdni_v;
	}

	/**
	 * @param textFproducto_v the textFproducto_v to set
	 */
	public void setTextFproducto_v(JTextField textFproducto_v) {
		this.textFproducto_v = textFproducto_v;
	}

	

	/**
	 * @return the tableV
	 */
	public JTable getTableV() {
		return tableV;
	}

	/**
	 * @return the textFieldFecha
	 */
	public JTextField getTextFieldFecha() {
		return textFieldFecha;
	}




	/**
	 * @param textFImporte_v the textFImporte_v to set
	 */


	public JTable getTableP() {
		return tableP;
	}

	/**
	 * @return the textFdni_v
	 */
	public JTextField getTextFdni_v() {
		return textFdni_v;
	}

	/**
	 * @return the textFproducto_v
	 */
	public JTextField getTextFproducto_v() {
		return textFproducto_v;
	}



	/**
	 * @return the textFecha_v
	 */
	public JTextField getTextFecha_v() {
		return textFecha_v;
	}


	/**
	 * @return the btnInsertarVenta
	 */
	public JButton getBtnInsertarVenta() {
		return btnInsertarVenta;
	}

	/**
	 * @return the btnAnular_v
	 */
	public JButton getBtnAnular_v() {
		return btnAnular_v;
	}


	
	/**
	 * @return the textFImporte_v
	 */
	public JTextField getTextFImporte_v() {
		return textFImporte_v;
	}
}
