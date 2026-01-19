package Unidad3.Boletin1.ejercicio4;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        int puerto = 6000;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);
            String numclientes = args[0];
            int num = Integer.parseInt(numclientes);
           
            for (int i = 1; i <= num; i++) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");

                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

                
                salida.println("cliente " + i);

                cliente.close();
                System.out.println("Cliente " + i + "  desconectado");
            }

            System.out.println("Servidor cerrado.clientes maximos .");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
