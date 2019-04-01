package com.company;

public class Gerente {
    private String nome;
    private double porcentagemComissao;
    private double salarioBase;

    public Gerente(String nome, double salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.porcentagemComissao = 0.1;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getComissao(double totalVendasMes){
        return this.porcentagemComissao * totalVendasMes + 0.5 * this.salarioBase;
    }

    public double getSalarioMes(double totalVendasMes){
        return getComissao(totalVendasMes) + this.salarioBase;
    }

    public boolean aumentarSalarioBaseVendedor(Vendedor vendedor){
        if (vendedor.getGerente().equals(this)) {
            return true;
        }else {
            return false;
        }
    }
}
