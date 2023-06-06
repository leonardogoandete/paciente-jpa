package br.com.ifrs.paciente;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        System.out.println("Hello world!");
        String a = String.valueOf(gerador.nextLong());

        System.out.println(a);
    }
}