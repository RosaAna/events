package modelo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


	public class GenerarLog {

		private static File file = new File("Datos/log.txt");


		public void generarLog(String log, String primaryKey){

			try(PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file,true)));) {
				output.println(LocalDateTime.now()+"  "+ primaryKey +"  "+log+"\n");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
}

	


