package Unidad3.Boletin2.ejerciciomapas;
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientePremios {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 44444);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            // Leer invitación del servidor
            System.out.println("SERVIDOR: " + entrada.readLine());
            
            // Escribir ID del premio
            System.out.print("Introduce ID: ");
            String id = teclado.readLine();
            salida.println(id);

            // Recibir resultado con ID de hilo y hora para el examen
            System.out.println("[" + new Date() + "] [Hilo ID: " + Thread.currentThread().getId() + "] " + entrada.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}