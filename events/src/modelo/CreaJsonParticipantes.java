package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import modeloDAO.FansDAO;


public class CreaJsonParticipantes {

	
	public static void escribeGson() {
		// TODO Auto-generated method stub
		 Gson gson = new Gson();
         FansDAO fa =new FansDAO();
         List<FanDQO> lista=fa.getListaFansQparticipan();
         //convert the Java object to json
         String jsonString = gson.toJson(lista);
         //Write JSON String to file 
         try {
         FileWriter fileWriter = new FileWriter("C:\\Users\\rosa\\Desktop\\events_json\\participantes.json");
         fileWriter.write(jsonString);
         fileWriter.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
	  }
  public static void main(String[] args) {
       escribeGson();
	}

}
