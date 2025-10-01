package Unidad1;

import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime kernel = Runtime.getRuntime();
		
		System.out.println(kernel.totalMemory());
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.freeMemory());
		//String [] argumentos = {"Notepad","adios.txt"};
		System.out.println(kernel.availableProcessors());
		String [] argumentos = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","https://chatgpt.com/"};
		
		try {
			kernel.exec(argumentos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
