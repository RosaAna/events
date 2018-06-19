package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Conexion;
import modelo.ConexionProfe;
import modelo.FanDTO;
import modelo.GenerarLog;
import modelo.ParticipanteDTO;

public class ParticipanteDAO implements IParticipanteDAO {
		private static Connection conexion= Conexion.getInstance();
		PreparedStatement preparedStatement;
		ParticipanteDTO cdto;
		Statement statement;
		String sql;
		GenerarLog lo =new GenerarLog();
		private String path;
		
	 
		 
		@Override
		public List<ParticipanteDTO> getListaParticipantes() {
			List<ParticipanteDTO> listParticipantes = new ArrayList<>();
			
		String	sql = "SELECT * FROM clientes;";
			try(Statement statement=conexion.createStatement();
				   ResultSet resultset = statement.executeQuery(sql);) {
				while (resultset.next()){
					String dni = resultset.getString("DNI");
					String nombre = resultset.getString("NOMBRE");
					String sexo = resultset.getString("SEXO");
					String email = resultset.getString("EMAIL");
					String fecha=resultset.getString("FECHA");
					ParticipanteDTO participante = new ParticipanteDTO(dni, nombre, sexo, email, fecha);
					listParticipantes.add(participante);
				}
					
			} catch (SQLException e2) {
				
			}
			return listParticipantes;
		}
		
		public boolean borrarTablaParty() {
			boolean borrada=false;
			Statement statement = null;
			try{
				statement = conexion.createStatement();
			    statement.executeUpdate("DELETE FROM  clientes;");
			 borrada=true;
		} catch (SQLException e) {
			lo.generarLog("tabla", "no borrada ");
		}	
			return borrada;
		}
		@Override
		public List<ParticipanteDTO> getListaParticipantesAperdidasConCodigoP(String codigo) {
			List<ParticipanteDTO> listaParticipantes = new ArrayList<>();
			
		String	sql = "SELECT clientes.DNI, clientes.NOMBRE, clientes.SEXO, clientes.EMAIL, clientes.FECHA FROM clientes, perdidas WHERE clientes.DNI=perdidas.DNI_CLIENTE AND perdidas.CODIGO_PRODUCTO=?;";
		try{
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, codigo);
			System.out.println("1");
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("2");
			while (rs.next()) {
				String dni = rs.getString("DNI");
				String nombre = rs.getString("NOMBRE");	
				String sexo=rs.getString("SEXO");
				String email=rs.getString("EMAIL");
				String fecha=rs.getString("FECHA");
				
			ParticipanteDTO participante = new ParticipanteDTO(dni, nombre, sexo, email, fecha);
			listaParticipantes.add(participante);
			System.out.println("3");
			}
					
		} catch (SQLException e2) {
			System.out.println("No se pudo leer getListaParticipantes");
		}
		return listaParticipantes;
	}
				

		
		@Override
		public List<ParticipanteDTO> getListaParticipantesAperdidas() {
			List<ParticipanteDTO> listParticipantes = new ArrayList<>();
			
		String	sql = "SELECT * FROM clientes, perdidas WHERE clientes.DNI=perdidas.DNI_CLIENTE;";
			try(Statement statement=conexion.createStatement();
				   ResultSet resultset = statement.executeQuery(sql);) {
				while (resultset.next()){
					String dni = resultset.getString("DNI");
					String nombre = resultset.getString("NOMBRE");
					String sexo = resultset.getString("SEXO");
					String email = resultset.getString("EMAIL");
					String fecha=resultset.getString("FECHA");
					ParticipanteDTO participante = new ParticipanteDTO(dni, nombre, sexo, email, fecha);
					listParticipantes.add(participante);
				}
					
			} catch (SQLException e2) {
				
			}
			return listParticipantes;
		}	
		

		@Override
		public  boolean addParticipante(String dni, String nombre, String sexo, String email) {
	        boolean add = false;
			
			String sql = "INSERT INTO clientes(DNI, NOMBRE, SEXO, EMAIL) VALUES (?, ? , ?, ?);";
			System.out.println("si adParty -1");
			try(PreparedStatement  preparedStatement = conexion.prepareStatement(sql);) {
				System.out.println("si adParty 0");
				preparedStatement.setString(1, dni);
				System.out.println("si adParty 1");
				preparedStatement.setString(2, nombre);
				System.out.println("si adParty 2");
				preparedStatement.setString(3, sexo);
				preparedStatement.setString(4, email);
				
				int rows = preparedStatement.executeUpdate();
				if (rows != 0)
					add = true;
				System.out.println("si adParty");
			} catch (SQLException e) {
				lo.generarLog(dni, "no updateParticipante: nombre, sexo o email ");	
				System.out.println("no adParty");
			}
			
			return add;	
		}
		
		
		@Override
		public  boolean addParticipante(ParticipanteDTO p) {
	        boolean add = false;
			
			String sql = "INSERT INTO clientes(DNI, NOMBRE, SEXO, EMAIL) VALUES (?, ? ,? ,?);";
			try(PreparedStatement  preparedStatement = conexion.prepareStatement(sql);) {
				System.out.println("Entra en tr11y");
				preparedStatement.setString(1, p.getDni());
				System.out.println("Entra en tr13y");
				preparedStatement.setString(2, p.getNombre());
				preparedStatement.setString(3, p.getSexo());
				preparedStatement.setString(4, p.getEmail());
				System.out.println("Entra en tr14y");
				int rows = preparedStatement.executeUpdate();
				System.out.println("Entra en tr15y");
				if (rows != 0)
					add = true;
			} catch (SQLException e) {
				
				lo.generarLog(p.getDni(), "no adParticipante por object");
			}
			
			return add;	
		}

		@Override
		public boolean deleteParticipante(String dni) {
			boolean delete= false;
			sql = "DELETE FROM clientes WHERE DNI = ?";
			try (PreparedStatement  preparedStatement = conexion.prepareStatement(sql);){
				preparedStatement.setString(1, dni);
				int rows = preparedStatement.executeUpdate();
				if (rows != 0)
					delete = true;
			} catch (SQLException e) {
				
			lo.generarLog(dni,  "no deleteParticipante");
			}
			
			return delete;
		}
		
     
		@Override
		public boolean updateEmailParticipante( String email, String dni) {
			boolean update = false;
		
			String sql = "UPDATE clientes SET EMAIL=?   WHERE DNI = ?";
			try(PreparedStatement  preparedStatement = conexion.prepareStatement(sql);) {
				System.out.println("1");
				preparedStatement.setString(1, email);
				System.out.println("2");
				preparedStatement.setString(2, dni);
				System.out.println("3");
				int rows = preparedStatement.executeUpdate();
				if (rows != 0)
					update = true;
			} catch (SQLException e) {
			lo.generarLog(dni, "no updateParticipante email ");	

			}
			
			return update;
		}
   
		
		
		



		@Override
		public boolean addListaParticipantes(List<ParticipanteDTO> listaparticipantes) {
			boolean addLC=false;
			//conexion.setAutoCommit(true);
			try {
			for(ParticipanteDTO cto: listaparticipantes){
				ParticipanteDAO da=new ParticipanteDAO();
				da.addParticipante(cto);
			 }
			addLC=true;
			}catch(Exception e) {
				lo.generarLog( "participantes.json", "no adListaParticipantes");	
				System.out.println("no lista");
			}
		
			return addLC;
		}
		
		public static Object [][] listaData (List<ParticipanteDTO> lista){
			Object [][] matriz = new Object [lista.size()][5];
				
				for (int i=0 ; i < lista.size() ;i++){
				matriz[i][0] = lista.get(i).getDni();
				matriz[i][1] = lista.get(i).getNombre();
				matriz[i][2] = lista.get(i).getSexo();
				matriz[i][3] = lista.get(i).getEmail();
				matriz[i][4] = lista.get(i).getFecha();
				}
			
			return matriz;	
			}
		

	/*
		public static void main(String[] args) {
			ParticipanteDAO c=new ParticipanteDAO();
			List<ParticipanteDTO>lista=new ArrayList<>();
			ParticipanteDTO d0=new ParticipanteDTO("9999999W9SER", "AAJose", "CHICO", "mvpprg@gmail.com");
			ParticipanteDTO d1=new ParticipanteDTO("9999999W9ESP", "AALolo", "CHICO", "mvpprg@gmail.com");
			ParticipanteDTO d2=new ParticipanteDTO("9999999W9ESQ", "AARamiro", "CHICO", "mvpprg@gmail.com");
			ParticipanteDTO d3=new ParticipanteDTO("999999W99SES", "AAJuanito", "CHICO", "mvpprg@gmail.com");
			lista.add(d0);
			lista.add(d1);
			lista.add(d2);
			lista.add(d3);
			//c.addParticipante("999999W99SESe", "AAJuanito", "Chico", "mvpprg@gmail.com");
			//System.out.println("SQLITE");
			//System.out.println(c.getListaParticipantes());
		  //  System.out.println(c.deleteParticipante("popop"));
			//System.out.println(c.updateEmailParticipante("joseO@gmail.com", "99999999R"));
			//c.addListaParticipantes(lista);
		  //  System.out.println(c.getListaParticipantesAperdidas());
            System.out.println(c.getListaParticipantesAperdidasConCodigoP("A0"));
			//System.out.println(c.borrarTablaParty());
			
		}
*/

}
