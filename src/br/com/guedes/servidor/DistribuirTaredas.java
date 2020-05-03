package br.com.guedes.servidor;

import java.net.Socket;
import java.util.Scanner;

public class DistribuirTaredas implements Runnable {

	private Socket socket;

	public DistribuirTaredas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefas para " + socket);
			Scanner scanner = new Scanner(socket.getInputStream());
			
			while(scanner.hasNextLine()) {
				String comando = scanner.nextLine();
				System.out.println(comando);
			}
			
			scanner.close();
			Thread.sleep(20000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
