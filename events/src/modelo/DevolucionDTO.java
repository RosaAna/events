package modelo;

public class DevolucionDTO {
private String dniDC;
private String codigoProductoDC;
private int importeDC;
private String estado;
private String fechaDevolucion;
public DevolucionDTO(String dniDC, String codigoProductoDC, int importeDC, String estado, String fechaDevolucion) {
	super();
	this.dniDC = dniDC;
	this.codigoProductoDC = codigoProductoDC;
	this.importeDC = importeDC;
	this.estado = estado;
	this.fechaDevolucion = fechaDevolucion;
}
/**
 * @return the dniDC
 */
public String getDniDC() {
	return dniDC;
}
/**
 * @param dniDC the dniDC to set
 */
public void setDniDC(String dniDC) {
	this.dniDC = dniDC;
}
/**
 * @return the codigoProductoDC
 */
public String getCodigoProductoDC() {
	return codigoProductoDC;
}
/**
 * @param codigoProductoDC the codigoProductoDC to set
 */
public void setCodigoProductoDC(String codigoProductoDC) {
	this.codigoProductoDC = codigoProductoDC;
}
/**
 * @return the importeDC
 */
public int getImporteDC() {
	return importeDC;
}
/**
 * @param importeDC the importeDC to set
 */
public void setImporteDC(int importeDC) {
	this.importeDC = importeDC;
}
/**
 * @return the estado
 */
public String getEstado() {
	return estado;
}
/**
 * @param estado the estado to set
 */
public void setEstado(String estado) {
	this.estado = estado;
}
/**
 * @return the fechaDevolucion
 */
public String getFechaDevolucion() {
	return fechaDevolucion;
}
/**
 * @param fechaDevolucion the fechaDevolucion to set
 */
public void setFechaDevolucion(String fechaDevolucion) {
	this.fechaDevolucion = fechaDevolucion;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "dniDC=" + dniDC + ", codigoProductoDC=" + codigoProductoDC + ", importeDC=" + importeDC
			+ ", estado=" + estado + ", fechaDevolucion=" + fechaDevolucion + "\n";
}


}
