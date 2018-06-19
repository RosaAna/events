package apkmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import controlador.ModelTableFans;
import modelo.FanDTO;

public class PanelFansROSA extends JPanel {
	private JTable tablaFan;
	private JTextField textFdniFan;
	private JTextField textFnombreFan;
	private JTextField textFsexoFan;
	private JTextField textFemailFan;
	private boolean cargadoFan=false;
	private JButton btnBorrarFan;
	private JButton btnInsertarFan;
	private JButton btnModificarFan;
	private JButton btnCargarFan;
	private List<FanDTO> listaFans;
	private JButton btnMenosMenos;
	private JButton btnMenos;
	private JButton btnMas;
	private JButton btnMasMas;
	private JButton btnInsertarFans;
	private JTextField textFnacimiento;
  
	/**
	 * Create the panel.
	 */
	public PanelFansROSA() {
		cargadoFan=false;
		JScrollPane scrollPane = new JScrollPane();
		
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
		
		textFsexoFan = new JTextField();
		textFsexoFan.setColumns(5);
		
		textFemailFan = new JTextField();
		textFemailFan.setColumns(5);
		
		JLabel lblFanSeleccionado = new JLabel("Fan Seleccionado");
		lblFanSeleccionado.setForeground(Color.WHITE);
		lblFanSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
	
	    btnCargarFan = new JButton("CARGAR");
		btnCargarFan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Fans");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		btnMenosMenos = new JButton("<<");
		
		btnMenos = new JButton("<");
		
		btnMas = new JButton(">");
		
		btnMasMas = new JButton(">>");
		btnMasMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnInsertarFans = new JButton("INSERTAR");
		
		textFnacimiento = new JTextField();
		textFnacimiento.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblFechaNac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(18))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblDni)
													.addComponent(lblNombre)))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textFnombreFan, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addComponent(textFsexoFan, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addComponent(textFemailFan, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textFdniFan, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(textFnacimiento, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
									.addGap(54))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(btnInsertarFans)
									.addGap(18)
									.addComponent(btnModificarFan))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(lblFanSeleccionado)))
					.addGap(0)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBorrarFan)
							.addGap(18)
							.addComponent(btnMenosMenos, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnMenos)
							.addGap(18)
							.addComponent(btnMas)
							.addGap(18)
							.addComponent(btnMasMas, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCargarFan)
							.addGap(138))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 719, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(613, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(303))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBorrarFan)
								.addComponent(btnMenosMenos)
								.addComponent(btnMenos)
								.addComponent(btnMas)
								.addComponent(btnMasMas)
								.addComponent(btnCargarFan)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(221)
									.addComponent(lblFanSeleccionado)
									.addGap(26)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFdniFan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDni))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFnombreFan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombre))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFsexoFan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSexo))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFemailFan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFnacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(377)
									.addComponent(lblFechaNac)))
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnInsertarFans)
								.addComponent(btnModificarFan))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		
		
		
		/*
		tablaFan= new JTable();
		tablaFan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "NOMBRE", "APELLIDOS", "EMAIL", "FECHA"
			}
		));
		*/
		scrollPane.setViewportView(tablaFan);
		DefaultTableModel modelo= new DefaultTableModel();
		setLayout(groupLayout);
    	tablaFan = new JTable(new ModelTableFans());
		scrollPane.setViewportView(tablaFan);
		tablaFan.setAutoCreateRowSorter(true);
		tablaFan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tablaFan);
		setLayout(groupLayout);
		String[] sexo= {"Chico", "Chica", "Otro"};
		JComboBox combo=new JComboBox<String>(sexo);
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, combo.getSelectedItem());
			}
			
		});
		TableColumn col=tablaFan.getColumnModel().getColumn(2);
		col.setCellEditor(new DefaultCellEditor(combo));
		 tablaFan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             public void valueChanged(ListSelectionEvent e) {
            	 
              /*   if(!(tablaFan.getSelectionModel().isSelectionEmpty( ))) {
                     int filap = tablaFan.getSelectedRow();
                    
                     String dni = tablaFan.getValueAt(filap, 0).toString();
                     String nombre = tablaFan.getValueAt(filap, 1).toString();
                     String apellidos = tablaFan.getValueAt(filap, 2).toString();
                     String email = tablaFan.getValueAt(filap, 3).toString();
                     String fecha = tablaFan.getValueAt(filap, 4).toString();
                     textFdniFan.setText(dni);
                     textFnombreFan.setText(nombre);
                     textFapellidosFan.setText(apellidos);
                     textFemailFan.setText(email);
                   
                 }
                */ 
             }
            
         });
		
		
		
		
		
		
		
		btnCargarFan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		    }
		 });
			
			
		

	}


	/**
	 * @return the btnMenosMenos
	 */
	public JButton getBtnMenosMenos() {
		return btnMenosMenos;
	}

	/**
	 * @return the btnMenos
	 */
	public JButton getBtnMenos() {
		return btnMenos;
	}

	/**
	 * @return the btnMas
	 */
	public JButton getBtnMas() {
		return btnMas;
	}

	/**
	 * @return the btnMasMas
	 */
	public JButton getBtnMasMas() {
		return btnMasMas;
	}

    

	/**
	 * @return the tablaFan
	 */
	public JTable getTablaFan() {
		return tablaFan;
	}


	/**
	 * @return the textFsexoFan
	 */
	public JTextField getTextFsexoFan() {
		return textFsexoFan;
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
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textFnacimiento;
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
	 * @return the textFapellidosFan
	 */
	public JTextField getTextFapellidosFan() {
		return textFsexoFan;
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
	 * @return the btnCargarFan
	 */
	public JButton getBtnCargarFan() {
		return btnCargarFan;
	}

	/**
	 * @return the listaFans
	 */
	public List<FanDTO> getListaFans() {
		return listaFans;
	}
}
