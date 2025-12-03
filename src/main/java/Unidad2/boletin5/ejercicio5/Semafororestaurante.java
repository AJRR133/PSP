package Unidad2.boletin5.ejercicio5;

import java.util.concurrent.Semaphore;

public class Semafororestaurante {
	private Semaphore semaforo;

	public Semafororestaurante(int num) {
		super();
		this.semaforo = new Semaphore(num);
	}

	public void paracocinero() {
		try {
			
			System.out.println(Thread.currentThread().getName() + " esta cocinando");
			System.out.println("esta cocinando");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " termina de cocinar");
			semaforo.release();
		}}
	
	public void paracomensal() {
		try {
			semaforo.acquire(3);
			System.out.println(Thread.currentThread().getName() + " esta comiendo");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
		}}
	
	
}

	
