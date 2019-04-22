package com.company;

public class Funcionario {
    protected String nome;
    protected double porcentagemComissao;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase, double porcentagemComissao){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.porcentagemComissao = porcentagemComissao;
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
}
