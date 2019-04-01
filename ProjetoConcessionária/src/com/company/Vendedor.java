package com.company;

public class Vendedor {
    private String nome;
    private double porcentagemComissao;
    private double salarioBase;
    private Gerente gerente;

    public Vendedor(String nome, double salarioBase, Gerente gerente){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.porcentagemComissao = 0.05;
        this.gerente = gerente;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getComissao(double totalVendasMes){
        return this.porcentagemComissao * totalVendasMes;
    }

    public double getSalarioMes(double totalVendasMes){
        return this.porcentagemComissao*totalVendasMes + this.salarioBase;
    }

    public Gerente getGerente(){
        return gerente;
    }
}
