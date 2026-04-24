package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.AreaDeInteresse;

public record ProspectanteRequestDTO(
        String nome,
        String email,
        String telefone,
        AreaDeInteresse areaDeInteresse
) {}