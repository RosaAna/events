package modelo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
public class LeerProductosGson {
		
	 public static List leeJsonGson(String ruta) {
		   
		List<ProductoDTO> listClientes=new ArrayList<>();
		BufferedReader reader = null; 
		
	    try {
			reader = new BufferedReader ( new FileReader ( ruta ));
			 Gson gson = new Gson();
		        ProductoDTO[] clientesDTO = gson.fromJson(reader, ProductoDTO[].class);

		        for (ProductoDTO clienteDTO : clientesDTO) {
		            listClientes.add(clienteDTO);
		        }
		      //  System.out.println(listClientes); 
		      //  System.out.println(clientesDTO.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return listClientes;
	   } 
	 public static void main(String[] args) {
		System.out.println(leeJsonGson("Datos/productos.json"));
	}
	}

