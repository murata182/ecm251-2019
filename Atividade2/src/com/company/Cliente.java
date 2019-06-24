package com.company;

public class Cliente {
    public String cpf;
    public String nome;
    public String endereço;
    public String cep;
    public String email;

    public Cliente(String cpf,String nome, String endereço, String cep, String email){
        this.cep = cep;
        this.cpf = cpf;
        this.nome = nome;
        this.endereço = endereço;
        this.email = email;
    }
}
