package adapters.dao;

import domain.entity.Mecanico;

import java.util.List;
import java.util.Optional;

public class MecanicoDAOimpl implements MecanicoDAO {

    @Override
    public int save(Mecanico type) {
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
