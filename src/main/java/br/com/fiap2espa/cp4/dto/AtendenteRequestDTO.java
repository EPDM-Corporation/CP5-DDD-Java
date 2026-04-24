package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.Tipo;
import br.com.fiap2espa.cp4.domain.vo.Endereco;

public record AtendenteRequestDTO(
        String nome,
        String cpf,
        String email,
        String telefone,
        Tipo tipo,
        Endereco endereco
) {}
