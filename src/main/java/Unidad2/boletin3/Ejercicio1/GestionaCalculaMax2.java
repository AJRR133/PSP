package Unidad2.boletin3.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class GestionaCalculaMax2 {
	public static void main(String[] args) {
		int tamTabla= 10000;
		int numHilos = 10;
		long t_comienzo = System.currentTimeMillis();
		
		GestionaCalculaMaxHilo calcula = new GestionaCalculaMaxHilo();
		
		int[] tabla = calcula.construyeTablaNotas(tamTabla);
		List<Thread> hilos  = new ArrayList<Thread>();
		
		List<CalculaMaxHilo> objetosHilos  = new ArrayList<CalculaMaxHilo>();
		
	
	
	
	}
}