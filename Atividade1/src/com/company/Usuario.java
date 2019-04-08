//Rafael Murata 17.00103-0
//Osvaldo William Schimidt Junior 17.04091-4

package com.company;

public class Usuario {
    private String nome;
    private String email;
    private String cpf;
    private String nascimento;
    private Carteira carteira;

    //Construtor sem carteira pois ela pode ser criada posteriormente
    public Usuario(String nome, String email, String cpf, String nascimento){
        this.setNome(nome);
        this.setEmail(email);
        this.cpf =cpf;
        this.nascimento =nascimento;

    }
     public String getDados(){
        return "Nome: " + this.nome  + "\n" + "Email: " + this.email  + "\n" + "CPF: " +this.cpf  + "\n" + "Data de nascimento: " +this.nascimento+"\n";
    }


    //Unicos parametros que podem ser alterados
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCarteira(Carteira carteira){
        this.carteira = carteira;
    }

}
