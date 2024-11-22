package domain.usecase;

import domain.entity.Proprietario;
import domain.entity.Veiculo;
import domain.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

public class VeiculoUseCase {
    private final VeiculoRepository repository;

    public VeiculoUseCase(VeiculoRepository repository) {
        this.repository = repository;
    }

    public void save(Veiculo veiculo){
        repository.save(veiculo);
    }

    public Optional<Veiculo> findById(int id){
        return repository.findById(id);

    }

    public List<Veiculo> findAll(){
        return repository.findAll();
    }

    public List<Veiculo> obterVeiculoPorPlaca(String placa){
        return repository.obterVeiculoPorPlaca(placa); // Argumento string -> placa
    }

    public List<Veiculo> obterVeiculoPorProprietario(Proprietario proprietario){
        return repository.obterVeiculoPorProprietario(proprietario);
    }

}
