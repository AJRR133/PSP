package Unidad3.Boletin2.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Hiloclientes extends Thread {

	public void run() {
		String host = "localhost";
        int puerto = 44444;

        try (Socket socket = new Socket(host, puerto);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado. Escribe mensajes :");
            String texto;
            
            while ((texto = teclado.readLine()) != null) {

                salida.println(texto); 
                String eco = entrada.readLine(); 
                
                System.out.println( new Date() +" "+  eco);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
