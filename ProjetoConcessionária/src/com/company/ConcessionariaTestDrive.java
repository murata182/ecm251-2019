package com.company;

public class ConcessionariaTestDrive {
    public static void main(String[] args) {
        Gerente g1 = new Gerente("Carlos II", 6500.0);
        Vendedor v1 = new Vendedor("Joao", 1000.0, g1);
        double totalVendasMes = 10000.0;

        System.out.println("Vendedor: ");
        System.out.println("Comissão: " + v1.getComissao(totalVendasMes));
        System.out.println("Gerente: ");
        System.out.println("Comissão: " + g1.getComissao(totalVendasMes));
        if(g1.aumentarSalarioBaseVendedor(v1)){
            System.out.println("Pode dar aumento!");
        }else{
            System.out.println("Not today!");
        }
    }
}
