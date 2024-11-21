package adapters.dao;

import domain.entity.Manutencao;
import domain.entity.Veiculo;

import java.util.List;

public interface ManutencaoDAO extends DAO<Manutencao> {
    List<Manutencao> obterManutencaoPorVeiculo(Veiculo veiculo);
}
