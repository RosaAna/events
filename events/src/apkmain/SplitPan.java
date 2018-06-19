package apkmain;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ModelTablePerdidas;
import controlador.ModelTableVentasParticipantes;
import modeloDAO.PerdidasDAO;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SplitPan extends JPanel {
	private JTable table_SAperdidas;
	private JTextField textFtotalPerdidas;
	private JTextField textFieldDni;
	private JTextField textFieldFecha;
	private JTextField textFieldNombre;
	private JTextField textFieldSexo;
	private JTextField textFieldEmail;
	private JButton buttonMenosMenos;
	private JButton buttonMenos;
	private JButton buttonMas;
	private JButton buttonMasMas;

	
	/**
	 * Create the panel.
	 */
	public SplitPan() {
		setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBounds(10, 11, 1018, 504);
		add(splitPane);
		
		JPanel panelSA = new JPanel();
		splitPane.setLeftComponent(panelSA);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 126, 485, 278);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addContainerGap())
		);
		

		table_SAperdidas = new JTable(new ModelTablePerdidas());
		table_SAperdidas.setAutoCreateRowSorter(true);
		table_SAperdidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_2.setViewportView(table_SAperdidas);
		panel_4.setLayout(gl_panel_4);
		panelSA.setLayout(null);
		panelSA.add(panel_4);
		
		textFtotalPerdidas = new JTextField();
		textFtotalPerdidas.setBounds(235, 415, 86, 20);
		panelSA.add(textFtotalPerdidas);
		textFtotalPerdidas.setColumns(10);
		textFtotalPerdidas.setText(new PerdidasDAO().sumaPerdidas()+"");
		JLabel lblNewLabel_1 = new JLabel("Total p\u00E9rdidas");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(117, 416, 108, 14);
		panelSA.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Euros");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(331, 416, 46, 14);
		panelSA.add(lblNewLabel_2);
		
		JLabel lblPerdidas = new JLabel("DEVOLUCIONES A PERDIDAS");
		lblPerdidas.setBounds(56, 75, 401, 29);
		panelSA.add(lblPerdidas);
		lblPerdidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdidas.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPerdidas.setForeground(new Color(0, 102, 153));
		//PanelPerdidas p= new PanelPerdidas();
       // panelSA.add(p, BorderLayout.CENTER);
        
        
        
		
		JPanel panelSB = new JPanel();
		splitPane.setRightComponent(panelSB);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 81, 465, 152);
		
		JLabel lblProductos = new JLabel("Producto devuelto a p\u00E9rdidas");
		lblProductos.setBounds(10, 46, 475, 24);
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductos.setForeground(new Color(0, 102, 153));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 279, 496, 135);
		
		JLabel lblClientes = new JLabel("Participantes  que lo han devuelto a p\u00E9rdidas");
		lblClientes.setBounds(10, 244, 475, 24);
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(new Color(0, 102, 153));
		
		JLabel lblDni = new JLabel("DNI");
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		JLabel lblSexo = new JLabel("SEXO");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		buttonMenos = new JButton("<");
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		
		buttonMas = new JButton(">");
		
		buttonMasMas = new JButton(">>");
		
		buttonMenosMenos = new JButton("<<");
		
		JLabel lblFecha = new JLabel("Fecha");
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 990, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 152, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		panelSB.setLayout(null);
		panelSB.add(lblProductos);
		panelSB.add(lblClientes);
		panelSB.add(panel_1);
		panelSB.add(panel_2);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(100)
					.addComponent(buttonMenosMenos, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(buttonMenos, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(buttonMas, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(buttonMasMas, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(93))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textFieldDni, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addGap(8)
							.addComponent(textFieldSexo, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(68)
							.addComponent(lblNombre)
							.addGap(65)
							.addComponent(lblSexo)
							.addGap(55)
							.addComponent(lblEmail)
							.addGap(100)))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblFecha)
							.addGap(42))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textFieldFecha, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDni)
						.addComponent(lblNombre)
						.addComponent(lblSexo)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEmail)
							.addComponent(lblFecha)))
					.addGap(11)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonMenosMenos)
						.addComponent(buttonMenos)
						.addComponent(buttonMas)
						.addComponent(buttonMasMas)))
		);
		panel_2.setLayout(gl_panel_2);
		
	}
	
	
	

	/**
	 * @param table_SAperdidas the table_SAperdidas to set
	 */
	public void setTable_SAperdidas(JTable table_SAperdidas) {
		this.table_SAperdidas = table_SAperdidas;
	}

	/**
	 * @param textFtotalPerdidas the textFtotalPerdidas to set
	 */
	public void setTextFtotalPerdidas(JTextField textFtotalPerdidas) {
		this.textFtotalPerdidas = textFtotalPerdidas;
	}



	/**
	 * @return the table_SAperdidas
	 */
	public JTable getTable_SAperdidas() {
		return table_SAperdidas;
	}

	/**
	 * @return the textFtotalPerdidas
	 */
	public JTextField getTextFtotalPerdidas() {
		return textFtotalPerdidas;
	}
}
