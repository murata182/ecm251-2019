//17.00103-0 Rafael Murata
//17.04091-4 Osvaldo William Schimidt Junior
package utilities;

public class Constants {
    public static final String URL_MEU_BANCO = "jdbc:sqlite:meu_banco.db";


    public static final String getInsertUsuario(){
        return "INSERT INTO usuarios (usuario, SENHA) VALUES (?,?)";
    }

    public static final String getInsertProduto(){
        return "INSERT INTO produtos (quantidade, nome, preco, fabricante, categoria) VALUES (?, ?, ?, ?, ?)";

    }
    public static final String selectAllProdutos(){
        return "SELECT * FROM produtos";
    }
    public static final String selectProdutoCat(String categ){
        return "SELECT * FROM produtos WHERE categoria = \""+categ+"\";";

    }
    public static final String getInsertVenda(){
        return "INSERT INTO vendas(usuario,quantidade,produto) VALUES (?, ?, ?)";
    }
    public static final String getProdutoNome(String nome){
        return "SELECT * FROM produtos WHERE nome = \""+nome+"\";";
    }
    public static final String updateProduto(String nome,int qtd){
        return "UPDATE produtos SET quantidade = "+qtd+" WHERE nome= \"" +nome+"\";";
    }
    public static final String getUsuarioNome(String nome){
        return "SELECT * FROM usuarios WHERE usuario = \""+nome+"\";";
    }


}
