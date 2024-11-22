package adapters.repository;

import adapters.dao.ProprietarioDAO;
import domain.entity.Proprietario;
import domain.repository.ProprietarioRepository;

import java.util.List;
import java.util.Optional;

public class ProprietarioRepositoryImpl implements ProprietarioRepository {
    private final ProprietarioDAO dao;

    public ProprietarioRepositoryImpl(ProprietarioDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(Proprietario proprietario) {
        int id=dao.save(proprietario);
        proprietario.setId(id);

    }

    @Override
    public Optional<Proprietario> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Proprietario> findAll() {
        return dao.findAll();
    }
}
