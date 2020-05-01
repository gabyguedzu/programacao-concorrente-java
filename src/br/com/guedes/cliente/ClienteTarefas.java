package br.com.guedes.cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTarefas {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 12345);
		
		System.out.println("conexao estabelecida");
		
		Scanner entrada = new Scanner(System.in);
		
		entrada.nextLine();
		
		entrada.close();
		socket.close();
	}
}
