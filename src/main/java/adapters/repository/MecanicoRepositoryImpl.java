package adapters.repository;

import adapters.dao.MecanicoDAO;
import domain.entity.Mecanico;
import domain.repository.ManutencaoRepository;
import domain.repository.MecanicoRepository;

import java.util.List;
import java.util.Optional;

public class MecanicoRepositoryImpl implements MecanicoRepository {

    private final MecanicoDAO dao;

    public MecanicoRepositoryImpl(MecanicoDAO dao) {
        this.dao = dao;
    }


    @Override
    public void save(Mecanico mecanico) {
        int id = dao.save(mecanico);
        mecanico.setId(id);


    }

    @Override
    public Optional<Mecanico> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Mecanico> findAll() {
        return dao.findAll();
    }
}
