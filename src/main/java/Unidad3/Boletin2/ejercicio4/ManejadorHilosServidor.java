package Unidad3.Boletin2.ejercicio4;

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
        String infoCliente = "IP=" + socket.getInetAddress().getHostAddress() + ", Puerto=" + socket.getPort();
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
        	{
        		
                salida.println("Eres el cliente " );
            }

        } catch (IOException e) {
        } finally {
            System.out.println("cliente desconenctado: " + infoCliente + " " + new Date() );
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}