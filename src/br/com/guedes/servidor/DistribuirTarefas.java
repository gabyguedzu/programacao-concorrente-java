package br.com.guedes.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool;

	public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
		this.threadPool = threadPool;
		this.socket = socket;
		this.servidor = servidor;
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
					ComandoC1 c1 = new ComandoC1(saidaCliente);
					threadPool.execute(c1);
					break;
				case "c2":
					saidaCliente.println("c2 recebido");
					ComandoC2 c2 = new ComandoC2(saidaCliente);
					threadPool.execute(c2);
					break;
				case "fim":
					saidaCliente.println("shutdown");
					servidor.desligar();
					break;
				default:
					saidaCliente.println("comando n�o encontrado");
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