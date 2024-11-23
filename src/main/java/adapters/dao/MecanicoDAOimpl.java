package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Manutencao;
import domain.entity.Mecanico;
import domain.entity.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MecanicoDAOimpl implements MecanicoDAO {

    @Override
    public int save(Mecanico mecanico) {
        String sql = "INSERT INTO mecanico (id, nome, salario) values (?,?,?)";
        int generatedId = 0;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, mecanico.getId());
            stmt.setString(2, mecanico.getNome());
            stmt.setDouble(2, mecanico.getSalario());
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
    public Optional<Mecanico> findById(int id) {
        String sql = "SELECT * FROM mecanico WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Mecanico mecanico = new Mecanico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("salario")
                );

                return Optional.of(mecanico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public List<Mecanico> findAll() {
        String sql = "SELECT * FROM mecanico";
        List<Mecanico> mecanicoList = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mecanico mecanico = new Mecanico(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("salario"));
                mecanicoList.add(mecanico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mecanicoList;
    }
}
