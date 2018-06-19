package modeloDAO;

import java.util.List;

import modelo.FanDQO;
import modelo.FanDTO;


public interface IFansDAO { 
	List<FanDTO> getListaFans();
	List<FanDQO>  getListaFansQparticipan();
	boolean deleteFan(String  dni);
	boolean updateEmailFan(String dni, String email);
	boolean addListaFans(List<FanDTO> listaFans);
    boolean crearTablaFans();
	boolean addFan(FanDTO fanDTO);
	boolean existeFan(String dni);
	boolean addFans(String dni, String nombre, String sexo, String email, String fecha, String participa);
	boolean updateEmailFan(String nombre, String sexo, String email, String participa, String dni);
	
}