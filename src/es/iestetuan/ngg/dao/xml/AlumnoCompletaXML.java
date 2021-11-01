package es.iestetuan.ngg.dao.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import es.iestetuan.ngg.dao.IAlumno;
import es.iestetuan.ngg.dao.vo.Alumno;

public class AlumnoCompletaXML implements IAlumno {

	@Override
	public Alumno getAlumno(long nia) {
		// TODO Auto-generated method stub

		Alumno alum = new Alumno();
		
		try {
			
			File ficheroxml = new File ("C:\\xampp\\htdocs\\aadd\\recursos\\alumnos-dam2-nuevos.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(ficheroxml);
			doc.getDocumentElement().normalize();
			
			//Aquí me creo una lista de nodos, donde me busque todos los alumnos con sus etiquetas
			NodeList nodos = doc.getElementsByTagName("alumno");
			System.out.println("El número de alumnos es: " + nodos.getLength());
			
			//ahora me tengo que recorrer cada etiqueta, buscando por el ID
			//Una vez tenga los ID, los comparo, y si es el mismo que se me pasa por parámetro
			//imprimo el alumno.
			
			for (int i =0; i < nodos.getLength(); i ++) {
				Node nNode = nodos.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					long id = Integer.parseInt(element.getAttribute("id"));
					
					if(id==nia) {
						alum.setNombre(element.getElementsByTagName("Nombre").item(0).getTextContent());
						alum.setApellido1(element.getElementsByTagName("Apellido1").item(0).getTextContent());
						alum.setApellido2(element.getElementsByTagName("Apellido2").item(0).getTextContent());
						
						break;
					}
		
					
				/*	System.out.println("\nNombre id: " +element.getAttribute("id"));
					System.out.println("Apellido1: " +element.getElementsByTagName("Apellido1").item(0).getTextContent());
					System.out.println("Apellido2: " +element.getElementsByTagName("Apellido2").item(0).getTextContent());
			*/		
					
				}
			}
			
			
				
			
		} catch (Exception error) {
			error.printStackTrace();
			
		}
		
		
		return alum ;
	}

	@Override
	public List<Alumno> getAlumnos() {
		// TODO Auto-generated method stub
		
		List<Alumno> lista = new ArrayList<Alumno> ();
		File listaXML = new File("alumnos-dam2.xml");
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(listaXML);
			doc.getDocumentElement().normalize();
			
			
			NodeList nodos = doc.getElementsByTagName("alumno");
			
			
			//dentro del for, hay que crearse un alumno, que es el que luego se pone alumno.set...
			
			for (int i =0; i < nodos.getLength(); i ++) {
				Node nNode = nodos.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					long id = Long.parseLong(element.getAttribute("id"));
					
					
					Alumno alum = new Alumno();
					
					
						alum.setNombre(element.getElementsByTagName("Nombre").item(0).getTextContent());
						alum.setApellido1(element.getElementsByTagName("Apellido1").item(0).getTextContent());
						alum.setApellido2(element.getElementsByTagName("Apellido2").item(0).getTextContent());
						alum.setNia(id);;
						lista.add(alum);
						
		
					}
			
			}
			
			
		} catch (Exception error) {
			error.printStackTrace();
		}
	 	
		return lista;
	}
	
	//Esto me crea el XML a partir de la lista de alumnos

	@Override
	public void guardarUsuario(List<Alumno> lista) {
		// TODO Auto-generated method stub
		
		Document documento = null;
		
		//Crear el Properties igual que en el del txt
		
		Properties pr = new Properties();
		InputStream is ;
		
		try {
			

				DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbF.newDocumentBuilder();
				DOMImplementation domImpl = db.getDOMImplementation();
				documento = domImpl.createDocument(null, "xml", null);
				
				
				//creo el nodo raiz, que es el que alberga todos los elementos
				Element raiz = documento.createElement("alumnos");
				documento.getDocumentElement().appendChild(raiz);
				
				//informacion para todos los nodos internos

				Element nodoAlum = null, nodoDatos = null;
				Text texto = null;
				Attr atributo = null;
				
				
				//Ejercicio 3
				is= new FileInputStream("ArchivoConfiguracion.properties");
				pr.load(is);
				
				
				for (Alumno alum : lista) {

					
					//se asigna el nodo/elemento alumno al elemento raiz
					
					nodoAlum = documento.createElement("alumno");
					raiz.appendChild(nodoAlum);	
					
					
					//cargar la info de los ususarios

					
					
					//para el ID
					String sId = String.valueOf(alum.getNia());
					atributo = documento.createAttribute("id");
					nodoAlum.setAttributeNode(atributo);
					atributo.setTextContent(sId);

					//nodo para el Nombre

					nodoDatos = documento.createElement("Nombre");
					nodoAlum.appendChild(nodoDatos);
					texto = documento.createTextNode(alum.getNombre());
					nodoDatos.appendChild(texto);
					
					//nodo para el apellido 1
					
					nodoDatos = documento.createElement("Apellido1");
					nodoAlum.appendChild(nodoDatos);
					texto = documento.createTextNode(alum.getApellido1());
					nodoDatos.appendChild(texto);
					
					//nodo para el apellido 2
					
					nodoDatos = documento.createElement("Apellido2");
					nodoAlum.appendChild(nodoDatos);
					texto = documento.createTextNode(alum.getApellido2());
					nodoDatos.appendChild(texto);

					}
				
				//Me crea el XML una lista que yo le paso como parámetro.
				
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
			      Transformer transformer = transformerFactory.newTransformer();
			      DOMSource source = new DOMSource(documento);
			      StreamResult result = new StreamResult(new File(pr.getProperty("Destino")));
			      transformer.transform(source, result);
			
		}catch (Exception err) {
			err.printStackTrace();
		}
		
	}

	public void altaAlumno(Alumno alumno) {
		
		AlumnoCompletaXML objeto = new AlumnoCompletaXML();
		List <Alumno> listaalta = new ArrayList <Alumno> ();
		boolean esta=false;
		
		//me guarda todos los alumnos de la lista
		listaalta= objeto.getAlumnos();
		
		//Aqui el foreach con la lista, y comparo los nia de los alumnos que ya estan con los que les paso
		
		for (Alumno alumnoalta : listaalta) {
			if(alumnoalta.getNia()==alumno.getNia()) {
				esta=true;
				break;
			}
			
			
		}
		if(!esta) {
			listaalta.add(alumno);
		
			
			//modifica el XML con los alumnos dados de alta
			objeto.guardarUsuario(listaalta);
		}
		
		
	}

	@Override
	public void bajaAlumno(long nia) {
		
		AlumnoCompletaXML objeto = new AlumnoCompletaXML();
		List <Alumno> listabaja = new ArrayList <Alumno> ();
		boolean esta=false;
		int cont=0;
		//me guarda todos los alumnos de la lista
		listabaja= objeto.getAlumnos();
		
		//Aqui el foreach con la lista, y comparo los nia
		
		for (Alumno alumno : listabaja) {
			if(alumno.getNia()==nia) {
				esta=true;
				break;
			}
			cont++;
			
		}
		if(esta) {
			listabaja.remove(cont);
			//modifique el XML con los alumnos borrados
			objeto.guardarUsuario(listabaja);
		}
		
	}

	@Override
	public void modificacionAlumno(Alumno alumno) {
		
		AlumnoCompletaXML objeto = new AlumnoCompletaXML();
		List <Alumno> listamodificada = new ArrayList <Alumno>();
		boolean sepuede = false;
		listamodificada= objeto.getAlumnos();
		
		for(Alumno alumnomodif: listamodificada) {
			if(alumno.getNia()==alumnomodif.getNia()) {
				sepuede=true;
				break;
			}
			if(sepuede) {
				alumno.setNia((long) 34215);
				break;
				
			}
		}
		
	}

}
