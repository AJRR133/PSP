package Unidad2;

public class Mihilo2 implements Runnable {
	private String nombreHilo;
	
	public Mihilo2(String nombre) {
		super();
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(nombreHilo);
		System.out.println("Ejecutando Hilo:"+Thread.currentThread().getName());		
	}

}
