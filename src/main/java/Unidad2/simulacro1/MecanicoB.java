package Unidad2.simulacro1;

public class MecanicoB implements Runnable {
    private final TallerB taller;
    private final int tiempoReparacion; 
    private final String nombre;

    public MecanicoB(TallerB taller, int tiempoReparacion, String nombre) {
        this.taller = taller;
        this.tiempoReparacion = tiempoReparacion;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (taller.hayCoches()) {
            taller.repararCoche(tiempoReparacion, nombre);
        }
        System.out.println(nombre + " ha terminado su jornada.");
    }
}