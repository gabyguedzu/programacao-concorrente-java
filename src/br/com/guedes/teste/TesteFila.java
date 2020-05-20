package br.com.guedes.teste;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TesteFila {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> fila = new ArrayBlockingQueue(3);

        fila.put("C1");
        fila.put("C2");
        fila.put("C3");

        System.out.println("pegar elemntos C1 " + fila.take());
        System.out.println("pegar elemntos C2 " + fila.take());
        System.out.println("pegar elemntos C3 " + fila.take());

        System.out.println(fila.size());
    }
}
