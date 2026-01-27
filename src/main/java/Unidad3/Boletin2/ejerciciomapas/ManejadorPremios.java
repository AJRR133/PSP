package Unidad3.Boletin2.ejerciciomapas;

import java.io.*;
import java.net.Socket;

public class ManejadorPremios extends Thread {
    private Socket socket;

    public ManejadorPremios(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            salida.println("Introduce ID de premio para probar suerte:");
            String idBuscado = entrada.readLine();

            // RECUPERAR Y ELIMINAR (Lógica de examen)
            // .remove(key) devuelve el valor y lo quita del mapa al mismo tiempo
            String premioEncontrado = ServidorPremios.almacenPremios.remove(idBuscado);

            if (premioEncontrado != null) {
                salida.println("¡GANASTE!: " + premioEncontrado);
            } else {
                salida.println("SIN PREMIO o ID no válido.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}