package Unidad2.boletin3.Ejercicio1;

public class CalculaMaxHilo2 implements Runnable{
	
	private int[] tabla;
	private int inicio;
	private int fin;
	private int maximoTramo;
	private int calculaMax( ) {
		int maxTotal = tabla[inicio];
		for (int i = inicio; i < fin; i++) {
			if (tabla[i] > maxTotal) {
				maxTotal = tabla[i];
			}
		}
		System.out.println("Maximo del rango "+inicio+" - "+fin+":"+maxTotal);
		return maxTotal;
	}
	
	
	public int[] getTabla() {
		return tabla;
	}

	public void setTabla(int[] tabla) {
		this.tabla = tabla;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public int getMaximoTramo() {
		return maximoTramo;
	}

	public void setMaximoTramo(int maximoTramo) {
		this.maximoTramo = maximoTramo;
	}

	@Override
	public void run() {
		maximoTramo = calculaMax();
		
	}
 
}
