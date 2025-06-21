package br.com.api.emergencias.repository;

import br.com.api.emergencias.enums.StatusManutencao;
import br.com.api.emergencias.enums.TipoManutencao;
import br.com.api.emergencias.model.ManutencaoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ManutencaoVeiculoRepository extends JpaRepository<ManutencaoVeiculo, Long> {
    List<ManutencaoVeiculo> findByVeiculoId(Long veiculoId);
    List<ManutencaoVeiculo> findByTipo(TipoManutencao tipo);
    List<ManutencaoVeiculo> findByStatus(StatusManutencao status);
    List<ManutencaoVeiculo> findByDataServicoBetween(LocalDate inicio, LocalDate fim);
    List<ManutencaoVeiculo> findByDataServicoBeforeAndStatus(LocalDate date, StatusManutencao status);
}