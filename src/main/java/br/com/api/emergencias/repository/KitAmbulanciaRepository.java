package br.com.api.emergencias.repository;

import br.com.api.emergencias.enums.TipoKitAmbulancia;
import br.com.api.emergencias.model.KitAmbulancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface KitAmbulanciaRepository extends JpaRepository<KitAmbulancia, Long> {
    List<KitAmbulancia> findByVeiculoId(Long veiculoId);
    List<KitAmbulancia> findByTipo(TipoKitAmbulancia tipo);
    List<KitAmbulancia> findByProximaVerificacaoBefore(LocalDate date);
    boolean existsByCodigo(String codigo);
}