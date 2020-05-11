package br.com.guedes.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefas para " + socket);
			Scanner scanner = new Scanner(socket.getInputStream());

			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

			while (scanner.hasNextLine()) {
				String comando = scanner.nextLine();

				switch (comando) {
				case "c1":
					saidaCliente.println("c1 recebido");
					break;
				case "c2":
					saidaCliente.println("c2 recebido");
					break;
				default:
					saidaCliente.println("comando não encontrado");
				}
				System.out.println(comando);
			}

			saidaCliente.close();
			scanner.close();
			Thread.sleep(20000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}