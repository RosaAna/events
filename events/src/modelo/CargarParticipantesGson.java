package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CargarParticipantesGson {
				
			 public static List leeJsonGson(String ruta) {
				   
				List<ParticipanteDTO> listParty=new ArrayList<>();
				BufferedReader reader = null; 
				
			    try {
					reader = new BufferedReader ( new FileReader ( ruta ));
					 Gson gson = new Gson();
				        ParticipanteDTO[] partysDTO = gson.fromJson(reader, ParticipanteDTO[].class);

				        for (ParticipanteDTO partyDTO : partysDTO) {
				            listParty.add(partyDTO);
				        }
				        System.out.println(listParty); 
				      //  System.out.println(partysDTO.length);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    return listParty;
			   } 
			 /*
			 public static void main(String[] args) {
				System.out.println(leeJsonGson("Datos/participantes.json"));
		}
*/
}
