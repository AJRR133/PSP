package Unidad2.simulacro1;

import java.util.concurrent.Semaphore;

public class Gestionatallerc {
	public static void main(String[] args) throws InterruptedException {

        Semaphore semaforo = new Semaphore(2);

        TallerB taller = new TallerB(20, semaforo);

        Thread mecanico1 = new Thread(
                new MecanicoB(taller, 5, "Mecánico 1"));
        Thread mecanico2 = new Thread(
                new MecanicoB(taller, 8000, "Mecánico 2"));

        long inicio = System.currentTimeMillis();

        mecanico1.start();
        mecanico2.start();

        mecanico1.join();
        mecanico2.join();

        long fin = System.currentTimeMillis();

        System.out.println("Tiempo total: " + (fin - inicio) / 1000 + " segundos");
    }
}
