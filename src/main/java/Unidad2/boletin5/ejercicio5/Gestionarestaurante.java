package Unidad2.boletin5.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

;

public class Gestionarestaurante {
	public static void main(String[] args) {

		int numHilos = 3;
		
		List<Thread> hilos = new ArrayList<>();
		
		Semaphore semaforo = new Semaphore(3);
		try {
			semaforo.acquire(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Cocinero cocinero = new Cocinero("cocinero",semaforo );
		//Thread cocinerohilo = new Thread(cocinero);
	    Thread cocinero = new Thread(new Cocinero("cocinero",semaforo));
		
	    hilos.add(cocinero);
		for(int i = 0; i < numHilos; i++)
		{
			Comensal comensal = new Comensal("comensal"+i,semaforo);
			Thread comensalhilo = new Thread(comensal);
			hilos.add(comensalhilo);
		}		
		
		for(Thread hilo : hilos)
		{
			hilo.start();
		}		
	}

}
