package adapters.dao;


import domain.entity.Proprietario;
import domain.entity.Veiculo;

import java.util.List;
import java.util.Optional;

public class VeiculoDAOimpl implements VeiculoDAO{

    @Override
    public int save(Veiculo type) {
        return 0;
    }

    @Override
    public Optional<Veiculo> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Veiculo> findAll() {
        return null;
    }

    @Override
    public List<Veiculo> obterVeiculoPorProprietario(Proprietario proprietario) {
        return null;
    }

    @Override
    public List<Veiculo> obterVeiculoPorPlaca(String placa) {
        return null;
    }
}
