package br.com.api.emergencias.repository;

import br.com.api.emergencias.model.ServicoManutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoManutencaoRepository extends JpaRepository<ServicoManutencao, Long> {
    List<ServicoManutencao> findByManutencaoId(Long manutencaoId);
    List<ServicoManutencao> findByDescricaoContaining(String termo);
}