package adapters.dao;

import domain.entity.Proprietario;
import domain.entity.Veiculo;

import java.util.List;

public interface VeiculoDAO extends DAO<Veiculo>{
    List<Veiculo> obterVeiculoPorProprietario(Proprietario proprietario);
    List<Veiculo> obterVeiculoPorPlaca(String placa);

}
