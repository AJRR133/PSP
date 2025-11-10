package Unidad2;

public class GestionaMihilo {

	public static void main(String[] args) {
		Mihilo hilo1 = new Mihilo("Hilo1");
		System.out.println(hilo1.getState());

		hilo1.start();
		System.out.println(hilo1.getState());
		Mihilo hilo2 = new Mihilo("Hilo2");

		hilo2.start();
		System.out.println("Estoy en el main");
		System.out.println(hilo1.getState());
	}

}
