package Unidad1.simulacro2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GeneraNSSFichero {
	private static final String RUTAR = "src/main/resources/";

	public GeneraNSSFichero() {
		super();
	}
	
	public List<String> devolerNSS(String ruta) throws FileNotFoundException{
		List<String> lineas = new java.util.ArrayList<>();
		try (java.util.Scanner sc = new java.util.Scanner(new java.io.FileReader(ruta))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if(linea.trim().startsWith("AN")) {
                	lineas.add(linea);
                }
            }
            }
		return lineas;
	}
	public void escribirFichero(String ruta, List<String> lineas) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (String linea : lineas)
            	pw.printf("%s%n",linea);
        }
    }
	
	public static void main(String[] args) throws IOException {
		String rutaEntrada = RUTAR + args[0];
		String rutaSalida = RUTAR + "NSSs.txt";
		GeneraNSSFichero g = new GeneraNSSFichero();
		List<String> salida = g.devolerNSS(rutaEntrada);
		g.escribirFichero(rutaSalida, salida);
        System.out.println("Fichero  generado correctamente en" + rutaSalida);

	}
	
}
