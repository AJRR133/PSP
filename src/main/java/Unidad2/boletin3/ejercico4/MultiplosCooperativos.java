package Unidad2.boletin3.ejercico4;

public class MultiplosCooperativos {

	public static synchronized void multiplicar(int num) {
		for(int i = 0; i<=10; i++) {
		System.out.println(num + "*" + i+ "="+(num*i));	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}
}
