package br.com.guedes.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWS implements Callable<String> {

    private PrintStream saida;

    public ComandoC2ChamaWS(PrintStream saida) {
        this.saida = saida;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Servidor recebeu comando C2 - AWS");

        saida.println("processsando comando C2 - AWS");

        Thread.sleep(20000);

        int numeroRandomico = new Random().nextInt(100) + 1;

        saida.println("Servidor finalizou a excecução C2 - AWS");

        return Integer.toString(numeroRandomico);
    }
}
