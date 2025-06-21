package br.com.api.emergencias.repository;

import br.com.api.emergencias.model.EstoqueAmbulancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EstoqueAmbulanciaRepository extends JpaRepository<EstoqueAmbulancia, Long> {
    List<EstoqueAmbulancia> findByVeiculoId(Long veiculoId);
    List<EstoqueAmbulancia> findByItemId(Long itemId);
    List<EstoqueAmbulancia> findByQuantidadeAtualLessThan(Integer quantidade);
    List<EstoqueAmbulancia> findByProximaVerificacaoBefore(LocalDate date);
    boolean existsByVeiculoIdAndItemId(Long veiculoId, Long itemId);
}