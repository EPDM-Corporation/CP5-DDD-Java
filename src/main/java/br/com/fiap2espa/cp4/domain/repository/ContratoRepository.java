package br.com.fiap2espa.cp4.domain.repository;

import br.com.fiap2espa.cp4.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
