package modelo;

public class CorreoJava {
private String usuarioCorreo ;
private String contrasena;
private String rutaArchivo;
private String nombreArchivo;
private String destino;
private String asunto;
private String mensaje;
public CorreoJava() {}
public CorreoJava(String usuarioCorreo, String contrasena, String rutaArchivo, String nombreArchivo, String destino,
		String asunto, String mensaje) {
	super();
	this.usuarioCorreo = usuarioCorreo;
	this.contrasena = contrasena;
	this.rutaArchivo = rutaArchivo;
	this.nombreArchivo = nombreArchivo;
	this.destino = destino;
	this.asunto = asunto;
	this.mensaje = mensaje;
}
public String getUsuarioCorreo() {
	return usuarioCorreo;
}
public void setUsuarioCorreo(String usuarioCorreo) {
	this.usuarioCorreo = usuarioCorreo;
}
public String getContrasena() {
	return contrasena;
}
public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}
public String getRutaArchivo() {
	return rutaArchivo;
}
public void setRutaArchivo(String rutaArchivo) {
	this.rutaArchivo = rutaArchivo;
}
public String getNombreArchivo() {
	return nombreArchivo;
}
public void setNombreArchivo(String nombreArchivo) {
	this.nombreArchivo = nombreArchivo;
}
public String getDestino() {
	return destino;
}
public void setDestino(String destino) {
	this.destino = destino;
}
public String getAsunto() {
	return asunto;
}
public void setAsunto(String asunto) {
	this.asunto = asunto;
}
public String getMensaje() {
	return mensaje;
}
public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}
@Override
public String toString() {
	return "CorreoJava [usuarioCorreo=" + usuarioCorreo + ", contrasena=" + contrasena + ", rutaArchivo=" + rutaArchivo
			+ ", nombreArchivo=" + nombreArchivo + ", destino=" + destino + ", asunto=" + asunto + ", mensaje="
			+ mensaje + "]";
}


}
