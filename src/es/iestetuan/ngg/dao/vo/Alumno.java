package es.iestetuan.ngg.dao.vo;

public class Alumno {

	String nombre;
	String nie;
	String Apellido1;
	String apellido2;
	String email;
	Long nia;
	
	public Long getNia() {
		return nia;
	}
	public void setNia(Long nia) {
		this.nia = nia;
	}
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
		return "Alumno [nombre=" + nombre + ", nie=" + nie + ", Apellido1=" + Apellido1 + ", apellido2=" + apellido2
				+ ", email=" + email + ", nia=" + nia + "]";
	}
}
