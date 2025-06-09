package br.com.api.emergencias.repository;

import br.com.api.emergencias.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    boolean existsByCodigo(String codigo);
    Servico findByCodigo(String codigo);
}
