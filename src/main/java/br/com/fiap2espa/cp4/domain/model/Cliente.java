package br.com.fiap2espa.cp4.domain.model;

import br.com.fiap2espa.cp4.domain.enums.Status;
import br.com.fiap2espa.cp4.domain.vo.Endereco;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco; //Enum
    private Status status;     //Enum


}
