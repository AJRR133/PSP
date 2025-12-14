package Unidad2.simulacro2;

public class Laboratorio {
	private int numpiezas;

	public Laboratorio(int numpiezas) {
		super();
		this.numpiezas = numpiezas;
	}
	
	public int getNumpiezas() {
		return numpiezas;
	}

	public void setNumpiezas(int numpiezas) {
		this.numpiezas = numpiezas;
	}

	public synchronized void imprimirpieza() {
		
		if(numpiezas>0) {
			try {
				System.out.println("imprimiendo pieza "+numpiezas);
				Thread.sleep(4000);
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
			System.out.println("terminada impresion pieza "+numpiezas);
			numpiezas--;
	}

	public synchronized boolean haypiezas() {
		return numpiezas >0;
	}
	
	
}
