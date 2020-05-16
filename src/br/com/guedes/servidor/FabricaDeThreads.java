package br.com.guedes.servidor;

import br.com.guedes.teste.TratadorDeExcecao;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

    private static int numero = 1;

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "Servidor Tarefas " + numero);

        numero++;

        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());

        return thread;
    }
}
