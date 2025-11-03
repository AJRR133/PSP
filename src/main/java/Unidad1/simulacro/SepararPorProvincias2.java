package Unidad1.simulacro;

import java.io.*;
import java.util.*;

public class SepararPorProvincias2 {
    private static final String RUTA_BASE = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Uso: java SepararPorProvincias2 <fichero> <provincia>");
            System.exit(1);
        }

        String ficheroEntrada = RUTA_BASE + args[0];
        String provincia = args[1];
        String ficheroSalida = RUTA_BASE + provincia + ".txt";

        List<String> lineasProvincia = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea = br.readLine(); // Cabecera
            while ((linea = br.readLine()) != null) {
                // Dividimos la línea por el carácter #
                // Ejemplo: Mesa exterior #1 #500 #0000001 #c/Calle Jamaica, 1 #Sevilla #01/03/2021
                String[] partes = linea.split("#");

                if (partes.length >= 7) {
                    String provinciaLinea = partes[5].trim(); //trim elimina espacios en blanco
                    if (provinciaLinea.equalsIgnoreCase(provincia)) {
                        lineasProvincia.add(linea);
                    }
                }
            }
        }

        // Escribir el fichero de esa provincia
        try (PrintWriter pw = new PrintWriter(new FileWriter(ficheroSalida))) {
            for (String l : lineasProvincia) {
                pw.println(l);
            }
        }

        // Mostrar el resultado
        System.out.println(provincia + " : " + lineasProvincia.size());
    }
}
