package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Manutencao;
import domain.entity.Mecanico;
import domain.entity.Proprietario;
import domain.entity.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "SELECT * FROM manutencao WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // aqui recupera-se o veículo
                Veiculo veiculo = new VeiculoDAOimpl().findById(rs.getInt("veiculo")).orElse(null);

                // agr o mecânico:
                Mecanico mecanico = new MecanicoDAOimpl().findById(rs.getInt("mecanico")).orElse(null);

                // criando um obj manutenção:
                Manutencao manutencao = new Manutencao(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getDouble("custo"),
                        veiculo,                             // obj veic relacionado
                        mecanico                             // obj mec relacionado
                );

                return Optional.of(manutencao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public List<Manutencao> findAll() {
        String sql = "SELECT * FROM manutencao";
        List<Manutencao> manutencaoList = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                Veiculo veiculo = new VeiculoDAOimpl().findById(rs.getInt("veiculo")).orElse(null);

                // agr o mecânico:
                Mecanico mecanico = new MecanicoDAOimpl().findById(rs.getInt("mecanico")).orElse(null);


                Manutencao manutencao = new Manutencao(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getDouble("custo"),
                        veiculo,
                        mecanico
                );

                manutencaoList.add(manutencao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manutencaoList;
    }
    @Override
    public List<Manutencao> obterManutencaoPorVeiculo(Veiculo veiculo) {
        return null;
    }
}
