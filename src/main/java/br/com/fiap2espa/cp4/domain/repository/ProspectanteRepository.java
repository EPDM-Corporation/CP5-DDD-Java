package br.com.fiap2espa.cp4.domain.repository;

import br.com.fiap2espa.cp4.domain.model.Prospectante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectanteRepository extends JpaRepository<Prospectante, Long> {
}
