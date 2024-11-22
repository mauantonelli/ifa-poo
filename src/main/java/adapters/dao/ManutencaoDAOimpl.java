package adapters.dao;

import domain.entity.Manutencao;
import domain.entity.Mecanico;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ManutencaoDAOimpl implements MecanicoDAO {


    @Override
    public int save(Manutencao manutencao) {
        String sql = "INSERT INTO manutencao (id, data, custo, veiculo, mecanico) vales (?,?,?,?,?)";
        int generateId=0;
        try(PreparedStatement stmt = )




        return 0;
    }

    @Override
    public Optional<Mecanico> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Mecanico> findAll() {
        return null;
    }


}
