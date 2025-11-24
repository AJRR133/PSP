package Unidad2.boletin3.ejercico4;

public class MultiploCoopHilo7  extends Thread{

	private MultiplosCooperativos multiplo;
	

	
	public MultiploCoopHilo7(MultiplosCooperativos multiplo) {
		super();
		this.multiplo = multiplo;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		MultiplosCooperativos.multiplicar(7);
	}
	
	
	
}
