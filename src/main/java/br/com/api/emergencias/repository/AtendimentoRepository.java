package br.com.api.emergencias.repository;

import br.com.api.emergencias.enums.StatusAtendimento;
import br.com.api.emergencias.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    boolean existsByProtocolo(String protocolo);
    List<Atendimento> findByPacienteId(Long pacienteId);
    List<Atendimento> findByStatus(StatusAtendimento status);
    List<Atendimento> findByDataAtendimentoBetween(LocalDateTime inicio, LocalDateTime fim);
}