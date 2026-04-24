package br.com.fiap2espa.cp4.dto;

public record ContratoResponseDTO(
        Long id,
        String descricao,
        Double valor,
        Long clienteId
) {}
