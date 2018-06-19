package modeloDAO;

import java.util.List;

import modelo.FanDTO;
import modelo.UserLoginDTO;

public interface IUserLoginDAO {
	List<UserLoginDTO> getListaUserLogin();
	boolean addUserLogin(UserLoginDTO userDTO);
	boolean comprobarUserLogin(String login, String pass);
	boolean addListaUsuarios(List<UserLoginDTO> listaUser);
}
