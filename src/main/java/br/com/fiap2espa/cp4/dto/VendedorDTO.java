package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.enums.Qualificacao;
import br.com.fiap2espa.cp4.domain.enums.Tipo;
import br.com.fiap2espa.cp4.domain.vo.Endereco;

public record VendedorDTO(
        String nome,
        String email,
        Qualificacao qualificacao,
        Endereco endereco
) {}