package Unidad1;

import java.awt.List;

public class Lanzadorcontadorpalabras {
	private static final String rutaclase = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\src\\main\\java\\Unidad1\\Contadorpalabraspsp.java";
	private static final String rutafichero ="C:\\Users\\alumno\\Desktop\\sprint\\PSP\\src\\main\\resources\\fichero.txt";
	
	/*String[] comando = { "javac", "-d",rutaclase,rutafichero};
	ProcessBuilder p1 = new ProcessBuilder(comando+"es");
	ProcessBuilder p2 = new ProcessBuilder(comando+"y");
	ProcessBuilder p3 = new ProcessBuilder(comando+"java");*/

	
	public void lanzar(String rutaclase,String rutafichero) {
		String[] comando = { "javac", "-d",rutaclase,rutafichero};
		ProcessBuilder p1 = new ProcessBuilder(comando+"es");
		ProcessBuilder p2 = new ProcessBuilder(comando+"y");
		ProcessBuilder p3 = new ProcessBuilder(comando+"java");
		
		//try {
			
		//}
		
	}
	
	public static void main(String[] args) {
		
	}
}
	

