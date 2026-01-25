package Unidad3.Boletin2.ejercicio1;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ManejadorHilosServidor extends Thread {
    private Socket socket;

    public ManejadorHilosServidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                salida.println("ECO:" + mensaje);
            }

        } catch (IOException e) {
        	
        } finally {
            System.out.println("DESCONEXIÓN: " + new Date() + " Puerto: " + socket.getPort());
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}