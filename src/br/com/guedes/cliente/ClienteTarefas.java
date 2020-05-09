package br.com.guedes.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket("localhost", 12345);

		System.out.println("conexão estabelecida");

		Thread threadEnviaComando = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					PrintStream saida = new PrintStream(socket.getOutputStream());
					Scanner entrada = new Scanner(System.in);
					while (entrada.hasNextLine()) {
						String nextLine = entrada.nextLine();

						if (nextLine.trim().equals("")) {
							break;
						}
						saida.println(nextLine);
					}
					saida.close();
					entrada.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		Thread threadRecebeRespostaDoServidor = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Scanner entradaServidor = new Scanner(socket.getInputStream());
					while (entradaServidor.hasNextLine()) {
						String nextLineServer = entradaServidor.nextLine();
						System.out.println(nextLineServer);
					}
					entradaServidor.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		threadEnviaComando.start();
		threadRecebeRespostaDoServidor.start();
		
		threadEnviaComando.join();
		
		System.out.println("Fechando socket do cliente");
		
		socket.close();
	}
}