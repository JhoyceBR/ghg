
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DaoPaciente {

    public void adicionarPaciente(Paciente p) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO Pessoa(id, nome, cpf, celular, email, diaPresente) VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getCPF());
            stmt.setString(4, p.getCelular());
            stmt.setString(5, p.getEmail());
            stmt.setDate(6, p.getDiaPresente());

            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("INSERT INTO paciente(id, preco) VALUES(?,?)");
            stmt.setInt(1, p.getId());
            stmt.setDouble(2, p.getPreco());

            stmt.executeUpdate();
        } catch (SQLException e) {
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }

    public List<Paciente> listarPaciente() {
        List<Paciente> listaRetorno = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Pessoa ORDER BY id");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa p = new Pessoa(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("celular"),
                        rs.getString("email"),
                        rs.getDate("diaPresente"));
                listaRetorno.add(p);
            
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Paciente ORDER BY id, diaPresente");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente p = new Paciente(rs.getInt("id"),
                        rs.getDouble("preco"));
                listaRetorno.add(p);
            }
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
