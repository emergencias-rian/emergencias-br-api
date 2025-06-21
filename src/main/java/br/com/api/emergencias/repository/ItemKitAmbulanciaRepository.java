package br.com.api.emergencias.repository;

import br.com.api.emergencias.model.ItemKitAmbulancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemKitAmbulanciaRepository extends JpaRepository<ItemKitAmbulancia, Long> {
    List<ItemKitAmbulancia> findByKitId(Long kitId);
    List<ItemKitAmbulancia> findByItemEstoque_Id(Long estoqueId);
    List<ItemKitAmbulancia> findByValidadeBefore(LocalDate date);
    List<ItemKitAmbulancia> findByValidadeBetween(LocalDate start, LocalDate end);
}