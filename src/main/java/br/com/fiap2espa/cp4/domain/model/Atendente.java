package br.com.fiap2espa.cp4.domain.model;

import br.com.fiap2espa.cp4.domain.enums.Qualificacao;


public class Atendente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Qualificacao qualificacao;  //Enumeração
}
