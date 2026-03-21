package br.com.fiap2espa.cp4.domain.repository;

import br.com.fiap2espa.cp4.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //Adicionar depois os métodos de busca customizados se caso a gente for utilizar

}
