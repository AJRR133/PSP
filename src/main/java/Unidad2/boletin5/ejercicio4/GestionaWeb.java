package Unidad2.boletin5.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class GestionaWeb {
	public static void main(String[] args) {

		Semaforo numconexiones = new Semaforo(12);
		int numHilos = 20;
		
		List<Thread> hilos = new ArrayList<>();
		
		for(int i = 0; i < numHilos; i++)
		{
			hilos.add(new Thread(new Peticionweb(numconexiones,"hilo"+(i+1))));
		}		
		
		for(Thread hilo : hilos)
		{
			hilo.start();
		}		
	}

}
