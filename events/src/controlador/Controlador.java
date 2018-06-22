package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.itextpdf.text.log.SysoCounter;

import modelo.CargarClientesGson;
import modelo.CargarParticipantesGson;
import modelo.CargarProductosGson;
import modelo.ColorearFilasJTable;
import modelo.CorreoJava;
import modelo.CreaJsonParticipantes;
import modelo.CrearPDF;
import modelo.DevolucionDTO;
import modelo.FanDTO;
import modelo.Filechoossee;
import modelo.GenerarIncidenciaDevolucionesPDF;
import modelo.GenerarPDFtablaDevoluciones;
import modelo.ParticipanteDTO;
import modelo.PerdidasDTO;
import modelo.ProductoDTO;
import modelo.VentaDTO;
import modeloDAO.FansDAO;
import modeloDAO.ParticipanteDAO;
import modeloDAO.DevolucionDAO;
import modeloDAO.PerdidasDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;
import vista.PanelLogin;
import vista.SplitPan;
import vista.Vista;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador implements ActionListener{

private static Vista vista;
private FansDAO fansDAO;
private ProductoDAO productoDAO;
private DevolucionDAO devolucionesDAO;
private ParticipanteDAO participanteDAO;
private PerdidasDAO perdidas;
private SplitPan splipan;
private List<FanDTO> listaFans;
private List<ProductoDTO> listaProductos;
private List<VentaDTO> listaVentas;
private List<DevolucionDTO>listaDevoluciones;
private List<PerdidasDTO> listaPerdidas;
private List<ParticipanteDTO> listaParticipante;
private List<ParticipanteDTO> listaParticipantes;
Matcher rege = null;
boolean comprobarCliente;
boolean comprobarProducto;
boolean comprobarVenta;
private VentaDAO ventasDAO;
private PanelLogin panelLogin;
private CorreoJava c;
private String path;
private int contador=0;
private int contadorIPDF=0;
private int contadorDPDF=0;
private int contadorCargaClientes=0;
private int contadorCargaProductos=0;
private int contadorCargaParty=0;
private String co_p;
  
	public Controlador(Vista vista, FansDAO fansDAO, ProductoDAO productoDAO, VentaDAO ventasDAO,
		DevolucionDAO devolucionesDAO,ParticipanteDAO participanteDAO, PerdidasDAO perdidasDAO) {
	
	this.vista = vista;
	this.productoDAO = productoDAO;
	this.fansDAO=fansDAO;
	this.participanteDAO=participanteDAO;
	this.ventasDAO = ventasDAO;
	this.devolucionesDAO = devolucionesDAO;
	this.perdidas = perdidasDAO;
	actionListener(this);

}

	///------------------------ACTIONLISTENER----------------------------///
	
	private void actionListener(ActionListener oyente) {
	//vista.getPanelLogin().getBtnEntrar().addActionListener(controlador);
	vista.getMntmSalir().addActionListener(oyente);
	vista.getMntmClientes().addActionListener(oyente);
	vista.getMntmParticipantes().addActionListener(oyente);
	vista.getMntmProductos().addActionListener(oyente);
	vista.getMntmSobreNosotros().addActionListener(oyente);
	
	vista.getPanelB().getBtnAnular_v().addActionListener(oyente);
	vista.getPanelB().getBtnInsertarVenta().addActionListener(oyente);
	
	vista.getSplitPan().getButtonMas().addActionListener(oyente);
	vista.getSplitPan().getButtonMasMas().addActionListener(oyente);
	vista.getSplitPan().getButtonMenosMenos().addActionListener(oyente);
	vista.getSplitPan().getButtonMenos().addActionListener(oyente);
	
	
	vista.getPanelFans().getBtnInsertarFans().addActionListener(oyente);
	vista.getPanelFans().getBtnBorrarFan().addActionListener(oyente);
	vista.getPanelFans().getBtnModificarFan().addActionListener(oyente);
	
	vista.getPanelParticipantes().getBtnBorrarBaseDatos().addActionListener(oyente);
	vista.getPanelFans().getBtnGenerarArchivoParticipantes().addActionListener(oyente);
    vista.getPanelParticipantes().getBtnInsertarParty().addActionListener(oyente);
	vista.getPanelParticipantes().getBtnBorrarParty().addActionListener(oyente);
	vista.getPanelParticipantes().getBtnImprimir().addActionListener(oyente);
	vista.getPanelParticipantes().getTextFieldEmail().addActionListener(oyente);
	vista.getPanelParticipantes().getBtnEnviarEmail().addActionListener(oyente);
	
	vista.getPanelDevoluciones().getComboBox().addActionListener(oyente);
	vista.getPanelDevoluciones().getBtnAPerdidas().addActionListener(oyente);
	vista.getPanelDevoluciones().getBtnAVentas().addActionListener(oyente);
    
	vista.getPanelProductos().getBtnBorrarBaseDatos().addActionListener(oyente);
	vista.getPanelProductos().getBtnBorrar().addActionListener(oyente);
	vista.getPanelProductos().getBtnInsertarProducto().addActionListener(oyente);
		
	vista.getPanelB().getTableV().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
              if(!(vista.getPanelB().getTableV().getSelectionModel().isSelectionEmpty( ))) {
            	  vista.getPanelB().getBtnAnular_v().setEnabled(false);
                  vista.getPanelB().getBtnInsertarVenta().setEnabled(true);
                  int fila = vista.getPanelB().getTableV().getSelectedRow();
                    String codigo_producto= vista.getPanelB().getTableV().getValueAt(fila, 0).toString();
                    String importe=vista.getPanelB().getTableV().getValueAt(fila, 1).toString();
                    vista.getPanelB().getTextFproducto_v().setText(codigo_producto);
                    vista.getPanelB().getTextFImporte_v().setText(importe);
                    Calendar fecha = new GregorianCalendar();
                       int aÒo = fecha.get(Calendar.YEAR);
                       int mes = fecha.get(Calendar.MONTH);
                       int dia = fecha.get(Calendar.DAY_OF_MONTH);
                       int hora = fecha.get(Calendar.HOUR_OF_DAY);
                       int minuto = fecha.get(Calendar.MINUTE);
                       int segundo = fecha.get(Calendar.SECOND);
                  
                    vista.getPanelB().getTextFieldFecha().setText(aÒo + "-" + (mes+1) +"-" +dia); 
              }
	});
    vista.getPanelB().getTableP().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelB().getTableP().getSelectionModel().isSelectionEmpty( ))) {
			 vista.getPanelB().getBtnAnular_v().setEnabled(true);
		     vista.getPanelB().getBtnInsertarVenta().setEnabled(false);
         }
         
   	});
    
    
    vista.getPanelDevoluciones().getTable().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {	
      	// JOptionPane.showMessageDialog(null, "1");
   		 if(!(vista.getPanelDevoluciones().getTable().getSelectionModel().isSelectionEmpty( ))) {
   			   int filaP=vista.getPanelDevoluciones().getTable().getSelectedRow();
   			  //JOptionPane.showMessageDialog(null, filaP);
   			   String co_p=vista.getPanelDevoluciones().getTable().getValueAt(filaP, 1).toString();
   			  // JOptionPane.showMessageDialog(null, co_p);
   		       String ruta="C:\\Users\\rosa\\Desktop\\events_img\\"+co_p+".PNG";
   		      // JOptionPane.showMessageDialog(null, ruta);
   		       vista.getPanelDevoluciones().getLblFoto().setIcon(new ImageIcon(ruta));
   		
           }
          
    	}); 
    
    
    vista.getSplitPan().getTable_SAperdidas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {	
  
		 if(!(vista.getSplitPan().getTable_SAperdidas().getSelectionModel().isSelectionEmpty( ))) {
			   int filaP=vista.getSplitPan().getTable_SAperdidas().getSelectedRow();
			   String co_pe=vista.getSplitPan().getTable_SAperdidas().getValueAt(filaP, 0).toString();
			   ParticipanteDAO p =new ParticipanteDAO();
		       listaParticipantes=p.getListaParticipantesAperdidasConCodigoP(co_pe); 
			   colocarFormularioParticipante(contador, listaParticipantes);
			   ColorearFilasJTable colorear = new ColorearFilasJTable();
		       vista.getSplitPan().getTable_SAperdidas().setDefaultRenderer (Object.class, colorear);
		       String ruta="C:\\Users\\rosa\\Desktop\\events_img\\"+co_pe+".PNG";
		       vista.getSplitPan().getLabelFoto().setIcon(new ImageIcon(ruta));
		
        }
       
 	}); 
   
     
    vista.getPanelB().getTableParty().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
 		 if(!(vista.getPanelB().getTableParty().getSelectionModel().isSelectionEmpty( ))) {
 			  vista.getPanelB().getBtnAnular_v().setEnabled(false);
		      vista.getPanelB().getBtnInsertarVenta().setEnabled(true);
 			  int fila = vista.getPanelB().getTableParty().getSelectedRow();
              String dni = vista.getPanelB().getTableParty().getValueAt(fila, 0).toString(); 
              vista.getPanelB().getTextFdni_v().setText(dni);
 		 }
    });
    vista.getPanelProductos().getTablep().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelProductos().getTablep().getSelectionModel().isSelectionEmpty( ))) {
	
            int fila = vista.getPanelProductos().getTablep().getSelectedRow();
            String codigo = vista.getPanelProductos().getTablep().getValueAt(fila, 0).toString();
            String precio= vista.getPanelProductos().getTablep().getValueAt(fila, 1).toString();
            String cantidad=vista.getPanelProductos().getTablep().getValueAt(fila, 2).toString();
            
            vista.getPanelProductos().getTextCodigo().setText(codigo);
            vista.getPanelProductos().getTextPrecio().setText(precio);
            vista.getPanelProductos().getTextCantidad().setText(cantidad);
          
        }
        
  	});
	
    vista.getPanelParticipantes().getTablaPa().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelParticipantes().getTablaPa().getSelectionModel().isSelectionEmpty( ))) {

           int fila = vista.getPanelParticipantes().getTablaPa().getSelectedRow();
           String dni = vista.getPanelParticipantes().getTablaPa().getValueAt(fila, 0).toString();
         }
       
 	});
    
    //Fans
    vista.getPanelFans().getTablaFan().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelFans().getTablaFan().getSelectionModel().isSelectionEmpty( ))) {
	 
      }
      
	});
    
    
    
    
    
	}
	

    ///-----------------------EVENTOS---------------------///
	
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    //JmenuBar
    public void actionPerformed(ActionEvent e) {
	   if (e.getSource().getClass() == JMenuItem.class) {
			  JMenuItem menuItem = (JMenuItem) e.getSource();	
			     if(menuItem.getText().equals("Salir")) {	
			        cerrarAplicacion();
			     }
		         else if(menuItem.getText().equals("Sobre nosotros")) {
                   sobreNosotros();
		         }
		         else {
		    	   // rutaAlFichero();
		         }
	    }
	   
	  
     
   
     //Panel fans CRUD 
  
	 if(e.getSource()==vista.getPanelFans().getBtnInsertarFans()) {
		 FansDAO dao = new FansDAO();
		 insertarFan();
		 cargarFans();
	 }
	 if(e.getSource()==vista.getPanelFans().getBtnBorrarFan()) {
		 FansDAO dao = new FansDAO();
		 borrarFan();
		 cargarFans();
	 }
	 
	 if(e.getSource()==vista.getPanelFans().getBtnModificarFan()) {
	   modificarFan();
	   cargarFans();
	 }
	 //Panel Productos CRUD
	 
	 if(e.getSource()==vista.getPanelProductos().getBtnInsertarProducto()) {
		 insertarProducto();
		 cargarProductos();
		 limpiarTesFProductos();
	 }
	 
	 if(e.getSource()==vista.getPanelProductos().getBtnBorrar()) {
		 borrarProducto();
		 cargarProductos();
		 limpiarTesFProductos();
	 }
	
	 
	 //Panel devoluciones CRUD
	
	 if(e.getSource()==vista.getPanelDevoluciones().getBtnAPerdidas()) {
		 enviarDevolucionAperdidas();
		 cargarDevoluciones();
		 cargarPerdidas();
	 }
	 if(e.getSource()==vista.getPanelDevoluciones().getBtnAVentas()) {
		 enviarDevolucionAventas();
		 cargarDevoluciones();
	     cargarProductos();
     } 
	 
	 
	 //Panel participantes CRUD

	 if(e.getSource()==vista.getPanelParticipantes().getBtnBorrarParty()) {
		 borrarParticipante();
		 cargarParticipantes(); 	
	}	 
	 
	 if(e.getSource()==vista.getPanelParticipantes().getBtnInsertarParty()) {
		 
		insertarParticipante();
		cargarParticipantes();
		  }
	 if(e.getSource()==vista.getPanelParticipantes().getBtnEnviarEmail()) {
	
	 }
	 
     //Panel ventas CRUD
	 if(e.getSource()==vista.getPanelB().getBtnAnular_v()) {
		anularVenta();
		cargarDevoluciones();
		cargarVentas();
	 }
	 
	 if(e.getSource()==vista.getPanelB().getBtnInsertarVenta()) {
			insertarVenta();
			cargarVentas();
		    cargarProductos();
	        limpiarTesFVenta();
	        cargarParticipantes();
		 } 
	 
	 
	  if(e.getSource()==vista.getSplitPan().getButtonMasMas()) {
		
		contador+=2;
		 if(contador>=listaParticipantes.size())
	           contador = 0; 
	       else if (contador < 0) {
		        contador = 0;
		   }
		
		 colocarFormularioParticipante(contador, listaParticipantes);
		
	  }
	 
      if(e.getSource()==vista.getSplitPan().getButtonMas()){
    	  contador++;
		 if(contador>=listaParticipantes.size())
	           contador = 0; 
	       else if (contador < 0) {
		        contador = 0;
		   }
		
		 colocarFormularioParticipante(contador, listaParticipantes);
		
	  }
    
     if(e.getSource()==vista.getSplitPan().getButtonMenosMenos()) {
		 
		contador-=2;
		 if(contador>=listaParticipantes.size())
	           contador = 0; 
	       else if (contador < 0) {
		        contador = 0;
		   }
		
		 colocarFormularioParticipante(contador, listaParticipantes);
	  }
    
     if(e.getSource()==vista.getSplitPan().getButtonMenos()) {
 
		contador--; 
		 if(contador>=listaParticipantes.size())
	           contador = 0; 
	       else if (contador < 0) {
		        contador = 0;
		   }
		
		 colocarFormularioParticipante(contador, listaParticipantes);
	  }
      
     if(e.getSource()==vista.getPanelParticipantes().getBtnImprimir()) {
    	CrearPDF cpdf = new CrearPDF();
    	cpdf.imprimirJTable(vista.getPanelParticipantes().getTablaPa());
     }
     
     if(e.getSource()==vista.getMntmClientes()) {
      if(contadorCargaClientes==0) {
    	JOptionPane.showMessageDialog(null, "Este proceso puede tardar unos segundos en varios procesos");	 
 		FansDAO po =new FansDAO(); 
 		po.crearTablaFans();
 		List<FanDTO> lista=CargarClientesGson.leeJsonGson(Filechoossee.darRuta());
 		po.addListaFans(lista);
 		       cargarFans();
 		       contadorCargaClientes++;
 		 
    	}else {
    		 JOptionPane.showMessageDialog(null, "No pude recargar de nuevo, ya lo ha hecho");	 
    	 }
 	 }
 	 if(e.getSource()==vista.getMntmProductos()) {
 		 if(contadorCargaProductos==0) {
 			JOptionPane.showMessageDialog(null, "Este proceso puede tardar unos segundos");
 			ProductoDAO po =new ProductoDAO();
 			po.borrarTablaProductos();
 			List<ProductoDTO> lista=CargarProductosGson.leeJsonGson(Filechoossee.darRuta());
 			po.addListaProducto(lista); 
 			    cargarProductos();
 			    contadorCargaProductos++;
 
 			   
 		 }else {
 			 JOptionPane.showMessageDialog(null, "No puede recargar de nuevo, ya lo ha hecho");	
 		 }   
 			   
 	 }  

 	 if(e.getSource()==vista.getMntmParticipantes()) {
 		 if(contadorCargaParty==0) {
 			JOptionPane.showMessageDialog(null, "Este proceso puede tardar unos segundos");
			ParticipanteDAO po =new ParticipanteDAO();
			po.borrarTablaParty();
			List<ParticipanteDTO> lista=CargarParticipantesGson.leeJsonGson(Filechoossee.darRuta());
		    JOptionPane.showMessageDialog(null, "Este proceso puede tardar unos segundos");
		    po.addListaParticipantes(lista);
			       cargarParticipantes();
			       contadorCargaParty++;
	  
 	      }else {
 			 JOptionPane.showMessageDialog(null, "No puede recargar de nuevo, ya lo ha hecho");
 			 }
 	 }
 	 if(e.getSource()==vista.getPanelFans().getBtnGenerarArchivoParticipantes()){
 		 JOptionPane.showMessageDialog(null, "Este proceso puede tardar unos segundos");
 		 if(CreaJsonParticipantes.escribeGson()) {
 			JOptionPane.showMessageDialog(null, "El archivo participantes.json ha sido creado en la carpeta Datos del workspace");	 
 		 }
 		 
 		 
 			 
 	 }
 	 
 	if(e.getSource()==vista.getPanelParticipantes().getBtnBorrarBaseDatos()) {
 		ParticipanteDAO po =new ParticipanteDAO();
 		
 		 if(po.borrarTablaParty()) {
			   JOptionPane.showMessageDialog(null, "Se ha recargado la base datos  correctamente ");
		       cargarParticipantes();
		       vista.getPanelParticipantes().getTablaPa().repaint();
		   }else
			   JOptionPane.showMessageDialog(null, "No se podido recargar la base de datos");
 	
 	}
 	if(e.getSource()==vista.getPanelProductos().getBtnBorrarBaseDatos()) {
 		ProductoDAO po =new ProductoDAO();
 		
 		 if(po.borrarTablaProductos()) {
			   JOptionPane.showMessageDialog(null, "Se ha recargado la base datos  correctamente ");
		       cargarProductos();
		       vista.getPanelProductos().getTablep().repaint();
		   }else
			   JOptionPane.showMessageDialog(null, "No se podido recargar la base de datos");
 	       
 	}
    if(e.getSource()==(vista.getPanelDevoluciones().getComboBox())) {
    	informeDevolucion();
    }
    
    if(e.getSource()==vista.getPanelParticipantes().getBtnEnviarEmail()) {
    	CorreoJava c=new CorreoJava();
    	enviarCorreo();
    	enviarCorreosJava();
    }
    
 }   
     //Cierre de los eventos-----------------------------------//	

    
    
    
    
    
    ///--------------------METODOS DE EVENTOS-------------------///
    
	@SuppressWarnings("static-access")
	public  String rutaAlFichero() {
	 JFileChooser jFileChooser = new JFileChooser(".");
	 int resultado = jFileChooser.showOpenDialog(vista.getFrame());
     if (resultado == jFileChooser.APPROVE_OPTION) {
	  path = jFileChooser.getSelectedFile().getPath();  
	 }
	 return path;
	}
	
	 private void cerrarAplicacion() {
		System.exit(0);

	 }

	
	
	 @SuppressWarnings("static-access")
	private void sobreNosotros() {
		JOptionPane jpJOptionPane = new JOptionPane();
		jpJOptionPane.showMessageDialog(vista.getFrame(), 
		"The Event's Singel", "PinBravo",
        JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void darTotalPerdidas() {

	}
	
	public void insertarProducto() {
		String codigo=vista.getPanelProductos().getTextCodigo().getText().toString();
        String preci=vista.getPanelProductos().getTextPrecio().getText().toString();
        String cantida=vista.getPanelProductos().getTextCantidad().getText().toString();
        int precio=Integer.parseInt(preci);
        int cantidad=Integer.parseInt(cantida);
      
        
        ProductoDTO co= new ProductoDTO(codigo, precio, cantidad, "--");
        ProductoDAO po= new ProductoDAO();


        boolean registroProducto=po.addProducto(co);

        if(registroProducto==true) {
                JOptionPane.showMessageDialog(null, "Producto registrado correctamente ");
        } else {
                JOptionPane.showMessageDialog(null, "No se ha podido registrar este producto ");
        }
        
	}
	
	public void borrarProducto() {	
		
		
		if(vista.getPanelProductos().getTablep().getSelectedRow()<0) {
			 JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");	 
	   }
	   else {
          int filaP=vista.getPanelProductos().getTablep().getSelectedRow();
	      String codigo=vista.getPanelProductos().getTablep().getValueAt(filaP, 0).toString();
	      int input = JOptionPane.showConfirmDialog(null, "Est· seguro de borrar este producto?");
	      if(input==0) {
	      ProductoDAO dao=new ProductoDAO();
	      boolean borrar= dao.deleteProducto(codigo);
	      

             if(borrar==true) {
                JOptionPane.showMessageDialog(null, "Producto borrado correctamente ");
             } else {
                JOptionPane.showMessageDialog(null, "No se ha podido borrar este producto ");
             }
	      }
	   }
	}
	
    public void insertarFan() {
         FansDAO dao = new FansDAO();
		 String dni=vista.getPanelFans().getTextFdniFan().getText();
		 String nombre=vista.getPanelFans().getTextFnombreFan().getText();
		 String sexo=null;
		 if(vista.getPanelFans().getRdbtnChica().isSelected()) {
			sexo="Chica"; 
		 }else {
			 sexo="Chico";
		 }
		 String email=vista.getPanelFans().getTextFemailFan().getText();
		 SimpleDateFormat formaFecha= new SimpleDateFormat("yyyy-MM-dd");
		 String fecha=formaFecha.format(vista.getPanelFans().getDateChooser().getDate());
		 String participa=null;
		 if(vista.getPanelFans().getRdbtnNo().isSelected()) {
			participa="No"; 
		 }else {
			 participa="Si";
	     }
		 
		 
		 boolean registro=dao.addFans(dni, nombre, sexo, email, fecha, participa);  
		  if(registro==true) {
		      JOptionPane.showMessageDialog(null, "F. insertado correctamente");
		      vista.getPanelFans().getTextFdniFan().setText("");
		      vista.getPanelFans().getTextFemailFan().setText("");
		      vista.getPanelFans().getTextFnombreFan().setText("");
		      vista.getPanelFans().getGroupButton_sexo().getSelection().getActionCommand();
		      vista.getPanelFans().getGroupButton_participa().getSelection().getActionCommand();
		      vista.getPanelFans().getDateChooser().setCalendar(null);
		      
	       }else {
	    	 JOptionPane.showMessageDialog(null, "F. no pudo ser insertado");
	       }

    }
    
    public void modificarFan() {
    	 FansDAO dao = new FansDAO();
    	 int filad =vista.getPanelFans().getTablaFan().getSelectedRow();
    	 String dni=vista.getPanelFans().getTablaFan().getValueAt(filad, 0).toString();
    	 String nombre=vista.getPanelFans().getTablaFan().getValueAt(filad, 1).toString();
         String sexo=vista.getPanelFans().getTablaFan().getValueAt(filad, 2).toString();
         String email=vista.getPanelFans().getTablaFan().getValueAt(filad, 3).toString();
         String participa=vista.getPanelFans().getTablaFan().getValueAt(filad, 5).toString();
 		
 		 
 		 boolean registro=dao.updateEmailFan(nombre, sexo, email, participa, dni);  
 		  if(registro==true) {
 		      JOptionPane.showMessageDialog(null, "F. modificado correctamente");
 		      vista.getPanelFans().getTextFdniFan().setText("");
 		      vista.getPanelFans().getTextFemailFan().setText("");
 		      vista.getPanelFans().getTextFnombreFan().setText("");
 		      vista.getPanelFans().getGroupButton_sexo().getSelection().getActionCommand();
 		      vista.getPanelFans().getGroupButton_participa().getSelection().getActionCommand();
 		      vista.getPanelFans().getDateChooser().setCalendar(null);
 		      
 	       }else {
 	    	 JOptionPane.showMessageDialog(null, "F. no pudo ser modificado");
 	       }

    }
    public void borrarFan() {
    	if(vista.getPanelFans().getTablaFan().getSelectedRow()<0) {
			 JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");	 
	   }
	   else {
		   
		   int input = JOptionPane.showConfirmDialog(null, "øEst· seguro de borrar esta persona?");
		      if(input==0) {  
         int filaP=vista.getPanelFans().getTablaFan().getSelectedRow();
	      String dni=vista.getPanelFans().getTablaFan().getValueAt(filaP, 0).toString();
	
	      FansDAO dao =new FansDAO();
	      boolean borrar= dao.deleteFan(dni);

        if(borrar) {
           JOptionPane.showMessageDialog(null, "Fan eliminado correctamente ");
        } else {
           JOptionPane.showMessageDialog(null, "No se ha podido eliminar este fan ");
        }
	   }
	  }
    }
    
    public void insertarVenta() {
	     String dni=vista.getPanelB().getTextFdni_v().getText();
         String codigo_producto=vista.getPanelB().getTextFproducto_v().getText();
         String importes=vista.getPanelB().getTextFImporte_v().getText();
         int importe=Integer.parseInt(importes);
         VentaDAO ve=new VentaDAO();

         boolean registroVenta=ve.addVenta(dni, codigo_producto,importe );
         productoDAO.productoCantidadMenosUno(codigo_producto);
         if(registroVenta==true) {
              JOptionPane.showMessageDialog(null, "Venta registrada correctamente");
              cargarVentas();
	     }else {
	    	 JOptionPane.showMessageDialog(null, "Venta registrada correctamnte");
	     }
     
       
    }
    
    
    public void  enviarDevolucionAventas(){
    	 int filad = vista.getPanelDevoluciones().getTable().getSelectedRow();
         String dnis=vista.getPanelDevoluciones().getTable().getValueAt(filad, 0).toString();
         String codigo_productos=vista.getPanelDevoluciones().getTable().getValueAt(filad, 1).toString();
         String importes=vista.getPanelDevoluciones().getTable().getValueAt(filad, 2).toString().toString();
         String estados=vista.getPanelDevoluciones().getTable().getValueAt(filad, 3).toString().toString();
         String fecha_devolucions=vista.getPanelDevoluciones().getTable().getValueAt(filad, 4).toString();
         
         int importe =Integer.parseInt(importes);
         DevolucionDAO d=new DevolucionDAO();
         DevolucionDTO dto=new DevolucionDTO(dnis, codigo_productos, importe, estados, fecha_devolucions);

         boolean aVentas=d.updateEstadoDevolucion(dnis, codigo_productos);
         productoDAO.productoCantidadMasUno(codigo_productos);
        if(aVentas) {
             JOptionPane.showMessageDialog(null, "Se ha enviado a ventas");
        } else {
             JOptionPane.showMessageDialog(null, "No se ha enviado a ventas.Revise estado");
        }
     	
    }
    
  public void enviarDevolucionAperdidas() {
	  int filad =vista.getPanelDevoluciones().getTable().getSelectedRow();
      String dni=vista.getPanelDevoluciones().getTable().getValueAt(filad, 0).toString();
      String codigo_producto=vista.getPanelDevoluciones().getTable().getValueAt(filad, 1).toString();
      DevolucionDAO d=new DevolucionDAO();

      boolean borrar=d.deleteDevolucion(dni, codigo_producto);
      if(borrar) {
              JOptionPane.showMessageDialog(null, "Se ha enviado a pÈrdidas");
      } else {
              JOptionPane.showMessageDialog(null, "No ha sido posible enviar a pÈrdidas");
      }
      
  } 
  
  
  //MÈtodo para anular la venta
   public void anularVenta() {
	  if(vista.getPanelB().getTableP().getSelectedRow()<0) {
		 JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");	 
		 }
	  int input = JOptionPane.showConfirmDialog(null, "øEst· seguro de anular esta venta?");
      if(input==0) {  
	     int filaVenta=vista.getPanelB().getTableP().getSelectedRow();
		 String dni=vista.getPanelB().getTableP().getValueAt(filaVenta, 0).toString(); 
		 String codigo=vista.getPanelB().getTableP().getValueAt(filaVenta, 1).toString();
		 String importes=vista.getPanelB().getTableP().getValueAt(filaVenta, 2).toString();
		 int importe =Integer.parseInt( importes);
		 String fecha=vista.getPanelB().getTableP().getValueAt(filaVenta, 3).toString();
		 VentaDTO vdto=new VentaDTO(dni, codigo, importe,  fecha);
		 VentaDAO vdao=new VentaDAO();
		 vdao.deleteVenta(dni, codigo, fecha);
      }
  }
   //MÈtodo para insertar un participante
   public void insertarParticipante() {
       ParticipanteDAO dao = new ParticipanteDAO();
		 String dni=vista.getPanelParticipantes().getTextFdniParty().getText();
		 String nombre=vista.getPanelParticipantes().getTextFnombreParty().getText();
		 String sexo;
		 if(vista.getPanelParticipantes().getRdbtnChico().isSelected()) {
			sexo="CHICO"; 
		 }else {
			 sexo="CHICA";
		 }
		 String email=vista.getPanelParticipantes().getTextFemailParty().getText();
		 boolean registro=false;
		 
			if (!isDni(dni)) {
			
			
		    registro=dao.addParticipante(dni, nombre, sexo, email);  
			}
			
		  if(registro==true) {
		      JOptionPane.showMessageDialog(null, "P. insertado correctamente");
		      vista.getPanelParticipantes().getTextFdniParty().setText("");
		      vista.getPanelParticipantes().getTextFnombreParty().setText("");
		      vista.getPanelParticipantes().getTextFemailParty().setText("");
		      vista.getPanelParticipantes().getGroupButton_sexo().getSelection().getActionCommand();
		      
	       }else {
	    	 JOptionPane.showMessageDialog(null, "P. no pudo ser insertado");
	       
	       }
    }
   
  
   
   public void borrarParticipante() {
	   if(vista.getPanelParticipantes().getTablaPa().getSelectedRow()<0) {
			 JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");	 
	   }
	   else {
		   int input = JOptionPane.showConfirmDialog(null, "øEst· seguro de borrar este participante?");
		      if(input==0) {  
          int filaP=vista.getPanelParticipantes().getTablaPa().getSelectedRow();
	      String dni=vista.getPanelParticipantes().getTablaPa().getValueAt(filaP, 0).toString();
	
	      ParticipanteDAO dao =new ParticipanteDAO();
	      boolean borrar= dao.deleteParticipante(dni);

         if(borrar) {
            JOptionPane.showMessageDialog(null, "Participante eliminado correctamente ");
         } else {
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar este participante ");
         }
	   }
	  } 
   }
   
 
   public void cargarVentas() {
	  ModelPanelBP.setData(VentaDAO.listaData(new VentaDAO().getListaVentas()));
	  vista.getPanelB().getTableP().setModel(new controlador.ModelPanelBP());
	  vista.getPanelB().getTableP().repaint();
   }
   public void cargarDevoluciones() {
	   ModelTableDevoluciones.setData(DevolucionDAO.listaData(new DevolucionDAO().getListaDevolucionPendienteRevision()));
	   vista.getPanelDevoluciones().getTable().setModel(new controlador.ModelTableDevoluciones());
	   vista.getPanelDevoluciones().getTable().repaint();  
   }
   public void cargarPerdidas() {
	   ModelTablePerdidas.setData(PerdidasDAO.listaDatos(new PerdidasDAO().getListaPerdidasPorCliente()));	
	   vista.getSplitPan().getTable_SAperdidas().setModel(new controlador.ModelTablePerdidas()); 
	   vista.getSplitPan().getTable_SAperdidas().repaint();	
   }
   public void cargarParticipantes() {
      ModelTableParticipantes.setData(ParticipanteDAO.listaData(new ParticipanteDAO().getListaParticipantes()));
      vista.getPanelParticipantes().getTablaPa().setModel(new controlador.ModelTableParticipantes()); 
	  ModelTableVentasParticipantes.setData(ParticipanteDAO.listaData(new ParticipanteDAO().getListaParticipantes()));
	  vista.getPanelB().getTableParty().setModel(new controlador.ModelTableParticipantes());
	  vista.getPanelParticipantes().getTablaPa().repaint();
	  vista.getPanelB().getTableParty().repaint();
   }
   public void cargarFans() {
	ModelTableFans.setData(FansDAO.listaData(new FansDAO().getListaFans()));
  	vista.getPanelFans().getTablaFan().setModel(new controlador.ModelTableFans()); 
   	vista.getPanelFans().getTablaFan().repaint();
     
   }
   
   public void cargarProductos() {
	   ModelTableProductos.setData(ProductoDAO.listaData(new ProductoDAO().getListaProductos()));	
	   vista.getPanelProductos().getTablep().setModel(new controlador.ModelTableProductos());
	   ModelPanelB.setData(ProductoDAO.listaData(new ProductoDAO().getListaProductos()));
	   vista.getPanelB().getTableV().setModel(new controlador.ModelTableProductos());	
	   vista.getPanelProductos().getTablep().repaint();
	   
   }
   public void limpiarTesFVenta() {
	   vista.getPanelB().getTextFdni_v().setText("");
       vista.getPanelB().getTextFproducto_v().setText("");
       vista.getPanelB().getTextFImporte_v().setText("");
       vista.getPanelB().getTextFieldFecha().setText("");
   }
   
  
   
   private void colocarFormularioParticipante(int i, List<ParticipanteDTO> lista) {
		vista.getSplitPan().getTextFieldDni().setText(
				lista.get(i).getDni());
		vista.getSplitPan().getTextFieldNombre().setText(
				lista.get(i).getNombre());
		vista.getSplitPan().getTextFieldSexo().setText(
				lista.get(i).getSexo()+"");
		vista.getSplitPan().getTextFieldEmail().setText(
				lista.get(i).getEmail());
		vista.getSplitPan().getTextFieldFecha().setText(
	    		lista.get(i).getFecha());
	}
   
   public void cargarTableFansComb() {

		String[] party= {"SI", "NO"};
		JComboBox combo=new JComboBox<String>(party);
		
		TableColumn col=vista.getPanelFans().getTablaFan().getColumnModel().getColumn(5);
		col.setCellEditor(new DefaultCellEditor(combo));
		
		String[] sexy= {"CHICO", "CHICA"};
		JComboBox comby=new JComboBox<String>(sexy);
		
		TableColumn coly=vista.getPanelFans().getTablaFan().getColumnModel().getColumn(2);
		coly.setCellEditor(new DefaultCellEditor(comby));  
   }
   
   public void limpiarInformacionClientesAperdidas() {
	   vista.getSplitPan().getTextFieldDni().setText("");
	   vista.getSplitPan().getTextFieldNombre().setText("");
	   vista.getSplitPan().getTextFieldSexo().setText("");
	   vista.getSplitPan().getTextFieldEmail().setText("");
	   vista.getSplitPan().getTextFieldFecha().setText("");
   }
   
   public void limpiarTesFProductos() {
	   vista.getPanelProductos().getTextCodigo().setText("");
       vista.getPanelProductos().getTextPrecio().setText("");
       vista.getPanelProductos().getTextCantidad().setText("");
   }
   public void leerLista() {
	   
   }
   
   
   public boolean isDni(String dni) {

		Pattern miPatron = Pattern.compile("^\\d{8}[A-Z]$");
		rege = miPatron.matcher(dni);
		return rege.matches();
   }
   
   
  public void informeDevolucion() {
	String iten;
	iten=vista.getPanelDevoluciones().getComboBox().getSelectedItem().toString();
	
	if(iten=="INCIDENCIAS") {
	  JOptionPane.showMessageDialog(null, "Crear una incidencia", "", JOptionPane.INFORMATION_MESSAGE);
	  contadorIPDF++;
	  
	  GenerarIncidenciaDevolucionesPDF gp =new GenerarIncidenciaDevolucionesPDF();
	 
	  int filaP=vista.getPanelDevoluciones().getTable().getSelectedRow();
	  String co_pa=vista.getPanelDevoluciones().getTable().getValueAt(filaP, 1).toString();
	  String incidencia=vista.getPanelDevoluciones().getTextArea().getText();
	  gp.createPDF(new File("Datos/Incidencias"+contadorIPDF+".pdf"), incidencia, "C:\\Users\\rosa\\Desktop\\events_img\\"+ co_pa+".PNG", co_pa);
	  contadorIPDF++;
	  vista.getPanelDevoluciones().getTextArea().setText("");;
		//vista.getPanelDevoluciones().getTextArea().setVisible(false);
		//vista.getPanelDevoluciones().getScrollPane_1().setVisible(false);
	}
	
	else {
		JOptionPane.showMessageDialog(null, "Ha entrado en GENERAR PDF INFORME DEVOLUCIONES","", JOptionPane.INFORMATION_MESSAGE); 
         try {
			
			GenerarPDFtablaDevoluciones gpdf=new GenerarPDFtablaDevoluciones();
		    
		    gpdf.crearPDF(new File("Datos/informeTablaDevoluciones"+contadorDPDF+".pdf"), vista.getPanelDevoluciones().getTable());
		    contadorDPDF++;
		 }catch(Exception e) {
			JOptionPane.showMessageDialog(null,  "No ha creado el fichero","", JOptionPane.INFORMATION_MESSAGE);
	      }		
     }
  }
  public void enviarCorreo() {
	 System.out.println("correo inicio");
	c.setContrasena("mjmajcimjnbsmvmf");
	c.setUsuarioCorreo("chavalinesguapos@gmail.com");
	c.setAsunto("Asunto");
	 System.out.println("correo inicio2");
	c.setMensaje(vista.getPanelParticipantes().getTextFemailParty().getText());
	 System.out.println("correo inicio3");
	c.setDestino(vista.getPanelParticipantes().getTextFieldEmail().getText().trim());
	//c.setNombreArchivo("barner.png");
	//c.setRutaArchivo("barner.png");
  } 
  
  
  public boolean enviarCorreosJava() {
		CorreoJava c=new CorreoJava();
	  	    try {
	    		    Properties p=new Properties();
	    	
	    	        p.put("mail.smtp.host", "smtp.gmail.com");
	    	        p.setProperty("mail.smtp.starttls.enable", "true");
	    	        p.setProperty("mail.smtp.port", "587");
	    	        p.setProperty("mail.smtp.user", c.getUsuarioCorreo());
	    	        p.setProperty("mail.smtp.auth", "true");
System.out.println("correo 0");
	    	        Session s= Session.getDefaultInstance(p, null);
	    	        BodyPart texto=new MimeBodyPart();
	    	        texto.setText(c.getMensaje());
	    	        BodyPart adjunto=new MimeBodyPart();
	 System.out.println("correo 1");      
	    	         if(!c.getRutaArchivo().equals("")) {
	    	    	   adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
	    	    	   adjunto.setFileName(c.getNombreArchivo()); 
	    	           }
	    	           MimeMultipart m=new MimeMultipart();
	    	           m.addBodyPart(texto);
	    	       
	    	          if(!c.getRutaArchivo().equals("")) {
	    	    	  m.addBodyPart(adjunto); 
	    	          }
	     System.out.println("correo 2");
	    	          MimeMessage mensaje=new MimeMessage(s);
	    	          mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
	    	          mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(c.getDestino()));
	    	          mensaje.setSubject(c.getAsunto());
	    	          mensaje.setContent(m);
	    	       
	    	         Transport t=s.getTransport("smpt");
	    	         t.connect(c.getUsuarioCorreo(), c.getContrasena());
	    	         t.sendMessage(mensaje, mensaje.getAllRecipients());
	    	         t.close();
	    	         return true;
	 
	    		
	    	}catch(Exception e2) {
	    		//JOptionPane.showMessageDialog(null,  "No se ha podido enviar el correo","", JOptionPane.INFORMATION_MESSAGE);
	    	 return false;
	    	}
	   	}		
   
 


public boolean comprobarFan(boolean clienteVerificar){
	boolean fanComprobar = false, dniComprobar, nombreComprobar, emailComprobar, fechaComprobar = false;
    String dni = vista.getPanelParticipantes().getTextFdniParty().getText();
    
        if(!dni.isEmpty()){
            String dniRgx = "\\d{8}[A-Z]";
            dniComprobar = Pattern.matches(dniRgx, dni);

            String nombreRgx= "[Ò—·ÈÌÛ˙¡…Õ”⁄a-zA-Z]{4,30}";
            String nombre = vista.getPanelParticipantes().getTextFnombreParty().getText();
            nombreComprobar = Pattern.matches(nombreRgx, nombre);

            String emailRgx= "^[a-zA-Z0-9_!#$%&í*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            String email = vista.getPanelParticipantes().getTextFieldEmail().getText();
            emailComprobar = Pattern.matches(emailRgx, email);
         
        
            if((dniComprobar == true) && (nombreComprobar == true) && (emailComprobar == true) && (fechaComprobar == true)){
                fanComprobar=true ;
            } else {
                    fanComprobar = false;
             }
        }
    return fanComprobar;
    }
}
	/*
	public  void acertarLogin() {
		char[] login=vista.getPanelLogin().getPasswordField().getPassword();
    	String pass=new String(login);
    	        JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Has ingresado correctamente", JOptionPane.INFORMATION_MESSAGE);   
    	        activarPestanas();
    	
         	}
    	
    	    else {
    	    	JOptionPane.showMessageDialog(null, "Login o pass incorrecto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    	    	
    	    }
	}
	*/

