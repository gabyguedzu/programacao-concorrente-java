package br.com.guedes.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("-------- Iniciando servidor --------");
		ServerSocket servidor = new ServerSocket(12345);
		
		while(true) {
			Socket accept = servidor.accept();
			System.out.println("aceitando novo cliente na porta " + accept.getPort());
		}
	}
}
