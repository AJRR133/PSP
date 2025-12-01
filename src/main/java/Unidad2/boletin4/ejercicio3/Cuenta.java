package Unidad2.boletin4.ejercicio3;

public class Cuenta {

	private int saldo;

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}

	public Cuenta(int saldo) {
		super();
		this.saldo = saldo;
	}
	
	
	public synchronized void retirardinero() throws CuentaBancoException {
		int aleatorio=((int)(Math.random()*500+1));
		if ((saldo-aleatorio)<0)
			throw new CuentaBancoException("El saldo se quedaria negativo");
		
		saldo = saldo - aleatorio;
	        System.out.println("Se ha retirado " +aleatorio+ " y el saldo es " + saldo);
	}
	
	public synchronized void ingresardinero( ) {
		int aleatorio=((int)(Math.random()*500+1));
		saldo = saldo+aleatorio;
		System.out.println("Se ha ingresado " +aleatorio+ " y el saldo es " + saldo);
	}
	
	
	
}
