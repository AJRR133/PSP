package Unidad1.simulacro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class LanzadorSepararprovincias {
	private final static String directorioGenerarClasses = "target\\classes";
	private final static String rutaSourceJava = "src/main/java/";

	public void compila() {
		String[] comando = { "javac", "-d", directorioGenerarClasses,
				rutaSourceJava + "Unidad1/simulacro/Separarprovincias.java" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exit = p1.waitFor();
		} catch (Exception e) {
		}

	}
	
	public void ejecuta(String fichero, String provincia) {
		String[] comando = { "java", "-cp", "target", "Unidad1.simulacro.Separarprovincias", fichero,
				provincia };

		ProcessBuilder pb = new ProcessBuilder(comando);
		

		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
		} catch (IOException e) {
		}
	}
	
	public static void main(String[] args) {
		LanzadorSepararprovincias lanzador = new LanzadorSepararprovincias();
		lanzador.compila();

		String fichero = "pedidos.txt";

		String[] provincias = { "Sevilla", "Cádiz","Almería", "Córdoba", "Jaén","Malaga","Huelva","Granada" };

		for (String u : provincias) {
			lanzador.ejecuta(fichero,u);
		}

		// logger.info("Todos los procesos hijos han sido lanzados.");
	}

	
}
