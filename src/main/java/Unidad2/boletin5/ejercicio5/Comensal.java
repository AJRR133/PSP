package Unidad2.boletin5.ejercicio5;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable {

	private String nombre;
	private Semaphore semaforo;
	
	public Comensal(String nombre, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			System.out.println(nombre + " esta comiendo");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
		}}
}
