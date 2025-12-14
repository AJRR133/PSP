package Unidad2.simulacro2;

public class Impresora implements Runnable {
	private Laboratorio labo1;
	
	public Impresora(Laboratorio labo1) {
		super();
		this.labo1 = labo1;
	}

	@Override
	public void run() {
		
		while(labo1.haypiezas()) {
			
			labo1.imprimirpieza();
		}
		System.out.println("todas las piezas han sido impresas");

	}

}
