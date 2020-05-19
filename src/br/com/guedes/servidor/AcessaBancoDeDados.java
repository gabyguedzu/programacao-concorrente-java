package br.com.guedes.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class AcessaBancoDeDados implements Callable<String> {

    private PrintStream saida;

    public AcessaBancoDeDados(PrintStream saida) {
        this.saida = saida;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Servidor recebeu comando C2 - Banco de dados");

        saida.println("processsando comando c2 - Banco de dados");

        Thread.sleep(20000);

        int numeroRandomico = new Random().nextInt(100) + 1;

        saida.println("Servidor finalizou a excecução C2 - Banco de dados");

        return Integer.toString(numeroRandomico);
    }
}
