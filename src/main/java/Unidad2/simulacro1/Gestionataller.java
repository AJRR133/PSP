package Unidad2.simulacro1;

public class Gestionataller {
	 public static void main(String[] args) {
	        Taller taller = new Taller(20);   // 20 coches esperando
	        Mecanico mecanico = new Mecanico(taller);
	        mecanico.start();
	    }
	}