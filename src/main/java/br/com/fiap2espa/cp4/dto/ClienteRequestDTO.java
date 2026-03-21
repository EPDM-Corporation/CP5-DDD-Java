package br.com.fiap2espa.cp4.dto;

import br.com.fiap2espa.cp4.domain.vo.Endereco;

// DTO para criação e atualização (Request)
public record ClienteRequestDTO(
        String nome,
        String cpf,
        String email,
        String telefone,
        Endereco endereco
) {}