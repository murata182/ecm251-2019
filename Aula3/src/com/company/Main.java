package com.company;

public class Main {

    public static void main(String[] args) {
        Sayajin s1;
        s1 = new Sayajin();
        s1.nome = "Vegeta";
        s1.ki = 1000.0;
        s1.odio = true;

        Sayajin s2 = new Sayajin();
        s2.nome = "Broly";
        s2.ki = 1000000.0;

        System.out.println(s1.nome);
        s1.treinar();
        System.out.println(s2.nome);
        s2.treinar();
    }
}
