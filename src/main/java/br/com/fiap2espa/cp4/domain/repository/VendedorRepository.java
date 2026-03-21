package br.com.fiap2espa.cp4.domain.repository;

import br.com.fiap2espa.cp4.domain.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
}
