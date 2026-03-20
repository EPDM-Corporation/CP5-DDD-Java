package br.com.fiap2espa.cp4.domain.model;

import br.com.fiap2espa.cp4.domain.enums.AreaDeInteresse;
import br.com.fiap2espa.cp4.domain.vo.Endereco;

public class Prospectante {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;
    private AreaDeInteresse areaDeInteresse;    //Enum
}
