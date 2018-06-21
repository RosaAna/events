package vista;


import javax.swing.JPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ModelTableParticipantes;
import controlador.ModelTableProductos;
import modelo.FanDTO;
import modelo.ProductoDTO;
import modeloDAO.FansDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import modeloDAO.FansDAO;
import modelo.FanDTO;
public class PanelProductos extends JPanel {
private JTextField textCantidad;
private List<ProductoDTO> listaProductos;
private JTextField textCodigo;
private JTextField textPrecio;
private JButton btnBorrar ;
private JButton btnBuscar ;
private JButton btnInsertarCliente ;
private JButton btnInsertarProducto;
private JButton btnBorrarBaseDatos;
private JTable tablep;

	/**
	 * Create the panel.
	 */
	public PanelProductos()  {
		
		
		JLabel lblCodigo_producto = new JLabel("Codigo");
		lblCodigo_producto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo_producto.setForeground(Color.WHITE);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textCodigo = new JTextField();
		textCodigo.setColumns(5);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(5);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(5);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnInsertarProducto = new JButton("INSERTAR PRODUCTO");	
		btnInsertarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
                            String codigo=getTextCodigo().getText().toString();
                            String preci=getTextPrecio().getText().toString();
                            String cantida=getTextCantidad().getText().toString();
                            int precio=Integer.parseInt(preci);
                            int cantidad=Integer.parseInt(cantida);
                          
                            
                            ProductoDTO co= new ProductoDTO(codigo, precio, cantidad);
                            ProductoDAO po= new ProductoDAO();
              

                            boolean registroProducto=po.addProducto(co);

                            if(registroProducto) {
                                    JOptionPane.showMessageDialog(null, "Registrado correctamente "+registroProducto);
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha podido registrar "+registroProducto);
                            }
                            
                            System.out.println(codigo +""+precio);
                            */
                        }

		
		});
		
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblProductos.setForeground(new Color(255, 255, 255));
		
		btnBorrarBaseDatos = new JButton("CARGAR");
		
		JPanel panel = new JPanel();
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
			
                            String codigo=getTextCodigo().getText().toString();
                            ProductoDTO co= new ProductoDTO(codigo, 0, 0,"");
                            ProductoDAO po= new ProductoDAO();
              

                            boolean updateProducto=po.deleteProducto(codigo);

                            if(updateProducto) {
                                    JOptionPane.showMessageDialog(null, "Borrado correctamente ");
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha podido borrar ");
                            }
                   */         
                            
               }     
		  });
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCodigo_producto)
										.addComponent(lblPrecio))
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textCodigo)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(2)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btnInsertarProducto, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
											.addComponent(textCantidad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
								.addComponent(textPrecio, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(lblProducto, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(69)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
									.addGap(115))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(268)
									.addComponent(btnBorrarBaseDatos, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
									.addGap(47)
									.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
									.addGap(274))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblProductos)
							.addGap(357))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblProductos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBorrar)
								.addComponent(btnBorrarBaseDatos)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(242)
							.addComponent(lblProducto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(57)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPrecio)
										.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(23)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCantidad)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCodigo_producto))))
							.addGap(260)
							.addComponent(btnInsertarProducto)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 624, 301);
		
		tablep = new JTable(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(tablep);
		//tablep.setLayout(gl_panel);
		tablep.setAutoCreateRowSorter(true);
		tablep.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(scrollPane);
		setLayout(groupLayout);	
	
	}
		public JButton getBtnBorrarBaseDatos() {
		return btnBorrarBaseDatos;
	}
	
	
	public JTextField getTextCodigo() {
		// TODO Auto-generated method stub
		return textCodigo;
	}
	/**
	 * @return the btnInsertarProducto
	 */
		
		
	public JButton getBtnInsertarProducto() {
		return btnInsertarProducto;
	}
	
	
	public JTable getTablep() {
		return tablep;
	}
	/**
	 * @return the btnBorrar
	 */
	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	/**

	 * @return the btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	/**
	 
	 * @return the textCantidad
	 */
	public JTextField getTextCantidad() {
		return textCantidad;
	}
	/**
	 * @return the listaProductos
	 */
	public List<ProductoDTO> getListaProductos() {
		return listaProductos;
	}
	/**
	 * @return the textPrecio
	 */
	public JTextField getTextPrecio() {
		return textPrecio;
	}
	/**
	 * @return the btnInsertarCliente
	 */
	public JButton getBtnInsertarCliente() {
		return btnInsertarCliente;
	}
}	
				


