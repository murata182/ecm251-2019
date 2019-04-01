package com.company;

public class FuncionarioTestDrive {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Douglas", 1000.0);
        System.out.println("Salario Mes: " + f1.getSalarioMes(10000));
    }
}
