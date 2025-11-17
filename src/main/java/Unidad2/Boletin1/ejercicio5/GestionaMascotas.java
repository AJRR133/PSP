package Unidad2.Boletin1.ejercicio5;

public class GestionaMascotas {
	public static void main(String[] args) throws InterruptedException {
	Mascota Manolito = new Mascota("Manolito",0);
	Thread juanito = new Thread(Manolito,"Cuidador 1");
	Thread juanito2 = new Thread(Manolito,"Cuidador 2");
	Thread juanito3 = new Thread(Manolito,"Cuidador 3");
	Thread juanito4 = new Thread(Manolito,"Cuidador 4");
	Thread juanito5 = new Thread(Manolito,"Cuidador 4");
	
	juanito.start();
	juanito2.start();
	juanito3.start();
	juanito4.start();
	juanito5.start();
	
	
	juanito.join();
	juanito2.join();
	juanito3.join();
	juanito4.join();
	juanito5.join();
	
	System.out.println((Manolito.getNumcome()));
	
	}
	
	
	
}
