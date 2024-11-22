package domain.usecase;

import domain.entity.Manutencao;
import domain.entity.Veiculo;
import domain.repository.ManutencaoRepository;

import java.util.List;
import java.util.Optional;

public class ManutencaoUseCase {

    // Associacao entre ManutencaoUseCase -> MenutencaoRep/Rep

    private final ManutencaoRepository repository;

    public ManutencaoUseCase(ManutencaoRepository repository) {
        this.repository = repository;
    }

    public void save(Manutencao manutencao){
        repository.save(manutencao);
    }

    public Optional<Manutencao> findById(int id){
        return repository.findById(id);
    }

    public List<Manutencao> obterManutencaoPorVeiculo(Veiculo veiculo){
        return repository.obterManutencaoPorVeiculo(veiculo);
    }

    public List<Manutencao> findAll(){
        return repository.findAll();



}
}
