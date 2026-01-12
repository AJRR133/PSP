package Unidad3.inicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSimple {

	public static void main(String[] args) {
		// 1 definir el puerto 
		int puerto= 6000;
		ServerSocket servidor = null;
	
		// 2 crear el server socket para escuchar peticiones
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor: servidor escuchando en el puerto "+puerto);
		// acepto comunicarme y devuelvo el socket del cliente
			Socket cliente = servidor.accept();
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
			String mensaje = entrada.readLine();
			System.out.println("Servidor: cliente dice " + mensaje);
;		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
