package Unidad2.boletin4.ejercicio3;

public class HiloIngresar extends Thread {
	
	
	private Cuenta c;
	
	
	public HiloIngresar(Cuenta c) {
        this.c = c;
    }


	@Override
	public void run() {
		
			c.ingresardinero();
		
	}
	
	

}
