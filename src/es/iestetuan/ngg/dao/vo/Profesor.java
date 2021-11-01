package es.iestetuan.ngg.dao.vo;

public class Profesor {

	String nombre;
	String nie;
	String Apellido1;
	String apellido2;
	String email;
	String departamento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNie() {
		return nie;
	}
	public void setNie(String nie) {
		this.nie = nie;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", nie=" + nie + ", Apellido1=" + Apellido1 + ", apellido2=" + apellido2
				+ ", email=" + email + ", departamento=" + departamento + "]";
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
