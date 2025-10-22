package Unidad1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cuentapalabras.modelo.Contadorpalabras;

public class Contadorpalabraspsp {
	
		private static final Logger logger =LogManager.getLogger(Contadorpalabraspsp.class);
		private static final String rutar ="src/main/resources/";
		public Contadorpalabraspsp( ) {
			super();
			
		}

		public int contar(String ruta, String palabra) throws FileNotFoundException {
			Scanner sc = null;
			FileReader f = new FileReader(ruta);
			int contador =0;
			sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String pa = sc.nextLine();
				String[] partes = pa.split(" ");
				for(String p : partes) {
					if(p.equalsIgnoreCase(palabra)) {
						contador++;
					}
				}
			}
			return contador;
		}
		public static void main(String[] args) throws FileNotFoundException {
			String ruta = rutar+ args[0];
			String palabra = args[1];
			Contadorpalabraspsp c = new Contadorpalabraspsp();
			System.out.println(c.contar(ruta, palabra));
		}
	}
