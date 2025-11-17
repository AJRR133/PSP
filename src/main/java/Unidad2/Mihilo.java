package Unidad2;

public class Mihilo extends Thread {

    private String nombrehilo;
    private long inicioHilo;
    private long finHilo;

    public Mihilo(String nombrehilo) {
        super();
        this.nombrehilo = nombrehilo;
    }

    @Override
    public void run() {
        inicioHilo = System.currentTimeMillis();
        System.out.println(this.nombrehilo + " estado: " + this.getState() + " inicio: " + inicioHilo);

        try {
            sleep(10000); // Simula trabajo del hilo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finHilo = System.currentTimeMillis();
        System.out.println("Termina hilo: " + this.nombrehilo + " fin: " + finHilo
                + " -> Duración: " + (finHilo - inicioHilo) + " ms");
    }

    // Métodos para obtener la duración del hilo
    public long getDuracion() {
        return finHilo - inicioHilo;
    }
}
