package com.company;

import java.util.LinkedList;
import java.util.List;

public class Carrinho extends Lista {
    private int tamanho = 12;
    private List<Produto> produtos;

    public Carrinho(){
        produtos =new LinkedList<Produto>();
    }
    public void limparLista(){
        produtos.clear();
    }

    @Override
    public boolean adicionarALista(Produto produto) {
        //Confere se está no maximo
        if (produtos.size() >= this.tamanho){
            return false;
        }
        else {
            produtos.add(produto);
            return true;
        }
    }
    @Override
    public boolean removerUltimoDaLista() {
        //Se o array não tem nada dentro, não há o que remover
        if (produtos.size() == 0 ){
            return false;
        }
        else{
            //Remove o indice
            produtos.remove(produtos.size()-1);
            return true;
        }
    }
    @Override
    public String retornarResumo(){
        double frete = 0.0;
        double preco = 0.0;
        String descricao = new String();

        for (Produto produto : produtos) {
            descricao += produto.exibirInfos();

            //Calculo da somatoria de frete e preco
            frete += produto.getFrete();
            preco += produto.getPreco();
        }
        //Total
        double total = preco+frete;
        return descricao + "Total(produtos + frete): "+ total;

    }
    @Override
    public int getRestantes() {
        //Subtrai tamanho do numero de produtos
        return this.tamanho- produtos.size();
    }
    public int getTamanho(){
        return produtos.size();
    }
}
