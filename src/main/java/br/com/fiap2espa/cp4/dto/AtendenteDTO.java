package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.Tipo;
import br.com.fiap2espa.cp4.domain.vo.Endereco;

public record AtendenteDTO(
        String nome,
        String email,
        Tipo tipo,
        Endereco endereco
) {}
