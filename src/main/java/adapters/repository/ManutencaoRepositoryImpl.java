package adapters.repository;

import adapters.dao.ManutencaoDAO;
import domain.entity.Manutencao;
import domain.entity.Veiculo;
import domain.repository.ManutencaoRepository;

import java.util.List;
import java.util.Optional;

public class ManutencaoRepositoryImpl implements ManutencaoRepository {

  private final ManutencaoDAO dao;

    public ManutencaoRepositoryImpl(ManutencaoDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Manutencao> obterManutencaoPorVeiculo(Veiculo veiculo) {
        return dao.obterManutencaoPorVeiculo(veiculo);
    }

    @Override
    public void save(Manutencao manutencao) {
        int id= dao.save(manutencao);
        manutencao.setId(id);

    }

    @Override
    public Optional<Manutencao> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Manutencao> findAll() {
        return dao.findAll();
    }
}
