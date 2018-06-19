package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.FanDTO;
import modelo.GenerarLog;
import modelo.Conexion;
import modelo.ConexionProfe;
import modelo.ExceptionProducto;
import modelo.ProductoDTO;


public class ProductoDAO implements IProductoDAO {
	private static Connection conexion= Conexion.getInstance();
	GenerarLog lo =new GenerarLog();
	PreparedStatement preparedStatement;
	ProductoDTO pdto;
	String sql=null;
	
	
	@Override
	public List<ProductoDTO> getListaProductos() {
	   List<ProductoDTO> listaProductos=new ArrayList<>();
		String sql=" SELECT * FROM PRODUCTOS ";
		//Creamos el objeto statement
	    try {
			Statement statement=conexion.createStatement();
		   //Creamos el objeto resultSet
		    ResultSet resultSet=statement.executeQuery(sql);

		    while(resultSet.next()) {
		        	String codigo=resultSet.getString("CODIGO_PRODUCTO");
		        	int precio=resultSet.getInt("PRECIO");
		        	int cantidad=resultSet.getInt("CANTIDAD");
		          //  String fecha=resultSet.getString("FECHA");
		        	ProductoDTO producto;
					try {
						producto = new ProductoDTO(codigo, precio, cantidad);
						listaProductos.add(producto);
					} catch (ExceptionProducto e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("No lee getListaProductos");
		}
		
		return listaProductos;
	}
	
	public boolean borrarTablaProductos() {
		boolean borrada=false;
		Statement statement = null;
		try{
			statement = conexion.createStatement();
		    statement.executeUpdate("DELETE FROM  productos;");
		 borrada=true;
	} catch (SQLException e) {
		lo.generarLog("tabla productos", "no borrada ");
	}	
		return borrada;
	}

	@Override
	public List<ProductoDTO> getListaProductosDisponibles() {
		
		   List<ProductoDTO> listaProductosDisponibles=new ArrayList<>();
			 sql=" SELECT * FROM PRODUCTOS WHERE CANTIDAD>0";
			//Creamos el objeto statement
		    try {
				Statement statement=conexion.createStatement();
			   //Creamos el objeto resultSet
			    ResultSet resultSet=statement.executeQuery(sql);
			    while(resultSet.next()) {
			        	String codigo=resultSet.getString("CODIGO_PRODUCTO");
			        	int precio=resultSet.getInt("PRECIO");
			        	int cantidad=resultSet.getInt("CANTIDAD");
			        	//String fecha=resultSet.getString("FECHA");
			           // LocalDate fecha=resultSet.getDate("FECHA").toLocalDate();
			        	ProductoDTO producto;
						try {
							producto = new ProductoDTO(codigo, precio, cantidad);
							 listaProductosDisponibles.add(producto);
						} catch (ExceptionProducto e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
 
			    }       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println("No lee getListaProductosDisponibles");
			}
		
		
		
		// TODO Auto-generated method stub
		return listaProductosDisponibles;
	}

	@Override
	public boolean deleteProducto(String codigoProducto) {
		boolean delete= false;
		sql = "DELETE FROM productos WHERE CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, codigoProducto);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
		} catch (SQLException e) {
			lo.generarLog(codigoProducto, " no deleteProducto");

		}
		
		return delete;
	}
    
	@Override
	public boolean updatePrecioProducto(String codigo, int precioProducto) {
		// TODO Auto-generated method stub
		boolean update = false;
		// UPDATE productos SET PRECIO="" WHERE CODIGO_PRODUCTO = "";
		sql = "UPDATE productos SET PRECIO=?   WHERE CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			System.out.println("1");
			preparedStatement.setInt(1, precioProducto);
			System.out.println("2");
			preparedStatement.setString(2, codigo);
			System.out.println("3");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update = true;
		} catch (SQLException e) {
			
			lo.generarLog(codigo, " no updatePrecioProducto");
		}
		
		return update;
	}

	@Override
	public boolean addProducto(ProductoDTO producto) {
		boolean add = false;
		
		String sql = "INSERT INTO productos(CODIGO_PRODUCTO, PRECIO, CANTIDAD) VALUES (?, ? , ?)";
		try {
		    preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, producto.getCodigo_producto());
			preparedStatement.setInt(2, producto.getPrecio());
			preparedStatement.setInt(3, producto.getCantidad());
			//preparedStatement.setString(4, producto.getFecha());
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				add = true;
		} catch (SQLException e) {
			lo.generarLog(producto.getCodigo_producto(), " no adProducto por object");

		}
		
		return add;
	}

	@Override
	public boolean addListaProducto(List<ProductoDTO> listaProductos) {
		// TODO Auto-generated method stub
		boolean addLista = false;
		ProductoDAO pd=new ProductoDAO();
		int contador=0;
		for( ProductoDTO po: listaProductos) {
			pd.addProducto(po);
			if(addProducto(po))
			 addLista=true;
			
		}
		
		return addLista;
	}
	
	public boolean  productoCantidadMenosUno(String codigo) {
		boolean update = true;
		// UPDATE productos SET CANTIDAD=CANTIDAD-1  WHERE CODIGO_PRODUCTO = "";
		sql = "UPDATE productos SET CANTIDAD=CANTIDAD-1   WHERE CODIGO_PRODUCTO = ?;";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, codigo);
			System.out.println("3");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update =true;	
		} catch (SQLException e) {
		
			lo.generarLog(codigo, " no productoCantidadMenosUno");
		}
		
			
	return update;	
		
	}
	
	public boolean  productoCantidadMasUno(String codigo) {
		boolean update =false;
		// UPDATE productos SET CANTIDAD=CANTIDAD+1  WHERE CODIGO_PRODUCTO = "";
		sql = "UPDATE productos SET CANTIDAD=CANTIDAD+1   WHERE CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, codigo);
			System.out.println("3");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update =true;	
		} catch (SQLException e) {
			lo.generarLog(codigo, " no productoCantidadMasUno");
		}
		
			
	return update;	
		
	}
	
	public static Object [][] listaData (List<ProductoDTO> lista){
		Object [][] matriz = new Object [lista.size()][3];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getCodigo_producto();
			matriz[i][1] = lista.get(i).getPrecio();
			matriz[i][2] = lista.get(i).getCantidad();
			//matriz[i][3] = lista.get(i).getFecha();
			}
		
		return matriz;	
		}
	

	
	/*

	public static void main(String[] args) {
		ProductoDAO p =new ProductoDAO();
		//System.out.println("Lista Productos Todos");
		//System.out.println(p.getListaProductos());
		
	  //  System.out.println("Lista Productos Disponibles");
	    //System.out.println(p.getListaProductosDisponibles());
		ProductoDTO p2 =new ProductoDTO("C4488eee",186 ,100);
    	System.out.println(p.addProducto(p2));
		//System.out.println(p.deleteProducto("B26"));
	    ProductoDTO pdt=new ProductoDTO("A1", 186, 100);
	   // System.out.println(p.updatePrecioProducto(pdt, 9800));
	    //System.out.println(p.productoCantidadMenosUno("A1"));
	  //  System.out.println(p.getListaProductosDisponibles());
	    //System.out.println(p.productoCantidadMasUno(pdt));
	    //System.out.println(p.productoCantidadMenosUno("C23"));
	   // System.out.println(p.borrarTablaProductos());
	    System.out.println(p.getListaProductosDisponibles());
	    
		List<ProductoDTO> lp=new ArrayList<>();
		ProductoDTO pt1=new ProductoDTO("C23mmm",334,100);
		ProductoDTO pt2=new ProductoDTO("mmm",364,100);
		ProductoDTO pt3=new ProductoDTO("C25mmm",384,100);
		ProductoDTO pt4=new ProductoDTO("C26mmm",394,100);
		lp.add(pt4);
		lp.add(pt3);
		lp.add(pt2);
		lp.add(pt1);
		System.out.println(p.addListaProducto(lp));
		
	}
*/
}
