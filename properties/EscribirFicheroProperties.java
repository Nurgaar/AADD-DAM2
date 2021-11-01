package Ejercicio4AccesoADatos.ngg.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class EscribirFicheroProperties {

String rutas = "C:\\Users\\usuario\\git\\Accesoadatos\\AccesoADatosUsuario\\PropertiesAlumnos.txt";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			//creamos los directorios, llamando a las rutas que hay en el properties
		
		EscribirFicheroProperties prop = new EscribirFicheroProperties();
		
			prop.Crear("rutaInicial");
			
			
			
			//llamada al método crearvacio, que saca la ruta del fichero creado
			
			crearVacio("C:\\xampp\\htdocs\\aadd\\recursos\\alumnos-dam2.xml");
			
			
	}
	
	private void Crear (String clave) throws IOException {
		Properties prop = new Properties ();
		InputStream input = null;
		input = new FileInputStream (rutas);
		prop.load(input);
		Path path = Paths.get(prop.getProperty(clave));
		
			if (!Files.exists(path)) {
				Files.createDirectories(path);
			} else {
				System.out.println("Ya está creado");
			}
		
	}
	 private static void crearVacio (String ruta2) throws IOException {
		 
		 String [] archivo;
		 File fl = new File (ruta2);
		 archivo =fl.list();
		 
		 for (String arch: archivo)
		 {
			 FileWriter fw = new FileWriter (ruta2+ "//"+arch.concat("C:\\xampp\\htdocs\\aadd\\recursos\\alumnos-dam2.xml"));
		 }
	 }

}
