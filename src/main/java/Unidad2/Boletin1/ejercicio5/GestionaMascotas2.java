package Unidad2.Boletin1.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class GestionaMascotas2 {

	public static void main(String[] args) throws InterruptedException {
		Mascota Manolito = new Mascota("Manolito",0);
		List<Thread> cuidadores = new ArrayList<Thread>();
		for(int i = 0; i<10;i++) {
			Thread cuidador= new Thread(Manolito,"Cuidador"+i);
			if(i%2 == 0) {
				cuidador.setPriority(cuidador.MAX_PRIORITY);
			} else {
				cuidador.setPriority(cuidador.MIN_PRIORITY);
			}
			
			cuidadores.add(cuidador);
			cuidador.start();
			
		}
		for(Thread c : cuidadores)
		c.join();
		
		System.out.println((Manolito.getNumcome()));
	}
	

}
