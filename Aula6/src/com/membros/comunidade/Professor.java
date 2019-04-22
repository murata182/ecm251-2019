package com.membros.comunidade;

public class Professor extends CorpoDocente {
    private String disciplina;

    public Professor(String nome, String cpf, String disciplina){
        super(nome, cpf);
        this.disciplina = disciplina;
    }

    public String getDados(){
        return super.getDados() + "\n" + this.disciplina;
    }
}
