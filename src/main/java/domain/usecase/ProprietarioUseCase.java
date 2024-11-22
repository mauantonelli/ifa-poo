package domain.usecase;

import domain.entity.Mecanico;
import domain.entity.Proprietario;
import domain.entity.Veiculo;
import domain.repository.ProprietarioRepository;

import java.util.List;
import java.util.Optional;

public class ProprietarioUseCase {
    private final ProprietarioRepository repository;


    public ProprietarioUseCase(ProprietarioRepository repository) {
        this.repository = repository;
    }

    public void save(Proprietario proprietario){
        repository.save(proprietario);
    } // Passar referencia do repositório

    public Optional<Proprietario> findById(int id){
        return repository.findById(id);
    }


    public List<Proprietario> findAll(){
        return repository.findAll();
}
}

