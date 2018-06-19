package modelo;

public class UserLoginDTO {
private String login;
private String pass;
private String fecha;
public UserLoginDTO(String login, String pass) {
	super();
	this.login = login;
	this.pass = pass;
}


public UserLoginDTO(String login, String pass, String fecha) {
	super();
	this.login = login;
	this.pass = pass;
	this.fecha = fecha;
}


/**
 * @return the login
 */
public String getLogin() {
	return login;
}
/**
 * @param login the login to set
 */
public void setLogin(String login) {
	this.login = login;
}
/**
 * @return the pass
 */
public String getPass() {
	return pass;
}
/**
 * @param pass the pass to set
 */
public void setPass(String pass) {
	this.pass = pass;
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
	return "login=" + login + ", pass=" + pass +", fecha"+ fecha +"\n";
}



}
