//Criando estrutura de relacionamento de entidades com os repositórios JPA

package br.com.fiap2espa.cp4.domain.repository;

import br.com.fiap2espa.cp4.domain.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente,Long> {
}
