package com.company;

public class Pedido {
    public static int numero = 0;
    public Cliente cliente;
    public Carrinho carrinho;

    public Pedido (Cliente cliente, Carrinho carrinho){
        this.carrinho = carrinho;
        this.cliente = cliente;
        Pedido.numero ++;
    }

    public String resumoPedido(){
        //String com resumo do pedido
        return "Senhorx " + cliente.nome + ", seu pedido foi gerado com sucesso."+
                "\n" +"Numero do pedido: " + Pedido.numero +
                "\n" + "Nome: " + cliente.nome +
                "\n" + "CPF: " + cliente.cpf+
                "\n" + "Endereço: " + cliente.endereço + "-" + cliente.cep +
                "\n" + "Resumo da compra. \n" + "Voce comprou " + carrinho.getTamanho() + " itens." +
                "\n" + carrinho.retornarResumo() +
                "\n" + "Um boleto foi enviado para o email " + cliente.email +". Obrigado pela preferencia";


    }

}
