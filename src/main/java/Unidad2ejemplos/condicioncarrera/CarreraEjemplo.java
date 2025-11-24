package Unidad2ejemplos.condicioncarrera;

public class CarreraEjemplo {
	 public static void main(String[] args) throws InterruptedException {
	      
		 long t_inicio = System.currentTimeMillis();		 
		 Contador contador = new Contador();
	       Thread t1 = new Thread(new TareaIncremento(contador));
	       Thread t2 = new Thread(new TareaIncremento(contador));
	       Thread t3 = new Thread(new TareaIncremento(contador));
	       Thread t4 = new Thread(new TareaIncremento(contador));
	       t1.start();
	       t2.start();
	       t1.join();
	       t2.join();
	       t3.start();
	       t4.start();
	       t3.join();
	       t4.join();
	       System.out.println("Valor final: " + contador.getValor());
	       
	       long tfin =System.currentTimeMillis();
	       long tiempototal = tfin-t_inicio;
	       System.out.println("El proceso ha tardado = "+ tiempototal +" mg");
	 }
	}

