package modelo;

public class FanDQO {
		private String dni;
		private String nombre;
		private String sexo;
		private String email;
	

		public FanDQO(String dni, String nombre, String sexo, String email) {
			
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
		
		@Override
		public String toString() {
			return "dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", email=" + email +"\n";
					
		}



		}
