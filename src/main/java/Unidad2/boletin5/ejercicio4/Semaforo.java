package Unidad2.boletin5.ejercicio4;

import java.util.concurrent.Semaphore;

public class Semaforo {

	private Semaphore semaforo;

	public Semaforo(int numconex) {
		super();
		this.semaforo = new Semaphore(numconex);
	}
	
	public void conexion() {
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName() + " tiene conexión");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + " libera conexión");
		}}

	}
	

