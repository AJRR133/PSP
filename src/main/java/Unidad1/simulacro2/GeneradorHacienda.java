package Unidad1.simulacro2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneradorHacienda {
	private final static String directorioGenerarClasses = "target\\classes";
	private final static String rutaSourceJava = "src/main/java/";
	private final static String RUTAR = "src/main/resources/";

	public void compila() {
		String[] comando1 = { "javac", "-d", directorioGenerarClasses,
				rutaSourceJava + "Unidad1/simulacro2/GeneraDNIFichero.java" };
		ProcessBuilder pb1 = new ProcessBuilder(comando1);

		String[] comando2 = { "javac", "-d", directorioGenerarClasses,
				rutaSourceJava + "Unidad1/simulacro2/GeneraNSSFichero.java" };
		ProcessBuilder pb2 = new ProcessBuilder(comando2);

		try {
			pb1.redirectErrorStream(true);
			pb1.inheritIO();
			Process p1 = pb1.start();
			int exit = p1.waitFor();
			pb2.redirectErrorStream(true);
			pb2.inheritIO();
			Process p2 = pb1.start();
			int exit2 = p2.waitFor();
		} catch (Exception e) {
		}

	}

	private int contarLineasArchivo(String rutaFichero) {
		int contador = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
			while (br.readLine() != null) {
				contador++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contador;
	}

	private void escribirResumen(int dniCount, int nssCount) throws IOException {
		int total = dniCount + nssCount;
		try (PrintWriter pw = new PrintWriter(new FileWriter(RUTAR + "resumen.txt"))) {
			pw.println("Número total:");
			pw.println("DNIs: " + dniCount);
			pw.println("NSSs: " + nssCount);
			pw.println("Total: " + (dniCount + nssCount));
		}
	}

	public void ejecuta(String fichero) throws InterruptedException {
		// sin el "classes en el target no funciona bien
		String[] comando1 = { "java", "-cp", "target/classes", "Unidad1.simulacro2.GeneraDNIFichero", fichero };

		ProcessBuilder pb1 = new ProcessBuilder(comando1);

		String[] comando2 = { "java", "-cp", "target/classes", "Unidad1.simulacro2.GeneraNSSFichero", fichero };

		ProcessBuilder pb2 = new ProcessBuilder(comando2);

		try {
			pb1.redirectErrorStream(true);
			pb1.inheritIO();
			Process p1 = pb1.start();
			p1.waitFor();

			pb2.redirectErrorStream(true);
			pb2.inheritIO();
			Process p2 = pb2.start();
			p2.waitFor();
			
			// desde aqui tambien funciona
			/*int dniCount = contarLineasArchivo("src/main/resources/DNIs.txt");
			int nssCount = contarLineasArchivo("src/main/resources/NSSs.txt");

			escribirResumen(dniCount, nssCount);*/
			

		} catch (IOException e) {
		}

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		GeneradorHacienda lanzador = new GeneradorHacienda();
		lanzador.compila();

		String fichero = "simulacro2.txt";

		lanzador.ejecuta(fichero);
		int dniCount = lanzador.contarLineasArchivo("src/main/resources/DNIs.txt");
		int nssCount = lanzador.contarLineasArchivo("src/main/resources/NSSs.txt");

		lanzador.escribirResumen(dniCount, nssCount);
		System.out.println(" Resumen generado correctamente en src/main/resources/resumen.txt");

	}

}