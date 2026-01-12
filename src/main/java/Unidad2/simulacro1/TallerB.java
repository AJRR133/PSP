package Unidad2.simulacro1;

import java.util.concurrent.Semaphore;

	public class TallerB {
		private int cochesEsperando;
		private final Semaphore semaforo;

	public TallerB(int cochesEsperando,Semaphore semaforo) {
		this.cochesEsperando = cochesEsperando;
		this.semaforo = semaforo;
	}

	/*public void repararCoche(int tiempoReparacion, String nombreMecanico) {
		try {
			semaforo.acquire(); 
			if (cochesEsperando > 0) {
				int cocheActual = cogercoche();
				System.out.println(nombreMecanico + " está reparando coche " + cocheActual );
				Thread.sleep(tiempoReparacion * 1000);
				cochesEsperando--;
				System.out.println(nombreMecanico + " ha reparado coche " + cocheActual);
						
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(nombreMecanico + " fue interrumpido.");
		} finally {
			semaforo.release(); 
		}
	}*/
	
	public void repararCoche(int tiempoReparacion, String nombreMecanico) {
	    int cocheActual = cogercoche(); // coger coche de manera thread-safe

	    try {
	        if (cocheActual != -1) { // solo entra si hay coche
	            semaforo.acquire(); // ocupa el taller
	            System.out.println(nombreMecanico + " está reparando coche " + cocheActual);
	            Thread.sleep(tiempoReparacion * 1000);
	            System.out.println(nombreMecanico + " ha reparado coche " + cocheActual);
	        }
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        System.out.println(nombreMecanico + " fue interrumpido.");
	    } finally {
	        if (cocheActual != -1) { // liberar semáforo solo si se adquirió
	            semaforo.release();
	        }
	    }
	}


	public boolean hayCoches() {
		return cochesEsperando > 0;
	}
	
	public synchronized int cogercoche() {
	    int cocheActual = -1;
	    if (cochesEsperando > 0) {
	        cocheActual = cochesEsperando;
	        cochesEsperando--;
	    }
	    return cocheActual;
	}
}