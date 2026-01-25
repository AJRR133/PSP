package Unidad3.Boletin2.ejercicio2;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 44444);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            String mensaje;
            while ((mensaje = teclado.readLine()) != null) {
                salida.println(mensaje);
                System.out.println("[" + new Date() + "] [Hilo ID: " + Thread.currentThread().getId() + "] " + entrada.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}