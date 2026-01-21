package Unidad3.Boletin2.ejercicio0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorHilosServidor extends Thread {

	Socket socket = new Socket();

	public ManejadorHilosServidor(Socket socket) {
		super();
		this.socket = socket;
	} 
	
	public void run() {
		BufferedReader entrada;
		try {
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			salida.println("Conexion establecidad con : "+ this.socket.getPort());
			String mensaje;
			Thread.sleep(5000);
			System.out.println("conexion finalizada");
			  
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
}
