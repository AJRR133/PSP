package Unidad2.boletin3.ejercico4;

public class MultiploCoopHilo3  extends Thread{

	private MultiplosCooperativos multiplo;
	

	
	public MultiploCoopHilo3(MultiplosCooperativos multiplo) {
		super();
		this.multiplo = multiplo;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		MultiplosCooperativos.multiplicar(3);
	}
	
	
	
}
