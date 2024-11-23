package adapters.dao;


import adapters.ConnectionFactory;
import domain.entity.Proprietario;
import domain.entity.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class VeiculoDAOimpl implements VeiculoDAO{

    @Override
    public int save(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (id, placa, marca) values (?,?,?)";
        int generatedId = 0;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, veiculo.getId());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getMarca());
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
    public Optional<Veiculo> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Veiculo> findAll() {
        return null;
    }

    @Override
    public List<Veiculo> obterVeiculoPorProprietario(Proprietario proprietario) {
        return null;
    }

    @Override
    public List<Veiculo> obterVeiculoPorPlaca(String placa) {
        return null;
    }
}
