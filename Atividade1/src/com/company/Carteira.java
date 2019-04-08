//Rafael Murata 17.00103-0
//Osvaldo William Schimidt Junior 17.04091-4

package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Carteira {
    private long idCarteira;
    private String nomeCarteira;
    private String senhaAcesso;
    private Cartao cartaoDebito;
    private Cartao cartaoCredito;
    private Usuario usuario;

    public Carteira(long idCarteira, String nomeCarteira, String senhaAcesso){
        this.idCarteira = idCarteira;
        this.setNomeCarteira(nomeCarteira);
        this.setSenhaAcesso(senhaAcesso);
    }

    public String getDados(){
        return "Id da carteira: " + this.idCarteira  + "\n" + "Nome da carteira: " + this.nomeCarteira  + "\n" ;
    }

    public void setNomeCarteira(String nomeCarteira) {
        this.nomeCarteira = nomeCarteira;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }


    public void addCartao(Cartao cartao){
        if (getTipoCartao(cartao) == "Debito")
            this.cartaoDebito = cartao;
        else
            this.cartaoCredito = cartao;
    }


    public String getTipoCartao(Cartao cartao){
        return cartao.getTipo();
    }

    public boolean pagamento(Cartao cartao, String tipo, String senha){

        if ( cartao.getTipo() != tipo) {
            System.out.println("Tipo do cartão inválido (Jumento)\n");
            return false;
        }else {
            if (cartao.getSenha() == senha) {
                System.out.println("Pagamento Confirmado!\n");
                return true;
            }else {
                System.out.println("Senha incorreta (Burro)\n");
                return false;
            }
        }
    }
}
