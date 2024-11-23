package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProprietarioDAOimpl implements ProprietarioDAO{

    @Override
    public int save(Proprietario proprietario) {
        String sql = "INSERT INTO proprietario (id, nome, telefone) values (?,?,?)";
        int generatedId = 0;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, proprietario.getId());
            stmt.setString(2, proprietario.getNome());
            stmt.setString(2, proprietario.getTelefone());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                generatedId = generatedKeys.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    @Override
    public Optional findById(int id) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return null;
    }
}
