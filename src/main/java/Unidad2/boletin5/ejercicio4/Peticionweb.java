package Unidad2.boletin5.ejercicio4;

public class Peticionweb implements Runnable {

	private Semaforo semaforo;
	private String nombre;
	
	
	public Peticionweb(Semaforo semaforo, String nombre) {
		super();
		this.semaforo = semaforo;
		this.nombre = nombre;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		semaforo.conexion();
	}

}
