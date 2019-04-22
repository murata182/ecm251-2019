package com.company;

public class RH {
    private double totalComissao;

    public double getTotalComissao(){
        return this.totalComissao;
    }

    public void adicionaComissao(Funcionario f){
        this.totalComissao += f.comissao();
    }
}
