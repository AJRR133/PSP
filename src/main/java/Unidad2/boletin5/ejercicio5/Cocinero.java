package Unidad2.boletin5.ejercicio5;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable{
	private String nombre;
	private Semaphore semaforo;
	
	public Cocinero(String nombre, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.semaforo = semaforo;
	}
	


	@Override
	public void run() {
			try {
			
			System.out.println(nombre + " esta cocinando");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(nombre + " termina de cocinar");
			semaforo.release(3);
		}}

}
