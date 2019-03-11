package com.company;

import javax.management.NotCompliantMBeanException;
import java.util.Scanner;

public class MeuCadastro {
    public static void main(String[] args) {

        String nome;
        String funcao;
        int idade;
        double salario;
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while(continuar) {

            System.out.println("Informe o seu nome: ");
            nome = scanner.nextLine();
            System.out.println("Informe a sua função: ");
            funcao = scanner.nextLine();
            System.out.println("Informe a sua idade: ");
            idade = scanner.nextInt();
            System.out.println("Informe o seu salário: ");
            salario = scanner.nextDouble();

            System.out.printf(
                    "Nome: %s\nFunção: %s\nIdade: %d\nSalário: R$%.2f\n",
                    nome, // Nome do usuário
                    funcao, // Função do usuário
                    idade, // Idade
                    salario // Salário
            );
            String resposta;
            System.out.println("Deseja continuar?");
            resposta = scanner.next();
            if(resposta.equalsIgnoreCase("SIM"))
                continuar = true;
            else
                continuar = false;
        }
    }
}
