package Unidad1;

import java.io.IOException;

public class Lanzadorejemplo {
	private static final String directorioGenerarClasses = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\target";
	private static final String rutaSource = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\src\\main\\java\\Unidad1\\Procesohijo.java";
	
	public static void main(String[] args) {
		Lanzadorejemplo l = new Lanzadorejemplo();
		l.ejectaprocesojava();
	}
	public void ejecutaproceso() {
		String[] comando = { "javac", "-d", directorioGenerarClasses, 
				rutaSource+"\\Unidad1\\Gestionaejemploo.java" };
		
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void ejectaprocesojava() {
		String[] comando = {"java", "-cp", "target/classes", rutaSource ,"hola2", "adios2" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
		    pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

