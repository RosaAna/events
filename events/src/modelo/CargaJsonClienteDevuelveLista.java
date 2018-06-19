package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CargaJsonClienteDevuelveLista {
	 
	 public static List<FanDTO> listaClienteDTO(String ruta){
		List<FanDTO> listClientes=new ArrayList<>();
			BufferedReader reader = null; 
			
		    try {
				reader = new BufferedReader ( new FileReader ( ruta ));
				 Gson gson = new Gson();
			        FanDTO[] clientesDTO = gson.fromJson(reader, FanDTO[].class);

			        for (FanDTO clienteDTO : clientesDTO) { 
			            listClientes.add(clienteDTO);
			        }
		    
			  } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			return listClientes;
       } 
	 
public static void main(String[] args) {
		System.out.println(listaClienteDTO("Datos/clientes.json")); 
	 }
}
