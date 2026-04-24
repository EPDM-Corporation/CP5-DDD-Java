package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.vo.*;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        String telefone,
        Endereco endereco
) {}