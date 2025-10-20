package Unidad1.boletin2;

public class Calculasuma {

	public static void main(String[] args) {
		Calculasuma ca = new Calculasuma();
		System.out.println(ca.realizasuma(args[0], args[1]));
	}
	
	public int realizasuma(String parimpar, String num2) {
		  int numerosumado = 0;
	      int numargumento = Integer.parseInt(num2);
		if(parimpar.equalsIgnoreCase("par")) {
            for(int i = 0; i <= numargumento; i++) {
                if(i % 2 == 0) {
                    numerosumado += i;
                }
            }
        } else if(parimpar.equalsIgnoreCase("impar")) {
            for(int i = 0; i <= numargumento; i++) {
                if(i % 2 != 0) {
                    numerosumado += i;
                }
            }
        } else {
            System.out.println("El primer argumento debe ser 'par' o 'impar'.");
        }
        
        return numerosumado;
    }
	
}
