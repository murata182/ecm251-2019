//Rafael Murata 17.00103-0
//Osvaldo William Schimidt Junior 17.04091-4

package com.company;

public class Carteira {
    private long idCarteira;
    private String nomeCarteira;
    private String senhaAcesso;
    private Cartao cartaoDebito;
    private Cartao cartaoCredito;

    public Carteira(long idCarteira, String nomeCarteira, String senhaAcesso){
        this.idCarteira = idCarteira;
        this.setNomeCarteira(nomeCarteira);
        this.setSenhaAcesso(senhaAcesso);
    }

    //Exibe apenas dados não sigilosos
    public String getDados(){
        return "Id da carteira: " + this.idCarteira  + "\n" + "Nome da carteira: " + this.nomeCarteira  + "\n" ;
    }

    public void setNomeCarteira(String nomeCarteira) {
        this.nomeCarteira = nomeCarteira;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    //Remove um cartão da carteira
    public void removeCartao(Cartao cartao){
        if (getTipoCartao(cartao) == "Debito")
            this.cartaoDebito = null;
        else
            this.cartaoCredito = null;
    }

    //Adiciona um cartão à carteira
    public void addCartao(Cartao cartao){
        if (getTipoCartao(cartao) == "Debito")
            this.cartaoDebito = cartao;
        else
            this.cartaoCredito = cartao;
    }


    public String getTipoCartao(Cartao cartao){
        return cartao.getTipo();
    }

    //Realiza pagamento
    //Pagamento implementado na Carteira, pois possui acesso aos cartões e possui um único usuário que realiza esse pagamento
    public boolean pagamento(Cartao cartao, String tipo, String senha){
        //Confere o tipo de cartão (crédito ou débito)
        if ( cartao.getTipo() != tipo) {
            System.out.println("Tipo do cartão inválido (Jumento)\n");
            return false;
        }else {
            //Confere se a senha está correta
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
