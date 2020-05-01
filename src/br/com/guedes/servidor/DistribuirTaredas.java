package br.com.guedes.servidor;

import java.net.Socket;

public class DistribuirTaredas implements Runnable {

	private Socket socket;

	public DistribuirTaredas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		System.out.println("Distribuindo tarefas para " + socket);
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
