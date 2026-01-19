package Unidad3.Boletin1.ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        try (Socket cliente = new Socket(host, puerto)) {

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            String mensaje = entrada.readLine();
            System.out.println("Mensaje del servidor: " + mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
