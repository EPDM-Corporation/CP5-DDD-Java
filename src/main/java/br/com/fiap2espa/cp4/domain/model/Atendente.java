package br.com.fiap2espa.cp4.domain.model;

import br.com.fiap2espa.cp4.domain.enums.Qualificacao;
import br.com.fiap2espa.cp4.domain.enums.Tipo;
import br.com.fiap2espa.cp4.domain.vo.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @Embedded
    private Endereco endereco;  //vo

    @Enumerated(EnumType.STRING)
    private Tipo tipo;  //Enumeração

}
