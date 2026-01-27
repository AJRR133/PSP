package Unidad3.Boletin2.ejerciciomapas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServidorPremios {
    // El Mapa compartido: Clave = ID, Valor = Nombre del premio
    // Es static para que todos los hilos vean el mismo mapa
    public static Map<String, String> almacenPremios = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // Inicializamos algunos datos en el mapa (como pide tu ejercicio 4)
        almacenPremios.put("A1", "Crucero");
        almacenPremios.put("B2", "Entradas Cine");
        almacenPremios.put("C3", "Masaje");
        almacenPremios.put("D4", "1000€");

        try (ServerSocket servidor = new ServerSocket(44444)) {
            System.out.println("Servidor de Premios iniciado...");
            while (true) {
                Socket cliente = servidor.accept();
                // Pasamos el mapa al manejador
                new ManejadorPremios(cliente).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}