package br.com.guedes.teste;

import java.util.LinkedList;
import java.util.Queue;

public class TesteFila {

    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.offer("C1");
        fila.offer("C2");
        fila.offer("C3");

        System.out.println("pegar elemntos C1 " + fila.poll());
        System.out.println("pegar elemntos C2 " + fila.poll());
        System.out.println("pegar elemntos C3 " + fila.poll());

        System.out.println(fila.size());
    }
}
