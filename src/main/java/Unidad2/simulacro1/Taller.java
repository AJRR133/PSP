package Unidad2.simulacro1;

public class Taller {
    private int cochesesperando;

    

    public Taller(int cochesesperando) {
		super();
		this.cochesesperando = cochesesperando;
	}

	public synchronized void repararCoche() {
		int cocheactual = cochesesperando;
		
        if(cochesesperando >0) {
        	try {
        		
            	System.out.println("El mecanico esta reparando el coche " +cocheactual);
				Thread.sleep(5000);
				cochesesperando--;
			System.out.println("Reparado coche "+cocheactual);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        } else {
        	System.out.println("todos los coches reparados");
        }
    }

    public synchronized boolean hayCoches() {
        return cochesesperando > 0;
    }
}
