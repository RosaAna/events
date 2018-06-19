package vista;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
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

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private Image imagen;
	private JPanel panel;
	private JLabel labelFoto;
	private JPanel panelSB;
	
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
		
		
		textFtotalPerdidas = new JTextField();
		textFtotalPerdidas.setEditable(false);
		textFtotalPerdidas.setColumns(10);
		textFtotalPerdidas.setText(new PerdidasDAO().sumaPerdidas()+"");
		JLabel lblNewLabel_1 = new JLabel("Total p\u00E9rdidas");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_2 = new JLabel("Euros");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		
		JLabel lblPerdidas = new JLabel("DEVOLUCIONES A PERDIDAS");
		lblPerdidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdidas.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPerdidas.setForeground(new Color(0, 102, 153));
		GroupLayout gl_panelSA = new GroupLayout(panelSA);
		gl_panelSA.setHorizontalGroup(
			gl_panelSA.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSA.createSequentialGroup()
					.addGap(56)
					.addComponent(lblPerdidas, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
					.addGap(38))
				.addGroup(gl_panelSA.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panelSA.createSequentialGroup()
					.addGap(97)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFtotalPerdidas, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(117))
		);
		gl_panelSA.setVerticalGroup(
			gl_panelSA.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSA.createSequentialGroup()
					.addGap(75)
					.addComponent(lblPerdidas)
					.addGap(22)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_panelSA.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFtotalPerdidas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panelSA.setLayout(gl_panelSA);
		//PanelPerdidas p= new PanelPerdidas();
       // panelSA.add(p, BorderLayout.CENTER);
        
        
	
		
		panelSB = new JPanel();
		splitPane.setRightComponent(panelSB);
		
		panel = new JPanel();

		JLabel lblProductos = new JLabel("Producto devuelto a p\u00E9rdidas");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductos.setForeground(new Color(0, 102, 153));
		
		
		
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblClientes = new JLabel("Participantes  que lo han devuelto a p\u00E9rdidas");
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
		
		JLabel label = new JLabel("");
		
		labelFoto = new JLabel("");
		//labelFoto.setIcon(new ImageIcon("C:\\Users\\rosa\\Desktop\\a.PNG"));
		labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelFoto, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelFoto, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(46))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
								.addComponent(textFieldDni, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
								.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addGap(138)
							.addComponent(buttonMenosMenos, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(15)))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldSexo, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
								.addComponent(lblSexo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(73))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(buttonMenos, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonMas, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonMasMas, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addGap(6)))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFecha, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldFecha, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSexo)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDni)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonMas)
						.addComponent(buttonMenos)
						.addComponent(buttonMenosMenos)
						.addComponent(buttonMasMas)))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panelSB = new GroupLayout(panelSB);
		gl_panelSB.setHorizontalGroup(
			gl_panelSB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSB.createSequentialGroup()
					.addGap(147)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addGap(144))
				.addGroup(gl_panelSB.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProductos, GroupLayout.PREFERRED_SIZE, 532, Short.MAX_VALUE)
					.addGap(18))
				.addGroup(gl_panelSB.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblClientes, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(gl_panelSB.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
					.addGap(95))
		);
		gl_panelSB.setVerticalGroup(
			gl_panelSB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSB.createSequentialGroup()
					.addGap(46)
					.addComponent(lblProductos, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblClientes, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		panelSB.setLayout(gl_panelSB);
		
	}
	
	
	

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}




	public JPanel getPanelSB() {
		return panelSB;
	}




	public JLabel getLabelFoto() {
		return labelFoto;
	}




	public JPanel getPanel() {
		return panel;
	}




	public Image getImagen() {
		return imagen;
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




	public JTextField getTextFieldDni() {
		return textFieldDni;
	}




	public JTextField getTextFieldFecha() {
		return textFieldFecha;
	}




	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}




	public JTextField getTextFieldSexo() {
		return textFieldSexo;
	}




	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}




	public JButton getButtonMenosMenos() {
		return buttonMenosMenos;
	}




	public JButton getButtonMenos() {
		return buttonMenos;
	}




	public JButton getButtonMas() {
		return buttonMas;
	}




	public JButton getButtonMasMas() {
		return buttonMasMas;
	}
}
