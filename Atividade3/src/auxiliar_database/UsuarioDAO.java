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
