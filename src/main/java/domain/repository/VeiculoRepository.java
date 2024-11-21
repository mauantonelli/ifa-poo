package domain.repository;
import domain.entity.Proprietario;
import domain.entity.Veiculo;

import java.util.List;

public interface VeiculoRepository extends Repository<Veiculo> {
    List<Veiculo> obterVeiculoPorProprietario(Proprietario proprietario);
    List<Veiculo> obterVeiculoPorPlaca(String placa);

}
