package com.company;

import java.util.LinkedList;
import java.util.List;

public class ListaDeDesejos extends Lista {
    private int tamanho = 5;
    private List<Produto> produtos;

    public ListaDeDesejos(){
        produtos =new LinkedList<Produto>();
    }

    @Override
    public String retornarResumo(){
        String descricao = new String();

        for (Produto produto : produtos) {
            descricao += produto.exibirInfos();

        }
        return descricao;

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
    public int getRestantes() {
        //Subtrai tamanho do numero de produtos
        return this.tamanho- produtos.size();
    }
}
