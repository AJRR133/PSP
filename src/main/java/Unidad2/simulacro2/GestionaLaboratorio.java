package Unidad2.simulacro2;

public class GestionaLaboratorio {
	 public static void main(String[] args) {
		 Laboratorio l1 = new Laboratorio(15);
		 Impresora i1 = new Impresora(l1);
		 Thread i1hilo = new Thread(i1);
		 
		 long inicio = System.currentTimeMillis();
		 i1hilo.start();
		 try {
			 i1hilo.join(); // Espera a que termine la impresora
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 long fin = System.currentTimeMillis();
		 System.out.println("Tiempo total: " + (fin-inicio)/1000 + " segundos");
	 }


}
