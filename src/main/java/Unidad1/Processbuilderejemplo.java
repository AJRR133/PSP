package Unidad1;

import java.io.IOException;

public class Processbuilderejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*String[] comando = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};
	ProcessBuilder pb = new ProcessBuilder(comando);
	try {
		Process p = pb.start();
		pb.start();
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}*/

	
	
	String[] comando2 = {"cmd" , "/C", "Start", "cmd", "/K", "tasklist"};
	ProcessBuilder pb2 = new ProcessBuilder(comando2);
	try {
		Process p2 = pb2.start();
		pb2.start();
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
}
