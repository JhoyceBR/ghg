
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DaoFuncionario {

    public void adicionarFuncionario(Funcionario f) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO Pessoa(id, nome, cpf, celular, email, diaPresente) VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getCPF());
            stmt.setString(4, f.getCelular());
            stmt.setString(5, f.getEmail());
            stmt.setDate(6, f.getDiaPresente());

            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("INSERT INTO funcionario(id, salario) VALUES(?,?)");
            stmt.setInt(1, f.getId());
            stmt.setDouble(2, f.getSalario());

            stmt.executeUpdate();
        } catch (SQLException e) {
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    public List<Funcionario> listarFuncionario() {
        List<Funcionario> listaRetorno = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Funcionario ORDER BY id");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario(rs.getInt("id"),
                        rs.getDouble("salario"));
                listaRetorno.add(f);
            }

        } catch (SQLException e) {
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return listaRetorno;
    }
    
    public void updatePaciente(Paciente p) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Pessoa SET nome=?, cpf=?, celular=?, email=?, diaPresente=? WHERE id=?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getCelular());
            stmt.setString(4, p.getEmail());
            stmt.setDate(5, p.getDiaPresente());
            stmt.setInt(6, p.getId());

            stmt.executeUpdate();
            
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Paciente SET preco=? WHERE id=?");
            stmt.setDouble(1, p.getPreco());
            stmt.setInt(2, p.getId());

            stmt.executeUpdate();
        }
          catch (SQLException e) {
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    public void deletarPaciente(int id) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM Paciente WHERE id=?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    

}


