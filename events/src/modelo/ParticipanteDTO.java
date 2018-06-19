package modelo;

public class ParticipanteDTO {
	private String dni;
	private String nombre;
	private String sexo;
	private String email;
	private String fecha;

	public ParticipanteDTO(String dni, String nombre, String sexo, String email, String fecha) {
		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.email = email;
		this.fecha = fecha;
	}



	public ParticipanteDTO(String dni, String nombre, String sexo, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.email = email;
	}



	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
		return "dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", email=" + email + ", fecha="
				+ fecha + "\n";
	}



}
