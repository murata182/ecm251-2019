package com.company;

import java.util.Scanner;

public class EntradaDados {
    public static void main(String[] args) {

        int numero;
//        numero = 32;
//        System.out.println("Idade: " + numero);
//        double rendimento = 4.58;
//        System.out.printf("O valor da idade é: %d\nO valor do rendimento é: %.3f\n", numero, rendimento);

        System.out.println("Informe sua idade:");
        //Cria uma variável que lê o teclado
        Scanner scanner = new Scanner(System.in);
        numero = scanner.nextInt();
        System.out.println("valor digitado: " + numero);
    }
}
