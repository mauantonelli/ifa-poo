package domain.usecase;

import com.sun.jmx.mbeanserver.Repository;
import domain.entity.Mecanico;
import domain.repository.MecanicoRepository;

import java.util.List;
import java.util.Optional;

public class MecanicoUseCase {
    private final MecanicoRepository repository;

    public MecanicoUseCase(MecanicoRepository repository) {
        this.repository = repository;
    }

    public void save(Mecanico mecanico){
        repository.save(mecanico);
    }

    public Optional<Mecanico> findById(int id){
        return repository.findById(id);
    }

    public List<Mecanico> findAll(){
        return repository.findAll();
    }


}
