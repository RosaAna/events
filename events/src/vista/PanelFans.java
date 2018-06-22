package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controlador.Controlador;
import controlador.ModelTableDevoluciones;
import controlador.ModelTableFans;
import modelo.FanDTO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Checkbox;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;


public class PanelFans extends JPanel {
	private JTextField textFdniFan;
	private JTextField textFnombreFan;
	private JTextField textFemailFan;
	private boolean cargadoFan=false;
	private JButton btnBorrarFan;
	private JButton btnInsertarFan;
	private JButton btnModificarFan;
	private List<FanDTO> listaFans;
	private JButton btnInsertarFans;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnChico;
	private JRadioButton rdbtnChica;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private ButtonGroup groupButton_participa;
	private ButtonGroup groupButton_sexo;
	private JButton btnGenerarArchivoParticipantes;
	private JScrollPane scrollPane;
	private JTable tablaFan;
	/**
	 * Create the panel.
	 * 
	 */

	public PanelFans() {
		
		 btnBorrarFan = new JButton("BORRAR");
		 btnBorrarFan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
		 
	
	    btnModificarFan = new JButton("MODIFICAR");
		btnModificarFan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
			}
		});
		
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDni.setForeground(Color.WHITE);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(Color.WHITE);
		
		textFdniFan = new JTextField();
		textFdniFan.setColumns(5);
		
		textFnombreFan = new JTextField();
		textFnombreFan.setColumns(5);
		
		textFemailFan = new JTextField();
		textFemailFan.setColumns(5);
		
		JLabel lblFanSeleccionado = new JLabel("Fan");
		lblFanSeleccionado.setForeground(Color.WHITE);
		lblFanSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Fans");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		btnInsertarFans = new JButton("INSERTAR");
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setForeground(Color.WHITE);
		
		JLabel lblParticipa = new JLabel("Participa");
		lblParticipa.setForeground(Color.WHITE);
		lblParticipa.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		dateChooser = new JDateChooser();
	   
		
		groupButton_participa = new ButtonGroup();
		   rdbtnNo = new JRadioButton("No");
		   rdbtnNo.setActionCommand("No");
		   rdbtnNo.setSelected(true);
		   
		   rdbtnSi = new JRadioButton("Si");
		   rdbtnSi.setActionCommand("Si");
		   
		   groupButton_participa.add(rdbtnNo);   
		   groupButton_participa.add(rdbtnSi);
		   
		   
	    groupButton_sexo = new ButtonGroup(); 
		   rdbtnChico = new JRadioButton("Chico");
		   rdbtnChico.setActionCommand("Chico");
		   rdbtnChico.setSelected(true);
		   
		   rdbtnChica = new JRadioButton("Chica");
		   rdbtnChica.setActionCommand("Chica");
		   
		   groupButton_sexo.add(rdbtnChico);   
		   groupButton_sexo.add(rdbtnChica);
		
		btnGenerarArchivoParticipantes = new JButton("GENERAR ARCHIVO PARTICIPANTES JSON");
		
		JPanel panel = new JPanel();
		   
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDni)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblParticipa, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFechaNac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnChico)
											.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
											.addComponent(rdbtnChica))
										.addComponent(textFemailFan, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
										.addComponent(textFnombreFan, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnSi, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
											.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
										.addComponent(textFdniFan, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnInsertarFans, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFanSeleccionado)
							.addGap(73)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(195)
							.addComponent(btnGenerarArchivoParticipantes, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnModificarFan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnBorrarFan, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
							.addGap(357))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(518)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
					.addGap(435))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNewLabel_1)
							.addGap(172)
							.addComponent(lblFanSeleccionado)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFdniFan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDni))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFnombreFan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(lblSexo))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdbtnChico, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnChica, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFemailFan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFechaNac))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnSi, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblParticipa)
								.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnInsertarFans)
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGenerarArchivoParticipantes)
								.addComponent(btnModificarFan)
								.addComponent(btnBorrarFan)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
	/*	
		tablaFan = new JTable();
		tablaFan.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"DNI", "NOMBRE", "SEXO", "EMAIL", "FECHA_NACIMIENTO", "PARTICIPA"
			}
		));
		*/
		
		tablaFan=new JTable(new ModelTableFans());
		scrollPane.setViewportView(tablaFan);
		panel.setLayout(gl_panel);
		tablaFan.setAutoCreateRowSorter(true);
		tablaFan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);	
	
		
			
		

	}



    
	


	public JButton getBtnGenerarArchivoParticipantes() {
		return btnGenerarArchivoParticipantes;
	}







	public ButtonGroup getGroupButton_participa() {
		return groupButton_participa;
	}







	public ButtonGroup getGroupButton_sexo() {
		return groupButton_sexo;
	}







	public JRadioButton getRdbtnChico() {
		return rdbtnChico;
	}







	public JRadioButton getRdbtnChica() {
		return rdbtnChica;
	}







	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}







	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}







	public void setBtnBorrarFan(JButton btnBorrarFan) {
		this.btnBorrarFan = btnBorrarFan;
	}


	

    

	
	public JTable getTablaFan() {
		return tablaFan;
	}



	/**
	 * @return the btnInsertarFan
	 */
	public JButton getBtnInsertarFan() {
		return btnInsertarFan;
	}


	/**
	 * @return the btnInsertarFans
	 */
	public JButton getBtnInsertarFans() {
		return btnInsertarFans;
	}


	/**
	 * @return the textFdniFan
	 */
	public JTextField getTextFdniFan() {
		return textFdniFan;
	}

	/**
	 * @return the textFnombreFan
	 */
	public JTextField getTextFnombreFan() {
		return textFnombreFan;
	}



	/**
	 * @return the textFemailFan
	 */
	public JTextField getTextFemailFan() {
		return textFemailFan;
	}

	/**
	 * @return the cargadoFan
	 */
	public boolean isCargadoFan() {
		return cargadoFan;
	}

	/**
	 * @return the btnBorrarFan
	 */
	public JButton getBtnBorrarFan() {
		return btnBorrarFan;
	}
	/**
	 * @return the btnModificarFan
	 */
	public JButton getBtnModificarFan() {
		return btnModificarFan;
	}



	/**
	 * @return the listaFans
	 */
	public List<FanDTO> getListaFans() {
		return listaFans;
	}
	
		public JDateChooser getDateChooser() {
			return dateChooser;
		}
}
