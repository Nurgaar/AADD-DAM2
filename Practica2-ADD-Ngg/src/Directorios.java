import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Directorios {

	String rutas = "C:\\Users\\usuario\\eclipse-workspace\\Practica2_AADD_DAM\\FicheroProperties.properties";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			//creamos los directorios, llamando a las rutas que hay en el properties
		
		Directorios dir = new Directorios();
		
			dir.Crear("RutaCreacion1");
			dir.Crear("RutaCreacion2");
			dir.Crear("RutaCreacion3");
			dir.Crear("RutaCreacion4");
			dir.Crear("RutaCreacion5");
			dir.Crear("RutaCreacion6");
			dir.Crear("RutaCreacion7");
			dir.Crear("RutaCreacion8");
			dir.Crear("RutaCreacion9");
			dir.Crear("RutaCreacion10");
			dir.Crear("RutaCreacion11");
			
			
			//llamada al método crearvacio, que saca la ruta del fichero creado
			
			crearVacio("C:/DAM2/AccesoADatos/Ficheros/00-tmp");
			
			
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
			 FileWriter fw = new FileWriter (ruta2+ "//"+arch.concat("//info-temporal.txt"));
		 }
	 }
	 
	 public void manejarGSON () {
		 File ficheroJson = new File ("Ficherojson.json");
		 String fichero = "";
		 
		 	try {
		 		fichero = new String(Files.readAllBytes(ficheroJson.toPath()), StandardCharsets.UTF_8);
		 	} catch (Exception error) {
		 		error.printStackTrace();
		 	}
		 
		 JsonObject propiedades = JsonParser.parseString("").getAsJsonObject();
		 String ruta1 = propiedades.get("Ruta1").getAsString();
	 }
	 
	/* public static InfoConfiguracion getConfiguracionJSON() {
		 if(configuracionJSON==null) {
			 configuracionJSON = cargarConfiguracion
		 }
		 return configuracionJSON;
	
	 
	 private static InfoConfiguracion cargarConfiguracionJSON() {
		 InfoConfiguracion configuracion = null;
		 Gson gson = new Gson();
		 File fichero = new File ("Ficherojson.json");
	 }
	  }*/
	 
	 public void ficheroXMl() {
		 Properties propiedades = new Properties ();
		 File ficheroXML = new File ("FicheroXML.xml");
		 
	 }
	 
}



