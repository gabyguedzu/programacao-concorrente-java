package br.com.guedes.teste;

public class TratadorDeExcecao implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("Deu erro na exceção " + thread.getName() + ", " + throwable.getMessage());
    }
}
