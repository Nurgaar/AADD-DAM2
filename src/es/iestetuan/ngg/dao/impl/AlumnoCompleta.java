package es.iestetuan.ngg.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import es.iestetuan.ngg.dao.IAlumno;
import es.iestetuan.ngg.dao.vo.Alumno;

public class AlumnoCompleta implements IAlumno {

	public Alumno getAlumno(long nia) {
		// TODO Auto-generated method stub
		
		File fichero = new File ("C:\\Users\\usuario\\git\\repository\\Ejercicio4AccesoADatos\\src\\alumnos-dam2-nuevos.txt");
		FileReader fr =null;
		BufferedReader br = null;
		String linea;
		boolean leerLineaUno = true;
		Alumno alumno = new Alumno();
		
		
		try {
			 fr = new FileReader(fichero, Charset.forName("UTF-8"));
			 br = new BufferedReader(fr);
			 while ((linea= br.readLine())!=null)
					 {
				 		
				 		if(leerLineaUno)
				 		{
				 			leerLineaUno=false;
				 		}
				 		else
				 		{
				 			
				 			String[] partes = linea.split(",");
				 			
				 			long NiaIgual = Integer.parseInt(partes[0]);
							if(nia==NiaIgual)
				 			{
								
								alumno.setNombre(partes[1]);
				 				alumno.setApellido1(partes[2]);
				 				alumno.setApellido2(partes[3]);
				 				break;
				 			}
				 		}
					 }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return alumno;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Alumno> getAlumnos() {
		
		//tiene que leer el fichero txt igual que arriba, pero que me devuelva la lista completa del txt
		
		Properties pr = new Properties();
		InputStream is ;
		
		
		File fichero ; 
		FileReader fr =null;
		BufferedReader br = null;
		String linea;
		boolean leerLineaUno = true;
		Alumno alumno;
		List<Alumno> lista = new ArrayList <Alumno>();
		
		
		try {
			//ejer4 parte 3
			is = new FileInputStream("ArchivoConfiguracion.properties");
			pr.load(is);
			
			fichero = new File (pr.getProperty("Origen"));
			
			
			 fr = new FileReader(fichero, Charset.forName("UTF-8"));
			 br = new BufferedReader(fr);
			 while ((linea= br.readLine())!=null)
					 {
				 		
				 		if(leerLineaUno)
				 		{
				 			leerLineaUno=false;
				 		}
				 		else
				 		{
				 			
				 			String[] partes = linea.split(",");
				 			
				 			long NiaIgual = Long.parseLong(partes[0]);
							
								alumno = new Alumno();
								
								alumno.setNombre(partes[1]);
				 				alumno.setApellido1(partes[2]);
				 				alumno.setApellido2(partes[3]);
				 				alumno.setNia(NiaIgual);
				 				
				 			lista.add(alumno);
				 		}
					 }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	
	
	
	
	

	@Override
	public void guardarUsuario(List<Alumno> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bajaAlumno(long nia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificacionAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

}
