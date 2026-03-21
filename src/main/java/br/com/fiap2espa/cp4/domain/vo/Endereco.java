//Value Objects {São entidades imutáveis e sem identidade própria}

package br.com.fiap2espa.cp4.domain.vo;


import jakarta.persistence.Embeddable;

@Embeddable
public record Endereco(
        String rua,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep
        ) { }
