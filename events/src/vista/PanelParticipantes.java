package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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

import controlador.Controlador;
import controlador.ModelTableParticipantes;
import modelo.FanDTO;
import modelo.ParticipanteDTO;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PanelParticipantes extends JPanel {
	private JTable tablaPa;
	private JTextField textFdniParty;
	private JTextField textFnombreParty;
	private JTextField textFemailParty;
	private JButton btnBorrarParty;
	private JButton btnInsertarFan;
	private List<ParticipanteDTO> listaParty;
	private JButton btnInsertarParty;
	private JRadioButton rdbtnChico;
	private JRadioButton rdbtnChica;
	private ButtonGroup groupButton_sexo;
	private JButton btnImprimir;
	private JTextField textFieldEmail;
	private JLabel lblNewLabel;
	private JButton btnEnviarEmail;
	private JButton btnBorrarBaseDatos;
	
	

	public ButtonGroup getGroupButton_sexo() {
		return groupButton_sexo;
	}

	/**
	 * Create the panel.
	 */
	public PanelParticipantes() {
		JScrollPane scrollPane = new JScrollPane();
		
		 btnBorrarParty = new JButton("BORRAR");
		 btnBorrarParty.addActionListener(new ActionListener() {
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
		
		textFdniParty = new JTextField();
		textFdniParty.setColumns(5);
		
		textFnombreParty = new JTextField();
		textFnombreParty.setColumns(5);
		
		textFemailParty = new JTextField();
		textFemailParty.setColumns(5);
		
		JLabel lblPartySeleccionado = new JLabel("    Participante ");
		lblPartySeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartySeleccionado.setForeground(Color.WHITE);
		lblPartySeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnInsertarParty = new JButton("INSERTAR");
		
		   groupButton_sexo = new ButtonGroup(); 
		   rdbtnChico = new JRadioButton("Chico");
		   rdbtnChico.setActionCommand("Chico");
		   rdbtnChico.setSelected(true);
		   
		   rdbtnChica = new JRadioButton("Chica");
		   rdbtnChica.setActionCommand("Chica");
		   
		   groupButton_sexo.add(rdbtnChico);   
		   groupButton_sexo.add(rdbtnChica);
		
		btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		btnEnviarEmail = new JButton("ENVIAR EMAIL");
		
		lblNewLabel = new JLabel("Participantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		
		btnBorrarBaseDatos = new JButton("CARGAR");
		btnBorrarBaseDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		   
	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(178)
							.addComponent(btnEnviarEmail)
							.addPreferredGap(ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
							.addComponent(btnBorrarParty)
							.addGap(27)
							.addComponent(btnImprimir)
							.addGap(18)
							.addComponent(btnBorrarBaseDatos)
							.addGap(108))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(31)
											.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(textFdniParty, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFemailParty)))
												.addComponent(lblEmail))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNombre)
												.addComponent(lblSexo))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(rdbtnChico, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(rdbtnChica, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
												.addComponent(textFnombreParty, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
									.addGap(36))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnInsertarParty, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(168))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPartySeleccionado, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
									.addGap(124)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE))
							.addGap(16)))
					.addGap(532))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPartySeleccionado)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDni)
										.addComponent(textFdniParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEmail)
										.addComponent(textFemailParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnChica)
										.addComponent(lblSexo)
										.addComponent(rdbtnChico)))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNombre)
									.addComponent(textFnombreParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnInsertarParty)
							.addGap(26)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnviarEmail)
						.addComponent(btnBorrarBaseDatos)
						.addComponent(btnBorrarParty)
						.addComponent(btnImprimir)))
		);
	
		
	
    	tablaPa = new JTable(new ModelTableParticipantes());
		scrollPane.setViewportView(tablaPa);
		tablaPa.setAutoCreateRowSorter(true);
		tablaPa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);
		
		 tablaPa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             public void valueChanged(ListSelectionEvent e) {
            	 
                
             }
            
         });
			
			
		

	}

	public JButton getBtnBorrarBaseDatos() {
		return btnBorrarBaseDatos;
	}

	public JButton getBtnInsertarFan() {
		return btnInsertarFan;
	}

	public List<ParticipanteDTO> getListaParty() {
		return listaParty;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JButton getBtnEnviarEmail() {
		return btnEnviarEmail;
	}

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public JRadioButton getRdbtnChico() {
		return rdbtnChico;
	}

	public JRadioButton getRdbtnChica() {
		return rdbtnChica;
	}

	
	/**
	 * @return the tablaPa
	 */
	public JTable getTablaPa() {
		return tablaPa;
	}

	/**
	 * @return the textFdniParty
	 */
	public JTextField getTextFdniParty() {
		return textFdniParty;
	}

	/**
	 * @return the textFnombreParty
	 */
	public JTextField getTextFnombreParty() {
		return textFnombreParty;
	}


	
	/**
	 * @return the textFemailParty
	 */
	public JTextField getTextFemailParty() {
		return textFemailParty;
	}

	/**
	 * @return the btnBorrarParty
	 */
	public JButton getBtnBorrarParty() {
		return btnBorrarParty;
	}




	/**
	 * @return the btnInsertarParty
	 */
	public JButton getBtnInsertarParty() {
		return btnInsertarParty;
	}
}
	