package domain.usecase;

import domain.entity.Manutencao;
import domain.repository.ManutencaoRepository;

public class ManutencaoUseCase {

    // Associacao entre ManutencaoUseCase -> MenutencaoRep/Rep

    private final ManutencaoRepository repository;

    public ManutencaoUseCase(ManutencaoRepository repository) {
        this.repository = repository;
    }

    public void save(Manutencao manutencao){
        repository.save(manutencao);
    }



}
