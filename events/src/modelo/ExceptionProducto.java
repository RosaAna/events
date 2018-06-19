package modelo;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ExceptionProducto extends Exception {

	public ExceptionProducto(String message) {
		super(message);
	}
}