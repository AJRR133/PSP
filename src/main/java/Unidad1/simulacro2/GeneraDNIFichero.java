package Unidad1.simulacro2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GeneraDNIFichero {
	private static final String RUTAR = "src/main/resources/";

	
	
	public GeneraDNIFichero() {
		super();
	}
	public List<String> devolerDNI(String ruta) throws FileNotFoundException{
		List<String> lineas = new java.util.ArrayList<>();
		try (java.util.Scanner sc = new java.util.Scanner(new java.io.FileReader(ruta))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if(!linea.trim().startsWith("AN")) {
                	lineas.add(linea);
                }
            }
            }
		return lineas;
	}
	public void escribirFicherodni(String ruta, List<String> lineas) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (String linea : lineas)
            	pw.printf("%s%n",linea);
        }
    }
	
	public static void main(String[] args) throws IOException {
		String rutaEntrada = RUTAR + args[0];
		String rutaSalida = RUTAR + "DNIs.txt";
		GeneraDNIFichero g = new GeneraDNIFichero();
		List<String> salida = g.devolerDNI(rutaEntrada);
		g.escribirFicherodni(rutaSalida, salida);
		System.out.println("Fichero DNIs.txt generado correctamente en " + rutaSalida);

	}
	
}