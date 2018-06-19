package modelo;

public class FanDTO {
private String dni;
private String nombre;
private String sexo;
private String email;
private String fecha;
private String participa;
public FanDTO(String dni, String nombre, String sexo, String email, String fecha, String participa) {
	this.dni = dni;
	this.nombre = nombre;
	this.sexo = sexo;
	this.email = email;
	this.fecha = fecha;
	this.participa = participa;
}


public FanDTO(String dni, String nombre, String sexo, String email) {
	super();
	this.dni = dni;
	this.nombre = nombre;
	this.sexo = sexo;
	this.email = email;
}

public String getDni() {
	return dni;
}
public String getNombre() {
	return nombre;
}
public String getSexo() {
	return sexo;
}
public String getEmail() {
	return email;
}
public String getFecha() {
	return fecha;
}
public String getParticipa() {
	return participa;
}
@Override
public String toString() {
	return "dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", email=" + email +", fecha=" + fecha+ ", participa=" + participa + "\n";
}



}