package br.com.fiap2espa.cp4.dto;

// DTO para retorno da API (Response) - Esconde o CPF por segurança
public record ClienteResponseDTO(
        Long id,
        String nome,
        String email,
        String status
) {}
