package modeloDAO;

import java.util.List;

import modelo.ParticipanteDTO;

public interface IParticipanteDAO {
	List<ParticipanteDTO>getListaParticipantesAperdidasConCodigoP(String codigo);
	List<ParticipanteDTO> getListaParticipantesAperdidas();
	List<ParticipanteDTO> getListaParticipantes();
	boolean addParticipante(String dni, String nombre, String apellidos, String email);
	boolean deleteParticipante(String  dni);
	boolean updateEmailParticipante(String dni, String email);
	boolean addListaParticipantes(List<ParticipanteDTO> listaparticipantes);
	boolean addParticipante(ParticipanteDTO p);
}
