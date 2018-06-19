package modelo;

public class VentaDTO {
private String dniCliente;
private String codigoProducto;
private int importe;
private String fechaVenta;
public VentaDTO(String dniCliente, String codigoProducto, int importe, String fechaVenta) {
	super();
	this.dniCliente = dniCliente;
	this.codigoProducto = codigoProducto;
	this.importe = importe;
	this.fechaVenta = fechaVenta;
}


public VentaDTO(String dniCliente, String codigoProducto, int importe) {
	super();
	this.dniCliente = dniCliente;
	this.codigoProducto = codigoProducto;
	this.importe = importe;
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
 * @return the fechaVenta
 */
public String getFechaVenta() {
	return fechaVenta;
}
/**
 * @param fechaVenta the fechaVenta to set
 */
public void setFechaVenta(String fechaVenta) {
	this.fechaVenta = fechaVenta;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "dniCliente=" + dniCliente + ", codigoProducto=" + codigoProducto + ", importe=" + importe
			+ ", fechaVenta=" + fechaVenta + "\n";
}


}
