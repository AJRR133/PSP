package Unidad2;

public class GestionaMihilo {

    public static void main(String[] args) {
        long inicioMain = System.currentTimeMillis();

        Mihilo hilo1 = new Mihilo("Hilo1");
        Mihilo hilo2 = new Mihilo("Hilo2");

        System.out.println(hilo1.getState()); // NEW
        hilo1.start();
        System.out.println(hilo1.getState()); // RUNNABLE

        hilo2.start();
        System.out.println("Estoy en el main");
        System.out.println(hilo1.getState()); // RUNNABLE o TIMED_WAITING

        try {
            // Espera a que ambos hilos terminen para medir duración exacta
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finMain = System.currentTimeMillis();

        System.out.println("\n--- RESUMEN DE TIEMPOS ---");
        System.out.println("Duración Hilo1: " + hilo1.getDuracion() + " ms");
        System.out.println("Duración Hilo2: " + hilo2.getDuracion() + " ms");
        System.out.println("Duración total del main: " + (finMain - inicioMain) + " ms");
    }
}
