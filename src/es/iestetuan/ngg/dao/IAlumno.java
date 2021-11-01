package es.iestetuan.ngg.dao;

import java.util.List;

import es.iestetuan.ngg.dao.vo.Alumno;

public interface IAlumno {

	public Alumno getAlumno(long nia);
	public List<Alumno> getAlumnos();
	public void guardarUsuario(List<Alumno> lista);
	public void altaAlumno(Alumno alumno);
	public void bajaAlumno(long nia);
	public void modificacionAlumno(Alumno alumno);
}
