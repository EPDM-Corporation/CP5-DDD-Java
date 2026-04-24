package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.AreaDeInteresse;

public record ProspectanteResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        AreaDeInteresse areaDeInteresse
) {}
