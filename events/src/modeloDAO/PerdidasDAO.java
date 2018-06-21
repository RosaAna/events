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
import modelo.ParticipanteDTO;
import modelo.Conexion;
import modelo.ConexionProfe;
import modelo.PerdidasDTO;

public class PerdidasDAO  implements IPerdidasDAO{
	private static Connection conexion= Conexion.getInstance();
	GenerarLog lo =new GenerarLog();
	Statement statement;
	String sql;

@Override
public List<PerdidasDTO> getListaPerdidasPorCliente() {
	List<PerdidasDTO> listaPerdidas = new ArrayList<>();
	
String	sql = "SELECT * FROM perdidas ORDER BY DNI_CLIENTE;";
	try(Statement statement=conexion.createStatement();
			ResultSet resultset = statement.executeQuery(sql);) {
		
	
		while (resultset.next()){
			String codigo = resultset.getString("CODIGO_PRODUCTO");
			String dni = resultset.getString("DNI_CLIENTE");
			int importe = resultset.getInt("IMPORTE");
			String fecha=resultset.getString("FECHA");
			PerdidasDTO pd = new PerdidasDTO(codigo, dni, importe, fecha);
			listaPerdidas.add(pd);
		}
			
	} catch (SQLException e2) {
		//System.out.println("No se pudo leer getListaClientes");
	}
	return listaPerdidas;
  }

@Override
public  boolean deletePerdidas(String dni) {

boolean delete= false;
sql = "DELETE FROM perdidas WHERE DNI=? ";
try(PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {

	preparedStatement.setString(1, dni);
	int rows = preparedStatement.executeUpdate();
	if (rows != 0)
		delete = true;
} catch (SQLException e) {

}
return delete;
}
@Override
public int totalPorCliente(String dni) {
	int total=0;
	String	sql = "SELECT COUNT(CODIGO_PRODUCTO) FROM perdidas GROUP BY DNI_CLIENTE HAVING DNI_CLIENTE=? ;";
	try{
		PreparedStatement preparedStatement = conexion.prepareStatement(sql);
		preparedStatement.setString(1, dni);
	    //System.out.println("1");
		ResultSet rs = preparedStatement.executeQuery();
		//System.out.println("2");
	
		total=rs.getInt(1);
				
	} catch (SQLException e2) {
		System.out.println("No se pudo contar;");
	}
 return total;
}




@Override
public List<PerdidasDTO> getListaPerdidasPorProducto() {
	// TODO Auto-generated method stub
	return null;
}



public static Object [][] listaDatos (List<PerdidasDTO> lista){
	Object [][] matriz = new Object [lista.size()][5];
		
		for (int i=0 ; i < lista.size() ;i++){
		matriz[i][0] = lista.get(i).getCodigoProducto();
		matriz[i][1] = lista.get(i).getDniCliente();
		matriz[i][2] = lista.get(i).getImporte();
		matriz[i][3] = lista.get(i).getFecha();
		}
	
	return matriz;	
	}

@Override
public int sumaPerdidas() {
int total=0;
String	sql = "SELECT SUM(IMPORTE) FROM perdidas ;";
 try(Statement statement=conexion.createStatement();
	    ResultSet resultset = statement.executeQuery(sql);) {

    total=resultset.getInt(1);
		
  } catch (SQLException e2) {
	 
  }

	return total;
}


public static void main(String[] args) {
	PerdidasDAO p=new PerdidasDAO();
	System.out.println(p.getListaPerdidasPorCliente());
	//System.out.println(p.sumaPerdidas());
	//System.out.println(p.totalPorCliente("99999999S"));
	System.out.println(p.deletePerdidas(""));
 }








}