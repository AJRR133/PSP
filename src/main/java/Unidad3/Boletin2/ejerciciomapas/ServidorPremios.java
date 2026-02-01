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

/**
 * * 1. RECURSO COMPARTIDO:
 * - Usar 'ConcurrentHashMap' para evitar 'ConcurrentModificationException'.
 * - Es Thread-Safe: permite que varios hilos borren/metan datos a la vez.
 * * 2. MÉTODOS CLAVE DEL MAPA:
 * - V remove(key): Elimina la clave y devuelve el valor. 
 * ¡IMPORTANTE! Si devuelve null, el elemento no existía o ya fue borrado por otro hilo.
 * - boolean containsKey(key): Solo chequea si existe (sin borrar).
 * - V put(key, value): Inserta o actualiza.
 * - boolean isEmpty(): Útil para saber si ya se acabaron los premios/datos.
 * * 3. ARQUITECTURA:
 * - Servidor: Bucle infinito con servidor.accept().
 * - Manejador (Thread): Recibe el Socket y el Mapa (static o por constructor).
 * - Cliente: Usa BufferedReader (entrada) y PrintWriter (salida, con true para autoflush).
 * * 4. DETALLES DE RED (Para logs):
 * - socket.getInetAddress().getHostAddress() -> Obtiene la IP del cliente.
 * - socket.getPort() -> Obtiene el puerto remoto.
 * * 5. REQUISITO EXAMEN (Ejercicio 4/5): 
 * - Si un hilo modifica el mapa, el cambio es visible para todos los hilos 
 * inmediatamente[cite: 43, 46].
 Métodos Vitales:
 * - map.remove(key): Recupera y borra (ideal para premios únicos)[cite: 47, 62].
 * - map.put(key, val): Inserta o actualiza datos compartidos[cite: 41].
 * - map.get(key): Consulta sin borrar.
 * - map.isEmpty(): Para saber si el juego/inventario terminó[cite: 60].
 *
 */