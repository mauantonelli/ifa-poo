import adapters.dao.MecanicoDAO;
import adapters.dao.MecanicoDAOimpl;
import adapters.repository.MecanicoRepositoryImpl;
import domain.entity.Mecanico;
import domain.repository.MecanicoRepository;
import domain.usecase.MecanicoUseCase;

public class Main {

    public static void main(String[] args) {

        MecanicoDAO mecanicoDAO = new MecanicoDAOimpl();
        MecanicoRepository mecanicoRepository = new MecanicoRepositoryImpl(mecanicoDAO);
        MecanicoUseCase mecanicoUseCase = new MecanicoUseCase(mecanicoRepository);

        Mecanico mecanico1 = new Mecanico(1, "Maurício", 1200);
        mecanicoUseCase.save(mecanico1);

    }
}
