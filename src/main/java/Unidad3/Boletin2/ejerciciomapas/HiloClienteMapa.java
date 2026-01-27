package Unidad3.Boletin2.ejerciciomapas;


import java.io.*;
import java.net.Socket;
import java.util.Date;

public class HiloClienteMapa extends Thread {
    private String idPremio;

    public HiloClienteMapa(String idPremio) {
        this.idPremio = idPremio;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 44444);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            entrada.readLine(); 
            salida.println(idPremio);
            
            String respuesta = entrada.readLine();
            System.out.println("[" + new Date() + "] [Hilo ID: " + this.getId() + "] Intento con " + idPremio + " -> " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}