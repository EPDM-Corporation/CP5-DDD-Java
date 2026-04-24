package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.vo.Endereco;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        Endereco endereco
) {}