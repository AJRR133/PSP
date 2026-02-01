package Unidad3.Boletin2.ejerciciomapas;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientePremios {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 44444;
        Socket socket = null;

        try {
            // 1. Conexión
            socket = new Socket(host, puerto);
            
            // 2. Configuración de flujos
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            // 3. Lectura de invitación (Servidor envía ID o bienvenida)
            System.out.println("SERVIDOR: " + entrada.readLine());
            
            // 4. Envío de datos (Teclado) 
            System.out.print("Introduce ID de premio: ");
            String id = teclado.readLine();
            salida.println(id);

            // 5. Recepción y muestra de datos con ID de hilo y fecha 
            String respuesta = entrada.readLine();
            System.out.println("[" + new Date() + "] [Hilo ID: " + Thread.currentThread().getId() + "] " + respuesta);

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        } finally {
            // 6. Cierre manual de recursos
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/*package Unidad3.Boletin2.ejerciciomapas;
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
}*/