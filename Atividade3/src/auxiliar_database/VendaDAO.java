package auxiliar_database;

import model.Produto;
import model.Venda;
import utilities.Constants;

import java.sql.*;

public class VendaDAO {
    //Implementação de Singleton
    private Connection connection;
    private static VendaDAO instance = null;
    public static VendaDAO getInstance(){
        if(instance == null)
            instance = new VendaDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private VendaDAO(String myConnection){
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
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
}
