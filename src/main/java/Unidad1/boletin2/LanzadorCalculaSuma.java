package Unidad1.boletin2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanzadorCalculaSuma {

	private static final Logger logger = LogManager.getLogger(LanzadorCalculaSuma.class);

	 private final static String directorioGenerarClasses = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\target";
	   private final static String rutaSourceJava = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\src\\main\\java";

	public void ejecutaProcesoCompila() {

		String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSourceJava + "\\Gestiona.java"};

		ProcessBuilder pb = new ProcessBuilder(comando);

		try {
			pb.redirectErrorStream(true);

			pb.inheritIO();

			Process p1 = pb.start();

		} catch (Exception e) { 			logger.error(e.getMessage()); 		}

	}

	

	public void lanzaCompilador(String rutaFicheroFuente, String rutaParaGenerarClass) {

		ProcessBuilder pb;

		try {

			String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSourceJava};

			pb = new ProcessBuilder(comando);

			pb.redirectErrorStream(true);

			pb.inheritIO();

			Process proceso = pb.start();

			int exit = proceso.waitFor();

			logger.debug(exit);

			

		} catch (Exception e) { 			logger.error(e.getMessage()); 		}

	}

	public static void main(String[] args) {

		LanzadorCalculaSuma l = new LanzadorCalculaSuma();

		l.lanzaCompilador(rutaSourceJava, directorioGenerarClasses);

	

	} }