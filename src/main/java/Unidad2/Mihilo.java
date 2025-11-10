package Unidad2;

public class Mihilo extends Thread{
	
	private String nombrehilo;
	
	
	
	public Mihilo(String nombrehilo) {
		super();
		this.nombrehilo = nombrehilo;
	}



	@Override
	public void run() {
		System.out.println(this.nombrehilo+"estado: "+this.getState());
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina hilo: "+ this.nombrehilo);
	}
	
	
}
