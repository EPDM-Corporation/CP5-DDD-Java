package br.com.fiap2espa.cp4.dto;

public record ContratoRequestDTO(
        String descricao,
        Double valor,
        Long clienteId
) {}