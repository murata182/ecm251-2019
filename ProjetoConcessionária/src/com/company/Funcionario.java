package com.company;

public class Funcionario {
    private String nome;
    private double porcentagemComissao;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.porcentagemComissao = 0.05;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getPorcentagemComissao(){
        return this.porcentagemComissao;
    }

    public double getSalarioMes(double totalVendasMes){
        return this.porcentagemComissao*totalVendasMes + this.salarioBase;
    }
}
