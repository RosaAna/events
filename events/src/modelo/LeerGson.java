package modelo;


	import java.awt.print.Book;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
	import com.google.gson.GsonBuilder;

	public class LeerGson {
	  public static void main(String[] args) throws Exception {
	    // Configure Gson
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();

	    // The JSON data
	    try(Reader reader = new InputStreamReader(ProductoDTO.class.getResourceAsStream("Datos/productos.json"), "UTF-8")){

	      // Parse JSON to Java
	      Book book = gson.fromJson(reader, Book.class);
	      System.out.println(book);
	    }
	  }
	}
