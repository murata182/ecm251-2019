//Rafael Murata 17.00103-0
//Osvaldo William Schimidt Junior 17.04091-4

package com.company;

public class Cartao {
    private double taxaConversaoDolar;
    private long idCartao;
    private String label;
    private String emissorCartao;
    private String tipo;
    private String dataEmissao;
    private String validade;
    private String ccv;
    private String senha;
    private String numeroCartao;
    private String numeroConta;
    private Carteira carteira;

    public Cartao(double taxaConversaoDolar, long idCartao, String label, String emissorCartao, String tipo, String dataEmissao, String validade, String ccv, String senha, String numeroCartao, String numeroConta){
        this.taxaConversaoDolar=taxaConversaoDolar;
        this.idCartao=idCartao;
        this.label=label;
        this.emissorCartao=emissorCartao;
        this.tipo=tipo;
        this.dataEmissao=dataEmissao;
        this.validade=validade;
        this.ccv=ccv;
        this.setSenha(senha);
        this.numeroCartao=numeroCartao;
        this.numeroConta=numeroConta;
    }

    //Exibe apenas informações não sigilosas
    public String getDados(){
        return "Id do cartão: "+ this.idCartao  + "\n" + "Taxa de conversão: " + this.taxaConversaoDolar + "\n" + "Label: " +this.label  + "\n" + "Emissor do cartão: " + this.emissorCartao + "\n" + "Tipo: " + this.getTipo() + "\n" + "Data de emissão: " +this.dataEmissao  + "\n" + "Validade: " + this.validade + "\n" + "Número do cartão: " + this.numeroCartao  + "\n" + "Número da conta: " +this.numeroConta +"\n";
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }
    protected String getSenha(){
        return senha;
    }
}
