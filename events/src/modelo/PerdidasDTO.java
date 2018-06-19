package modelo;

public class PerdidasDTO {
private String codigoProducto;
private String dniCliente;
private int importe;
private String fecha;
public PerdidasDTO(String codigoProducto, String dniCliente, int importe, String fecha) {
	super();
	this.codigoProducto = codigoProducto;
	this.dniCliente = dniCliente;
	this.importe = importe;
	this.fecha = fecha;
}
public PerdidasDTO(String dni, int count) {
	// TODO Auto-generated constructor stub
}
/**
 * @return the codigoProducto
 */
public String getCodigoProducto() {
	return codigoProducto;
}
/**
 * @param codigoProducto the codigoProducto to set
 */
public void setCodigoProducto(String codigoProducto) {
	this.codigoProducto = codigoProducto;
}
/**
 * @return the dniCliente
 */
public String getDniCliente() {
	return dniCliente;
}
/**
 * @param dniCliente the dniCliente to set
 */
public void setDniCliente(String dniCliente) {
	this.dniCliente = dniCliente;
}
/**
 * @return the importe
 */
public int getImporte() {
	return importe;
}
/**
 * @param importe the importe to set
 */
public void setImporte(int importe) {
	this.importe = importe;
}
/**
 * @return the fecha
 */
public String getFecha() {
	return fecha;
}
/**
 * @param fecha the fecha to set
 */
public void setFecha(String fecha) {
	this.fecha = fecha;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "codigoProducto=" + codigoProducto + ", dniCliente=" + dniCliente + ", importe=" + importe
			+ ", fecha=" + fecha + "\n";
}


}
