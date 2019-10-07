//17.00103-0 Rafael Murata
//17.04091-4 Osvaldo William Schimidt Junior
package model;

public class Produto {
    public String nome;
    public double preco;
    public int quantidade;
    public String fabricante;
    public String categoria;


    public Produto(String nome, double preco, int quantidade, String fabricante, String categoria){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
        this.categoria = categoria;
    }

}
