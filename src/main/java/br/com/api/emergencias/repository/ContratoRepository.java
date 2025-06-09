package br.com.api.emergencias.repository;

import br.com.api.emergencias.enums.StatusContrato;
import br.com.api.emergencias.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    boolean existsByNumeroContrato(String numeroContrato);
    List<Contrato> findByClienteId(Long clienteId);
    List<Contrato> findByStatus(StatusContrato status);
}