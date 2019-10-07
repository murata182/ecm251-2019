package auxiliar_database;

import model.Produto;
import utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    //Implementação de Singleton
    private Connection connection;
    private static ProdutoDAO instance = null;
    public static ProdutoDAO getInstance(){
        if(instance == null)
            instance = new ProdutoDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private ProdutoDAO(String myConnection){
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
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

}
