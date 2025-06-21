package br.com.api.emergencias.repository;

import br.com.api.emergencias.enums.StatusFatura;
import br.com.api.emergencias.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    boolean existsByNumeroFatura(String numeroFatura);
    List<Fatura> findByClienteId(Long clienteId);
    List<Fatura> findByStatus(StatusFatura status);
    List<Fatura> findByDataVencimentoBetween(LocalDate inicio, LocalDate fim);
}