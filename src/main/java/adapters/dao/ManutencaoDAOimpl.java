package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Manutencao;
import domain.entity.Mecanico;
import domain.entity.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ManutencaoDAOimpl implements ManutencaoDAO {


    @Override
    public int save(Manutencao manutencao) {
        String sql = "INSERT INTO manutencao (id, data, custo) values (?,?,?)";
        int generatedId = 0;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, manutencao.getId());
            stmt.setString(2, manutencao.getData());
            stmt.setDouble(2, manutencao.getCusto());
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
    public Optional<Manutencao> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Manutencao> findAll() {
        return null;
    }

    @Override
    public List<Manutencao> obterManutencaoPorVeiculo(Veiculo veiculo) {
        return null;
    }
}
