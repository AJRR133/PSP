package Unidad2.boletin3.ejercicio3;

public class Multiplos implements Runnable {
	
	private int num;

	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Multiplos(int num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		multiplicar(num);
	}

	public void multiplicar(int num) {
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
