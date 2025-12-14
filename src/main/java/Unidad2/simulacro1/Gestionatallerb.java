package Unidad2.simulacro1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Gestionatallerb {
	  public static void main(String[] args) {

	        Semaphore semaforo = new Semaphore(1);
	        int totalCoches = 20;
	        List<Thread> hilos = new ArrayList<>();
	        TallerB taller = new TallerB(totalCoches,semaforo);

	        hilos.add(new Thread(new MecanicoB(taller, 1, "Mecánico 1"))); // 5 segundos por coche
	        hilos.add(new Thread(new MecanicoB(taller, 2, "Mecánico 2"))); // 8 segundos por coche

	        // Iniciar  los hilos
	        for (Thread hilo : hilos) {
	            hilo.start();
	        }
	    }
	}