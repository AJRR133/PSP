package Unidad3.Boletin2.ejercicio0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorHilosCliente extends Thread {

	Socket socket = new Socket();

	public ManejadorHilosCliente(Socket socket) {
		super();
		this.socket = socket;
	} 
	
	public void run() {
		BufferedReader entrada;
		try {
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			salida.println("Conexion establecidad con : ");
			String mensaje;
			while ((mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("fin")) {
					System.out.println("Cliente dice: " + mensaje);
					salida.println("Servidor responde: " + mensaje.toUpperCase());
			}
			if (mensaje != null && mensaje.equalsIgnoreCase("fin")) {
				salida.println("Cerrando sesión. ¡Hasta pronto!"); 			
		}

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
}
