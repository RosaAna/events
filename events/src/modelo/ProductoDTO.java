package modelo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductoDTO  {
private String codigo_producto;
private int precio;
private int cantidad;
private String fecha;
public ProductoDTO(String codigo_producto, int precio, int cantidad, String fecha) {
	super();
	this.codigo_producto = codigo_producto;
	this.precio = precio;
	this.cantidad=cantidad;
	this.fecha = fecha;
}

public ProductoDTO(String codigo_producto, int precio, int cantidad) throws ExceptionProducto {
	
	super();
	String regexP = "[A-Z0-9]{2}";
	if(codigo_producto.matches(regexP)) {
	this.codigo_producto = codigo_producto;
	this.precio = precio;
	this.cantidad=cantidad;
	}
	else {
		throw new ExceptionProducto("");
	
		
	}
}



/**
 * @return the codigo_producto
 */
public String getCodigo_producto() {
	return codigo_producto;
}


/**
 * @return the precio
 */
public int getPrecio() {
	return precio;
}

/**
 * @return the cantidad
 */
public int getCantidad() {
	return cantidad;
}



/**
 * @param fecha the fecha to set
 */
public void setFecha(String fecha) {
	this.fecha = fecha;
}

@Override
public String toString() {
	return "codigo_producto=" + codigo_producto + ", precio=" + precio + ", cantidad=" + cantidad+ "\n";
}


}
