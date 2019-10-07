//17.00103-0 Rafael Murata
//17.04091-4 Osvaldo William Schimidt Junior
package auxiliar_database;

import model.Produto;
import model.Usuario;
import model.Venda;
import utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    //Implementação de Singleton
    private Connection connection;
    private static UsuarioDAO instance = null;
    public static UsuarioDAO getInstance(){
        if(instance == null)
            instance = new UsuarioDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private UsuarioDAO(String myConnection){
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }
    //

    //Inserir usuário na tabela
    public boolean insertUsuario(Usuario user){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(Constants.getInsertUsuario());
            comandoSQL.setString(1, user.nome);
            comandoSQL.setString(2, user.senha);
            comandoSQL.executeUpdate();
            connection.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //

    //Inserir produto na tabela
    public boolean insertProduto(Produto prod){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(Constants.getInsertProduto());
            comandoSQL.setInt(1, prod.quantidade);
            comandoSQL.setString(2, prod.nome);
            comandoSQL.setDouble(3, prod.preco);
            comandoSQL.setString(4, prod.fabricante);
            comandoSQL.setString(5, prod.categoria);
            comandoSQL.executeUpdate();
            connection.commit();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //

    //Mostrar todos os produtos
    public List<Produto> getAllProdutos(){
        List<Produto> produtos = new ArrayList<>();

        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectAllProdutos());
            while(rs.next()){
                Produto produto = new Produto(rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria")
                );
                produtos.add(produto);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return produtos;
    }
    //

    //Mostrar produtos com filtro de categoria
    public List<Produto> getProdutoCategoria(String categoria){
        List<Produto> produtos = new ArrayList<>();
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectProdutoCat(categoria));
            while(rs.next()){
                Produto produto = new Produto(rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria")
                );
                produtos.add(produto);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return produtos;
    }
    //

    //Realizar uma venda
    public boolean insertVenda(Venda venda){

            Produto produto = getProdutoNome(venda.produto);

            if (venda.quantidade > produto.quantidade) {
                System.out.println("Quantidade insuficiente no estoque");
                return false;
            } else {
                PreparedStatement comandoSQL;
                try {
                    comandoSQL = connection.prepareStatement(Constants.getInsertVenda());
                    comandoSQL.setString(1, venda.usuario);
                    comandoSQL.setInt(2, venda.quantidade);
                    comandoSQL.setString(3, venda.produto);
                    comandoSQL.executeUpdate();
                    connection.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                updateProdutos(produto, venda.quantidade);
                return true;
            }
    }
    //

    //Atualizar produto pós-venda
    private void updateProdutos(Produto produto, int qtd){
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(Constants.updateProduto(produto.nome,qtd));
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //

    //Retorna o produto pelo nome para realizar uma venda (utilizado em insertVenda())
    private Produto getProdutoNome(String produto){
        Produto prod = null;
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.getProdutoNome(produto));
            while(rs.next()){
                prod = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria")
                );
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return prod;
    }
    //

    //Retorna se o usuário existe na tabela (utilizado na aplicação)
    public boolean getUsuario(String nome){
        List<Usuario> users= new ArrayList<>();
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.getUsuarioNome(nome));
            while(rs.next()){
                Usuario user = new Usuario(
                        rs.getString("usuario"),
                        rs.getString("senha")
                );
                users.add(user);
            }
            rs.close();

            if (users.size() == 0)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //

}
