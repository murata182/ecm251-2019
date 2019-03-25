package com.company;

public class Cliente {
    private String nome;
    private String ra;
    private boolean funcionario;
    private boolean visitante;

    public Cliente(String nome){
        this.nome = nome;
        this.visitante = true;

    }

    public Cliente(String nome, boolean funcionario){
        this.nome = nome;
        if(funcionario)
            this.funcionario = funcionario;
        else
            visitante = true;
    }

    public Cliente(String nome, String ra){
        this.nome = nome;
        this.ra = ra;
    }

    public void comprar(){

    }

    public void acompanhar(){

    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public boolean isFuncionario() {
        return funcionario;
    }

    public boolean isVisitante() {
        return visitante;
    }

}
