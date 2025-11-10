package Unidad2.Boletin1;

public class Ejercicio1_1 extends Thread{
	
	private String nombrehilo;

	public Ejercicio1_1(String nombrehilo) {
		super();
		this.nombrehilo = nombrehilo;
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(500);
				System.out.println("SERVICIOS");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	
	
	
}
