package Unidad3.Boletin2.ejercicio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 44444;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor ECO escuchando en el puerto " + puerto);
            
            while (true) {
                Socket socketCliente = servidor.accept();
                System.out.println("CONEXIÓN: " + new Date() + " Puerto:"+ socketCliente.getPort());
                
                new ManejadorHilosServidor(socketCliente).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}