package domain.repository;

import domain.entity.Manutencao;
import domain.entity.Veiculo;

import java.util.List;

public interface ManutencaoRepository extends Repository<Manutencao> {
    List<Manutencao> obterManutencaoPorVeiculo(Veiculo veiculo);


}
