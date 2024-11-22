package adapters.repository;

import adapters.dao.VeiculoDAO;
import domain.entity.Proprietario;
import domain.entity.Veiculo;
import domain.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

public class VeiculoRepositoryImpl implements VeiculoRepository {
    private final VeiculoDAO dao;

    @Override
    public void save(Veiculo veiculo) {
        int id=dao.save(veiculo);
        veiculo.setId(id);

    }

    @Override
    public Optional<Veiculo> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Veiculo> findAll() {
        return findAll();
    }

    @Override
    public List<Veiculo> obterVeiculoPorProprietario(Proprietario proprietario) {
        return dao.obterVeiculoPorProprietario(proprietario);
    }

    @Override
    public List<Veiculo> obterVeiculoPorPlaca(String placa) {
        return dao.obterVeiculoPorPlaca(placa);
    }

    public VeiculoRepositoryImpl(VeiculoDAO dao) {
        this.dao = dao;


    }
}
