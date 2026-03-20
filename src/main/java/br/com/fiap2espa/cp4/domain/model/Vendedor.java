package br.com.fiap2espa.cp4.domain.model;

import br.com.fiap2espa.cp4.domain.enums.Tipo;
import br.com.fiap2espa.cp4.domain.vo.Endereco;

public class Vendedor {
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;  //enum
    private Tipo tipo;          //Enum


}
