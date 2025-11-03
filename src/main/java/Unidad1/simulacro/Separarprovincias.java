package Unidad1.simulacro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Separarprovincias {
    private static final String rutar = "src/main/resources/";
   
	public Separarprovincias() {
		super();
	}




	public List<String> devuelveArticulos(String ruta, String provincia) throws IOException {
        List<String> lineas = new java.util.ArrayList<>();
        try (java.util.Scanner sc = new java.util.Scanner(new java.io.FileReader(ruta))) {
            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.contains(provincia)) 
                	lineas.add(linea);
                
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
        

        String rutaEntrada = rutar + args[0];
        String provincia = args[1];
        String rutaSalida = rutar + provincia + ".txt";

        Separarprovincias s = new Separarprovincias();
        List<String> lineas = s.devuelveArticulos(rutaEntrada, provincia);
        s.escribirFichero(rutaSalida, lineas);

        //System.out.println("Archivo generado correctamente: " + rutaSalida);
  
		System.out.println(provincia+":"+lineas.size());
    }
}
