package br.com.api.emergencias.repository;

import br.com.api.emergencias.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Cliente, Long> {

}
