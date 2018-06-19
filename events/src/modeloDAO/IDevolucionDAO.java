package modeloDAO;

import java.util.List;

import modelo.DevolucionDTO;
import modelo.Estado;

public interface IDevolucionDAO {
	List<DevolucionDTO> getListaDevolucionPendienteRevision();
	List<DevolucionDTO> getListaDevolucionEnviadAproductos();
	boolean updateEstadoDevolucion(String dni,String codigoProducto);
	boolean deleteDevolucion(String dni, String codigoProducto);
}
