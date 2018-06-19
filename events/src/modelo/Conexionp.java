package modelo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

public class Conexionp {
	
	public static Connection conexion;
	String BD = null;
	String DB_URL = null;
	String DRIVER = null;


	private Conexionp() {
		Properties p = new Properties();
			
	//Inicializar objeto conexion
		Connection conexion=null;
		
	//CARGAMOS PROPERTIES y leemos clave valor
		
		try {
			p.load(new FileReader("BD.properties"));
			BD = p.getProperty("BD");
			DB_URL = p.getProperty("DB_URL");
			DRIVER = p.getProperty("DRIVER");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("p1");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("P2");
		}

	    //cargar driver	
		//Configuramos el objeto fconfig para permitir foreing keys
		//Iniciamos el objeto conexion con DriverManagerConexion	
		
		System.out.println("1");
		
		try {
			Class.forName (DRIVER);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			System.out.println("2");
			
			try {
				
				conexion = DriverManager.getConnection(
						DB_URL + BD, config.toProperties());
				System.out.println("3");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("4");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("5");
		}
		

		
		
	}


	public static Connection getConexion() {
		if(conexion==null) {
		  new Conexionp();
		}
		return conexion;	
	}

	public static void main(String[] args) {
	Connection conexion = Conexionp.getConexion();

		System.out.println(conexion);


	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//Conexion sin archivo  properties
	/*private static Connection conexion;

	private Conexion(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(" El jdbc no se encontro");
		}
		try {
			conexion = DriverManager.
					getConnection("jdbc:sqlite:BD/tienda.db");
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la bd");
		}
	}
	public static Connection getInstance(){
		if (conexion == null)
			new Conexion();
		return conexion;
	}
	public static void main(String[] args) {
		Connection conexion = getInstance();
	}
	*/
}