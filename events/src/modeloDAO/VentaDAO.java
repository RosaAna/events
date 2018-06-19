package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.FanDTO;
import modelo.GenerarLog;
import modelo.Conexion;
import modelo.ConexionProfe;
import modelo.ProductoDTO;
import modelo.VentaDTO;

public class VentaDAO implements IVentaDAO {
	private static Connection conexion= Conexion.getInstance();
	GenerarLog lo =new GenerarLog();
	PreparedStatement preparedStatement;
    VentaDTO vdto;
	String sql=null;
	
	@Override
	public List<VentaDTO> getListaVentas() {
		  List<VentaDTO> listaVentas=new ArrayList<>();
			String sql=" SELECT * FROM VENTAS ";
		    try {
				Statement statement=conexion.createStatement();
			    ResultSet resultSet=statement.executeQuery(sql);
			    while(resultSet.next()) {
			        	String dniCliente=resultSet.getString("DNI");
			        	String codigoProducto=resultSet.getString("CODIGO_PRODUCTO");
			        	int importe=resultSet.getInt("IMPORTE");
			            String fechaVenta=resultSet.getString("FECHA_VENTA");
			        	VentaDTO venta=new VentaDTO(dniCliente, codigoProducto, importe, fechaVenta);
			            listaVentas.add(venta);
			    }       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listaVentas;
	}
@Override
	public boolean addVenta (String dniCliente, String codigoProducto, int importe) {
    boolean add = false;
 
		String sql = "INSERT INTO ventas(DNI, CODIGO_PRODUCTO, IMPORTE) VALUES (?, ?, ?);";
		try {
			
		    preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, dniCliente);
			preparedStatement.setString(2, codigoProducto);
			preparedStatement.setInt(3, importe);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0) {
				add=true;
			}
			
		} catch (SQLException e) {
			lo.generarLog(dniCliente, " no adVenta");
		}
		
		return add;
		
	}

	@Override
	public boolean deleteVenta(String dni, String  codigoProducto, String fecha) {
		boolean delete= false;
		sql = "DELETE FROM ventas WHERE DNI = ? AND CODIGO_PRODUCTO = ? AND FECHA_VENTA=?;";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			preparedStatement.setString(2, codigoProducto);
			preparedStatement.setString(3, fecha);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
		} catch (SQLException e) {
			lo.generarLog(dni, " no deleteVenta");	

		}
		
		return delete;
	}
	
	public static Object [][] listaData (List<VentaDTO> lista){
		Object [][] matriz = new Object [lista.size()][4];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getDniCliente();
			matriz[i][1] = lista.get(i).getCodigoProducto();
			matriz[i][2] = lista.get(i).getImporte();
			matriz[i][3] = lista.get(i).getFechaVenta();
			}
		
		return matriz;	
		}
	
	
	
/*	
	public static void main(String[] args) {
		//VentaDAO vdao=new VentaDAO();
		//FanDTO cd= new FanDTO("44444444D", "","","","","");
    	//ProductoDTO pd=new ProductoDTO("A7", 787, 0, "");
	   // System.out.println(vdao.addVenta("77777778F", "C0DF", 186));
		//System.out.println(vdao.addVentas());
		//System.out.println(vdao.deleteVenta("77777778G", "C054", "2018-06-05"));
		//System.out.println(vdao.getListaVentas());
	}
*/
}
