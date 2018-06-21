package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import modeloDAO.FansDAO;


public class CreaJsonParticipantes {

	
	public static boolean escribeGson() {
		boolean resul=false;
		// TODO Auto-generated method stub
		 Gson gson = new Gson();
         FansDAO fa =new FansDAO();
         List<FanDQO> lista=fa.getListaFansQparticipan();
         //convierte un objeto java a  json
         String jsonString = gson.toJson(lista);
         //Escribe el archivo json 
         try {
       //  FileWriter fileWriter = new FileWriter("C:\\Users\\rosa\\Desktop\\events_json\\participantes.json");
         FileWriter fileWriter = new FileWriter("C:\\Users\\rosa\\Desktop\\events_json\\participantes.json");
         fileWriter.write(jsonString);
         fileWriter.close();
         resul=true;
         } catch (IOException e) {
            e.printStackTrace();
         }
         return resul;
	  }
  public static void main(String[] args) {
       escribeGson();
	}

}
