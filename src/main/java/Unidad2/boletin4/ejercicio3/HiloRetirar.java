package Unidad2.boletin4.ejercicio3;

public class HiloRetirar extends Thread {
	
	
	private Cuenta c;
	

	public HiloRetirar(Cuenta c) {
        this.c = c;
    }
	@Override
	public void run() {
		try {
			c.retirardinero();
		} catch (CuentaBancoException e) {
			// TODO Auto-generated catch block
			 System.out.println(e.getMessage());
		}
	}
	
	

}
