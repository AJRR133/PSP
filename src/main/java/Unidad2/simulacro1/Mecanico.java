package Unidad2.simulacro1;



public class Mecanico extends Thread {
    private Taller taller;

    public Mecanico(Taller taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        while (taller.hayCoches()) {
            taller.repararCoche();  // método sincronizado
        }
        System.out.println("Todos los coches han sido reparados.");
    }
}
