package modeloDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import com.google.gson.Gson;

import modelo.FanDTO;
import modelo.ConexionProfe;
import modelo.Filechoossee;
import modelo.UserLoginDTO;

public class UserLoginDAO implements IUserLoginDAO {
	private static Connection conexion= ConexionProfe.getConexion();
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Statement statement;
	String sql;
	 public List<UserLoginDTO> readListUserDesdeJson(String rutAlFicheroJson){
		   //ruta="Datos/clientes.json"
			List<UserLoginDTO> listUser=new ArrayList<>();
				BufferedReader reader = null; 
				
			    try {
					reader = new BufferedReader ( new FileReader ( rutAlFicheroJson ));
					 Gson gson = new Gson();
				        UserLoginDTO[] usersDTO = gson.fromJson(reader, UserLoginDTO[].class);

				        for (UserLoginDTO userDTO : usersDTO) { 
				            listUser.add(userDTO);
				        }
			    
				  } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
				return listUser;
	       } 
	
		 
	 public boolean crearTablaUsuario () {
	 boolean add=false;
	 String sql = " CREATE TABLE usuario (login TEXT PRIMARY KEY, pass TEXT , fecha TEXT);";
	 try {
		statement=conexion.createStatement();
		int row=statement.executeUpdate(sql);
		if(row!=0) {
		add=true;	
		}
			
	} catch (SQLException e) {
		System.out.println("No se pudo crear BD");

	}
	
	return add;	
	} 

	 
	 public boolean borrarTablaUsuario () {
	 boolean add=false;
	 String sql = " DROP TABLE usuario;";
	 try {
		statement=conexion.createStatement();
		int row=statement.executeUpdate(sql);
		if(row!=0) {
		add=true;	
		}
			
	} catch (SQLException e) {
		System.out.println("No se pudo borrar BD");

	}
	
	return add;	
	} 
	
	
	@Override
	public List<UserLoginDTO> getListaUserLogin() {
		List<UserLoginDTO> listLogin=new ArrayList<>();
		System.out.println("entra en 01");
		sql = " SELECT * FROM usuario ;";
		System.out.println("entra en 02");
		try {
			 statement=conexion.createStatement();
			System.out.println("entra en 03");
		    ResultSet resultset = statement.executeQuery(sql);
		 System.out.println("entra en 1");
			while (resultset.next()){
				System.out.println("entra en 2");
				String login = resultset.getString("login");
				String pass = resultset.getString("pass");
				String fecha=resultset.getString("fecha");
				UserLoginDTO user = new UserLoginDTO(login, pass, fecha);
				listLogin.add(user);
				System.out.println("Aqui tabie,,,");
			}
				
		} catch (SQLException e2) {
			System.out.println("No se pudo leer getListaUserLogin");
		}
		return listLogin;
	}

	@Override
	public boolean addUserLogin(UserLoginDTO userDTO) {
		  boolean add = false;
			
			String sql = "INSERT INTO usuario (login , pass, fecha) VALUES (?, ?, ?);";
			try {
				System.out.println("Entra en tr11y");
			    preparedStatement = conexion.prepareStatement(sql);
			    System.out.println("Entra en tr12y");
				preparedStatement.setString(1, userDTO.getLogin());
				System.out.println("Entra en tr13y");
				preparedStatement.setString(2, userDTO.getPass());
				System.out.println("Entra en tr14y");
				preparedStatement.setString(3, userDTO.getFecha());
				System.out.println("Entra en tr15y");
				int rows = preparedStatement.executeUpdate();
				System.out.println("Entra en tr16y");
				if (rows != 0)
					add = true;
			} catch (SQLException e) {
				System.out.println("No se pudo añadir el user");

			}
			
			return add;	
	}



	

	@Override
	public boolean comprobarUserLogin(String login, String pass) {
		boolean existe =false;
		sql = "Select * FROM usuario WHERE LOGIN=? AND  PASS=?;";
	
		try {
			preparedStatement = conexion.prepareStatement(sql);
			System.out.println("Hace consulta");
			preparedStatement.setString(1, login);
			System.out.println("login entra");
			preparedStatement.setString(2, pass);
			System.out.println("pass entra");
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("Ejecuta sql");
		
		    if (resultSet.next()==true)
			existe = true;
			
			/*while(resultSet.next()) {
			existe=true;	
			}*/
			
		} catch (SQLException e) {
			
			System.out.println("No se pudo comprobar");
			
		}		
		
		return existe;
	}
	

	@Override
	public boolean addListaUsuarios(List<UserLoginDTO> listaUser) {
		boolean addC=false;
		for(UserLoginDTO cto: listaUser){
			UserLoginDAO cd=new UserLoginDAO();
			cd.addUserLogin(cto); 
			addC=true;
        }
	
		return addC;
	}
	
	
	
	
	public static void main(String[] args) {
		UserLoginDAO u1=new UserLoginDAO();
		//System.out.println(u1.getListaUserLogin());
		//UserLoginDTO ut1=new UserLoginDTO("rosa5", "rosa5");
		//System.out.println(u1.getListaUserLogin());
		//System.out.println(u1.addUserLogin(ut1));
		//System.out.println(u1.deleteUserLogin("rosa5"));
		//System.out.println (u1.updateContrasenaUser("rosa5", "12345"));
		//System.out.println(u1.comprobarUserLogin("rosa56", "12345"));
		Filechoossee fe=new Filechoossee();
	//	System.out.println(fe.darRuta());
		//System.out.println(u1.readListUserDesdeJson(fe.darRuta(   )));
		//System.out.println(u1.crearTablaUsuario());
	//	System.out.println(u1.getListaUserLogin());
		System.out.println(u1. addListaUsuarios(u1.readListUserDesdeJson(fe.darRuta(   ))));
		System.out.println(u1.getListaUserLogin());
		//System.out.println(u1.borrarTablaUsuario());
		
		
		
	}









	

}
