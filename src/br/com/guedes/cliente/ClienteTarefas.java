package br.com.guedes.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTarefas {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 12345);
		
		System.out.println("conexao estabelecida");
		
		Scanner entrada = new Scanner(System.in);
		
		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println("c1");
		
		entrada.nextLine();
		
		saida.close();
		entrada.close();
		socket.close();
	}
}
