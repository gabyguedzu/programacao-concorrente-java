package br.com.guedes.servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

    private PrintStream saida;

    public ComandoC2(PrintStream saida) {
        this.saida = saida;
    }

    @Override
    public void run() {
        System.out.println("Exceutando comando C1");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        saida.println("Comando C1 executado com sucesso!");
    }
}
