package es.iestetuan.ngg.dao.main;

import java.util.ArrayList;
import java.util.List;

import es.iestetuan.ngg.dao.IAlumno;
import es.iestetuan.ngg.dao.impl.AlumnoCompleta;
import es.iestetuan.ngg.dao.vo.Alumno;
import es.iestetuan.ngg.dao.xml.AlumnoCompletaXML;

public class AplicacionAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//ESTA PARTE ES LA DE TXT
		/*
		IAlumno llamadametodos = new AlumnoCompleta();
		
		Alumno alumno = llamadametodos.getAlumno(318);

		
		System.out.println(alumno.getNombre());
		System.out.println(alumno.getApellido1());
		System.out.println(alumno.getApellido2());
		
			*/
		
		//ESTA PARTE ES LA DE XML
		
		try {
			Alumno alumno = new Alumno();
			
			IAlumno alumno4 = new AlumnoCompleta();
			
			IAlumno alu = new AlumnoCompletaXML();
			
			//List <Alumno> lista = alu.getAlumno(); 
			//alumno=alu.getAlumno(171);
			
			//alu.guardarUsuario(lista);
			
		//	System.out.println(alumno);
			
			//Ejercicio 4
			List <Alumno> alum = new ArrayList <Alumno>();
			alum = alumno4.getAlumnos();
			
			alu.guardarUsuario(alum);
			
			//for (Alumno datos : lista) {
				//System.out.println(datos);
			//}
			
		} catch (Exception error) {
			error.printStackTrace();
		}
		
	}

}
