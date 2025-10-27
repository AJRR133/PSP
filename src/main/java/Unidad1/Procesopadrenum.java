package Unidad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Procesopadrenum {
	 private final static String directorioGenerarClasses = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\target";
	 private final static String rutafichero = "src\\main\\java\\Unidad1\\Procesohijonum.java";

	public void compilacljava()   {
	try {
		String[] comando = { "javac", "-d", directorioGenerarClasses,rutafichero};
		ProcessBuilder pb = new ProcessBuilder(comando);
		Process p1 = pb.start();
		pb.inheritIO();
		Process p2 = pb.start();
		int exit = p2.waitFor();
		System.out.println(exit);
	} catch(IOException e) {
		e.printStackTrace();
	} catch(InterruptedException e) {
		e.printStackTrace();
		}
	}

	public void ejecutaProcesoJava() {
		String[] comando = { "java", "-cp", directorioGenerarClasses,
				rutafichero};
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process proceso = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea = reader.readLine();
			while(linea != null) {
				System.out.println("Padre: "+ linea);
				linea = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Procesopadrenum p =new Procesopadrenum();
		p.compilacljava();
		p.ejecutaProcesoJava();
		
	}

}
