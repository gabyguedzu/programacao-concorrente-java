package br.com.guedes.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

	private ServerSocket servidor;
	private ExecutorService threadPool;
	private boolean isRodandoServidor;

	public ServidorTarefas() throws IOException {
		System.out.println("-------- Iniciando servidor --------");
		this.servidor = new ServerSocket(12345);
		this.threadPool = Executors.newFixedThreadPool(4);    //newCachedThreadPool();
		this.isRodandoServidor = true;
	}

	public static void main(String[] args) throws Exception {
		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
		servidor.desligar();
	}

	public void desligar() throws IOException {
		isRodandoServidor = false;
		servidor.close();
		threadPool.shutdown();
		//System.exit(0);
	}

	public void rodar() throws IOException {
		while (this.isRodandoServidor) {
			try {
				Socket socket = servidor.accept();
				System.out.println("aceitando novo cliente na porta " + socket.getPort());
				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool, socket, this);
				threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("SocketException, Est� rodando? " + this.isRodandoServidor);
			}
		}
	}
}
