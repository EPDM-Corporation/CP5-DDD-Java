package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.Qualificacao;

public record VendedorResponseDTO(
        Long id,
        String nome,
        String email,
        Qualificacao qualificacao
) {}