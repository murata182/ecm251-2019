package com.membros.comunidade;

public class MembroDaComunidade {
    protected String nome;
    protected String cpf;

    public MembroDaComunidade(){

    }
    public MembroDaComunidade(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getDados(){
        return "Nome: " + this.nome + "\n" + "CPF: " + this.cpf;
    }
}
