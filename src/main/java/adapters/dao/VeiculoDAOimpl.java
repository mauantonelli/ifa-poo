package adapters.dao;


import adapters.ConnectionFactory;
import domain.entity.Proprietario;
import domain.entity.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "SELECT * FROM veiculo";  // SQL para buscar todos os veículos
        List<Veiculo> veiculoList = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();  // Executa a query no banco de dados

            while (rs.next()) {
                // Busca o proprietário associado ao veículo
                Proprietario proprietario1 = (Proprietario) new ProprietarioDAOimpl() // prob?
                        .findById(rs.getInt("proprietario"))
                        .orElse(null);  // Se não encontrar, retorna null

                // Cria o objeto Veiculo
                Veiculo veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        proprietario1 // Passa o proprietário para o veículo
                );

                veiculoList.add(veiculo);  // Adiciona o veículo à lista
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Imprime o erro se ocorrer alguma exceção
        }

        return veiculoList;  // Retorna a lista de veículos
    }

    @Override
    public List<Veiculo> obterVeiculoPorProprietario(Proprietario proprietario) {
        String sql = "SELECT * FROM veiculo WHERE proprietario = ?";
        List<Veiculo> veiculos = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, proprietario.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        proprietario // proprietario foi passado como arg
                );
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @Override
    public List<Veiculo> obterVeiculoPorPlaca(String placa) {
        String sql = "SELECT * FROM veiculo WHERE placa = ?"; // Filtro pela placa
        List<Veiculo> veiculos = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setString(1, placa); // Define a placa no parâmetro da query
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int proprietarioId = rs.getInt("proprietario"); // ID do proprietário na tabela
                // Busca o proprietário associado usando o DAO
                Proprietario proprietario = (Proprietario) new ProprietarioDAOimpl()
                        .findById(proprietarioId)
                        .orElse(null); // Caso não encontre, retorna null

                // Criação do objeto Veiculo
                Veiculo veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        proprietario // Passa o proprietário encontrado
                );
                veiculos.add(veiculo); // Adiciona à lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
}
}
