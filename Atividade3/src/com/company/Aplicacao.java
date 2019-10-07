//17.00103-0 Rafael Murata
//17.04091-4 Osvaldo William Schimidt Junior


package com.company;

import auxiliar_database.ProdutoDAO;
import auxiliar_database.UsuarioDAO;
import auxiliar_database.VendaDAO;
import model.Produto;
import model.Usuario;
import model.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private List<Produto> produtos;

    Aplicacao(){
        produtos = new ArrayList<>();
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String nome, fabricante,senha,categoria,produtoNome;
        int quantidade;
        double preco;
        do{
            menu();
            int op = scanner.nextInt();

            switch (op){
                case 1:
                    //Verificação de credenciais admin
                    System.out.println("Informe suas credenciais");
                    System.out.println("Usuário:");
                    nome = scanner.next();
                    System.out.println("Senha:");
                    senha = scanner.next();

                    if (nome.equals("admin") && senha.equals("admin")){
                        System.out.println("Bem vindo admin");
                        //

                        //Dados do novo usuário e inserção
                        System.out.println("Informe");
                        System.out.println("Nome:");
                        nome = scanner.next();
                        System.out.println("Senha:");
                        senha = scanner.next();

                        Usuario user = new Usuario(
                                nome,senha
                        );
                        if(UsuarioDAO.getInstance().insertUsuario(user))
                            System.out.println("Usuário adicionado");
                        else System.out.println("Falha ao adicionar");
                        //
                    }
                    break;
                case 2:
                    //Inserção dos dados do novo produto e inserção
                    System.out.println("Nome:");
                    nome = scanner.next();
                    System.out.println("Preço:");
                    preco = scanner.nextDouble();
                    System.out.println("Quantidade:");
                    quantidade = scanner.nextInt();
                    System.out.println("Fabricante:");
                    fabricante = scanner.next();
                    System.out.println("Categoria:");
                    categoria = scanner.next();

                    Produto produto = new Produto(nome,preco,quantidade,fabricante,categoria);
                    if(ProdutoDAO.getInstance().insertProduto(produto))
                        System.out.println("Produto adicionado");
                    //

                    else System.out.println("Falha ao adicionar");
                    break;
                case 3:
                    //Opção de exibir todos os produtos ou por categoria
                    System.out.println("Todos os produtos(0) ou por categoria(1):");
                    int o = scanner.nextInt();
                    switch (o){
                        case 0:
                            produtos = ProdutoDAO.getInstance().getAllProdutos();
                            for (Produto p: produtos){
                                System.out.println("Nome: " + p.nome+ "\tPreço: " +p.preco+ "\tQuantidade: " + p.quantidade+
                                        "\tFabricante: "+ p.fabricante + "\tCategoria: " + p.categoria);
                            }
                            break;
                        case 1:
                            System.out.println("Qual categoria você quer? (Ferramenta ou Tinta)");
                            categoria = scanner.next();
                            produtos = ProdutoDAO.getInstance().getProdutoCategoria(categoria);
                            for (Produto p: produtos){
                                System.out.println("Nome: " + p.nome+ "\tPreço: " +p.preco+ "\tQuantidade: " + p.quantidade+
                                        "\tFabricante: "+ p.fabricante + "\tCategoria: " + p.categoria);
                            }
                            break;
                    }
                    //

                    break;
                case 4:
                    //Nova venda
                    System.out.println("Usuario: ");
                    nome = scanner.next();
                    //

                    //Verificar se usuário existe e gerar venda
                    if (UsuarioDAO.getInstance().getUsuario(nome)) {

                        System.out.println("Quantidade: ");
                        quantidade = scanner.nextInt();
                        System.out.println("Produto: ");
                        produtoNome = scanner.next();

                        Venda venda = new Venda(nome, quantidade, produtoNome);
                        if (VendaDAO.getInstance().insertVenda(venda))
                            System.out.println("Venda concluída");
                    }
                    else System.out.println("Usuário não existente");
                    //

                    break;
                default:return;

            }
        }while (true);
    }


    private void menu(){
        System.out.println("1 - Inserir usuário");
        System.out.println("2 - Inserir produto");
        System.out.println("3 - Pesquisar produtos");
        System.out.println("4 - Vender");
    }

}
