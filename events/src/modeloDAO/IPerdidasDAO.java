package modeloDAO;

import java.util.List;

import modelo.PerdidasDTO;

public interface IPerdidasDAO {
//List<PerdidasDTO> getListaPerdidas();
int sumaPerdidas();
int totalPorCliente(String dni);
List<PerdidasDTO> getListaPerdidasPorCliente();
List<PerdidasDTO> getListaPerdidasPorProducto();
}


