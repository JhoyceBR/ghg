/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ALUNO
 */
    
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DaoAssistente {

    public void adicionarAssistente(assistente a) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO Funcionario (id, salario) VALUES(?,?)");
            stmt.setInt(1, a.getId());
            stmt.setDouble(2, a.getSalario());
            

            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("INSERT INTO Assistente (id, formacao) VALUES(?,?)");
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getFormacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }

    /**
     *
     * @return
     */
    public List<assistente> listarassistente() {
        List<assistente> listaRetorno = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Assistente ORDER BY id");
            rs = stmt.executeQuery();

            while (rs.next()) {
                assistente a = new assistente(rs.getInt("id"),
                        rs.getString("formacao"));
                listaRetorno.add(a);
            }

        } catch (SQLException e) {
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return listaRetorno;
    }
    
    public void updateAssistente(assistente a) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Funcionario SET nome=?, cpf=?, celular=?, email=?, diaPresente=? WHERE id=?");
            stmt.setString(1, a.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getCelular());
            stmt.setString(4, f.getEmail());
            stmt.setDate(5, f.getDiaPresente());
            stmt.setInt(6, f.getId());

            stmt.executeUpdate();
            
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Funcionario SET salario=? WHERE id=?");
            stmt.setDouble(1, f.getSalario());
            stmt.setInt(2, f.getId());

            stmt.executeUpdate();
        }
          catch (SQLException e) {
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    public void deletarFuncionario(int id) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
     
            stmt.executeUpdate();
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM Funcionario WHERE id=?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM Pessoa WHERE id=?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    

}




