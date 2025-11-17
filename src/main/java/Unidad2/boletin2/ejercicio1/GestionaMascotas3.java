package Unidad2.boletin2.ejercicio1;


import java.util.ArrayList;
import java.util.List;

import Unidad2.Boletin1.ejercicio5.Mascota;

public class GestionaMascotas3 {

	public static void main(String[] args) throws InterruptedException {
		Mascota Manolito = new Mascota("Manolito",0);
		List<Thread> cuidadores = new ArrayList<Thread>();
		for(int i = 1; i<=10;i++) {
			Thread cuidador= new Thread(Manolito,"Cuidador"+i);
			cuidador.setPriority(11-i);
			cuidadores.add(cuidador);
			cuidador.start();
			
		}
		for(Thread c : cuidadores)
		c.join();
		
		System.out.println((Manolito.getNumcome()));
	}
	

}
