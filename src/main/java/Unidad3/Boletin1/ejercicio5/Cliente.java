package Unidad3.Boletin1.ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int puerto = 6000;// puerto remoto en el servidor que el cliente conoce
		Socket cliente;
		try {
			cliente = new Socket(Host, puerto);
			System.out.println("Cliente : conexion establecida");
			// 3 Configurar flujos para enviar y recibir mensajes
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			// scanner sc = new Scanner(System.in);
			// String mensajeParaservidor = sc.nextLine();
			// String mensajeParaservidor ="Hola soy un cliente";
			// 4 enviar mensaje al servidor
			String mensajeParaServidor = "hola";

			boolean acaba = false;

			while (!acaba) {
				Scanner sc = new Scanner(System.in);
				mensajeParaServidor = sc.nextLine();
				salida.println(mensajeParaServidor);
				if (mensajeParaServidor.equals("fin")) {
					//System.out.println("Programa terminado");
					acaba = true;

				}
			}
			//salida.println(mensajeParaservidor);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // conecta

	}
}
