package Unidad1.boletin2;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;

	public class Lanzadorsumaconruntime {

	    private static final Logger logger = LogManager.getLogger(Lanzadorsumaconruntime.class);

	    private final static String directorioGenerarClasses = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\target";
	    private final static String rutaSourceJava = "C:\\Users\\alumno\\Desktop\\sprint\\PSP\\src\\main\\java";

	    public void lanzaCompilador(String rutaFicheroFuente, String rutaParaGenerarClass) {
	        try {
	            String comando = "javac -d \"" + rutaParaGenerarClass + "\" \"" + rutaFicheroFuente + "\\Gestiona.java\"";

	            Process proceso = Runtime.getRuntime().exec(comando);

	            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	            BufferedReader stdError = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));

	            String s;

	            while ((s = stdInput.readLine()) != null) {
	                logger.info(s);
	            }

	            while ((s = stdError.readLine()) != null) {
	                logger.error(s);
	            }

	            int exitCode = proceso.waitFor();
	            logger.debug("Código de salida: " + exitCode);

	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	        }
	    }

	    public static void main(String[] args) {
	        Lanzadorsumaconruntime l = new Lanzadorsumaconruntime();
	        l.lanzaCompilador(rutaSourceJava, directorioGenerarClasses);
	    }
	}


