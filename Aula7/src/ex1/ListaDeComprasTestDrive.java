package ex1;

import java.util.Scanner;

public class ListaDeComprasTestDrive {
    public static void main(String[] args) {
        ListaDeCompras listaDeCompras = new ListaDeCompras();
//        Scanner scanner = new Scanner(System.in);
//        for(int i = 0; i < 10; i++){
//            String nome = scanner.next();
//            if(listaDeCompras.addProduto(new Produto(nome))){
//                System.out.println("Produto adicionado.");
//            }else{
//                System.out.println("Erro!");
//            }
//        }
        listaDeCompras.addProduto(new Produto("A"));
        listaDeCompras.addProduto(new Produto("B"));
        if(listaDeCompras.removerProduto("A"))
            System.out.println("Removido com sucesso!");
        if(listaDeCompras.removerProduto("c"))
            System.out.println("Removido com sucesso!");
        else
            System.out.println("Nao foi possivel remover!");
    }
}
