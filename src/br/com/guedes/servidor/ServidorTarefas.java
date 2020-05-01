package br.com.guedes.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("-------- Iniciando servidor --------");
		ServerSocket servidor = new ServerSocket(12345);
		
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("aceitando novo cliente na porta " + socket.getPort());
			
			DistribuirTaredas distribuirTarefas = new DistribuirTaredas(socket);
			Thread threadCliente = new Thread(distribuirTarefas);
			threadCliente.start();
			
		}
	}
}
