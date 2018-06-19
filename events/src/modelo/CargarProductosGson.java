package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modeloDAO.ProductoDAO;

public class CargarProductosGson {
			
		 public static List leeJsonGson(String ruta) {
			   
			List<ProductoDTO> listClientes=new ArrayList<>();
			
			BufferedReader reader = null; 
			
		    try {
				reader = new BufferedReader ( new FileReader ( ruta ));
				 Gson gson = new Gson();
			        ProductoDTO[] pdo = gson.fromJson(reader, ProductoDTO[].class);

			        for (ProductoDTO productoDTO : pdo) {
			            listClientes.add(productoDTO);
			        }
			        JOptionPane.showMessageDialog(null, "LeeJsonGsonP ha devuelto la lista correctamente ");
			       // System.out.println(listClientes); 
			       System.out.println(pdo.length);
			} catch (FileNotFoundException e) {
				 JOptionPane.showMessageDialog(null, "LeerJsonGsonP NO ha devuelto la lista ");
			}
		    return listClientes;
		   } 
		 
		 public static void main(String[] args) {
			System.out.println(leeJsonGson("Datos/productos.json"));
		}

}
