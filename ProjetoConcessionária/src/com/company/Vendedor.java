package com.company;

public class Vendedor extends Funcionario{
    private Gerente gerente;

    public Vendedor(String nome, double salarioBase, double porcentagemComissao, Gerente gerente){
        super(nome, salarioBase, porcentagemComissao);
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
