package modeloDAO;

import java.util.List;

import modelo.FanDTO;
import modelo.ProductoDTO;
import modelo.VentaDTO;

public interface IVentaDAO {
	List<VentaDTO> getListaVentas();
	boolean deleteVenta(String dni,String  codigoProducto, String fecha);
	boolean addVenta(String dniCliente, String codigoProducto, int importe);

}
