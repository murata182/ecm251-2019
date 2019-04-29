package ex1;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {

    private List<Produto> produtos;

    public ListaDeCompras(){
        produtos = new ArrayList<Produto>();
    }

    public boolean addProduto(Produto p){
        if(p == null) return false;
        produtos.add(p);
        return true;
    }

    public boolean removerProduto(String nome){
        return produtos.remove(new Produto(nome));
    }


}
