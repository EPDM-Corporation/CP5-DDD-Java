package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.Tipo;

public record AtendenteResponseDTO(
        Long id,
        String nome,
        String email,
        Tipo tipo
) {}