package Unidad2ejemplos.condicioncarrera;

public class Contador {
	private int valor = 0;
	
	   public synchronized void incrementar() { 
	       valor++;
	   }
	   public int getValor() {
	       return valor;
	   }
}