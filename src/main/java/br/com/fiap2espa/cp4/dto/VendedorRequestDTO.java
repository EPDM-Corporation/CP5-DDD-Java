package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.Qualificacao;
import br.com.fiap2espa.cp4.domain.vo.Endereco;

public record VendedorRequestDTO(
        String nome,
        String cpf,
        String email,
        String telefone,
        Qualificacao qualificacao,
        Endereco endereco
) {}