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
import modelo.DevolucionDTO;
import modelo.Estado;
import modelo.ProductoDTO;

public class DevolucionDAO implements IDevolucionDAO {
	private static Connection conexion= Conexion.getInstance();
	PreparedStatement preparedStatement;
	GenerarLog lo =new GenerarLog();
	DevolucionDTO dvto;
	Statement statement;
	String sql;
	
	@Override
	public List<DevolucionDTO> getListaDevolucionPendienteRevision() {
		List<DevolucionDTO> listDevolucionesPendientesRevison = new ArrayList<>();
		
		String	sql = "SELECT * FROM devoluciones ";
			try {
				Statement statement=conexion.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
			
				while (resultset.next()){
					String dni = resultset.getString("DNI");
					String codigo = resultset.getString("CODIGO_PRODUCTO");
					int importe = resultset.getInt("IMPORTE");
					String estado = resultset.getString("ESTADO");
					String fechaDevolucion=resultset.getString("FECHA_DEVOLUCION");
					DevolucionDTO devolucion = new DevolucionDTO(dni, codigo, importe, estado, fechaDevolucion);
					listDevolucionesPendientesRevison.add(devolucion);
				}
					
			} catch (SQLException e2) {
				//System.out.println("No se pudo leer getListaDevoluciones");
			}
			return listDevolucionesPendientesRevison;	
	
	}

	@Override
	public List<DevolucionDTO> getListaDevolucionEnviadAproductos() {
    List<DevolucionDTO> listDevolucionesEnviadasAventa = new ArrayList<>();
		
		String	sql = "SELECT * FROM devoluciones WHERE ESTADO='CORRECTO'";
			try(Statement statement=conexion.createStatement();
					ResultSet resultset = statement.executeQuery(sql);) {
			
				while (resultset.next()){
					String dni = resultset.getString("DNI");
					String codigo = resultset.getString("CODIGO_PRODUCTO");
					int importe = resultset.getInt("IMPORTE");
					String estado = resultset.getString("ESTADO");
					String fechaDevolucion=resultset.getString("FECHA_DEVOLUCION");
					DevolucionDTO devolucion = new DevolucionDTO(dni, codigo, importe, estado, fechaDevolucion);
					listDevolucionesEnviadasAventa.add(devolucion);
				}
					
			} catch (SQLException e2) {
				//System.out.println("No se pudo leer getListaDevoluciones");
			}
			return listDevolucionesEnviadasAventa;	
	
	}

	public boolean updateEstadoDevolucion(String dni, String codigoProducto) {
		boolean update = false;
	
		sql = "UPDATE devoluciones SET ESTADO='CORRECTO'   WHERE DNI=?  AND CODIGO_PRODUCTO = ?  AND ESTADO='EN REVISION'; ";
		try(PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setString(1, dni);
			preparedStatement.setString(2, codigoProducto);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0) {
			    ProductoDAO pdao=new ProductoDAO();
				update = true;
			}
		} catch (SQLException e) {
			lo.generarLog(dni, "no updateEstadoDevolucion ");

		}
		
		return update;
	}
	
	
	@Override
	public  boolean deleteDevolucion(String dni, String codigoProducto) {
	
	boolean delete= false;
	sql = "DELETE FROM devoluciones WHERE DNI=? AND CODIGO_PRODUCTO = ? AND ESTADO='EN REVISION'";
	try(PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {
	
		preparedStatement.setString(1, dni);
		preparedStatement.setString(2, codigoProducto);
		int rows = preparedStatement.executeUpdate();
		if (rows != 0)
			delete = true;
	} catch (SQLException e) {
		
		lo.generarLog(dni, "no deleteDevolucion ");

	}
	
	return delete;
	
	}
	
	public static Object [][] listaData (List<DevolucionDTO> lista){
		Object [][] matriz = new Object [lista.size()][5];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getDniDC();
			matriz[i][1] = lista.get(i).getCodigoProductoDC();
			matriz[i][2] = lista.get(i).getImporteDC();
			matriz[i][3] = lista.get(i).getEstado();
			matriz[i][4] = lista.get(i).getFechaDevolucion();
			}
		
		return matriz;	
		}
	
	
	
	/*
	public static void main(String[] args) {
	DevolucionDAO dvo=new DevolucionDAO();
	DevolucionDTO dvto=new DevolucionDTO("22225678B", "A7",456,"","" );
	DevolucionDTO dvto2=new DevolucionDTO("22225678B", "A7",456,"","" );
	DevolucionDTO dvt=new DevolucionDTO();
    System.out.println(dvo.getListaDevolucionPendienteRevision());	
	System.out.println(dvo. getListaDevolucionEnviadAproductos());
	System.out.println(dvo.updateEstadoDevolucion("11111111A","A4" ));
    System.out.println(dvo.deleteDevolucion("11111111A", "A3"));
    System.out.println("");
    System.out.println(dvo.getListaDevolucionEnviadAproductos());
    System.out.println(dvo.getListaDevolucionPendienteRevision());
    
	}

*/
	
}
