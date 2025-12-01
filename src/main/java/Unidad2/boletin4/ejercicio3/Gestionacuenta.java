package Unidad2.boletin4.ejercicio3;

public class Gestionacuenta {

	public static void main(String[] args) throws InterruptedException {

		Cuenta c = new Cuenta(300);
		
		
		
		HiloRetirar hr1 = new HiloRetirar(c);
		HiloRetirar hr2 = new HiloRetirar(c);
		HiloIngresar hi1 = new HiloIngresar(c);
		HiloIngresar hi2 = new HiloIngresar(c);
		
		hr1.start();
		hr1.join();
		System.out.println(c);
		hr2.start();
		hr2.join();
		System.out.println(c);
		hi1.start();
		hi1.join();
		System.out.println(c);
		hi2.start();
		hi2.join();
		System.out.println(c);


	}

}
