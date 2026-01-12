package Unidad3.inicio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSimple {

	public static void main(String[] args) {
		String Host = "localhost"; //host servidor con el que el cliente quiere conectarse
		int puerto = 6000;//puerto remoto en el servidor que el cliente conoce         
		Socket cliente;
		try {
			cliente = new Socket(Host, puerto);
			
			// informativos
			InetAddress i= cliente.getInetAddress ();
			System.out.println("cliente : Puerto local: "+ cliente.getLocalPort());
			System.out.println("cliente : Puerto Remoto: "+ cliente.getPort());  
			System.out.println("cliente : Host Remoto: "+ i.getHostName().toString());  
			System.out.println("cliente : IP Host Remoto: "+ i.getHostAddress().toString());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//conecta

		
	}

}
